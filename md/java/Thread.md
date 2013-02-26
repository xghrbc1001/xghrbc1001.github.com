### ���÷���
#### yield

�õ�ǰ�̻߳ص���ִ��״̬���Ա��þ�����ͬ���ȼ����߳̽���ִ��״̬�������Ǿ��Եġ���Ϊ��������ܻ��ø��߳����½���ִ��״̬��

#### join

�����߳�������ֱ����join���������Ŀ�����Ϊֹ,���Լ��볬ʱʱ��

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
