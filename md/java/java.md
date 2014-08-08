## jar

  jar�����޷���.jar��ѹ��ָ��Ŀ¼����Ϊ-C����ֻ�ڴ�������°���ʱ�����,��ͨ�����·�ʽ���н�ѹ���ض��ļ���
  ```Java
  zip struts-blank-1.3.10.war -d struts-blank
  ```
## gc.log
   
   -Xmx512m -Xloggc:${TOMCAT_HOME}/logs/gc.log

## BTrace

���OOM����

## -javaagent����

ʹ��-javaagent �����û�������ִ��main����ǰִ��һЩ�����߼�������aop�����������Զ�̬���޸��滻���д���

```Java
/**
* �����³����е�6��Ϊ7
* java -javaagent:MyAgent.jar HelloWorld
*
**/
    public class HelloWorld {  
        public static void main(String arg[]) {  
            System.out.println("The number six is 6");  
        }  
    }  

    import java.lang.instrument.Instrumentation;  
      
    public class MySimpleAgent {  
        public static void premain(String agentArgs,Instrumentation inst) {  
            inst.addTransformer(new MySimpleTransformer());  
        }  
    }  
    import java.lang.instrument.ClassFileTransformer;  
    import java.lang.instrument.IllegalClassFormatException;  
    import java.security.ProtectionDomain;  
      
    public class MySimpleTransformer implements ClassFileTransformer {  
        public byte[] transform(ClassLoader classloader,  
                                String classname,  
                                Class redefinedclass,  
                                ProtectionDomain protectiondomain,  
                                byte b[]) throws IllegalClassFormatException {  
            if(!classname.endsWith("HelloWorld"))  
                return(null);  
      
            String line = "";  
            for(int i=0; i < b.length;i++){          
                line += Byte.toString(b[i]) + " ";  
                if(line.length() > 60) {  
                    System.out.println(line);  
                    line = "";  
                }  
                if(b[i] == (byte)'6')  
                    b[i] = (byte)'7';  
            }  
            System.out.println(line);  
            System.out.println("The number of bytes in HelloWorld: " + b.length);  
            return(b);  
        }  
    }  


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

  ������ҲΪ�̹߳���

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

  ������Ҳ�ɱ���������,�������������ᵽ�����ô����ܶ�����Ϊ���ô���û��GC�ģ���Java������淶����ȷʵ˵�����Բ�Ҫ�������������ʵ��GC����������GC�ġ��Լ۱ȡ�һ��Ƚϵͣ��ڶ��У���������������������Ӧ�ý���һ��GC����һ����Ի���70%~95%�Ŀռ䣬�����ô���GCЧ��ԶС�ڴˡ���ȻVM Spec��Ҫ�󣬵���ǰ�����е���ҵJVM����ʵ�����ô���GC����Ҫ�������������ݣ����������������ࡣ���������˼����Java���еĶ�����պ����ƣ����������Ƿ�������ã���������Ժܼ򵥣���������Ƶ��ж����ɡ�����Ļ�����ȽϿ��̣���Ҫ��������3�������� 

  - �������е�ʵ�����Ѿ���GC��Ҳ����JVM�в����ڸ�Class���κ�ʵ���� 
  - ���ظ����ClassLoader�Ѿ���GC�� 
  - �����Ӧ��java.lang.Class ����û�����κεط������ã��粻�����κεط�ͨ��������ʸ���ķ����� 

  �Ƿ������л��տ�ʹ��-XX:+ClassUnloading�������п��ƣ�������ʹ��-verbose:class����-XX:+TraceClassLoading��-XX:+TraceClassUnLoading�鿴����ء�ж����Ϣ�� 
 
  �ڴ���ʹ�÷��䡢��̬����CGLib��bytecode��ܡ���̬����JSP�Լ�OSGi����Ƶ���Զ���ClassLoader�ĳ�������ҪJVM�߱���ж�ص�֧���Ա�֤���ô��������

  java.lang.OutOfMemoryError: PermGen space

#### ���ط���ջ(Native Method stack)
   
### Ҫ��
* ������Ͷѱ����е��̹߳���
* ÿ���̶߳����Լ��ļ�������ջ,Native Method stack
* OutOfMemory  ���OOM: û���㹻���ڴ��������� 
* Memory Leak  ���ML: ��������õ��ڴ����󣬵�������Ҫ��û�еõ��ͷ�

  eg: jdbcû��close
* -verbose:gc
* permanent: ���õ�
* JMM: Java Memory Model

### ջ֡

  �ռ䲻��ʱ����StackOverflowError -Xss

  �߳��ڴ����󣬶���������������(PC: PC registers)��ջ(Stack),pc�������һ��Ҫִ�е�ָ��

  �����������
  
  �ֲ�������
  
  ������ջ

  ֡������

  �ṹ���ӣ�

  ![ջ֡�ṹ����](../imgs/3.png)
  ![ջ��ϵͳ�ṹ](../imgs/7.png)

### ����
#### JIT: ��ʱ���루Just-in-time compilation�����ֳ�Ϊ��̬����

ͨ�����������������з�ʽ����̬�����붯ֱ̬�롣��̬����ĳ�����ִ��ǰȫ��������Ϊ�����룬��ֱ��ִ�е�����һ��һ������б߷���

��ʱ����������������ߣ�һ��һ�����Դ���룬���ǻὫ������Ĵ��뻺�������Խ���������ġ�����ھ�̬������룬��ʱ����Ĵ�����Դ����ӳٰ󶨲���ǿ��ȫ�ԡ�

��ʱ���������������ͣ�һ���ֽ��뷭�룬���Ƕ�̬���뷭�롣

΢���.NET Framework[1][2]�����о��������Javaʵ��[3]����������ʱ�������ṩ���ٵĴ���ִ�С�Mozilla Firefoxʹ�õ�Javascript����SpiderMonkeyҲ�õ���JIT�ļ���

#### HotSpot

HotSpot�ǽ��µ�Java�������������������JIT���������Դ�����Java���е�����

Javaԭ���ǰ�Դ�������Ϊ�ֽ����������ִ�У�����ִ���ٶȽ��������ü��������õĲ��ִ������Ϊ���أ�ԭ����native�����룬�����������������

## GC
### ����ʽ
* ���д�������		

  -XX:+UseSerialGC	

  ����������������Ƚ�С(100M���ң�,���������²��Ҷ���Ӧʱ����Ҫ���Ӧ��

  ȱ�㣺ֻ������С��Ӧ��
		
* ���д�������		
		
* ������������		

  ��������ͼʾ

  ![�����ռ���](../imgs/4.png)

### ������������
* Creation	
* Using	
  - ǿ����(Strong) Ĭ��
  - ������(Soft ) �ռ䲻��ʱ���� 
  - ������(Weak) ��ʱ����
  - ������(Phantom) ����������������
* Invisible	
* Unrearchable	
* Collected	
* Finalized	
* Free	

### Heap����

* Young(�����) MinorGC
  - Eden
  - 2��Survivor
	
* Tenured(���ϴ�) FullGC

### GC���շ�Ϊ����,ʶ����������������
#### ʶ������
* ��������(Reference Counting)
  - �ŵ㣺ʶ�������죬ֻ���жϼ������Ƿ�Ϊ0		
  - ȱ�㣺
    + ������ά���������ĳɱ�,�޷��ڶ��������õ������ʶ������ 		

    �ٸ��򵥵����ӣ�����A��B�ֱ����ֶ�b��a����A.b=B��B.a=A������֮����2�����������κ����ã���ʵ������2�������Ѿ��������ٱ����ʣ��������ü����㷨ȴ�޷���������
    
    + �����ڶ�ʵʱ��Ҫ��ǳ��ߵ�ϵͳ		

  - �㷨�ص�
    + ��Ҫ�������ֶδ洢�������������˴洢�ռ�Ŀ�����	
  
    + ÿ�θ�ֵ����Ҫ���¼�������������ʱ�俪����	
  
    + ����������ڱ�ʶ��ֻҪ������Ϊ0���Ϳ���Ϊ�������գ�	
  
    + ��ʱ����������û���ӳ��ԣ�	
  
    + ���ܽ��ѭ�����õ����⣻	

* ׷�ٷ�/�������㷨,�Ӹ������������ֲ�����������һ������������ �����޷���ɨ�赽 �����϶�����,�㷨,���֣�		
  - ����(Copying):
  
  �Ӹ�����ɨ������Ķ��󣬲����ҵ��Ĵ������Ƶ�һ���µ���ȫδʹ�õĿռ�

  ��Ҫ���յĴ��������ʱ�������㷨�Ƚϸ�Ч,ȱ��Ϊ������һ��յ��ڴ棬�����ж�����ƶ�
  - ���-���(Mark-Sweep)	

  �Ӹ����Ͽ�ʼɨ�裬�Դ��Ķ�����б�ǣ������Ϻ���ɨ�������ռ�δ����ǵĶ��󣬲����л���

  �����ƶ�����Ҳ����ռ䣬��������ڴ���Ƭ
  - ���-ѹ��(Mark-Compact)	

  �����ʱ���Ὣ���д���������˿ռ��ƶ�������������������ָ��

  �ƶ������ĳɱ�������������ڴ���Ƭ

#### ��������
* ������(SoftReference)		

  jvm�ڴ治��ʱ�ᱻ����	

  ʹ�÷�����	
```Java
    Object object=new Object();

    SoftReference<Object> softRef=new SoftReference<Object>(object);

    object=null;

    // ��ͨ��softRef.get����ȡ����ע����ܻ�õ�null
