## jar

  jar命令无法将.jar解压到指定目录，因为-C参数只在创建或更新包的时候可用,可通过以下方式进行解压至特定的件夹
  ```Java
  zip struts-blank-1.3.10.war -d struts-blank
  ```
## Java内存

### java内存结构图

![内存结构图](../imgs/1.png)


### 内存监控工具
* JProfiler
* Optimize
* visualvm http://visualvm.java.net/
* jconsole

### 内存区域结构
#### 程序计数器(Program counter register)
  
   每一个线程都有自己单独的程序计数器，即寄存器，在线程启动时创建
   值为下一条被执行指令的“地址”
   若执行本地方法，值为"undefined"

#### Java虚拟机栈(Java VM stack)

    一个线程一个栈
    -Xss 每个线程栈的大小 eg: -Xss1024K
    一个线程一个栈，以帧为单位压栈出栈
    一个栈多个帧
    Java返回,正常或异常返回，都弹出帧
    栈内的所有数据私有，两个线程间的数据不共享
    -vertify  减少类的载入

    帧在debug时的显示图
![线程帧](../imgs/2.png)

#### Java堆(Heap)

   Old:存放Java类生成的内存对象
   young:存放Java类生成的内存对象
      Eden
      FromSpace
      ToSpace
   多个线程共亨使用一个堆 
   Heap 过小会报java.lang.OutOfMemory

#### 方法区(Java VM Method Area)

        Perm: 存放java类及其它虚拟机的静态数据	
	-XX:PermSize=128M(PermGen初始值)
	-XX:MaxPermSize=256M(PermGen最大值)
	过小会导致：java.lang.OutOfMemoryError: PermGen space
	MaxPermSize缺省值和-server -client选项相关。
	-server选项下默认MaxPermSize为64m
	-client选项下默认MaxPermSize为32m
	
        一个class的线性二进制流	
        常量池，字段信息，方法信息，类的信息，字节码	
        类的静态变量被所有类实例共享	
        所有线程共享方法区	
        方法区也可被垃圾回收	

        java.lang.OutOfMemoryError: PermGen space

#### 本地方法栈(Native Method stack)
   
### 要点
* 方法域和堆被所有的线程共亨
* 每个线程都有自己的计数器和栈,Native Method stack
* OutOfMemory  简称OOM: 没有足够的内存来供分配 
* Memory Leak  简称ML: 己经分配好的内存或对象，当不再需要，没有得到释放

  eg: jdbc没有close
* -verbose:gc
