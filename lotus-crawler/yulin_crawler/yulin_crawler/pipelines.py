# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://doc.scrapy.org/en/latest/topics/item-pipeline.html

import pymysql
from DBUtils import PooledDB

from .items import CSMARItem


class YulinCrawlerPipeline(object):

    def process_item(self, item, spider):
        if isinstance(item, CSMARItem):
            self._save_stock_item(item)
        else:
            return item

    def _get_connection(self):
        host = 'localhost'
        port = 3306
        user = 'root'
        password = 'ipampas'
        db = 'stock'
        __mysql_connection_pool = PooledDB.PooledDB(pymysql, mincached=3, maxcached=50,
                                                    maxconnections=100, blocking=True, host=host, port=port,
                                                    user=user, passwd=password, db=db)
        return __mysql_connection_pool.connection()

    def _save_stock_item(self, item):
        insert_sql = ['insert into `stock_trade_quote`',
                      '(`stock_code`, `trade_date`, `open_price`, `high_price`, `low_price`, `close_price`,',
                      '`trade_volume`, `trade_amount`, `market_value`, `stock_total_market_value`, `return_dividend`, '
                      '`return_no_dividend`, `adj_close_price_with_dividend`, `adj_close_price_without_dividend`, '
                      '`market_type`, `captical_stock_change_date`, `trade_state`)',
                      'values("%s", "%s", "%s", "%s" , "%s" , "%s", "%s", "%s", "%s", "%s", "%s", '
                      '"%s", "%s", "%s", "%s", "%s", "%s")' % (
                          item['Stkcd'], item['Trddt'], item['Opnprc'], item['Hiprc'], item['Loprc'], item['Clsprc'],
                          item['Dnshrtrd'], item['Dnvaltrd'], item['Dsmvosd'], item['Dsmvtll'], item['Dretwd'],
                          item['Dretnd'], item['Adjprcwd'], item['Adjprcnd'], item['Markettype'], item['Capchgdt'],
                          item['Trdsta']
                      ),
                      'on duplicate key update `stock_code`="%s", `trade_date`="%s"' % (
                          item['Stkcd'], item['Trddt']
                      )]
        connection = self._get_connection()
        cursor = connection.cursor()
        cursor.execute(' '.join(insert_sql))
        connection.commit()
        cursor.close()
        connection.close()
