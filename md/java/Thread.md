### 常用方法
#### yield

让当前线程回到可执行状态，以便让具有相同优先级的线程进入执行状态，但不是绝对的。因为虚拟机可能会让该线程重新进入执行状态。

#### join

调用线程阻塞，直到被join方法加入的目标完成为止,可以加入超时时间

### Future

* cancel(boolean mayInterruptIfRunning)   // 取消该次执行
* get() // 等待并获取运行结果
* get(long timeout,TimeUtil unit) // 等待一定时间获取运行结果
* isCancelled()  //判断任务是否己经取消
* isDone()  //判断任务是否己经完成

```Java
     MatchCounter matchCounter=new MatchCounter();	
     FutureTask<Integer> task=new FutureTask<Integer>(matchCounter);

```

表示异步计算的结果

### synchronized 缺点

无法中断一个正在等候获得锁的线程，也无法通过投票得到锁，如果不想等下去，也就没法得到锁

synchronized与Lock机制一样，但volatile不一样，其为控制线程中对象的可见性，但不能保证操作的原子性

### Lock

时间锁等待，可中断锁等候，无块结构锁，多个条件变量，锁投票

```Java
ReentrantLock 		
	Lock lock=new ReentrantLock();	
	lock.lock();	
	try{	
		// update object state
	}	
	finally {	
		lock.unlock();  // 一定要在finally中释放
	}	

```

### 线程安全集合

HashTable

Vector

Collections.synchronizedMap(new HashMap());

ConcurrentHashMap

ConcurrentLinkedQueue  线程安全的非阻塞队列,peek/poll : 都是在头部添加一元素，peek取出后不将其删除，poll 取出后将其删除

LinkedBlockingQueue: 内部用链表实现的阻塞队列

ArrayBlockingQueue: 内部用数组实现的阻塞队列

### 线程池
```Java
// 生成一个初始大小为10,最大为1000的线程池，30为清除线程的最长时间，时间单位，线程池内部队列,,每次接收请求的时候 ，都从线程池中抽出一个线程来执行
ThreadPoolExecutor threadPool=new ThreadPoolExecutor(10,1000,30,TimeUtil.SECONDS,new ArrayBlockingQueue<Runnable>(3),new ThreadPoolExecutor.DiscardOldestPolicy());

```

### AtomicInteger

在没有AtomicInteger前，要实现一个按顺序获取ID,必须在每次获取时加锁操作

### CAS: compare and swap 比较并交换

CAS 操作包含三个操作数 —— 内存位置（V）、预期原值（A）和新值(B)。 如果内存位置的值与预期原值相匹配，那么处理器会自动将该位置值更新为新值 。否则，处理器不做任何操作。无论哪种情况，它都会在 CAS 指令之前返回该 位置的值。（在 CAS 的一些特殊情况下将仅返回 CAS 是否成功，而不提取当前 值。）CAS 有效地说明了“我认为位置 V 应该包含值 A；如果包含该值，则将 B 放到这个位置；否则，不要更改该位置，只告诉我这个位置现在的值即可
