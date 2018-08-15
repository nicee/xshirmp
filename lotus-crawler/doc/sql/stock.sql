
-- 创建数据库
create database if not exists `stock` default charset utf8mb4 collate utf8mb4_general_ci;

-- 国内股票(A股)交易日行情表
drop table if exists `stock_daily_quote`;
create table `stock_daily_quote`(
  `id` bigint(20) not null auto_increment comment 'id',
  `stock_code` varchar(20) not null comment '证券代码',
  `trade_date` datetime not null comment '交易日期',
  `open_price` decimal(20,6) comment '日开盘价',
  `high_price` decimal(20,6) comment '日最高价',
  `low_price` decimal(20,6) comment '日最低价',
  `close_price` decimal(20,6) comment '日收盘价',
  `trade_volume` decimal(20,6) comment '日交易量',
  `trade_amount` decimal(20,6) comment '日交易金额',
  `market_circulate` decimal(20,6) comment '日个股流通市值',
  `market_amount` decimal(30,6) comment '日个股总市值',
  `return_dividend` decimal(20,6) comment '考虑现金红利再投资的日个股回报率',
  `return_no_dividend` decimal(20,6) comment '不考虑现金红利的日个股回报率',
  `adj_price_with_dividend` decimal(20,6) comment '考虑现金红利再投资的收盘价的可比价格',
  `adj_price_without_dividend` decimal(20,6) comment '不考虑现金红利的收盘价的可比价格',
  `market_type` int(11) not null comment '市场类型, 1=上海A，2=上海B，4=深圳A，8=深圳B, 16=创业板',
  `capital_change_date` datetime comment '上市公司股本最近一次发生变化的日期',
  `trade_state` int(11) comment '交易状态, 1=正常交易，2=ST，3＝*ST，4＝S，5＝SST，6＝S*ST，7=G，8=GST，9=G*ST，10=U，11=UST，12=U*ST，13=N，14=NST，15=N*ST，16=PT',
  primary key(`id`) using btree,
  unique key `uk_stock_code_and_trade_date`(`stock_code`, `trade_date`)
)engine=innodb auto_increment=1 default charset=utf8mb4 row_format=dynamic comment='国内股票(A股)交易日行情表';

-- 国内上市公司基本信息
drop table if exists `stock_company`;
create table `stock_company`(
  `id` bigint(20) not null auto_increment comment 'id',
  `stock_code` varchar(20) not null comment '证券代码',
  `stock_name` varchar(20) comment '证券名称',
  `company_name` varchar(30) comment '企业名称',
  `company_name_en` varchar(100) comment '企业名称(英文)',
  `industry_code` varchar(20) comment '行业代码',
  `industry_name` varchar(30) comment '行业名称',
  `establish_date` datetime comment '成立日期',
  `listed_date` datetime comment '上市日期',
  `ipo_price` decimal(10,4) comment '发行价格',
  `ipo_premium` decimal(10,4) comment '发行溢价',
  `ipo_amount` decimal(20, 2) comment '发行数量',
  `ipo_currency` varchar(10) comment '股票面值单位',
  `ipo_date` datetime comment '发行日期',
  `parval` decimal(10,2) comment '股票面值',
  `ipo_area` smallint(4) comment '发行区域, 1=上海，2=深圳',
  `stat_code` varchar(4) comment '公司活动情况, A=正常交易，D＝终止上市，S=暂停上市， N=停牌',
  `cross_code` varchar(10) comment 'AB股交叉码',
  `hk_cross_code` varchar(10) comment 'H股交叉码',
  `stat_date` datetime comment '情况变动日期',
  `market_type` smallint(4) comment '市场类型, 1=上海A，2=上海B，4=深圳A，8=深圳B, 16=创业板',
  primary key(`id`) using btree,
  unique key `uk_stock_code`(`stock_code`)
)engine=innodb auto_increment=1 default charset=utf8mb4 row_format=dynamic comment='国内上市公司基本信息';

-- 国内A股公司上市信息
drop table if exists `stock_company_a`;
create table `stock_company_a`(
  `id` bigint(20) not null auto_increment comment 'id',
  `stock_code` varchar(20) not null comment '证券代码',
  `cross_code` varchar(20) comment '交叉代码',
  `stock_name` varchar(20) comment '证券名称',
  `industry_code` varchar(20) comment '行业代码',
  `industry_name` varchar(50) comment '行业名称, 0001=金融；0002=公用事业；0003=房地产；0004=综合；0005=工业；0006=商业',
  `listed_name` varchar(50) comment '上市交易所',
  `company_name` varchar(30) comment '公司名称',
  `company_name_en` varchar(256) comment '公司名称(英文)',
  `establish_date` datetime comment '成立日期',
  `ipo_date` datetime comment '首次招股日期',
  `listed_date` datetime comment '公司上市日期',
  `registry_address` varchar(256) comment '注册地址',
  `registry_location` varchar(50) comment '注册所在地(城市)',
  `registry_capacity1` decimal(20,4) comment '公司招股时注册资本',
  `registry_capacity2` decimal(20,4) comment '公司上市时注册资本',
  `number_staff` decimal(10, 2) comment '上市时公司职工人数',
  `number_directors` decimal(10, 2) comment '上市时董事会人数',
  `number_supervisors` decimal(10,2) comment '上市时监事会人数',
  primary key(`id`) using btree,
  unique key `uk_stock_code`(`stock_code`)
)engine=innodb auto_increment=1 default charset=utf8mb4 row_format=dynamic comment='国内A股公司上市信息';


-- 股票日衍生行情
drop table if exists `stock_derive_quote`;
create table `stock_derive_quote`(
  `id` bigint(20) not null auto_increment comment 'id',
  `stock_code` varchar(20) not null comment '证券代码',
  `trade_date` datetime not null comment '交易日期',
  `short_name` varchar(30) comment '股票简称',
  `dividend_ret` decimal(30, 6) comment '股息率, =公司派现/股票市值',
  `PE` decimal(30, 6) comment '市盈率, =股票总市值/最近四个季度的归属母公司的净利润之和',
  `PB` decimal(30, 6) comment '市净率, =股票市值/净资产',
  `PCF` decimal(30, 6) comment '市现率, =股票市值/净资产, 净资产为最新定期报告公布的净资产',
  `PS` decimal(30, 6) comment '市销率, =股票市值/去年营业收入',
  `turnover` decimal(30, 6) comment '换手率(%), =日个股成交金额/日个股流通市值',
  `circulate_market` decimal(30, 6) comment '流通市值',
  `change_ratio` decimal(15, 6) comment '涨跌幅',
  `amount` decimal(20, 2) comment '成交金额',
  `liquidity` decimal(10, 6) comment '流动性指标',
  primary key(`id`) using btree,
  unique key `uk_stock_code_and_trade_date`(`stock_code`, `trade_date`)
)engine=innodb auto_increment=1 default charset=utf8mb4 row_format=dynamic comment='股票日衍生行情';