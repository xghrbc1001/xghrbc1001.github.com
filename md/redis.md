一：运维常用的server端命令
　   TIME 查看时间戳与微秒数

    DBSIZE 查看当前库中的key数量

    BGREWRITEAOF 后台进程重写AOF

    BGSAVE       后台保存rdb快照

    SAVE         保存rdb快照

    LASTSAVE     上次保存时间

    SLAVEOF      设为slave服务器

    FLUSHALL     清空所有db

    FLUSHDB      清空当前db

    SHUTDOWN[""|save|nosave]     断开连接,关闭服务器

    SLOWLOG   显示慢查询

    INFO      显示服务器信息

    CONFIG GET 获取配置信息

    CONFIG SET 设置配置信息

    MONITOR    打开控制台

    SYNC       主从同步

    CLIENT LIST 客户端列表

    CLIENT KILL 关闭某个客户端

    CLIENT SETNAME 为客户端设置名字

    CLIENT GETNAME 获取客户端名字

二：运维时的观察参数
1: 内存

# Memory

used_memory:859192 数据结构的空间

used_memory_rss:7634944 实占空间

mem_fragmentation_ratio:8.89 前2者的比例,1.N为佳

2: 主从复制

# Replication

role:slave

master_host:192.168.1.128

master_port:6379

master_link_status:up

 

3:持久化

# Persistence

rdb_changes_since_last_save:0

rdb_last_save_time:1375224063

 

4: fork耗时

#Status

latest_fork_usec:936  上次持久化花费微秒

 

5: 慢日志

config get/set slowlog-log-slower-than

CONFIG get/SET slowlog-max-len

slow log get 获取慢日志

