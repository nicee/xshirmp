# -*- coding: utf-8 -*-
import json
import re
from datetime import date

import scrapy
from dateutil.relativedelta import relativedelta

from ..items import CSMARItem


class CSMARStockPrider(scrapy.Spider):
    name = 'csmar_stock_spider'
    login_url = 'http://www.gtarsc.com/Login/index?ReturnUrl=%2fSingleTable%2fQueryData'

    def start_requests(self):
        start_url = 'http://www.gtarsc.com/SingleTable/QueryData'
        headers = {
            'Accept': '*/*',
            'Accept-Encoding': 'gzip, deflate',
            'Accept-Language': 'zh-CN,zh;q=0.9',
            'Cache-Control': 'no-cache',
            'Connection': 'keep-alive',
            'Content-Type': 'application/x-www-form-urlencoded',
            'Host': 'www.gtarsc.com',
            'Origin': 'http://www.gtarsc.com',
            'Pragma': 'no-cache',
            'Referer': 'http://www.gtarsc.com/SingleTable/PreviewData',
            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 '
                          '(KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36',
            'X-Requested-With': 'XMLHttpRequest'
        }
        cookies = {
            '.ASPXAUTH': 'EB260CA9E6E7E6FE44BAD5BE93159FFE6FD0573D831F57A1D3E72FA2100F6E2B8D7B9591F36C242AADE4C283846707ABFAEFB1D50BF2C97C3FA99C30FFEA54902CFA59548A8E86FE0FED5E0059F3C4BC906B894A15303DB24C7DADE95B0485CCBC1B07E274567EEE0D15BF0AA900E745C2EE5237125A1867DBE44736F12ED614E8E83FAB40DA745DD9A8FB10CA3EB88A',
            'ASP.NET_SessionId': 'odfogdubwxqpkuos5l2gsyw2',
            'CNZZDATA1258304211': '60881034-1532858754-http%253A%252F%252Fwww.gtarsc.com%252F%7C1532921908',
            'Hm_lpvt_65bdc5493f8363f6edac9ffa7019ca87': '1532924442',
            'Hm_lvt_65bdc5493f8363f6edac9ffa7019ca87': '1532674524,1532689600,1532831189,1532924440',
            'UM_distinctid': '164e5c7a78b32f-03e10de2df431a-47e1039-100200-164e5c7a78d44b'
        }
        start = date(2010, 9, 1)
        now = date.today()
        while start <= now:
            form_data = self._get_next_form('002467', start)
            yield scrapy.FormRequest(url=start_url, method='post', headers=headers, cookies=cookies,
                                     formdata=form_data, callback=self.parse, dont_filter=True)
            start += relativedelta(months=1)

    def parse(self, response):
        if response.url == self.login_url:
            self.log(u'当前查询session已过期，请重新登录')
            return None

        json_data = json.loads(response.text)['Data']
        if json_data:
            item_keys = ['Stkcd', 'Trddt', 'Opnprc', 'Hiprc', 'Loprc', 'Clsprc', 'Dnshrtrd', 'Dnvaltrd', 'Dsmvosd',
                         'Dsmvtll', 'Dretwd', 'Dretnd', 'Adjprcwd', 'Adjprcnd', 'Markettype', 'Capchgdt', 'Trdsta']
            index = 0
            len_items = len(json_data)
            items = [{item['ColumnName']: item['CellValue']} for item in json_data]
            while (index + 17) < len_items:
                yield self._build_item(items[index: index + 17], item_keys)
                index += 17
        else:
            self.log(u'当前查询无结果')
        pass

    def _build_item(self, json_data, keys):
        one_json = {}
        for item in json_data:
            one_json.update(item)
        item = CSMARItem()
        for key in keys:
            item[key] = one_json[key] if key in one_json else 'null'
        if item['Trdsta'] != 'null':
            trdsta = re.findall(pattern='\d+', string=item['Trdsta'])
            if trdsta:
                item['Trdsta'] = trdsta[0]

        return item

    def _get_next_form(self, stock_code, start):
        start_str = start.strftime('%Y-%m-%d')
        end_str = (start + relativedelta(months=1)).strftime('%Y-%m-%d')
        query_set = json.dumps({
            'Tables': [{
                'TbId': '447',
                'Fields': [{
                    'DownCount': 362885, 'Pid': 4176, 'Fldid': 6888, 'Fldname': 'Stkcd', 'Showorder': 60,
                    'Replaceid': None, 'Tbid': 447, 'Datatypeid': 126, 'Langid': 0, 'Unitid': 0, 'Mlangid': 8437,
                    'Kid': 1, 'Typename': 'Nvarchar', 'Length': 6, 'Accuracy': 0, 'Mergerdatatype': 'C(6)',
                    'Title': '证券代码', 'Description': '以上交所、深交所公布的证券代码为准', 'Langtypeid': 1,
                    'TBTitle': '日个股回报率文件', 'Dbid': 63, 'DBTitle': '股票市场交易', 'NodeID': 1,
                    'UnitTitle': '没有单位', 'Keytype': 1, 'UnitValue': 0, 'Mergerunit': '没有单位', 'Iscode': 0
                }, {
                    'DownCount': 364061, 'Pid': 4176, 'Fldid': 6889, 'Fldname': 'Trddt', 'Showorder': 61,
                    'Replaceid': None, 'Tbid': 447, 'Datatypeid': 55, 'Langid': 1, 'Unitid': 0, 'Mlangid': 8438,
                    'Kid': 51, 'Typename': 'Datetime', 'Length': 10, 'Accuracy': 0, 'Mergerdatatype': 'D(10)',
                    'Title': '交易日期', 'Description': '以YYYY-MM-DD表示', 'Langtypeid': 1, 'TBTitle': '日个股回报率文件',
                    'Dbid': 63, 'DBTitle': '股票市场交易', 'NodeID': 0, 'UnitTitle': '没有单位', 'Keytype': 7,
                    'UnitValue': 0, 'Mergerunit': '没有单位', 'Iscode': 0
                }, {
                    'DownCount': 142096, 'Pid': 4176, 'Fldid': 6890, 'Fldname': 'Opnprc', 'Showorder': 62,
                    'Replaceid': None, 'Tbid': 447, 'Datatypeid': 93, 'Langid': 0, 'Unitid': 191, 'Mlangid': 8439,
                    'Kid': 0, 'Typename': 'decimal', 'Length': 9, 'Accuracy': 3, 'Mergerdatatype': 'N(9,3)',
                    'Title': '日开盘价', 'Description': 'A股以人民币元计，上海B以美元计，深圳B以港币计', 'Langtypeid': 1,
                    'TBTitle': '日个股回报率文件', 'Dbid': 63, 'DBTitle': '股票市场交易', 'NodeID': 0, 'UnitTitle': '元/股',
                    'Keytype': 0, 'UnitValue': 1, 'Mergerunit': '元/股', 'Iscode': 0
                }, {
                    'DownCount': 118130, 'Pid': 4176, 'Fldid': 6891, 'Fldname': 'Hiprc', 'Showorder': 63,
                    'Replaceid': None, 'Tbid': 447, 'Datatypeid': 93, 'Langid': 0, 'Unitid': 191, 'Mlangid': 8440,
                    'Kid': 0, 'Typename': 'decimal', 'Length': 9, 'Accuracy': 3, 'Mergerdatatype': 'N(9,3)',
                    'Title': '日最高价', 'Description': 'A股以人民币元计，上海B以美元计，深圳B以港币计', 'Langtypeid': 1,
                    'TBTitle': '日个股回报率文件', 'Dbid': 63, 'DBTitle': '股票市场交易', 'NodeID': 0, 'UnitTitle': '元/股',
                    'Keytype': 0, 'UnitValue': 1, 'Mergerunit': '元/股', 'Iscode': 0
                }, {
                    'DownCount': 117199, 'Pid': 4176, 'Fldid': 6892, 'Fldname': 'Loprc', 'Showorder': 64,
                    'Replaceid': None, 'Tbid': 447, 'Datatypeid': 93, 'Langid': 0, 'Unitid': 191, 'Mlangid': 8441,
                    'Kid': 0, 'Typename': 'decimal', 'Length': 9, 'Accuracy': 3, 'Mergerdatatype': 'N(9,3)',
                    'Title': '日最低价', 'Description': 'A股以人民币元计，上海B以美元计，深圳B以港币计', 'Langtypeid': 1,
                    'TBTitle': '日个股回报率文件', 'Dbid': 63, 'DBTitle': '股票市场交易', 'NodeID': 0, 'UnitTitle': '元/股',
                    'Keytype': 0, 'UnitValue': 1, 'Mergerunit': '元/股', 'Iscode': 0
                }, {
                    'DownCount': 247740, 'Pid': 4176, 'Fldid': 6893, 'Fldname': 'Clsprc', 'Showorder': 65,
                    'Replaceid': None, 'Tbid': 447, 'Datatypeid': 93, 'Langid': 0, 'Unitid': 191, 'Mlangid': 8442,
                    'Kid': 0, 'Typename': 'decimal', 'Length': 9, 'Accuracy': 3, 'Mergerdatatype': 'N(9,3)',
                    'Title': '日收盘价', 'Description': 'A股以人民币元计，上海B以美元计，深圳B以港币计', 'Langtypeid': 1,
                    'TBTitle': '日个股回报率文件', 'Dbid': 63, 'DBTitle': '股票市场交易', 'NodeID': 0, 'UnitTitle': '元/股',
                    'Keytype': 0, 'UnitValue': 1, 'Mergerunit': '元/股', 'Iscode': 0
                }, {
                    'DownCount': 134523, 'Pid': 4176, 'Fldid': 6894, 'Fldname': 'Dnshrtrd', 'Showorder': 66,
                    'Replaceid': None, 'Tbid': 447, 'Datatypeid': 64, 'Langid': 0, 'Unitid': 41, 'Mlangid': 8443,
                    'Kid': 0, 'Typename': 'decimal', 'Length': 12, 'Accuracy': 0, 'Mergerdatatype': 'N(12,0)',
                    'Title': '日个股交易股数', 'Description': '0=没有交易量', 'Langtypeid': 1, 'TBTitle': '日个股回报率文件',
                    'Dbid': 63, 'DBTitle': '股票市场交易', 'NodeID': 0, 'UnitTitle': '股', 'Keytype': 0, 'UnitValue': 1,
                    'Mergerunit': '股', 'Iscode': 0
                }, {
                    'DownCount': 128631, 'Pid': 4176, 'Fldid': 6895, 'Fldname': 'Dnvaltrd', 'Showorder': 67,
                    'Replaceid': None, 'Tbid': 447, 'Datatypeid': 113, 'Langid': 0, 'Unitid': 187, 'Mlangid': 8444,
                    'Kid': 0, 'Typename': 'decimal', 'Length': 16, 'Accuracy': 3, 'Mergerdatatype': 'N(16,3)',
                    'Title': '日个股交易金额', 'Description': '计量货币：人民币元。A股以人民币元计，上海B以美元计，深圳B以港币计，0=没有交易量',
                    'Langtypeid': 1, 'TBTitle': '日个股回报率文件', 'Dbid': 63, 'DBTitle': '股票市场交易', 'NodeID': 0,
                    'UnitTitle': '元', 'Keytype': 0, 'UnitValue': 1, 'Mergerunit': '元', 'Iscode': 0
                }, {
                    'DownCount': 136968, 'Pid': 4176, 'Fldid': 6896, 'Fldname': 'Dsmvosd', 'Showorder': 68,
                    'Replaceid': None, 'Tbid': 447, 'Datatypeid': 95, 'Langid': 0, 'Unitid': 102, 'Mlangid': 8445,
                    'Kid': 0, 'Typename': 'decimal', 'Length': 16, 'Accuracy': 2, 'Mergerdatatype': 'N(16,2)',
                    'Title': '日个股流通市值', 'Description': '个股的流通股数与收盘价的乘积，A股以人民币元计，上海B股以美元计，深圳B股以港币计，注意单位是千',
                    'Langtypeid': 1, 'TBTitle': '日个股回报率文件', 'Dbid': 63, 'DBTitle': '股票市场交易', 'NodeID': 0,
                    'UnitTitle': '元', 'Keytype': 0, 'UnitValue': 1000, 'Mergerunit': '千元', 'Iscode': 0
                }, {
                    'DownCount': 137437, 'Pid': 4176, 'Fldid': 6897, 'Fldname': 'Dsmvtll', 'Showorder': 69,
                    'Replaceid': None, 'Tbid': 447, 'Datatypeid': 95, 'Langid': 0, 'Unitid': 102, 'Mlangid': 8446,
                    'Kid': 0, 'Typename': 'decimal', 'Length': 16, 'Accuracy': 2, 'Mergerdatatype': 'N(16,2)',
                    'Title': '日个股总市值', 'Description': '个股的发行总股数与收盘价的乘积，A股以人民币元计，上海B股以美元计，深圳B股以港币计，注意单位是千',
                    'Langtypeid': 1, 'TBTitle': '日个股回报率文件', 'Dbid': 63, 'DBTitle': '股票市场交易', 'NodeID': 0,
                    'UnitTitle': '元', 'Keytype': 0, 'UnitValue': 1000, 'Mergerunit': '千元', 'Iscode': 0
                }, {
                    'DownCount': 219677, 'Pid': 4176, 'Fldid': 6898, 'Fldname': 'Dretwd', 'Showorder': 70,
                    'Replaceid': None, 'Tbid': 447, 'Datatypeid': 6, 'Langid': 0, 'Unitid': 0, 'Mlangid': 8447,
                    'Kid': 0, 'Typename': 'decimal', 'Length': 10, 'Accuracy': 6, 'Mergerdatatype': 'N(10,6)',
                    'Title': '考虑现金红利再投资的日个股回报率', 'Description': '上市首日的前收盘价取招股价,字段说明见“回报率计算方法”',
                    'Langtypeid': 1, 'TBTitle': '日个股回报率文件', 'Dbid': 63, 'DBTitle': '股票市场交易', 'NodeID': 0,
                    'UnitTitle': '没有单位', 'Keytype': 0, 'UnitValue': 0, 'Mergerunit': '没有单位', 'Iscode': 0
                }, {
                    'DownCount': 167304, 'Pid': 4176, 'Fldid': 6899, 'Fldname': 'Dretnd', 'Showorder': 71,
                    'Replaceid': None, 'Tbid': 447, 'Datatypeid': 6, 'Langid': 0, 'Unitid': 0, 'Mlangid': 8448,
                    'Kid': 0, 'Typename': 'decimal', 'Length': 10, 'Accuracy': 6, 'Mergerdatatype': 'N(10,6)',
                    'Title': '不考虑现金红利的日个股回报率', 'Description': '上市首日的前收盘价取招股价,字段说明见“回报率计算方法”', 'Langtypeid': 1,
                    'TBTitle': '日个股回报率文件', 'Dbid': 63, 'DBTitle': '股票市场交易', 'NodeID': 0, 'UnitTitle': '没有单位',
                    'Keytype': 0, 'UnitValue': 0, 'Mergerunit': '没有单位', 'Iscode': 0
                }, {
                    'DownCount': 111544, 'Pid': 4176, 'Fldid': 6900, 'Fldname': 'Adjprcwd', 'Showorder': 72,
                    'Replaceid': None, 'Tbid': 447, 'Datatypeid': 150, 'Langid': 0, 'Unitid': 191, 'Mlangid': 8449,
                    'Kid': 0, 'Typename': 'decimal', 'Length': 14, 'Accuracy': 6, 'Mergerdatatype': 'N(14,6)',
                    'Title': '考虑现金红利再投资的收盘价的可比价格',
                    'Description': 'A股以人民币元计，上海B以美元计，深圳B以港币计，去除由于时间间隔和股本变动原因引起变化的以上市首日为基准的经过调整后的收盘价。',
                    'Langtypeid': 1, 'TBTitle': '日个股回报率文件', 'Dbid': 63, 'DBTitle': '股票市场交易', 'NodeID': 0,
                    'UnitTitle': '元/股', 'Keytype': 0, 'UnitValue': 1, 'Mergerunit': '元/股', 'Iscode': 0
                }, {
                    'DownCount': 105332, 'Pid': 4176, 'Fldid': 6901, 'Fldname': 'Adjprcnd', 'Showorder': 73,
                    'Replaceid': None, 'Tbid': 447, 'Datatypeid': 150, 'Langid': 0, 'Unitid': 191, 'Mlangid': 8450,
                    'Kid': 0, 'Typename': 'decimal', 'Length': 14, 'Accuracy': 6, 'Mergerdatatype': 'N(14,6)',
                    'Title': '不考虑现金红利的收盘价的可比价格',
                    'Description': 'A股以人民币元计，上海B以美元计，深圳B以港币计，去除由于时间间隔和股本变动原因引起变化的以上市首日为基准的经过调整后的收盘价。',
                    'Langtypeid': 1, 'TBTitle': '日个股回报率文件', 'Dbid': 63, 'DBTitle': '股票市场交易', 'NodeID': 0,
                    'UnitTitle': '元/股', 'Keytype': 0, 'UnitValue': 1, 'Mergerunit': '元/股', 'Iscode': 0
                }, {
                    'DownCount': 142170, 'Pid': 4176, 'Fldid': 6902, 'Fldname': 'Markettype', 'Showorder': 74,
                    'Replaceid': None, 'Tbid': 447, 'Datatypeid': 5, 'Langid': 0, 'Unitid': 0, 'Mlangid': 8451,
                    'Kid': 0, 'Typename': 'decimal', 'Length': 10, 'Accuracy': 0, 'Mergerdatatype': 'N(10,0)',
                    'Title': '市场类型', 'Description': '1=上海A，2=上海B，4=深圳A，8=深圳B,  16=创业板', 'Langtypeid': 1,
                    'TBTitle': '日个股回报率文件', 'Dbid': 63, 'DBTitle': '股票市场交易', 'NodeID': 0, 'UnitTitle': '没有单位',
                    'Keytype': 0, 'UnitValue': 0, 'Mergerunit': '没有单位', 'Iscode': 0
                }, {
                    'DownCount': 98043, 'Pid': 4176, 'Fldid': 6903, 'Fldname': 'Capchgdt', 'Showorder': 75,
                    'Replaceid': None, 'Tbid': 447, 'Datatypeid': 55, 'Langid': 0, 'Unitid': 0, 'Mlangid': 8452,
                    'Kid': 0, 'Typename': 'Datetime', 'Length': 10, 'Accuracy': 0, 'Mergerdatatype': 'D(10)',
                    'Title': '最新股本变动日期', 'Description': '上市公司股本最近一次发生变化的日期', 'Langtypeid': 1, 'TBTitle': '日个股回报率文件',
                    'Dbid': 63, 'DBTitle': '股票市场交易', 'NodeID': 0, 'UnitTitle': '没有单位', 'Keytype': 0,
                    'UnitValue': 0, 'Mergerunit': '没有单位', 'Iscode': 0
                }, {
                    'DownCount': 122649, 'Pid': 4176, 'Fldid': 23912, 'Fldname': 'Trdsta', 'Showorder': 156,
                    'Replaceid': None, 'Tbid': 447, 'Datatypeid': 5, 'Langid': 0, 'Unitid': 0, 'Mlangid': 32557,
                    'Kid': 0, 'Typename': 'decimal', 'Length': 10, 'Accuracy': 0, 'Mergerdatatype': 'N(10,0)',
                    'Title': '交易状态',
                    'Description': '1=正常交易，2=ST，3＝*ST，4＝S（2006年10月9日及之后股改未完成），5＝SST，6＝S*ST，'
                                   '7=G（2006年10月9日之前已完成股改），8=GST，9=G*ST，10=U（2006年10月9日之前股改未完成）'
                                   '，11=UST，12=U*ST，13=N，14=NST，15=N*ST，16=PT',
                    'Langtypeid': 1, 'TBTitle': '日个股回报率文件', 'Dbid': 63, 'DBTitle': '股票市场交易', 'NodeID': 0,
                    'UnitTitle': '没有单位', 'Keytype': 0, 'UnitValue': 0, 'Mergerunit': '没有单位', 'Iscode': 1
                }],
                'TableName': 'TRD_Dalyr',
                'TableTitle': '日个股回报率文件', 'CodeKeyField': 'Stkcd', 'TimeKeyField': 'Trddt',
                'Conditions': [{
                    'FieldName': 'Trddt', 'Logic': True,
                    'Description': '[Trddt] BETWEEN \'' + start_str + '\' AND \'' + end_str + '\'',
                    'Value': start_str + ',' + end_str, 'Operator': ' BETWEEN ',
                    'IsTimeCondition': True, 'IsCondition': False
                }]
            }],
            'Codes': stock_code,
            'CodeNames': '', 'Institutionids': '', 'StartTime': start_str, 'EndTime': end_str,
            'DBID': 63, 'CodeSelType': '1', 'MID': 9, 'CodeType': '1', 'DBTitle': '股票市场交易',
            'TreeNodeId': '4178', 'QueryString': '?nodeid=4176', 'SingleTableId': 447, 'FileFormat': '1',
            'Ishavetime': True
        })
        page_row_count = 50
        return {
            'querySet': query_set.encode('utf-8'),
            'pageRowCount': str(page_row_count).encode('utf-8')
        }
