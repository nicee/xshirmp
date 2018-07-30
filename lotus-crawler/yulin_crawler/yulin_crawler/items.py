# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# https://doc.scrapy.org/en/latest/topics/items.html

import scrapy


class YulinCrawlerItem(scrapy.Item):
    # define the fields for your item here like:
    # name = scrapy.Field()
    pass


class CSMARItem(scrapy.Item):
    Stkcd = scrapy.Field()
    Trddt = scrapy.Field()
    Opnprc = scrapy.Field()
    Hiprc = scrapy.Field()
    Loprc = scrapy.Field()
    Clsprc = scrapy.Field()
    Dnshrtrd = scrapy.Field()
    Dnvaltrd = scrapy.Field()
    Dsmvosd = scrapy.Field()
    Dsmvtll = scrapy.Field()
    Dretwd = scrapy.Field()
    Dretnd = scrapy.Field()
    Adjprcwd = scrapy.Field()
    Adjprcnd = scrapy.Field()
    Markettype = scrapy.Field()
    Capchgdt = scrapy.Field()
    Trdsta = scrapy.Field()