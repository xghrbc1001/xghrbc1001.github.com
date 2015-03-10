# 查看是否支持分区
* show variables like '%partition%'

# 优点 
* 与单个磁盘或文件系统分区相比,可存储更多数据
* 方便删除失去意义的数据
* 优化查询

# 分区类型
## Range
## list
## columns
## hash
## key

# command
```
Alter table lemma_category partition by hash(categoryId) partitions 100;
alert table t drop partition p2
explain partitions select * from t;

CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL DEFAULT '0',
  `name` varchar(128) NOT NULL DEFAULT ''
 
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8
 partition by hash(id) partitions 100;

```

# 分区后建索引，也生效

# explain
```
explain partitions select * from test where a > 10
```
