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

# load data

load data infile 'D:/20_crt/categoryResult.tar/categoryResult/categoryResult.txt' ignore into Table baidu460w character set utf8 fields terminated by '\t' lines Terminated by '\n' (title,tag) ;

# 表重命名
  rename table 原表名 to 新表名
