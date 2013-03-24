### 常用方法
#### yield

让当前线程回到可执行状态，以便让具有相同优先级的线程进入执行状态，但不是绝对的。因为虚拟机可能会让该线程重新进入执行状态。

使线程放弃当前cpu时间，但是不使线程阻塞，线程仍处于可执行状态 ，随时可能再次分得cpu时间

#### join

调用线程阻塞，直到被join方法加入的目标完成为止,可以加入超时时间

#### sleep

使线程进入阻塞状态指定时间，不能得到cpu时间，指定时间一过，即进入可执行状态 

### volatile

为了提高性能，Java 语言规范允许 JRE 在引用变量的每个线程中维护该变量的一个本地副本。您可以将变量的这些 “线程局部” 副本看作是与缓存类似，在每次线程需要访问变量的值时帮助它避免检查主存储器。

eg: 两个线程启动，第一个线程将变量 A 读取为 5，第二个线程将变量 A 读取为 10。如果变量 A 从 5 变为 10，第一个线程将不会知道这个变化，因此会拥有错误的变量 A 的值。但是如果将变量 A 标记为 volatile，那么不管线程何时读取 A 的值，它都会回头查阅 A 的原版拷贝并读取当前值

取易失性变量是同步的，写入易失性变量也是同步的，但非原子操作不同步。

Volatile variables in the Java language can be thought of as "synchronized lite"

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

#### ReentrantLock 		

lock() ：请求锁定，如果锁己被别的线程锁定，使线程被阻断进入等待状态 

tryLock(): 如果没有被别的线程锁定，进入锁定状态，并返回true,若锁己被锁定，返回false,不进入等待状态； 若带时间参数，将等待此规定的时间，若还不行才返回false

unlock(): Lock不会自动取消，编程需手动解锁

#### ReadWriteLock

内有两个lock,一个读lock,一个写lock

readLock() : 返回一个读的lock
writeLock(): 返回一个写的lock,此lock为排他

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

### ThreadLocal

ThreadLocal有一个ThreadLocalMap静态内部类，你可以简单理解为一个MAP，这个‘Map’为每个线程复制一个变量的‘拷贝’存储其中。

当线程调用ThreadLocal.get()方法获取变量时,首先获取当前线程引用

虽然ThreadLocalMap已经使用了weakReference，但是还是建议能够显示的使用remove方法
