# -*- coding: utf-8 -*-

from .base_spider import *
from ..dbutil import get_record_stocks
from ..items import daily_quote


class daily_quote_spider(csmar_base_spider):
    # fields
    name = 'daily_quote_spider'

    sub_table_num = 20
    table = 'stock_daily_quote'

    space = relativedelta(years=1)

    def start_requests(self):
        stock_tuple = get_record_stocks(self.table, self.sub_table_num)
        for stock in stock_tuple:
            # 遍历股票代码和上市日期，获取行情数据
            for item in super().start_requests(stock[1], stock[0]):
                yield item
            pass
        pass

    def parse(self, response):
        col_data, json_data = super().parse(response)
        if json_data:
            for item in super().build_items(json_data, col_data, daily_quote):
                yield item
            pass
        pass

    def build_query_set(self, start, stock_code):
        start_str = str(start)
        end_str = self.calc_end_date(start)
        return {
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
        }
