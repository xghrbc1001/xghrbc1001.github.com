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

### jvm调优

   -Xms

   -Xmx

   -Xmn 新生代大小，Eden,s0,s1比例通过-XX:SurvivorRatio控制

   -XX:MaxTenuringThrehold 控制对象经过多少次minor gc后转入旧生代，只在串行gc时有效
	
   eg: -Xms135M -Xmx135M -XX:+UseSerialGC
   eg: -Xms680M -Xmx680M -Xmn80M -XX:+UseConcMarkSweepGC -XX:+PrintGCApplication-StoppedTime -XX:UseCMSCompactAtFullCollection -XX:CMSMaxAbortablePrecleanTime=5

   可通过jstat查看gc次数

   Ｗeb应用在处理请求时设置了一个最大可同时处理的请求数，当超过时，会将请求放入队列。当等待队列满了后，这些请求会被直接丢弃   

   cpu us过高，常见优化方法对这种线程动作添加Thread.sleep(1);
   cpu sy过高，原因为线程运行状态要经常切换，最简单的方法是减少线程数。还一原因为锁竞争激烈，尽可能降低线程间锁竞争

   文件io：多个线程在写大量的数据到同一文件，解决方法：
   * 异步写文件，如log4j可用AsyncAppender
   * 批量读写
   * 限流  logger.error(errorInfo,ex); 当出现大量异常时，可放入队列中
   * 限制文件大小

   网络io: 
   * 限流

   内存
   * 释放不必要的引用 eg: ThreadLocal 要在线程内动作完成时执行ThreadLocal.set把对象清除　
   * 使用对象缓存池 ，创建对象实例要耗费cpu及内存，可用对象缓存池，eg放入hashMap中
   * 采用合理的缓存失效算法，当缓存池中对象太多时，会造成内存内存严重消耗，可用一些缓存失效的算法，如FIFO,LRU,LFU
   * 合理使用SoftReference 和 WeakReference

   资源消耗不多，但程序执行慢
   * 锁竞争激烈
   * 拆分锁，如ConcurrentHashMap
   * 读取不加锁，写时加锁 

   未充分使用cpu
   * 未使用足够线程

   未充分使用内存
   * 数据缓存，耗时资源缓存，因为毕竟内存读取速度大于硬盘，网络

# 构建高可用系统

## 避免出现单点
  
  将系统部署在多台机器上，支持水平伸缩。每台机器对外提供同样功能，将这种环境称为集群。

  问题：

  均衡访问每个机器

  机器出问题，用户不会访问这些机器

### 负载均衡
  
#### 方法
##### 随机选择
##### hash选择
##### round-robin选择
##### 按权重weight选择，静态权重，动态权重（根据系统load,连接数）
##### 按负载(Load)选择

#### 常见问题

   队列方式(队中有一人慢，则慢下来)，unicorn(类似银行叫号)

   防止问题机器，负载机器定时和业务进行心跳（ping ,端口，url侦测)

#### 响应返回方式
##### 通过负载机返回

  对于请求包小，响应包大的web应用，负载机压力迅速上升

  基于NAT实现，将报文中源地址和端口修改为负载机器VIP地址和端口

##### 响应直接返回至请求发起方

  采用IP Tunneling或DR(Direct Routing)

##### 硬件负载设备

  F5和Netscalar
  
  两台负载机器用一根单独的心跳线连接。服务机器和standby机器通过心跳线保持心跳，一旦服务机器出问题，standby机器自动接管
     
  问题：负载设备流量达到上限,长连接

##### 软件负载方案

  LVS(linux virtual server)，多采用lvs + keepalive避免单点

  heartbeat

  HAProxy

##### 去中心化实现负载均衡

  Gossip,类似谣言传播

##### 热备
　
　真正对外只有一台，其它机器处于standby

  多机房也被认为是单点
