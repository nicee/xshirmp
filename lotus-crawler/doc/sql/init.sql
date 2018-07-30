
-- 创建数据库
create database if not exists `stock` default charset utf8mb4 collate utf8mb4_general_ci;


drop table if exists `ssc_quote`;
create table `ssc_quote`(
  `id` bigint(20) not null auto_increment comment 'id',
  `period` int(11) not null comment '期号',
  `award` smallint(4) not null comment '开奖',
  `type` tinyint(2) not null default 1 comment '类型, 1=cqssc, 2=ynffc',
  `info_src` varchar(100) comment '数据来源',
  `created_at` datetime not null default current_timestamp,
  `updated_at` datetime not null default current_timestamp on update current_timestamp,
  primary key (`id`) using btree,
  unique key `uk_period_award`(`period`, `award`)
)engine=innodb auto_increment=1 default charset=utf8mb4 row_format=dynamic comment='彩票数据';

-- 国内股票交易日行情表
drop table if exists `stock_trade_quote`;
create table `stock_trade_quote`(
  `id` bigint(20) not null auto_increment comment 'id',
  `stock_code` varchar(20) not null comment '证券代码',
  `trade_date` datetime not null comment '交易日期',
  `open_price` decimal(10,5) comment '日开盘价',
  `high_price` decimal(10,5) comment '日最高价',
  `low_price` decimal(10,5) comment '日最低价',
  `close_price` decimal(10,5) comment '日收盘价',
  `trade_volume` decimal(20,5) comment '日交易量',
  `trade_amount` decimal(20,5) comment '日交易金额',
  `market_value` decimal(20,5) comment '日个股流通市值',
  `stock_total_market_value` decimal(30,5) comment '日个股总市值',
  `return_dividend` decimal(10,5) comment '考虑现金红利再投资的日个股回报率',
  `return_no_dividend` decimal(10,5) comment '不考虑现金红利的日个股回报率',
  `adj_close_price_with_dividend` decimal(10,5) comment '考虑现金红利再投资的收盘价的可比价格',
  `adj_close_price_without_dividend` decimal(10,5) comment '不考虑现金红利的收盘价的可比价格',
  `market_type` int(11) not null comment '市场类型, 1=上海A，2=上海B，4=深圳A，8=深圳B, 16=创业板',
  `captical_stock_change_date` datetime comment '上市公司股本最近一次发生变化的日期',
  `trade_state` int(11) comment '交易状态, 1=正常交易，2=ST，3＝*ST，4＝S，5＝SST，6＝S*ST，7=G，8=GST，9=G*ST，10=U，11=UST，12=U*ST，13=N，14=NST，15=N*ST，16=PT',
  primary key(`id`) using btree,
  unique key `uk_stock_code_and_trade_date`(`stock_code`, `trade_date`)
)engine=innodb auto_increment=1 default charset=utf8mb4 row_format=dynamic comment='彩票数据';