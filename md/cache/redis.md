# 特性
* 定期通过flush，将数据flush至硬盘进行保存
* 支持List,Set,String,Sorted Set数据类型

# 知识点
* 内存数据库,避免IO
* 防止断电,进程crash,引入数据备份 rdb(全量)方式,aof(增量)
* 操作原子性,单进程,单线程方式运行,开放人解释:redis处理能力超过带宽
* 事件驱动机制,cpu低
* 订阅发布模型
* 数据过期

# 网址
* redis.io
* utils/install_server.sh

# redis
* src/redis-cli
* set key value 添加或修改
* get key
* del key
* lpush key value1
* lrange key 0 2
* llen key