```
		
* �����ã�WeakReference��		

  û��ǿ���ú�GC�ᱻ�����ͷ�	
  ʹ�÷�����	
```Java``

	Object object=new Object();
	WeakReference<Object> weakRef=new WeakReference<Object>object;
	object=null;
	//	�ɴ���ReferenceQueue����WeakReference�������У���object���󱻻���ʱ��ִ��weakRef.isEnqueued�᷵��true
```
		
* ������(PhantomReference)		

  �ɸ��ٶ����Ƿ񼺴��ڴ���ɾ��	
		
* ǿ����		

  eg: A a=new A();  ֻ�������ͷ������òŻᱻGC	


## Java IO
* ͬ��IO	
- BIO - Blocking IO
- NIO - Non-Blocking IO
* �첽IO	
- AIO

## ClassLoader

### classloaderͼ
![classloaderͼ](../imgs/5.png)

## HotSpot JIT

����ִ��:Ч�ʽϵ�

����ִ��

sun jdk �ֳ�hotspot vm ,�ṩ����ģʽ: client compiler (-client) ������ ��server compiler(-server)

HotSpot�ǽ��µ�Java�������������������JIT���������Դ�����Java���е����ܡ�Javaԭ���ǰ�Դ�������Ϊ�ֽ����������ִ�У�����ִ���ٶȽ��������ü��������õĲ��ִ������Ϊ���أ�ԭ����native�����룬�����������������

JIT��������Ӣ��д��Just-In-Time Compiler��������˼�Ǽ�ʱ��������

��ʱ���루Ӣ�Just-in-time compilation��[1]�����뼰ʱ����[2]��ʵʱ����[3]����̬�����һ����ʽ����һ����߳�������Ч�ʵķ�����ͨ�����������������з�ʽ����̬�����붯ֱ̬�롣��̬����ĳ�����ִ��ǰȫ��������Ϊ�����룬��ֱ��ִ�е�����һ��һ������б߷��롣

��ʱ����������������ߣ�һ��һ�����Դ���룬���ǻὫ������Ĵ��뻺�������Խ���������ġ�����ھ�̬������룬��ʱ����Ĵ�����Դ����ӳٰ󶨲���ǿ��ȫ�ԡ�
��ʱ���������������ͣ�һ���ֽ��뷭�룬���Ƕ�̬���뷭��

������ʱJIT��ѷ�����Ļ����뱣���������ѱ��´�ʹ�ã���˴���������˵�����ø�JIT�������ԣ����Խӽ���ǰ�����뼼��

## �������
### OutOfMemory
```Java
public class HeapOOM{  
    static class OOMObject{  
}  
public static void main(String[] args){  
    List<OOMObject> list = new ArrayList<OOMObject>();  
    while(true){  
    list.add(new OOMObject());  
}  
}  
} 

