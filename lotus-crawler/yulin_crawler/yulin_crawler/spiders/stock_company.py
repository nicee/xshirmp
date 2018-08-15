# -*- coding: utf-8 -*-

from .base_spider import *
from ..items import stock_company


class stock_company_spider(csmar_base_spider):
    # fields
    name = 'stock_company_spider'

    space = relativedelta(years=1)

    def start_requests(self):
        start = date(1990, 12, 1)
        for item in super().start_requests(start, None):
            yield item

    def parse(self, response):
        col_data, json_data = super().parse(response)
        if json_data:
            for item in super().build_items(json_data, col_data, stock_company):
                yield item
            pass
        pass

    def build_query_set(self, start, stock_code=None):
        start_str = start.strftime('%Y-%m-%d')
        end_str = (start + self.space).strftime('%Y-%m-%d')
        return {
            "Tables": [{
                "TbId": 444,
                "Fields": [
                    {"DownCount": 62687, "Pid": 4176, "Fldid": 6840, "Fldname": "Stkcd", "Showorder": 2,
                     "Replaceid": None, "Tbid": 444, "Datatypeid": 126, "Langid": 0, "Unitid": 0, "Mlangid": 8389,
                     "Kid": 1, "Typename": "Nvarchar", "Length": 6, "Accuracy": 0, "Mergerdatatype": "C(6)",
                     "Title": "证券代码",
                     "Description": "以上交所、深交所公布的证券代码为准", "Langtypeid": 1, "TBTitle": "公司文件", "Dbid": 63,
                     "DBTitle": "股票市场交易",
                     "NodeID": 1, "UnitTitle": "没有单位", "Keytype": 1, "UnitValue": 0, "Mergerunit": "没有单位", "Iscode": 0},
                    {"DownCount": 42435, "Pid": 4176, "Fldid": 6841, "Fldname": "Stknme", "Showorder": 3,
                     "Replaceid": None, "Tbid": 444, "Datatypeid": 103, "Langid": 0, "Unitid": 0, "Mlangid": 8390,
                     "Kid": 0, "Typename": "Nvarchar", "Length": 20, "Accuracy": 0, "Mergerdatatype": "C(20)",
                     "Title": "证券简称",
                     "Description": "以交易所公布的中文简称为准", "Langtypeid": 1, "TBTitle": "公司文件", "Dbid": 63,
                     "DBTitle": "股票市场交易",
                     "NodeID": 0, "UnitTitle": "没有单位", "Keytype": 0, "UnitValue": 0, "Mergerunit": "没有单位", "Iscode": 0},
                    {"DownCount": 30618, "Pid": 4176, "Fldid": 6844, "Fldname": "Conme", "Showorder": 6,
                     "Replaceid": None, "Tbid": 444, "Datatypeid": 57, "Langid": 0, "Unitid": 0, "Mlangid": 8393,
                     "Kid": 0,
                     "Typename": "Nvarchar",
                     "Length": 100, "Accuracy": 0, "Mergerdatatype": "C(100)", "Title": "公司全称",
                     "Description": "以公司公布的中文名为准", "Langtypeid": 1, "TBTitle": "公司文件", "Dbid": 63, "DBTitle": "股票市场交易",
                     "NodeID": 0,
                     "UnitTitle": "没有单位", "Keytype": 0, "UnitValue": 0, "Mergerunit": "没有单位", "Iscode": 0},
                    {"DownCount": 15428, "Pid": 4176, "Fldid": 6845, "Fldname": "Conme_en", "Showorder": 7,
                     "Replaceid": None,
                     "Tbid": 444, "Datatypeid": 57, "Langid": 0, "Unitid": 0, "Mlangid": 8394, "Kid": 0,
                     "Typename": "Nvarchar",
                     "Length": 100, "Accuracy": 0, "Mergerdatatype": "C(100)", "Title": "公司英文全称",
                     "Description": "以公司公布的英文名为准",
                     "Langtypeid": 1, "TBTitle": "公司文件", "Dbid": 63, "DBTitle": "股票市场交易", "NodeID": 0,
                     "UnitTitle": "没有单位",
                     "Keytype": 0, "UnitValue": 0, "Mergerunit": "没有单位", "Iscode": 0},
                    {"DownCount": 27222, "Pid": 4176, "Fldid": 6846, "Fldname": "Indcd", "Showorder": 8,
                     "Replaceid": None,
                     "Tbid": 444, "Datatypeid": 101, "Langid": 0, "Unitid": 0, "Mlangid": 8395, "Kid": 0,
                     "Typename": "Nvarchar", "Length": 4, "Accuracy": 0, "Mergerdatatype": "C(4)", "Title": "行业代码A",
                     "Description": "0001=金融，0002=公用事业，0003=房地产，0004=综合，0005=工业，0006=商业", "Langtypeid": 1,
                     "TBTitle": "公司文件",
                     "Dbid": 63, "DBTitle": "股票市场交易", "NodeID": 0, "UnitTitle": "没有单位", "Keytype": 0, "UnitValue": 0,
                     "Mergerunit": "没有单位", "Iscode": 1},
                    {"DownCount": 26738, "Pid": 4176, "Fldid": 6847, "Fldname": "Indnme", "Showorder": 9,
                     "Replaceid": None,
                     "Tbid": 444, "Datatypeid": 153, "Langid": 0, "Unitid": 0, "Mlangid": 8396, "Kid": 0,
                     "Typename": "Nvarchar", "Length": 50, "Accuracy": 0, "Mergerdatatype": "C(50)", "Title": "行业名称A",
                     "Description": "Finance=金融，Utilities=公用事业，Properties=房地产，Conglomerates=综合，Industrials=工业，Commerce=商业",
                     "Langtypeid": 1, "TBTitle": "公司文件", "Dbid": 63, "DBTitle": "股票市场交易", "NodeID": 0,
                     "UnitTitle": "没有单位",
                     "Keytype": 0, "UnitValue": 0, "Mergerunit": "没有单位", "Iscode": 0},
                    {"DownCount": 22617, "Pid": 4176, "Fldid": 6852, "Fldname": "Estbdt", "Showorder": 17,
                     "Replaceid": None,
                     "Tbid": 444, "Datatypeid": 55, "Langid": 0, "Unitid": 0, "Mlangid": 8401, "Kid": 0,
                     "Typename": "Datetime",
                     "Length": 10, "Accuracy": 0, "Mergerdatatype": "D(10)", "Title": "公司成立日期",
                     "Description": "以YYYY-MM-DD列示，部分缺少在相应位置上以00表示，如1993年12月某日表示为1993-12-00", "Langtypeid": 1,
                     "TBTitle": "公司文件", "Dbid": 63, "DBTitle": "股票市场交易", "NodeID": 0, "UnitTitle": "没有单位", "Keytype": 0,
                     "UnitValue": 0, "Mergerunit": "没有单位", "Iscode": 0},
                    {"DownCount": 36095, "Pid": 4176, "Fldid": 6853, "Fldname": "Listdt", "Showorder": 18,
                     "Replaceid": None,
                     "Tbid": 444, "Datatypeid": 55, "Langid": 1, "Unitid": 0, "Mlangid": 8402, "Kid": 2,
                     "Typename": "Datetime",
                     "Length": 10, "Accuracy": 0, "Mergerdatatype": "D(10)", "Title": "上市日期",
                     "Description": "以YYYY-MM-DD表示，上市日期为此股票证券代码的上市日期.", "Langtypeid": 1, "TBTitle": "公司文件", "Dbid": 63,
                     "DBTitle": "股票市场交易", "NodeID": 0, "UnitTitle": "没有单位", "Keytype": 2, "UnitValue": 0,
                     "Mergerunit": "没有单位",
                     "Iscode": 0},
                    {"DownCount": 15380, "Pid": 4176, "Fldid": 6856, "Fldname": "Ipoprm", "Showorder": 21,
                     "Replaceid": None,
                     "Tbid": 444, "Datatypeid": 51, "Langid": 0, "Unitid": 187, "Mlangid": 8405, "Kid": 0,
                     "Typename": "decimal", "Length": 10, "Accuracy": 4, "Mergerdatatype": "N(10,4)", "Title": "股票发行溢价",
                     "Description": "缺少以-9666表示", "Langtypeid": 1, "TBTitle": "公司文件", "Dbid": 63, "DBTitle": "股票市场交易",
                     "NodeID": 0, "UnitTitle": "元", "Keytype": 0, "UnitValue": 1, "Mergerunit": "元", "Iscode": 0},
                    {"DownCount": 17528, "Pid": 4176, "Fldid": 6857, "Fldname": "Ipoprc", "Showorder": 22,
                     "Replaceid": None,
                     "Tbid": 444, "Datatypeid": 51, "Langid": 0, "Unitid": 191, "Mlangid": 8406, "Kid": 0,
                     "Typename": "decimal", "Length": 10, "Accuracy": 4, "Mergerdatatype": "N(10,4)", "Title": "发行价格",
                     "Description": "缺少以-9666表示", "Langtypeid": 1, "TBTitle": "公司文件", "Dbid": 63, "DBTitle": "股票市场交易",
                     "NodeID": 0, "UnitTitle": "元/股", "Keytype": 0, "UnitValue": 1, "Mergerunit": "元/股", "Iscode": 0},
                    {"DownCount": 17166, "Pid": 4176, "Fldid": 6859, "Fldname": "Nshripo", "Showorder": 24,
                     "Replaceid": None,
                     "Tbid": 444, "Datatypeid": 30, "Langid": 0, "Unitid": 88, "Mlangid": 8408, "Kid": 0,
                     "Typename": "decimal",
                     "Length": 14, "Accuracy": 0, "Mergerdatatype": "N(14,0)", "Title": "发行数量",
                     "Description": "缺少值以-9666表示",
                     "Langtypeid": 1, "TBTitle": "公司文件", "Dbid": 63, "DBTitle": "股票市场交易", "NodeID": 0, "UnitTitle": "股",
                     "Keytype": 0, "UnitValue": 1000, "Mergerunit": "千股", "Iscode": 0},
                    {"DownCount": 14123, "Pid": 4176, "Fldid": 6860, "Fldname": "Parvcur", "Showorder": 25,
                     "Replaceid": None,
                     "Tbid": 444, "Datatypeid": 120, "Langid": 0, "Unitid": 0, "Mlangid": 8409, "Kid": 0,
                     "Typename": "Nvarchar", "Length": 3, "Accuracy": 0, "Mergerdatatype": "C(3)", "Title": "股票面值的计量货币",
                     "Description": "计量货币：人民币元，CNY=人民币元", "Langtypeid": 1, "TBTitle": "公司文件", "Dbid": 63,
                     "DBTitle": "股票市场交易",
                     "NodeID": 0, "UnitTitle": "没有单位", "Keytype": 0, "UnitValue": 0, "Mergerunit": "没有单位", "Iscode": 0},
                    {"DownCount": 17078, "Pid": 4176, "Fldid": 6861, "Fldname": "Ipodt", "Showorder": 26,
                     "Replaceid": None,
                     "Tbid": 444, "Datatypeid": 55, "Langid": 0, "Unitid": 0, "Mlangid": 8410, "Kid": 0,
                     "Typename": "Datetime",
                     "Length": 10, "Accuracy": 0, "Mergerdatatype": "D(10)", "Title": "发行日期",
                     "Description": "以YYYY-MM-DD表示",
                     "Langtypeid": 1, "TBTitle": "公司文件", "Dbid": 63, "DBTitle": "股票市场交易", "NodeID": 0,
                     "UnitTitle": "没有单位",
                     "Keytype": 0, "UnitValue": 0, "Mergerunit": "没有单位", "Iscode": 0},
                    {"DownCount": 16180, "Pid": 4176, "Fldid": 6862, "Fldname": "Parval", "Showorder": 27,
                     "Replaceid": None,
                     "Tbid": 444, "Datatypeid": 19, "Langid": 0, "Unitid": 187, "Mlangid": 8411, "Kid": 0,
                     "Typename": "decimal", "Length": 8, "Accuracy": 3, "Mergerdatatype": "N(8,3)", "Title": "股票面值",
                     "Description": "", "Langtypeid": 1, "TBTitle": "公司文件", "Dbid": 63, "DBTitle": "股票市场交易",
                     "NodeID": 0,
                     "UnitTitle": "元", "Keytype": 0, "UnitValue": 1, "Mergerunit": "元", "Iscode": 0},
                    {"DownCount": 14825, "Pid": 4176, "Fldid": 6863, "Fldname": "Sctcd", "Showorder": 28,
                     "Replaceid": None,
                     "Tbid": 444, "Datatypeid": 84, "Langid": 0, "Unitid": 0, "Mlangid": 8412, "Kid": 0,
                     "Typename": "decimal",
                     "Length": 1, "Accuracy": 0, "Mergerdatatype": "N(1,0)", "Title": "区域码", "Description": "1=上海，2=深圳",
                     "Langtypeid": 1, "TBTitle": "公司文件", "Dbid": 63, "DBTitle": "股票市场交易", "NodeID": 0,
                     "UnitTitle": "没有单位",
                     "Keytype": 0, "UnitValue": 0, "Mergerunit": "没有单位", "Iscode": 1},
                    {"DownCount": 16660, "Pid": 4176, "Fldid": 6864, "Fldname": "Statco", "Showorder": 29,
                     "Replaceid": None,
                     "Tbid": 444, "Datatypeid": 7, "Langid": 0, "Unitid": 0, "Mlangid": 8413, "Kid": 0,
                     "Typename": "Nvarchar",
                     "Length": 1, "Accuracy": 0, "Mergerdatatype": "C(1)", "Title": "公司活动情况",
                     "Description": "A=正常交易，D＝终止上市，S=暂停上市， N=停牌", "Langtypeid": 1, "TBTitle": "公司文件", "Dbid": 63,
                     "DBTitle": "股票市场交易", "NodeID": 0, "UnitTitle": "没有单位", "Keytype": 0, "UnitValue": 0,
                     "Mergerunit": "没有单位",
                     "Iscode": 1},
                    {"DownCount": 16734, "Pid": 4176, "Fldid": 6865, "Fldname": "Crcd", "Showorder": 30,
                     "Replaceid": None,
                     "Tbid": 444, "Datatypeid": 126, "Langid": 0, "Unitid": 0, "Mlangid": 8414, "Kid": 0,
                     "Typename": "Nvarchar", "Length": 6, "Accuracy": 0, "Mergerdatatype": "C(6)", "Title": "AB股交叉码",
                     "Description": "A股和B股的交叉码，指同时拥有A股和B股的公司的A（B）股对应的B（A）股代码", "Langtypeid": 1, "TBTitle": "公司文件",
                     "Dbid": 63,
                     "DBTitle": "股票市场交易", "NodeID": 0, "UnitTitle": "没有单位", "Keytype": 0, "UnitValue": 0,
                     "Mergerunit": "没有单位",
                     "Iscode": 0},
                    {"DownCount": 14507, "Pid": 4176, "Fldid": 6866, "Fldname": "Statdt", "Showorder": 31,
                     "Replaceid": None,
                     "Tbid": 444, "Datatypeid": 55, "Langid": 0, "Unitid": 0, "Mlangid": 8415, "Kid": 0,
                     "Typename": "Datetime",
                     "Length": 10, "Accuracy": 0, "Mergerdatatype": "D(10)", "Title": "情况变动日",
                     "Description": "以YYYY-MM-DD表示",
                     "Langtypeid": 1, "TBTitle": "公司文件", "Dbid": 63, "DBTitle": "股票市场交易", "NodeID": 0,
                     "UnitTitle": "没有单位",
                     "Keytype": 0, "UnitValue": 0, "Mergerunit": "没有单位", "Iscode": 0},
                    {"DownCount": 16572, "Pid": 4176, "Fldid": 6867, "Fldname": "Commnt", "Showorder": 32,
                     "Replaceid": None,
                     "Tbid": 444, "Datatypeid": 79, "Langid": 0, "Unitid": 0, "Mlangid": 8416, "Kid": 0,
                     "Typename": "Nvarchar",
                     "Length": 200, "Accuracy": 0, "Mergerdatatype": "C(200)", "Title": "H股交叉码",
                     "Description": "None：表示没有交叉码",
                     "Langtypeid": 1, "TBTitle": "公司文件", "Dbid": 63, "DBTitle": "股票市场交易", "NodeID": 0,
                     "UnitTitle": "没有单位",
                     "Keytype": 0, "UnitValue": 0, "Mergerunit": "没有单位", "Iscode": 0},
                    {"DownCount": 22952, "Pid": 4176, "Fldid": 6868, "Fldname": "Markettype", "Showorder": 33,
                     "Replaceid": None, "Tbid": 444, "Datatypeid": 5, "Langid": 0, "Unitid": 0, "Mlangid": 8417,
                     "Kid": 0,
                     "Typename": "decimal", "Length": 10, "Accuracy": 0, "Mergerdatatype": "N(10,0)", "Title": "市场类型",
                     "Description": "1=上海A，2=上海B，4=深圳A，8=深圳B,  16=创业板", "Langtypeid": 1, "TBTitle": "公司文件", "Dbid": 63,
                     "DBTitle": "股票市场交易", "NodeID": 0, "UnitTitle": "没有单位", "Keytype": 0, "UnitValue": 0,
                     "Mergerunit": "没有单位",
                     "Iscode": 1}],
                "TableName": "TRD_Co",
                "TableTitle": "公司文件",
                "CodeKeyField": "Stkcd",
                "TimeKeyField": "Listdt",
                "Conditions": [{
                    "FieldName": "Listdt", "Logic": True,
                    "Description": "[Listdt] BETWEEN '" + start_str + "' AND '" + end_str + "'",
                    "Value": start_str + "," + end_str, "Operator": " BETWEEN ", "IsTimeCondition": True,
                    "IsCondition": False
                }]
            }], "Codes": "", "CodeNames": "", "Institutionids": "",
            "StartTime": start_str, "EndTime": end_str, "DBID": 63, "CodeSelType": "0", "MID": 9,
            "CodeType": "1", "DBTitle": "股票市场交易", "TreeNodeId": "4177", "QueryString": "?nodeid=4176",
            "SingleTableId": 444, "FileFormat": "1", "Ishavetime": True
        }