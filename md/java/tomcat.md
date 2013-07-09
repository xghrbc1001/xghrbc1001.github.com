## ��war��
```Bash
jar -cvf xxxx.war xxxx
```
## CATALINA_HOME��CATALINA_BASE����

CATALINA_HOME��Tomcat�İ�װĿ ¼��CATALINA_BASE��Tomcat�Ĺ���Ŀ¼�����������Ҫ����Tomcat�� ���ʵ�������ǲ��밲װ���Tomcat�����������ô���ǿ������ö������ Ŀ¼��ÿ������ʵ����ռһ������Ŀ¼�����ǹ���ͬһ����װĿ¼

## clear tomcat's cache

	<Context docBase="D:\test" path="/" reloadable="true" >

## tomcatԴ��
### ����
* HttpServer: ����һ��ServerSocket��������http������
* Request:  �������װΪRequest���� 

## connector container
* ��servlet����ΪWrapper
* ��һ��web���̳���ΪContext
* ��һ��tomcat���������Ϊhost
* Engine �������host����һ��connector
 
![tomcat�ṹͼ](../imgs/6.png)

## LifeCycle

�ܶ������������������,����:StandardServer,StandardService��.��������������������������Դ���

Tomcat���������ڹ�������Ҫ�����ڽӿ�Lifecycle,LifecycleListener���������LifecycleEvent

ʵ��Lifecycle�ӿڵ��Ǳ��۲�Ķ���,��ʵ��LifecycleListener�ӿڵ��ǹ۲���.��LifecycleEvent���м䴫���¼������ݵĶ���

catalina�����кܶ��������catalinaһ������/�رա����磬��container�ر�ʱ������������Ѿ������servlet��destroy������tomcat�е�ʵ�ֻ�����ͨ��ʵ��org.apache.catalina.Lifecycle�ӿ�������

��������ǻᴥ��ǰ�����¼���BEFORE_START_EVENT��START_EVENT��AFTER_START_EVENT�����ر����ʱ�ᴥ���������¼���BEFORE_STOP_EVENT��STOP_EVENT��AFTER_STOP_EVENT��

## �õ������ģʽ
* �۲������ģʽ
* �������ģʽ
* ���������ģʽ
* Singleton
* ������ģʽ

## Digester

Digester������������xml�����ļ�,���������ǵĹ�ϵ�����ɺ������ļ�������

## session

��һ��sesson��ʼʱ��Servlet�����ᴴ��һ��HttpSession������ĳЩ����°���ЩHttpsession������ڴ���ת�Ƶ��ļ�ϵͳ�л����ݿ��У���Ҫ���ʵ�ʱ���ڰ��������뵽�ڴ��������������ĺô������㣺��Լ���ڴ�����ģ���web��������������ʱ�������Դ��ļ�ϵͳ�����ݿ��лָ�Session������

����Session�Ĺ���tomcat�ṩ������ʵ���ࣺorg.apache.catalina.session.StandardManager��org.apache.catalina.session.PersistentManager

StandardManager ����Ĭ�ϵķ�������Tomcat���������������ص�ʱ�򣬻��Session���󱣴浽
<%CATALINA_HOME%>/work/Catalina/honstname/applicatonname/SESSIONS.ser(Ĭ��ֵ)�ļ��У�ÿ�������Ӧһ���ļ�����Session IDΪ�ļ��������磺

<Context path="/helloapp" docBase="helloapp" debug="0" reloadable="true">
<Manager className="org.apache.catalina.session.StandardManager" debug="0" 
maxActiveSessions="-1" checkInterval="60" />
</Context>
����˵����checkInterval�����session�Ƿ���ڵ�ʱ����������Ϊ��λ��ȱʡֵ��60�룻
maxActiveSessions���ɴ��ڻ״̬��session����

PersistentManager ���ṩ�˸������Ĺ���ʽ�������ݴ����������Լ�ʱ��Session���ݵ�Session Store�У����Կ����ڴ���Session������

## Դ��

### Bootstrap

�����start�������ͱ���������tomcat�����Ⱥ�ִ��daemon.setAwait��daemon.load��daemon.start�������������������ջ�ֱ���÷���ķ�ʽȥ����֮ǰ�Ѿ���ʼ����catalina�Ķ�Ӧ����setAwait��load��start��Ҳ����˵��ʵbootstrap�͵�����Catalina��ķ�����������û��ʲô���⶯����

```Java
System.nanoTime()

log.info("Server startup in " + ((t2 - t1) / 1000000) + " ms");

Runtime.getRuntime().addShutdownHook(shutdownHook);

```
