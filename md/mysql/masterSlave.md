# 主从不同步
stop slave;
set global sql_slave_skip_counter =1 ;
start slave

 查看主库 show processlist,查看sleep是否太多
 show master status
 show slave status
