
-- 指数基本信息
drop table if exists `index_info`;
create table `index_info`(
  `id` bigint(20) not null auto_increment comment 'id',
  `index_code` varchar(10) not null comment '指数code',
  `index_name` varchar(256) comment '指数名称',
  `index_type` smallint(4) comment '指数大类, 1=综合指数类，2=样本指数类，3=分类指数类，4=其他指数类',
  `index_category` smallint(4) comment '指数类型, 1=股票类,2=基金类,3=债券类,4=期货类; 5=指数类; 6=币种类; 7=其他类型',
  `datum_value` decimal(20,4) comment '基准点数',
  `datum_date` datetime comment '基准日期',
  `weight_method` smallint(4) comment '加权方式, 1＝派氏加权法；2＝简单平均加权法；3＝等权重方式；4＝其它',
  `publisher` varchar(100) comment '发布机构, 1＝上海证券交易所；2＝深圳证券交易所；3=中证指数有限公司；4 ＝深圳证券信息有限公司；5＝其它',
  `market_type` smallint(4) comment '所属市场, 1=上海，2=深圳，3=沪深，4=香港，5=海外，6=银行间，7=期货交易所，8=其他市场',
  `begin_date` datetime comment '起始日期',
  primary key(`id`) using btree,
  unique key `uk_index_code`(`index_code`)
)engine=innodb auto_increment=1 default charset=utf8mb4 row_format=dynamic comment='指数基本信息';