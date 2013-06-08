# 导出数据库
```Bash
# 若只导出表结构，加-d
mysqldump YourDatabaseName --user=YourUserName --password=YourPassword 
```

# concat

* like concat('%',字段,'%')

# source
  不带引号
  source /data/beni/a.sql

# 显示创建表结构语句
  show create table 表名

# mysqldump

mysqldump -u name -p pwd dbname table1 table2 > /tmp/a.sql
