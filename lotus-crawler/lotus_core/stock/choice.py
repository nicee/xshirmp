# -*- coding: utf-8 -*-

from datetime import date

from dateutil.relativedelta import relativedelta

from lotus_core.utils import dbutil


def choose():
    cursor = dbutil.get_connection().cursor()
    trade_date = str(date.today() + relativedelta(days=-1))
    stock_codes_on_pe = _choose_on_pe(cursor, trade_date)
    stock_codes_on_probe = _choose_on_probe(cursor, trade_date)
    # print('choose to buy: ' + str(stock_codes_on_probe))
    to_buy = list(set(stock_codes_on_pe).intersection(set(stock_codes_on_probe)))
    print('choose to buy:' + str(to_buy))
    pass


# 探针搜索，下影线长于上影线2倍
def _choose_on_probe(cursor, trade_date):
    stock_codes = []
    for idx in range(0, 20):
        for item in _select_data(cursor, idx, trade_date):
            if _is_interest(item):
                stock_codes.append(item[1])
            pass
        pass
    return stock_codes


def _select_data(cursor, idx, trade_date):
    _sql = 'select * from stock_daily_quote%s where trade_date = "%s"' % (str(idx), trade_date)
    cursor.execute(_sql)
    return cursor.fetchall()


def _is_interest(item):
    low_price = item[5]
    close_price = item[6]
    percent1 = ((close_price - low_price) / low_price * 100)

    open_price = item[3]
    high_price = item[4]
    percent2 = ((high_price - open_price) / open_price * 100)

    return close_price >= high_price and percent1 > 2 * percent2


def _choose_on_pe(cursor, trade_date):
    stock_codes = []
    for idx in range(0, 30):
        stock_codes += [item[0] for item in _found_suit_turnover(cursor, idx, trade_date)]
    return stock_codes


def _found_suit_turnover(cursor, idx, trade_date):
    _sql = 'select stock_code from stock_derive_quote%s ' \
           'where trade_date = "%s" and turnover > 0.03' % (str(idx), trade_date)
    cursor.execute(_sql)
    return cursor.fetchall()


if __name__ == '__main__':
    choose()
