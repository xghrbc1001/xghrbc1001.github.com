# 开启服务

service crond start
搜索crontab并载入内存来启动,/var/spool/cron 以用户命名的文件

# 一些常用case(不对)
```
 每隔5秒执行一次：*/5 * * * * ?

 每隔1分钟执行一次：0 */1 * * * ?

 每天23点执行一次：0 0 23 * * ?

 每天凌晨1点执行一次：0 0 1 * * ?

 每月1号凌晨1点执行一次：0 0 1 1 * ?

 每月最后一天23点执行一次：0 0 23 L * ?

 每周星期天凌晨1点实行一次：0 0 1 ? * L

 在26分、29分、33分执行一次：0 26,29,33 * * * ?

 每天的0点、13点、18点、21点都执行一次：0 0 0,13,18,21 * * ?


```
```
0 1 * * * /home/testuser/test.sh
每天晚上1点调用/home/testuser/test.sh

*/10 * * * * /home/testuser/test.sh
每10钟调用一次/home/testuser/test.sh
30 21 * * * /usr/local/etc/rc.d/lighttpd restart
上面的例子表示每晚的21:30重启apache。

45 4 1,10,22 * * /usr/local/etc/rc.d/lighttpd restart
上面的例子表示每月1、10、22日的4 : 45重启apache。

10 1 * * 6,0 /usr/local/etc/rc.d/lighttpd restart
上面的例子表示每周六、周日的1 : 10重启apache。

0,30 18-23 * * * /usr/local/etc/rc.d/lighttpd restart
上面的例子表示在每天18 : 00至23 : 00之间每隔30分钟重启apache。

0 23 * * 6 /usr/local/etc/rc.d/lighttpd restart
上面的例子表示每星期六的11 : 00 pm重启apache。

* */1 * * * /usr/local/etc/rc.d/lighttpd restart
每一小时重启apache

* 23-7/1 * * * /usr/local/etc/rc.d/lighttpd restart
晚上11点到早上7点之间，每隔一小时重启apache

0 11 4 * mon-wed /usr/local/etc/rc.d/lighttpd restart
每月的4号与每周一到周三的11点重启apache

0 4 1 jan * /usr/local/etc/rc.d/lighttpd restart
一月一号的4点重启apache

*/30 * * * * /usr/sbin/ntpdate 210.72.145.44
每半小时同步一下时间

```

# crontab -e 编写cron,修改后重启 service cron restart,reload不可以
# 服务，有时候服务名叫cron
```
sbin/service crond start           //启动服务
/sbin/service crond stop            //关闭服务
/sbin/service crond restart        //重启服务
/sbin/service crond reload         //重新载入配置

```
# /var/spool/cron/

