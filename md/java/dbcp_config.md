## 基本信息
* username 数据库用户名
* password 数据库密码
* url 数据库的jdbc URL连接形式
* driverClassName 数据库的JDBC驱动类的全类名
* connectionProperties 连接属性，创建连接时会发给JDBC驱动，格式如： [propertyName=property;]*

## 事务相关
* defaultAutoCommit 默认true 连接是否自动提交 自己控制事务时请设置成false
* defaultTransactionIsolation 事务隔离级别,默认值为JDBC驱动默认
  + 事务隔离级别
    - NONE
    - READ_COMMITTED
    - READ_UNCOMMITTED
    - REPEATABLE_READ
    - SERIALIZABLE

* defaultCatalog 数据库catalog，数据库名,一般不设置

## 连接分配与回收（解决并发问题）
* initialSize 默认值0 连接池启动时创建的初始化连接数,生产系统最好与minIdle相同
* maxActive 默认值8 同一时刻从连接池分配的最大活动连接数，负数为无限制 并发时从连接池获取的最大连接数
* maxIdle default 8 连接池中保持空闲的的最大连接数，超过空闲数的连接会被释放，负数为无限制,为了保持并发性能，一般设置成接近于maxActive，推荐：maxIdle=maxActive * 2/3
* minIdle default 0 连接池中保持空闲的的最小连接数 推荐：minIdle = maxActive * 2/3 
* maxWait default 无限等待 当连接池中无可用连接时，获取连接等待的时间(毫秒)，负数为无限等待，

## 检查相关（解决网络不稳定问题）
* validationQuery		调用者从连接池获取jdbc相关对象(Connection、Statement、ResultSet等)之前用来校验的sql，必须是一条SELECT语句，且必须返回至少一行数据
* testOnBorrow	true	"调用者从连接池获取jdbc相关对象(Connection、Statement、ResultSet等)之前是否需要校验，如果校验失败，该连接将会从连接池中删除，并返回另一个连接。
注意：如果为true，则validationQuery不能为空"
* testOnReturn	false	"jdbc相关对象(Connection、Statement、ResultSet等)在返回给连接池之前是否需要校验
注意：如果为true，则validationQuery不能为空"
* testWhileIdle	false	"连接闲置时是否需要校验，如果校验失败，该连接将会从连接池中删除，并返回另一个连接。
注意：如果为true，则validationQuery不能为空"
* timeBetweenEvictionRunsMillis	-1	闲置连接驱逐线程的运行间隔时间，小于等于0时，该线程不会运行
* numTestsPerEvictionRun	3	闲置连接驱逐线程的并发运行数
* minEvictableIdleTimeMillis	1000 * 60 * 30	空闲连接被逐出连接池的最小时间
* connectionInitSqls	null	当连接第一次被驱动创建的时候执行的sql语句，仅会执行一次

## 开启连接池的prepared		
* poolPreparedStatements	false	开启池的prepared
* maxOpenPreparedStatements	unlimited	开启池的prepared 后的同时最大连接数
		
## 访问底层连接，不经过连接池（危险）		
* accessToUnderlyingConnectionAllowed	false	"是否允许访问底层的JDBC驱动连接（不经过连接池），方法如下：
  
    Connection conn = ds.getConnection();
    Connection dconn = ((DelegatingConnection) conn).getInnermostDelegate();
    ...
    conn.close()
		
## 自动关闭连接属性：解决连接泄漏问题（忘记关闭连接）		
* s	false	当连接达到废弃时间时，是否移除废弃的连接
* removeAbandonedTimeout	300	连接的废弃时间
* logAbandoned	false	当Statement或Connection被废弃时是否输出日志

