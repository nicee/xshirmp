# -*- coding: utf-8 -*-

import os

import scrapy.cmdline

if __name__ == '__main__':
    os.chdir('yulin_crawler/yulin_crawler/spiders')
    # company_spider csmar_stock_spider
    scrapy.cmdline.execute(['scrapy', 'crawl', 'daily_quote_spider'])
