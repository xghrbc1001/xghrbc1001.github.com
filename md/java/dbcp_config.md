## 基本信息
* username 数据库用户名
* password 数据库密码
* url 数据库的jdbc URL连接形式
* driverClassName 数据库的JDBC驱动类的全类名
* connectionProperties 连接属性，创建连接时会发给JDBC驱动，格式如： [propertyName=property;]*

## 事务相关
* defaultAutoCommit 默认true 连接是否自动提交 自己控制事务时请设置成false
* defaultTransactionIsolation 事务隔离级别,默认值为JDBC驱动默认

> 事务隔离级别
  NONE
  READ_COMMITTED
  READ_UNCOMMITTED
  REPEATABLE_READ
  SERIALIZABLE
* defaultCatalog 数据库catalog，数据库名,一般不设置

## 连接分配与回收（解决并发问题）
* 
