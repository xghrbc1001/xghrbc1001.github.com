# 好处

提高系统资源的利用率，主要是任务的派发不是24小时平均的，而是高峰时期任务量很多，比如1秒1000多个，有的时候很低，比如十几秒钟才来一个。应用服务通过JMS队列一个一个的取任务，做完一个再领一个，使系统资源的运用趋于平均
