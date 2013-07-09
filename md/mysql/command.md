# replace into vs insert into

replace into 跟 insert 功能类似，不同点在于：replace into 首先尝试插入数据到表中， 1. 如果发现表中已经有此行数据（根据主键或者唯一索引判断）则先删除此行数据，然后插入新的数据。 2. 否则，直接插入新数据。要注意的是：插入数据的表必须有主键或者是唯一索引！否则的话，replace into 会直接插入数据，这将导致表中出现重复的数据。

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

同一台机器  load  data local infile

# 表重命名
  rename table 原表名 to 新表名
