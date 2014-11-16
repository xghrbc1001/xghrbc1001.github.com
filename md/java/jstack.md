stack Dump 日志文件中的线程状态dump 文件里，值得关注的线程状态有：
死锁，Deadlock（重点关注） 
执行中，Runnable   
等待资源，Waiting on condition（重点关注） 
等待获取监视器，Waiting on monitor entry（重点关注）
暂停，Suspended
对象等待中，Object.wait() 或 TIMED_WAITING
阻塞，Blocked（重点关注）  
停止，Parked
