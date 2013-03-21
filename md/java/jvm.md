# 性能优化
## 步骤
* 衡定系统现状,如请求次数，响应时间，资源消耗。eg: 95%请求响应时间为1s
* 设定调优目标, eg: 95%请求要求在500ms返回　
* 寻找性能瓶颈，寻找最大瓶颈
* 制定优化策略，选择收益比最高的优化方案进行优化
* 部署后，衡量系统状况 IF 达目标，OK ELSE 看是否有新的瓶颈，或偿试其它的优化策略

### 寻找性能瓶颈

  cpu,io,net io,memory

#### cpu消耗分析

   linux进程优先级：中断 > 内核 > 用户进程

   load值

   利用率,Linux System and Network Perforamance Monitoring建议用户进程cpu消耗/内核cpu消耗 65%-70%/30%-35%

   top(多核时查看，按1,按shift + h按线程查看)
	Cpus(s) : 4.0% us, 8.9% sy,0.0%ni,87.0% id,0.0% wa,0.2% hi,0.0% si
	4.0% us,　用户进程所占百分比
	8.9% sy,  系统进程所占百分比
	0.0%ni,   被nice命令改变优先级所占百分比
	87.0% id, cpu空闲时间所占百分比
	0.0% wa,  等待io所占百分比
	0.2% hi,  硬件中断所占百分比
	0.0% si,  软件中断所占百分比
	
   pidstat
	需安装sysstat

   vmstat 1 查看cpu1

   us过高，如看是否gc很频繁,top pid  --> 16进制，jstack [pid] | grep 'nid=0x6849' 找到此线程
   sy过高,即linux花费更多时间进行线程切换，主要原因为启动线程较多。方法为dump出java应用程序线程信息，查看线程状态信息以及锁信息

	kill -3 [javapid] 或 jstack -l [javapid]

#### 文件io

   iostat

   pidstat -d -t pi [pid] 

#### net io

	sar

#### 内存消耗分析

   vmstat

   sar

   top
 
   pidstat
### dump文件

	-XX:+HeapDumpOnOutOfMemoryError-XX:HeapDumpPath=/home/xieyun/test/TestHeapDumpOnOutOfMemoryError.hprof //一定要放在最后，不然不会生效 
	linux mat分析
