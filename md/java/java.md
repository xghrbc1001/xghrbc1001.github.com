## jar

  jar�����޷���.jar��ѹ��ָ��Ŀ¼����Ϊ-C����ֻ�ڴ�������°���ʱ�����,��ͨ�����·�ʽ���н�ѹ���ض��ļ���
  ```Java
  zip struts-blank-1.3.10.war -d struts-blank
  ```
## Java�ڴ�

### java�ڴ�ṹͼ

![�ڴ�ṹͼ](../imgs/1.png)


### �ڴ��ع���
* JProfiler
* Optimize
* visualvm http://visualvm.java.net/
* jconsole

### �ڴ�����ṹ
#### ���������(Program counter register)
  
   ÿһ���̶߳����Լ������ĳ�������������Ĵ��������߳�����ʱ����
   ֵΪ��һ����ִ��ָ��ġ���ַ��
   ��ִ�б��ط�����ֵΪ"undefined"

#### Java�����ջ(Java VM stack)

    һ���߳�һ��ջ
    -Xss ÿ���߳�ջ�Ĵ�С eg: -Xss1024K
    һ���߳�һ��ջ����֡Ϊ��λѹջ��ջ
    һ��ջ���֡
    Java����,�������쳣���أ�������֡
    ջ�ڵ���������˽�У������̼߳�����ݲ�����
    -vertify  �����������

    ֡��debugʱ����ʾͼ
![�߳�֡](../imgs/2.png)

#### Java��(Heap)

   Old:���Java�����ɵ��ڴ����
   young:���Java�����ɵ��ڴ����
      Eden
      FromSpace
      ToSpace
   ����̹߳���ʹ��һ���� 
   Heap ��С�ᱨjava.lang.OutOfMemory

#### ������(Java VM Method Area)

        Perm: ���java�༰����������ľ�̬����	
	-XX:PermSize=128M(PermGen��ʼֵ)
	-XX:MaxPermSize=256M(PermGen���ֵ)
	��С�ᵼ�£�java.lang.OutOfMemoryError: PermGen space
	MaxPermSizeȱʡֵ��-server -clientѡ����ء�
	-serverѡ����Ĭ��MaxPermSizeΪ64m
	-clientѡ����Ĭ��MaxPermSizeΪ32m
	
        һ��class�����Զ�������	
        �����أ��ֶ���Ϣ��������Ϣ�������Ϣ���ֽ���	
        ��ľ�̬������������ʵ������	
        �����̹߳�������	
        ������Ҳ�ɱ���������	

        java.lang.OutOfMemoryError: PermGen space

#### ���ط���ջ(Native Method stack)
   
### Ҫ��
* ������Ͷѱ����е��̹߳���
* ÿ���̶߳����Լ��ļ�������ջ,Native Method stack
* OutOfMemory  ���OOM: û���㹻���ڴ��������� 
* Memory Leak  ���ML: ��������õ��ڴ����󣬵�������Ҫ��û�еõ��ͷ�

  eg: jdbcû��close
* -verbose:gc
