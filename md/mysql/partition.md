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
```

# 分区后建索引，也生效
