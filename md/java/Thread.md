### ���÷���
#### yield

�õ�ǰ�̻߳ص���ִ��״̬���Ա��þ�����ͬ���ȼ����߳̽���ִ��״̬�������Ǿ��Եġ���Ϊ��������ܻ��ø��߳����½���ִ��״̬��

ʹ�̷߳�����ǰcpuʱ�䣬���ǲ�ʹ�߳��������߳��Դ��ڿ�ִ��״̬ ����ʱ�����ٴηֵ�cpuʱ��

#### join

�����߳�������ֱ����join���������Ŀ�����Ϊֹ,���Լ��볬ʱʱ��

#### sleep

ʹ�߳̽�������״ָ̬��ʱ�䣬���ܵõ�cpuʱ�䣬ָ��ʱ��һ�����������ִ��״̬ 

### volatile

Ϊ��������ܣ�Java ���Թ淶���� JRE �����ñ�����ÿ���߳���ά���ñ�����һ�����ظ����������Խ���������Щ ���ֲ߳̾��� �����������뻺�����ƣ���ÿ���߳���Ҫ���ʱ�����ֵʱ���������������洢����

eg: �����߳���������һ���߳̽����� A ��ȡΪ 5���ڶ����߳̽����� A ��ȡΪ 10��������� A �� 5 ��Ϊ 10����һ���߳̽�����֪������仯����˻�ӵ�д���ı��� A ��ֵ��������������� A ���Ϊ volatile����ô�����̺߳�ʱ��ȡ A ��ֵ���������ͷ���� A ��ԭ�濽������ȡ��ǰֵ

ȡ��ʧ�Ա�����ͬ���ģ�д����ʧ�Ա���Ҳ��ͬ���ģ�����ԭ�Ӳ�����ͬ����

Volatile variables in the Java language can be thought of as "synchronized lite"

### Future

* cancel(boolean mayInterruptIfRunning)   // ȡ���ô�ִ��
* get() // �ȴ�����ȡ���н��
* get(long timeout,TimeUtil unit) // �ȴ�һ��ʱ���ȡ���н��
* isCancelled()  //�ж������Ƿ񼺾�ȡ��
* isDone()  //�ж������Ƿ񼺾����

```Java
     MatchCounter matchCounter=new MatchCounter();	
     FutureTask<Integer> task=new FutureTask<Integer>(matchCounter);

```

��ʾ�첽����Ľ��

### synchronized ȱ��

�޷��ж�һ�����ڵȺ��������̣߳�Ҳ�޷�ͨ��ͶƱ�õ���������������ȥ��Ҳ��û���õ���

synchronized��Lock����һ������volatile��һ������Ϊ�����߳��ж���Ŀɼ��ԣ������ܱ�֤������ԭ����

### Lock

ʱ�����ȴ������ж����Ⱥ��޿�ṹ�������������������ͶƱ

#### ReentrantLock 		

lock() �������������������������߳�������ʹ�̱߳���Ͻ���ȴ�״̬ 

tryLock(): ���û�б�����߳���������������״̬��������true,������������������false,������ȴ�״̬�� ����ʱ����������ȴ��˹涨��ʱ�䣬�������вŷ���false

unlock(): Lock�����Զ�ȡ����������ֶ�����

#### ReadWriteLock

��������lock,һ����lock,һ��дlock

readLock() : ����һ������lock
writeLock(): ����һ��д��lock,��lockΪ����

```Java
ReentrantLock 		
	Lock lock=new ReentrantLock();	
	lock.lock();	
	try{	
		// update object state
	}	
	finally {	
		lock.unlock();  // һ��Ҫ��finally���ͷ�
	}	

```

### �̰߳�ȫ����

HashTable

Vector

Collections.synchronizedMap(new HashMap());

ConcurrentHashMap

ConcurrentLinkedQueue  �̰߳�ȫ�ķ���������,peek/poll : ������ͷ�����һԪ�أ�peekȡ���󲻽���ɾ����poll ȡ������ɾ��

LinkedBlockingQueue: �ڲ�������ʵ�ֵ���������

ArrayBlockingQueue: �ڲ�������ʵ�ֵ���������

### �̳߳�
```Java
// ����һ����ʼ��СΪ10,���Ϊ1000���̳߳أ�30Ϊ����̵߳��ʱ�䣬ʱ�䵥λ���̳߳��ڲ�����,,ÿ�ν��������ʱ�� �������̳߳��г��һ���߳���ִ��
ThreadPoolExecutor threadPool=new ThreadPoolExecutor(10,1000,30,TimeUtil.SECONDS,new ArrayBlockingQueue<Runnable>(3),new ThreadPoolExecutor.DiscardOldestPolicy());

```

### AtomicInteger

��û��AtomicIntegerǰ��Ҫʵ��һ����˳���ȡID,������ÿ�λ�ȡʱ��������

### CAS: compare and swap �Ƚϲ�����

CAS ������������������ ���� �ڴ�λ�ã�V����Ԥ��ԭֵ��A������ֵ(B)�� ����ڴ�λ�õ�ֵ��Ԥ��ԭֵ��ƥ�䣬��ô���������Զ�����λ��ֵ����Ϊ��ֵ �����򣬴����������κβ�������������������������� CAS ָ��֮ǰ���ظ� λ�õ�ֵ������ CAS ��һЩ��������½������� CAS �Ƿ�ɹ���������ȡ��ǰ ֵ����CAS ��Ч��˵���ˡ�����Ϊλ�� V Ӧ�ð���ֵ A�����������ֵ���� B �ŵ����λ�ã����򣬲�Ҫ���ĸ�λ�ã�ֻ���������λ�����ڵ�ֵ����

### ThreadLocal

ThreadLocal��һ��ThreadLocalMap��̬�ڲ��࣬����Լ����Ϊһ��MAP�������Map��Ϊÿ���̸߳���һ�������ġ��������洢���С�

���̵߳���ThreadLocal.get()������ȡ����ʱ,���Ȼ�ȡ��ǰ�߳�����

��ȻThreadLocalMap�Ѿ�ʹ����weakReference�����ǻ��ǽ����ܹ���ʾ��ʹ��remove����
