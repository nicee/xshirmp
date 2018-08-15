# -*- coding: utf-8 -*-

from .base_spider import *
from ..items import index


class IndexInfo(csmar_base_spider):
    name = 'index_info_spider'

    space = relativedelta(years=3)

    def start_requests(self):
        start = date(1896, 1, 1)
        for item in super().start_requests(start, None):
            yield item

    def parse(self, response):
        col_data, json_data = super().parse(response)
        if json_data:
            for item in super().build_items(json_data, col_data, index):
                yield item
            pass
        pass

    def build_query_set(self, start, stock_code=None):
        start_str = str(start)
        end_str = self.calc_end_date(start)
        return {
            "Tables": [{
                "TbId": 789,
                "Fields": [
                    {"DownCount": 3362, "Pid": 254, "Fldid": 12016, "Fldname": "Indexcd", "Showorder": 1,
                     "Replaceid": None,
                     "Tbid": 789, "Datatypeid": 110, "Langid": 0, "Unitid": 0, "Mlangid": 13565, "Kid": 1,
                     "Typename": "Nvarchar", "Length": 10, "Accuracy": 0, "Mergerdatatype": "C(10)", "Title": "交易所指数代码",
                     "Description": "以交易所实际指数代码为准", "Langtypeid": 1, "TBTitle": "指数基本信息文件", "Dbid": 42,
                     "DBTitle": "市场指数",
                     "NodeID": 1, "UnitTitle": "没有单位", "Keytype": 1, "UnitValue": 0, "Mergerunit": "没有单位", "Iscode": 0},
                    {"DownCount": 3568, "Pid": 254, "Fldid": 12017, "Fldname": "Idxinfo01", "Showorder": 2,
                     "Replaceid": None,
                     "Tbid": 789, "Datatypeid": 57, "Langid": 0, "Unitid": 0, "Mlangid": 13566, "Kid": 0,
                     "Typename": "Nvarchar", "Length": 100, "Accuracy": 0, "Mergerdatatype": "C(100)", "Title": "指数名称",
                     "Description": "以交易所实际指数名称为准", "Langtypeid": 1, "TBTitle": "指数基本信息文件", "Dbid": 42,
                     "DBTitle": "市场指数",
                     "NodeID": 0, "UnitTitle": "没有单位", "Keytype": 0, "UnitValue": 0, "Mergerunit": "没有单位", "Iscode": 0},
                    {"DownCount": 2887, "Pid": 254, "Fldid": 12019, "Fldname": "Idxinfo02", "Showorder": 4,
                     "Replaceid": None,
                     "Tbid": 789, "Datatypeid": 55, "Langid": 0, "Unitid": 0, "Mlangid": 13568, "Kid": 0,
                     "Typename": "Datetime", "Length": 10, "Accuracy": 0, "Mergerdatatype": "D(10)", "Title": "基准日期",
                     "Description": "以YYYY-MM-DD表示", "Langtypeid": 1, "TBTitle": "指数基本信息文件", "Dbid": 42,
                     "DBTitle": "市场指数",
                     "NodeID": 0, "UnitTitle": "没有单位", "Keytype": 0, "UnitValue": 0, "Mergerunit": "没有单位", "Iscode": 0},
                    {"DownCount": 2779, "Pid": 254, "Fldid": 12020, "Fldname": "Idxinfo03", "Showorder": 5,
                     "Replaceid": None,
                     "Tbid": 789, "Datatypeid": 21, "Langid": 0, "Unitid": 0, "Mlangid": 13569, "Kid": 0,
                     "Typename": "decimal",
                     "Length": 18, "Accuracy": 3, "Mergerdatatype": "N(18,3)", "Title": "基准点数",
                     "Description": "-9666＝缺少资料",
                     "Langtypeid": 1, "TBTitle": "指数基本信息文件", "Dbid": 42, "DBTitle": "市场指数", "NodeID": 0,
                     "UnitTitle": "没有单位",
                     "Keytype": 0, "UnitValue": 0, "Mergerunit": "没有单位", "Iscode": 0},
                    {"DownCount": 2358, "Pid": 254, "Fldid": 12022, "Fldname": "Idxinfo05", "Showorder": 7,
                     "Replaceid": None,
                     "Tbid": 789, "Datatypeid": 57, "Langid": 0, "Unitid": 0, "Mlangid": 13571, "Kid": 0,
                     "Typename": "Nvarchar", "Length": 100, "Accuracy": 0, "Mergerdatatype": "C(100)", "Title": "加权方式",
                     "Description": "1＝派氏加权法；2＝简单平均加权法；3＝等权重方式；4＝其它", "Langtypeid": 1, "TBTitle": "指数基本信息文件",
                     "Dbid": 42,
                     "DBTitle": "市场指数", "NodeID": 0, "UnitTitle": "没有单位", "Keytype": 0, "UnitValue": 0,
                     "Mergerunit": "没有单位",
                     "Iscode": 1},
                    {"DownCount": 2364, "Pid": 254, "Fldid": 12023, "Fldname": "Idxinfo06", "Showorder": 8,
                     "Replaceid": None,
                     "Tbid": 789, "Datatypeid": 57, "Langid": 0, "Unitid": 0, "Mlangid": 13572, "Kid": 0,
                     "Typename": "Nvarchar", "Length": 100, "Accuracy": 0, "Mergerdatatype": "C(100)", "Title": "发布机构",
                     "Description": "1＝上海证券交易所；2＝深圳证券交易所；3=中证指数有限公司；4 ＝深圳证券信息有限公司；5＝其它", "Langtypeid": 1,
                     "TBTitle": "指数基本信息文件",
                     "Dbid": 42, "DBTitle": "市场指数", "NodeID": 0, "UnitTitle": "没有单位", "Keytype": 0, "UnitValue": 0,
                     "Mergerunit": "没有单位", "Iscode": 1},
                    {"DownCount": 2561, "Pid": 254, "Fldid": 12024, "Fldname": "Idxinfo07", "Showorder": 9,
                     "Replaceid": None,
                     "Tbid": 789, "Datatypeid": 103, "Langid": 0, "Unitid": 0, "Mlangid": 13573, "Kid": 0,
                     "Typename": "Nvarchar", "Length": 20, "Accuracy": 0, "Mergerdatatype": "C(20)", "Title": "指数类别",
                     "Description": "1=股票类,2=基金类,3=债券类,4=期货类; 5=指数类; 6=币种类; 7=其他类型", "Langtypeid": 1,
                     "TBTitle": "指数基本信息文件",
                     "Dbid": 42, "DBTitle": "市场指数", "NodeID": 0, "UnitTitle": "没有单位", "Keytype": 0, "UnitValue": 0,
                     "Mergerunit": "没有单位", "Iscode": 1},
                    {"DownCount": 2601, "Pid": 254, "Fldid": 12025, "Fldname": "Idxinfo08", "Showorder": 10,
                     "Replaceid": None,
                     "Tbid": 789, "Datatypeid": 84, "Langid": 0, "Unitid": 0, "Mlangid": 13574, "Kid": 0,
                     "Typename": "decimal",
                     "Length": 1, "Accuracy": 0, "Mergerdatatype": "N(1,0)", "Title": "指数类型",
                     "Description": "1=综合指数类，2=样本指数类，3=分类指数类，4=其他指数类", "Langtypeid": 1, "TBTitle": "指数基本信息文件",
                     "Dbid": 42,
                     "DBTitle": "市场指数", "NodeID": 0, "UnitTitle": "没有单位", "Keytype": 0, "UnitValue": 0,
                     "Mergerunit": "没有单位",
                     "Iscode": 1},
                    {"DownCount": 2579, "Pid": 254, "Fldid": 12026, "Fldname": "Idxinfo09", "Showorder": 11,
                     "Replaceid": None,
                     "Tbid": 789, "Datatypeid": 57, "Langid": 0, "Unitid": 0, "Mlangid": 13575, "Kid": 0,
                     "Typename": "Nvarchar", "Length": 100, "Accuracy": 0, "Mergerdatatype": "C(100)", "Title": "所属市场",
                     "Description": "1=上海，2=深圳，3=沪深，4=香港，5=海外，6=银行间，7=期货交易所，8=其他市场", "Langtypeid": 1,
                     "TBTitle": "指数基本信息文件",
                     "Dbid": 42, "DBTitle": "市场指数", "NodeID": 0, "UnitTitle": "没有单位", "Keytype": 0, "UnitValue": 0,
                     "Mergerunit": "没有单位", "Iscode": 1},
                    {"DownCount": 2840, "Pid": 254, "Fldid": 12029, "Fldname": "Idxinfo11", "Showorder": 14,
                     "Replaceid": None,
                     "Tbid": 789, "Datatypeid": 55, "Langid": 1, "Unitid": 0, "Mlangid": 13578, "Kid": 2,
                     "Typename": "Datetime", "Length": 10, "Accuracy": 0, "Mergerdatatype": "D(10)", "Title": "开始日期",
                     "Description": "以YYYY-MM-DD表示", "Langtypeid": 1, "TBTitle": "指数基本信息文件", "Dbid": 42,
                     "DBTitle": "市场指数",
                     "NodeID": 0, "UnitTitle": "没有单位", "Keytype": 2, "UnitValue": 0, "Mergerunit": "没有单位",
                     "Iscode": 0}],
                "TableName": "IDX_Idxinfo", "TableTitle": "指数基本信息文件", "CodeKeyField": "Indexcd",
                "TimeKeyField": "Idxinfo11",
                "Conditions": [{
                    "FieldName": "Idxinfo11", "Logic": True,
                    "Description": "[Idxinfo11] BETWEEN '" + start_str + "' AND '" + end_str + "'",
                    "Value": start_str + "," + end_str,
                    "Operator": " BETWEEN ",
                    "IsTimeCondition": True,
                    "IsCondition": False
                }]
            }], "Codes": "",
            "CodeNames": "", "Institutionids": "", "StartTime": start_str, "EndTime": end_str, "DBID": 42,
            "CodeSelType": "0", "MID": 9, "CodeType": "5", "DBTitle": "市场指数", "TreeNodeId": "255",
            "QueryString": "?nodeid=254", "SingleTableId": 789, "FileFormat": "1", "Ishavetime": True
        }
