### 常用方法
#### yield

yield 检测当前是否有相同优先级，若有，将占有权交给此线程，否则，继续运行原来的线程
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

最大的好处就是可以避免多线程的优先级倒置和死锁情况的发生，当然高并发下的性能提升也是很重要的

源码:

```Java
private volatile int value;

// unsafe是java提供的获得对对象内存地址访问的类，注释已经清楚的写出了，它的作用就是在更新操作时提供“比较并替换”的作用
private static final Unsafe unsafe = Unsafe.getUnsafe(); 

//valueOffset是用来记录value本身在内存的便宜地址的，这个记录，也主要是为了在更新操作在内存中找到value的位置，方便比较
private static final long valueOffset;
```

什么是非阻塞算法?
一个线程的失败或挂起不应该影响其他线程的失败或挂起.这类算法称之为非阻塞(nonblocking)算法

对比阻塞算法:
如果有一类并发操作, 其中一个线程优先得到对象监视器的锁, 当其他线程到达同步边界时, 就会被阻塞.
直到前一个线程释放掉锁后, 才可以继续竞争对象锁.(当然,这里的竞争也可是公平的, 按先来后到的次序)

### CAS: compare and swap 比较并交换

CAS 操作包含三个操作数 —— 内存位置（V）、预期原值（A）和新值(B)。 如果内存位置的值与预期原值相匹配，那么处理器会自动将该位置值更新为新值 。否则，处理器不做任何操作。无论哪种情况，它都会在 CAS 指令之前返回该 位置的值。（在 CAS 的一些特殊情况下将仅返回 CAS 是否成功，而不提取当前 值。）CAS 有效地说明了“我认为位置 V 应该包含值 A；如果包含该值，则将 B 放到这个位置；否则，不要更改该位置，只告诉我这个位置现在的值即可

### ThreadLocal

ThreadLocal有一个ThreadLocalMap静态内部类，你可以简单理解为一个MAP，这个‘Map’为每个线程复制一个变量的‘拷贝’存储其中。

当线程调用ThreadLocal.get()方法获取变量时,首先获取当前线程引用

虽然ThreadLocalMap已经使用了weakReference，但是还是建议能够显示的使用remove方法

### ConcurrentHashMap

结构示意图:
![结构图](../imgs/9.jpg)

HashEntry 和 Segment。HashEntry 用来封装映射表的键 / 值对；Segment 用来充当锁的角色，每个 Segment 对象守护整个散列映射表的若干个桶。每个桶是由若干个 HashEntry 对象链接起来的链表。一个 ConcurrentHashMap 实例中包含由若干个 Segment 对象组成的数组

Segment 类继承于 ReentrantLock 类，从而使得 Segment 对象能充当锁的角色

每一个 Segment 对象都有一个 count 对象来表示本 Segment 中包含的 HashEntry 对象的总数

注意，之所以在每个 Segment 对象中包含一个计数器，而不是在 ConcurrentHashMap 中使用全局的计数器，是为了避免出现“热点域”而影响 ConcurrentHashMap 的并发性。

在 ConcurrentHashMap中，每一个 Segment 对象都有一个 count 对象来表示本 Segment 中包含的 HashEntry 对象的个数。这样当需要更新计数器时，不用锁定整个 ConcurrentHashMap。

ConcurrentHashMap 在默认并发级别会创建包含 16 个 Segment 对象的数组。每个 Segment 的成员对象 table 包含若干个散列表的桶。每个桶是由 HashEntry 链接起来的一个链表。如果键能均匀散列，每个 Segment 大约守护整个散列表中桶总数的 1/16

加锁操作是针对（键的 hash 值对应的）某个具体的 Segment，锁定的是该 Segment 而不是整个 ConcurrentHashMap。因为插入键 / 值对操作只是在这个 Segment 包含的某个桶中完成，不需要锁定整个ConcurrentHashMap。此时，其他写线程对另外 15 个Segment 的加锁并不会因为当前线程对这个 Segment 的加锁而阻塞

### synchronized vs Lock
#### 要不要抛弃synchronized
* 在使用 synchronized 的时候，不能忘记释放锁；在退出 synchronized 块时，JVM 会为您做这件事。您很容易忘记用 finally 块释放锁
* 当 JVM 用 synchronized 管理锁定请求和释放时，JVM 在生成线程转储时能够包括锁定信息。这些对调试非常有价值，因为它们能标识死锁或者其他异常行为的来源。 Lock 类只是普通的类，JVM 不知道具体哪个线程拥有 Lock 对象
* 几乎每个开发人员都熟悉 synchronized，它可以在 JVM 的所有版本中工作

### 何时使用 ReentrantLock
* 在确实需要一些 synchronized 所没有的特性的时候，比如时间锁等候、可中断锁等候、无块结构锁、多个条件变量或者锁投票

### automic 原子性，保证原子性

* AtomicLong
```
private final AtomicLong count=new AtomicLong(0);  // 有final
count.incrementAndGet(); // 只有一个线程对其进行修改
public long getCount(){
	return count.get();
}
```
* AtomicReference
```
private final AtomicReference<BigInteger> num=new AtomicReference<BigInteger>();
```

### dameon
*  Daemon的作用是为其他线程的运行提供便利服务，比如垃圾回收线程就是一个很称职的守护者。User和Daemon两者几乎没有区别，唯一的不同之处就在于虚拟机的离开：如果 User Thread已经全部退出运行了，只剩下Daemon Thread存在了，虚拟机也就退出了。 因为没有了被守护者，Daemon也就没有工作可做了，也就没有继续运行程序的必要了。 
* thread.setDaemon(true)必须在thread.start()之前设置，否则会跑出一个IllegalThreadStateException异常。你不能把正在运行的常规线程设置为守护线程。  
* 在Daemon线程中产生的新线程也是Daemon的。  
* 不要认为所有的应用都可以分配给Daemon来进行服务，比如读写操作或者计算逻辑
