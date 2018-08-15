# -*- coding: utf-8 -*-
import json
import logging
import re
from datetime import date
from urllib import request

import scrapy
from dateutil.relativedelta import relativedelta


class csmar_base_spider(scrapy.Spider):
    # login url
    login_url = 'http://cn.gtadata.com/Login/AnonymousLogin'
    # 重定向到login的url
    redirect_url = 'http://cn.gtadata.com/Login/index?ReturnUrl=%2fSingleTable%2fQueryData'
    # 获取数据的url
    api_url = 'http://cn.gtadata.com/SingleTable/QueryData'

    today = date.today()
    space = relativedelta(months=1)

    cookies = None
    headers = {
        'Accept': '*/*',
        'Accept-Encoding': 'gzip, deflate',
        'Accept-Language': 'zh-CN,zh;q=0.9',
        'Cache-Control': 'no-cache',
        'Connection': 'keep-alive',
        'Content-Type': 'application/x-www-form-urlencoded',
        'Host': 'cn.gtadata.com',
        'Origin': 'http://cn.gtadata.com',
        'Pragma': 'no-cache',
        'Referer': 'http://cn.gtadata.com/Login/Index',
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) '
                      'Chrome/67.0.3396.99 Safari/537.36',
        'X-Requested-With': 'XMLHttpRequest'
    }

    # 获取有效cookies
    def get_cookies(self):
        if self.cookies:
            return self.cookies
        return self._request_cookies()

    def _request_cookies(self):
        cookies = {}
        response = request.urlopen(request.Request(self.login_url, headers=self.headers, data=None))
        cookies_list = response.headers.get_all('Set-Cookie')
        for cookie in cookies_list:
            items = cookie.split(';')[0].split('=')
            cookies[items[0]] = items[1]
        self.cookies = cookies
        return cookies

    # 数据请求
    def post_form(self, query_set):
        cookies = self.get_cookies()
        form_data = self._build_form_data(query_set)
        return scrapy.FormRequest(url=self.api_url, method='post', headers=self.headers, cookies=cookies,
                                  formdata=form_data, callback=self.parse, dont_filter=True)

    def start_requests(self, start, stock_code):
        while start <= self.today:
            query_set = self.build_query_set(start, stock_code)
            yield self.post_form(query_set)
            start += self.space
        pass

    def parse(self, response):
        if response.url == self.login_url:
            self.log(u'当前查询session已过期，请重新登录', level=logging.INFO)
            exit(-1)
        json_data = json.loads(response.text)
        real_data = json_data['Data']
        col_data = [i['Name'] for i in json_data['ColModels']]
        if not real_data:
            self.log(u'当前查询无结果')
        return col_data, real_data

    def _build_form_data(self, query_set):
        return {
            'querySet': json.dumps(query_set).encode('utf-8'),
            'pageRowCount': '50'.encode('utf-8')
        }

    def build_items(self, json_data, keys, clz):
        len_key = len(keys)
        items = [json_data[slice(len_key * bt, len_key * (bt + 1))] for bt in range(0, int(len(json_data) / len_key))]
        lm_fun = lambda obj: (obj['ColumnName'], obj['CellValue'])
        item_gen_list = [(lm_fun(obj) for obj in item) for item in items]
        return [self._gen_item(clz, item_gen) for item_gen in item_gen_list]

    def _gen_item(self, clz, item_gen):
        item = clz()
        while True:
            try:
                next_el = item_gen.__next__()
                item[next_el[0]] = self._filter_html(next_el[1].strip('\t| '))
            except StopIteration:
                break
        return item

    def _filter_html(self, text):
        find_list = re.findall(r'\>(.*?)\<', text)
        return find_list[0] if find_list else text

    def build_query_set(self, start, stock_code=None):
        raise NotImplementedError('{}.build_query_set callback is not defined'.format(self.__class__.__name__))

    def calc_end_date(self, start):
        end_date = start + self.space
        return str(end_date if end_date < self.today else self.today)
