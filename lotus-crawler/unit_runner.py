# -*- coding: utf-8 -*-

import scrapy.cmdline
import os

if __name__ == '__main__':
    os.chdir('yulin_crawler/yulin_crawler/spiders')
    scrapy.cmdline.execute(['scrapy', 'crawl', 'csmar_stock_spider'])
