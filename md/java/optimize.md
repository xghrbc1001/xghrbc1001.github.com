# 构建可伸缩的系统

## 垂直伸缩

* 通过升级或增加单台机器的硬件来支持访问量及数据量增长的方式
* 技术难度低
* 硬件无法不断升级和增加，若想升更高级别机器，成本指数增长

## 水平伸缩

* 通过增加机器来支持访问量及数据量增长的方式
* 技术上有较高的要求
* 理论上没有瓶颈
* 硬件故障机率大幅度上升（google经验，10000台机器，每天都要报废一台)

# cpu过高
* 根据top命令，发现PID为28555的Java进程占用CPU高达200%，出现故障。
* ps -mp pid -o THREAD,tid,time ,找到cpu过高的tid 或top -Hp pid
* printf "%x\n" tid
* jstack pid |grep tid -A 30 打印堆信息,分7代码 

-XX:CMSInitiatingOccupancyFraction=40


/data/jdk1.6.0_29/bin/jmap -histo:live 22117 > /tmp/jmap.log

cat /proc/sys/net/ipv4/tcp_tw_reuse
cat /proc/sys/net/ipv4/tcp_tw_recycle
参数调整为1，也能减少这个time-wait


sudo /usr/sbin/iptables -D INPUT -i eth1 -p tcp --dport 8111  -j REJECT

lsof -p 11754 -an | grep TCP | grep LISTEN

