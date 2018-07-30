# -*- coding: utf-8 -*-
from datetime import date

import scrapy
from dateutil.relativedelta import relativedelta


class YnffcSpiderSpider(scrapy.Spider):
    name = 'ynffc_spider'

    def start_requests(self):
        start_url = 'http://yulin234.com/Chart.aspx?lotteryType=33&type=wuxing'
        headers = {
            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',
            'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8',
            'Accept-Language': 'zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2',
            'Accept-Encoding': 'gzip, deflate',
            'Referer': 'http://yulin234.com/Play_ssc.aspx?cp=1minus',
            'Cookie': '__cfduid=d4400b4dc9a9d479b647c9706fb3097251532242086; ASP.NET_SessionId=mf2ebiczqomrpp554yajwhdh',
            'Connection': 'keep-alive',
            'Upgrade-Insecure-Requests': '1',
            'Cache-Control': 'max-age=0'
        }
        cookies = {
            '__cfduid': 'd4400b4dc9a9d479b647c9706fb3097251532242086',
            'ASP.NET_SessionId': 'uwy1d2ngw2za22iywhgufic2'
        }
        template_url = start_url + '&startTime=$START&endTime=$END'
        for one_date in self._get_start_end():
            one_str = one_date.strftime('%Y-%m-%d')
            data_url = template_url.replace('$START', one_str + ' 00:00:00').replace('$END', one_str + ' 23:59:59')
            yield scrapy.Request(url=data_url, headers=headers, callback=self.parse, cookies=cookies)

    def _get_start_end(self):
        start = date(2018, 7, 23)
        end = date.today()
        dates = []
        while start <= end:
            dates.append(start)
            start += relativedelta(days=1)
        return dates[0:1]

    def parse(self, response):
        chart_content = response.xpath('//./table/tbody[@id="J-chart-content"]/tr[not(@class)]')
        award_numbers = chart_content.xpath('//td/span/text()').extract()
        periods = chart_content.xpath('//td[@class="issue-numbers"]/text()').extract()

        for i in range(0, len(award_numbers)):
            print('period:' + periods[i] + ', award:' + award_numbers[i])
