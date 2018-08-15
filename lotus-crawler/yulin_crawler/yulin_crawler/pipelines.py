# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://doc.scrapy.org/en/latest/topics/item-pipeline.html

from .dbutil import *
from .items import *


class _StorePipeline(object):
    """
    定义保存Item的模板类, 子类只需要实现check_item和save_to_db方法即可
    """

    def process_item(self, item, spider):
        if self.check_item(item):
            self.save_to_db(item)
        else:
            return item

    def check_item(self, item):
        raise NotImplementedError('{}.check_item callback is not defined'.format(self.__class__.__name__))

    def save_to_db(self, item):
        raise NotImplementedError('{}.save_to_db callback is not defined'.format(self.__class__.__name__))


class ListedCompanyPipeline(_StorePipeline):

    def check_item(self, item):
        return isinstance(item, listed_company)

    def save_to_db(self, item):
        columns = ['stock_code', 'cross_code', 'stock_name', 'industry_code', 'industry_name', 'listed_name',
                   'company_name', 'company_name_en', 'establish_date', 'ipo_date', 'listed_date',
                   'registry_address', 'registry_location', 'registry_capacity1', 'registry_capacity2', 'number_staff',
                   'number_directors', 'number_supervisors']
        sql = build_item_sql('stock_company_a', item, columns)
        sql += ' on duplicate key update `stock_code` = "%s"' % item['Stkcd']
        execute_sql(sql)


class StockCompanyPipeline(_StorePipeline):

    def check_item(self, item):
        return isinstance(item, stock_company)

    def save_to_db(self, item):
        columns = ['stock_code', 'stock_name', 'company_name', 'company_name_en', 'industry_code', 'industry_name',
                   'establish_date', 'listed_date', 'ipo_premium', 'ipo_price', 'ipo_amount', 'ipo_currency',
                   'ipo_date', 'parval', 'ipo_area', 'stat_code', 'cross_code', 'stat_date', 'hk_cross_code',
                   'market_type']
        sql = build_item_sql('stock_company', item, columns)
        sql += ' on duplicate key update `stock_code` = "%s"' % item['Stkcd']
        execute_sql(sql)


class DailyQuotePipeline(_StorePipeline):

    def check_item(self, item):
        return isinstance(item, daily_quote)

    def save_to_db(self, item):
        columns = ['stock_code', 'trade_date', 'open_price', 'high_price', 'low_price', 'close_price', 'trade_volume',
                   'trade_amount', 'market_circulate', 'market_amount', 'return_dividend', 'return_no_dividend',
                   'adj_price_with_dividend', 'adj_price_without_dividend', 'market_type', 'capital_change_date',
                   'trade_state']
        sql = build_item_sql(choose_table(item['Stkcd']), item, columns)
        sql += ' on duplicate key update `stock_code`="%s", `trade_date`="%s"' % (item['Stkcd'], item['Trddt'])
        execute_sql(sql)


class DeriveQuotePipeline(_StorePipeline):

    def check_item(self, item):
        return isinstance(item, derive_quote)

    def save_to_db(self, item):
        columns = ['trade_date', 'stock_code', 'short_name', 'dividend_ret', 'PE', 'PB', 'PCF', 'PS', 'turnover',
                   'circulate_market', 'change_ratio', 'amount', 'liquidity']
        sql = build_item_sql(choose_derive(item['Symbol']), item, columns)
        sql += ' on duplicate key update `stock_code`="%s"' % item['Symbol']
        execute_sql(sql)


class IndexPipeline(_StorePipeline):

    def check_item(self, item):
        return isinstance(item, index)

    def save_to_db(self, item):
        columns = ['index_code', 'index_name', 'datum_date', 'datum_value', 'weight_method', 'publisher',
                   'index_category', 'index_type', 'market_type', 'begin_date']
        sql = build_item_sql('index_info', item, columns)
        sql += ' on duplicate key update `index_code`="%s"' % item['Indexcd']
        execute_sql(sql)