```
### StackOverflowError
```Java
    public class JavaVMStackOF{  
        private int stackLength = 1;  
        public void stackLeak(){  
            statckLength++;  
            stackLeak();  
    }  
    public static void main(String[] args){  
        JavaVMStackOF oom = new JavaVMStackOF();  
    oom.stackLeak();  
    }  
    }  

```

### java�����ջ�ڴ����
```Java
public class JavaVMStackOOM{  
    private void dontStop(){  
    while(true){  
}  
}  
public void stackLeakByThread{  
    while(true){  
        Thread t = new Thread(new Runnable(){  
    public void run(){  
    dontStop();  
}  
});  
t.start();  
}  
}   
public static void main(String[] args){  
    JavaVMStackOOM oom = new JavaVMStackOOM();  
    oom. stackLeakByThread();.  
}  
} 
```

### ���������
```Java
/**
*
* ����ʱ���������ڷ�������һ����
* String��intern()�������ڼ�鳣����������е��ڴ�String������ַ������ڣ���ֱ�ӷ��س������е��ַ������󣬷��򣬽���String�������������ַ�����ӵ�����ʱ�������У������ش�String��������á����String��intern()�����ر��ʺ���ʾ����ʱ���������
*/
    public class RuntimeConstantPoolOOM{  
        public static void main(String[] args){  
    List<String> list = new ArrayList<String>();  
            int i = 0;  
            while(true){  
            list.add(String.valueOf(i++).intern());  
    }  
    }  
    }  

```
### ���������
```Java
/**
* ���������ڴ��Class�������Ϣ��Java�ķ���Ͷ�̬������Զ�̬����Class�������������CGLIB����ֱ�Ӳ����ֽ��룬Ҳ���Զ�̬����Class��ʵ��ͨ��CGLIB����ʾ��ͬ��ʹ��-XX:PermSize=10m��-XX:MaxPermSize=10m�����ô�����ڴ����С�ڴ�����Ϊ10MB��С�������������ô�����ڴ����С�ڴ��С��ͬ������޷���չ
*/
    public class JavaMethodAreaOOM{  
        public static void main(String[] args){  
        while(true){  
        Enhancer enhancer = new Enhancer();  
        enhancer.setSuperClass(OOMObject.class);  
        enhancer.setUseCache(false);  
        enhancer.setCallback(new MethodInterceptor(){  
        public Object intercept(Object obj, Method method, Object[] args,   
                          MethodProxy proxy)throws Throwable{  
        return proxy.invokeSuper(obj, args);  
    }  
    });  
    enhancer.create();  
    }  
    }  
    class OOMObject{  
    }   
    }  

```

### ���ܵ���
#### jstack
```
jstack pid > stack.log
```
