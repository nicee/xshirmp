# -*- coding: utf-8 -*-

from .base_spider import *
from ..dbutil import get_record_stocks
from ..items import derive_quote


class StockDeriveQuote(csmar_base_spider):
    # fields
    name = 'derive_quote_spider'

    space = relativedelta(years=1)

    sub_table_num = 30
    table = 'stock_derive_quote'

    def start_requests(self):
        stock_tuple = get_record_stocks(self.table, self.sub_table_num)
        # stock_tuple = [('600309', date(2018, 8, 10))]
        for stock in stock_tuple:
            # 遍历股票代码和上市日期，获取行情数据
            for item in super().start_requests(stock[1], stock[0]):
                yield item
            pass
        pass

    def parse(self, response):
        col_data, json_data = super().parse(response)
        if json_data:
            for item in super().build_items(json_data, col_data, derive_quote):
                yield item
            pass
        pass

    def build_query_set(self, start, stock_code):
        start_str = str(start)
        end_str = self.calc_end_date(start)
        return {
            "Tables": [{
                "TbId": 2612,
                "Fields": [
                    {"DownCount": None, "Pid": 4801, "Fldid": 37104, "Fldname": "TradingDate", "Showorder": 2,
                     "Replaceid": None, "Tbid": 2612, "Datatypeid": 55, "Langid": 1, "Unitid": 0,
                     "Mlangid": 68776, "Kid": 2, "Typename": "Datetime", "Length": 10, "Accuracy": 0,
                     "Mergerdatatype": "D(10)", "Title": "交易日期", "Description": "以上交所、深交所公布的证券代码为准", "Langtypeid": 1,
                     "TBTitle": "个股日交易衍生指标", "Dbid": 75, "DBTitle": "股票市场衍生指标", "NodeID": 0, "UnitTitle": "没有单位",
                     "Keytype": 2, "UnitValue": 0, "Mergerunit": "没有单位", "Iscode": 0},
                    {"DownCount": None, "Pid": 4801, "Fldid": 37105, "Fldname": "Symbol", "Showorder": 3,
                     "Replaceid": None, "Tbid": 2612, "Datatypeid": 126, "Langid": 0, "Unitid": 0, "Mlangid": 68777,
                     "Kid": 1, "Typename": "Nvarchar", "Length": 6, "Accuracy": 0, "Mergerdatatype": "C(6)",
                     "Title": "证券代码", "Description": "以YYYY-MM-DD表示", "Langtypeid": 1, "TBTitle": "个股日交易衍生指标",
                     "Dbid": 75, "DBTitle": "股票市场衍生指标", "NodeID": 1, "UnitTitle": "没有单位", "Keytype": 1, "UnitValue": 0,
                     "Mergerunit": "没有单位", "Iscode": 0},
                    {"DownCount": None, "Pid": 4801, "Fldid": 37106, "Fldname": "ShortName", "Showorder": 4,
                     "Replaceid": None, "Tbid": 2612, "Datatypeid": 110, "Langid": 0, "Unitid": 0, "Mlangid": 68778,
                     "Kid": 0, "Typename": "Nvarchar", "Length": 10, "Accuracy": 0, "Mergerdatatype": "C(10)",
                     "Title": "股票简称", "Description": "", "Langtypeid": 1, "TBTitle": "个股日交易衍生指标", "Dbid": 75,
                     "DBTitle": "股票市场衍生指标", "NodeID": 0, "UnitTitle": "没有单位", "Keytype": 0, "UnitValue": 0,
                     "Mergerunit": "没有单位", "Iscode": 0},
                    {"DownCount": None, "Pid": 4801, "Fldid": 37107, "Fldname": "Ret", "Showorder": 5,
                     "Replaceid": None, "Tbid": 2612, "Datatypeid": 72, "Langid": 0, "Unitid": 0, "Mlangid": 68779,
                     "Kid": 0, "Typename": "decimal", "Length": 20, "Accuracy": 6, "Mergerdatatype": "N(20,6)",
                     "Title": "股息率(股票获利率)(%)", "Description": "股息率＝公司派现合计/股票市值", "Langtypeid": 1,
                     "TBTitle": "个股日交易衍生指标", "Dbid": 75, "DBTitle": "股票市场衍生指标", "NodeID": 0, "UnitTitle": "没有单位",
                     "Keytype": 0, "UnitValue": 0, "Mergerunit": "没有单位", "Iscode": 0},
                    {"DownCount": None, "Pid": 4801, "Fldid": 37108, "Fldname": "PE", "Showorder": 6,
                     "Replaceid": None, "Tbid": 2612, "Datatypeid": 72, "Langid": 0, "Unitid": 17, "Mlangid": 68780,
                     "Kid": 0, "Typename": "decimal", "Length": 20, "Accuracy": 6, "Mergerdatatype": "N(20,6)",
                     "Title": "市盈率", "Description": "市盈率＝股票市总值/最近四个季度的归属母公司的净利润之和", "Langtypeid": 1,
                     "TBTitle": "个股日交易衍生指标", "Dbid": 75, "DBTitle": "股票市场衍生指标", "NodeID": 0, "UnitTitle": "倍",
                     "Keytype": 0, "UnitValue": 1, "Mergerunit": "倍", "Iscode": 0},
                    {"DownCount": None, "Pid": 4801, "Fldid": 37109, "Fldname": "PB", "Showorder": 7,
                     "Replaceid": None, "Tbid": 2612, "Datatypeid": 72, "Langid": 0, "Unitid": 17, "Mlangid": 68781,
                     "Kid": 0, "Typename": "decimal", "Length": 20, "Accuracy": 6, "Mergerdatatype": "N(20,6)",
                     "Title": "市净率", "Description": "市净率＝股票市值/净资产。净资产为最新定期报告公布的净资产。", "Langtypeid": 1,
                     "TBTitle": "个股日交易衍生指标", "Dbid": 75, "DBTitle": "股票市场衍生指标", "NodeID": 0, "UnitTitle": "倍",
                     "Keytype": 0, "UnitValue": 1, "Mergerunit": "倍", "Iscode": 0},
                    {"DownCount": None, "Pid": 4801, "Fldid": 37110, "Fldname": "PCF", "Showorder": 8,
                     "Replaceid": None, "Tbid": 2612, "Datatypeid": 72, "Langid": 0, "Unitid": 17, "Mlangid": 68782,
                     "Kid": 0, "Typename": "decimal", "Length": 20, "Accuracy": 6, "Mergerdatatype": "N(20,6)",
                     "Title": "市现率", "Description": "市现率＝股票市值/去年经营现金流量净额。", "Langtypeid": 1, "TBTitle": "个股日交易衍生指标",
                     "Dbid": 75, "DBTitle": "股票市场衍生指标", "NodeID": 0, "UnitTitle": "倍", "Keytype": 0, "UnitValue": 1,
                     "Mergerunit": "倍", "Iscode": 0},
                    {"DownCount": None, "Pid": 4801, "Fldid": 37111, "Fldname": "PS", "Showorder": 9, "Replaceid": None,
                     "Tbid": 2612, "Datatypeid": 72, "Langid": 0, "Unitid": 17, "Mlangid": 68783, "Kid": 0,
                     "Typename": "decimal", "Length": 20, "Accuracy": 6, "Mergerdatatype": "N(20,6)", "Title": "市销率",
                     "Description": "市销率＝股票市值/去年营业收入。", "Langtypeid": 1, "TBTitle": "个股日交易衍生指标", "Dbid": 75,
                     "DBTitle": "股票市场衍生指标", "NodeID": 0, "UnitTitle": "倍", "Keytype": 0, "UnitValue": 1,
                     "Mergerunit": "倍", "Iscode": 0},
                    {"DownCount": None, "Pid": 4801, "Fldid": 37112, "Fldname": "Turnover", "Showorder": 10,
                     "Replaceid": None, "Tbid": 2612, "Datatypeid": 176, "Langid": 0, "Unitid": 0, "Mlangid": 68784,
                     "Kid": 0, "Typename": "decimal", "Length": 10, "Accuracy": 5, "Mergerdatatype": "N(10,5)",
                     "Title": "换手率(%)", "Description": "换手率＝日个股成交金额/日个股流通市值", "Langtypeid": 1, "TBTitle": "个股日交易衍生指标",
                     "Dbid": 75, "DBTitle": "股票市场衍生指标", "NodeID": 0, "UnitTitle": "没有单位", "Keytype": 0, "UnitValue": 0,
                     "Mergerunit": "没有单位", "Iscode": 0},
                    {"DownCount": None, "Pid": 4801, "Fldid": 37113, "Fldname": "CirculatedMarketValue",
                     "Showorder": 11, "Replaceid": None, "Tbid": 2612, "Datatypeid": 26, "Langid": 0, "Unitid": 187,
                     "Mlangid": 68785, "Kid": 0, "Typename": "decimal", "Length": 20, "Accuracy": 2,
                     "Mergerdatatype": "N(20,2)", "Title": "流通市值", "Description": "", "Langtypeid": 1,
                     "TBTitle": "个股日交易衍生指标", "Dbid": 75, "DBTitle": "股票市场衍生指标", "NodeID": 0, "UnitTitle": "元",
                     "Keytype": 0, "UnitValue": 1, "Mergerunit": "元", "Iscode": 0},
                    {"DownCount": None, "Pid": 4801, "Fldid": 37114, "Fldname": "ChangeRatio", "Showorder": 12,
                     "Replaceid": None, "Tbid": 2612, "Datatypeid": 176, "Langid": 0, "Unitid": 0, "Mlangid": 68786,
                     "Kid": 0, "Typename": "decimal", "Length": 10, "Accuracy": 5, "Mergerdatatype": "N(10,5)",
                     "Title": "涨跌幅", "Description": "", "Langtypeid": 1, "TBTitle": "个股日交易衍生指标", "Dbid": 75,
                     "DBTitle": "股票市场衍生指标", "NodeID": 0, "UnitTitle": "没有单位", "Keytype": 0, "UnitValue": 0,
                     "Mergerunit": "没有单位", "Iscode": 0},
                    {"DownCount": None, "Pid": 4801, "Fldid": 37115, "Fldname": "Amount", "Showorder": 13,
                     "Replaceid": None, "Tbid": 2612, "Datatypeid": 105, "Langid": 0, "Unitid": 276, "Mlangid": 68787,
                     "Kid": 0, "Typename": "decimal", "Length": 20, "Accuracy": 0, "Mergerdatatype": "N(20,0)",
                     "Title": "成交金额", "Description": "", "Langtypeid": 1, "TBTitle": "个股日交易衍生指标", "Dbid": 75,
                     "DBTitle": "股票市场衍生指标", "NodeID": 0, "UnitTitle": "元/美元/港元", "Keytype": 0, "UnitValue": 1,
                     "Mergerunit": "元/美元/港元", "Iscode": 0},
                    {"DownCount": None, "Pid": 4801, "Fldid": 37116, "Fldname": "Liquidility", "Showorder": 14,
                     "Replaceid": None, "Tbid": 2612, "Datatypeid": 72, "Langid": 0, "Unitid": 0,
                     "Mlangid": 68788, "Kid": 0, "Typename": "decimal", "Length": 20, "Accuracy": 6,
                     "Mergerdatatype": "N(20,6)", "Title": "流动性指标", "Description": "", "Langtypeid": 1,
                     "TBTitle": "个股日交易衍生指标", "Dbid": 75, "DBTitle": "股票市场衍生指标", "NodeID": 0,
                     "UnitTitle": "没有单位", "Keytype": 0, "UnitValue": 0, "Mergerunit": "没有单位", "Iscode": 0}
                ],
                "TableName": "STK_MKT_Dalyr", "TableTitle": "个股日交易衍生指标", "CodeKeyField": "Symbol",
                "TimeKeyField": "TradingDate",
                "Conditions": [{
                    "FieldName": "TradingDate", "Logic": True,
                    "Description": "[TradingDate] BETWEEN '" + start_str + "' AND '" + end_str + "'",
                    "Value": start_str + "," + end_str,
                    "Operator": " BETWEEN ",
                    "IsTimeCondition": True,
                    "IsCondition": False}]
            }], "Codes": stock_code,
            "CodeNames": "振华股份", "Institutionids": "", "StartTime": start_str, "EndTime": end_str,
            "DBID": 75, "CodeSelType": "1", "MID": 9, "CodeType": "1", "DBTitle": "股票市场衍生指标", "TreeNodeId": "4802",
            "QueryString": "?nodeid=4801", "SingleTableId": 2612, "FileFormat": "1", "Ishavetime": True
        }
