# -*- coding: utf-8 -*-

from datetime import date
from itertools import chain

import pymysql
from DBUtils import PooledDB
from dateutil.relativedelta import relativedelta
from scrapy import Item

__mysql_connection_pool = None

host = '127.0.0.1'
port = 3306
user = 'root'
password = 'ipampas'
db = 'stock'
trade_quote_table = 'stock_daily_quote'
derive_quote_table = 'stock_derive_quote'
today = date.today()


def get_connection():
    global __mysql_connection_pool
    if not __mysql_connection_pool:
        __mysql_connection_pool = PooledDB.PooledDB(pymysql, mincached=10, maxcached=100,
                                                    maxconnections=200, blocking=True, host=host, port=port,
                                                    user=user, passwd=password, db=db)
    return __mysql_connection_pool.connection()


def execute_sql(sql):
    connection = get_connection()
    cursor = connection.cursor()
    cursor.execute(sql)
    connection.commit()
    _all = cursor.fetchall()
    cursor.close()
    return _all


def build_item_sql(table, item, columns):
    if not isinstance(item, Item):
        raise Exception(u'不支持的类，item应为scrapy.Item的子类')

    sql_list = ['insert into `%s`' % table,
                '(%s)' % ('`' + '`,`'.join(columns) + '`'),
                'values (%s)' % _build_value_sql(item)]
    return ' '.join(sql_list)


def _build_value_sql(item):
    lm = lambda val: 'null' if len(val) == 0 or val == '0000-00-00' else ('"' + str(val) + '"')
    str_list = [lm(item[key]) for key in item.keys() if key != 'level']
    return ','.join(str_list)


def choose_table(stock_code):
    return trade_quote_table + str(int(stock_code) % 20)


def choose_derive(stock_code):
    return derive_quote_table + str(int(stock_code) % 30)


def get_all_stocks():
    sql = 'SELECT stock_code, listed_date from stock_company ' \
          'where stat_code = "A" and market_type in (1,4)'
    stock_tuple = execute_sql(sql)
    lm = lambda x: date(x.year, x.month, 1)
    return [(stock[0], lm(stock[1])) for stock in stock_tuple]


def get_record_stocks(table_name, mod_count):
    all_stocks = get_all_stocks()
    record_stocks_dict = _tuple_list_to_dict(_query_record_stocks(table_name, mod_count))
    lm = lambda x, y: max(x, y) if y else x
    f_lm = lambda y: (not y) or y < today
    return [(stock[0], lm(stock[1], record_stocks_dict.get(stock[0])))
            for stock in all_stocks if f_lm(record_stocks_dict.get(stock[0]))]


def _query_record_stocks(table_name, mod_count):
    template_sql = 'select stock_code, max(trade_date) from ' + table_name + '%s group by stock_code'
    record_stock = [execute_sql(template_sql % str(idx)) for idx in range(0, mod_count)]
    return list(chain.from_iterable(record_stock))


def _tuple_list_to_dict(tuple_list):
    tpl_dict = {}
    for tpl in tuple_list:
        tpl_dict[tpl[0]] = tpl[1].date() + relativedelta(days=1)
    return tpl_dict
