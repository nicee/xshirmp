# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# https://doc.scrapy.org/en/latest/topics/items.html

import scrapy


# 定义base csmar类
class bcsmar(scrapy.Item):
    level = scrapy.Field()


# 证券信息基础类
class bstock(bcsmar):
    Stkcd = scrapy.Field()


# 定义公司
class stock_company(bstock):
    Stknme = scrapy.Field()
    Conme = scrapy.Field()
    Conme_en = scrapy.Field()
    Indcd = scrapy.Field()
    Indnme = scrapy.Field()
    Estbdt = scrapy.Field()
    Listdt = scrapy.Field()
    Ipoprm = scrapy.Field()
    Ipoprc = scrapy.Field()
    Nshripo = scrapy.Field()
    Parvcur = scrapy.Field()
    Ipodt = scrapy.Field()
    Parval = scrapy.Field()
    Sctcd = scrapy.Field()
    Statco = scrapy.Field()
    Crcd = scrapy.Field()
    Statdt = scrapy.Field()
    Commnt = scrapy.Field()
    Markettype = scrapy.Field()


# 定义公司信息
class listed_company(bstock):
    Crcd = scrapy.Field()
    Stknme = scrapy.Field()
    Indcd = scrapy.Field()
    Indnme = scrapy.Field()
    IndClaCd = scrapy.Field()
    Nindcd = scrapy.Field()
    Nindnme = scrapy.Field()
    Listexg = scrapy.Field()
    Conme = scrapy.Field()
    Conmee = scrapy.Field()
    Estbdt = scrapy.Field()
    Ipodt = scrapy.Field()
    Listdt = scrapy.Field()
    Regadd = scrapy.Field()
    Regplc = scrapy.Field()
    Regcap1 = scrapy.Field()
    Regcap2 = scrapy.Field()
    Nstaff = scrapy.Field()
    Ndrct = scrapy.Field()
    Nspv = scrapy.Field()


# 定义股票日行情信息
class daily_quote(bstock):
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


# 股票衍生指标
class derive_quote(bstock):
    TradingDate = scrapy.Field()
    Symbol = scrapy.Field()
    ShortName = scrapy.Field()
    Ret = scrapy.Field()
    PE = scrapy.Field()
    PB = scrapy.Field()
    PCF = scrapy.Field()
    PS = scrapy.Field()
    Turnover = scrapy.Field()
    CirculatedMarketValue = scrapy.Field()
    ChangeRatio = scrapy.Field()
    Amount = scrapy.Field()
    Liquidility = scrapy.Field()


# 指数基本信息
class index(bcsmar):
    Indexcd = scrapy.Field()
    Idxinfo01 = scrapy.Field()
    Idxinfo02 = scrapy.Field()
    Idxinfo03 = scrapy.Field()
    Idxinfo05 = scrapy.Field()
    Idxinfo06 = scrapy.Field()
    Idxinfo07 = scrapy.Field()
    Idxinfo08 = scrapy.Field()
    Idxinfo09 = scrapy.Field()
    Idxinfo11 = scrapy.Field()