# log4j单独记文件
```
Log log = LogFactory.getLog("request");

log4j.logger.request=INFO,RequestLog
log4j.appender.RequestLog=org.apache.log4j.DailyRollingFileAppender
log4j.appender.RequestLog.Threshold=INFO
log4j.appender.RequestLog.File=${catalina.home}/logs/request.log
log4j.appender.RequestLog.layout=org.apache.log4j.PatternLayout
log4j.appender.RequestLog.layout.ConversionPattern=%5p %d{yyyy-MM-dd HH:mm:ss} %m %n
```

# 按包名com.xxx.api
```
log4j.logger.com.xxx.api=INFO,apiLog
log4j.logger.api=INFO,apiLog
log4j.appender.apiLog=org.apache.log4j.DailyRollingFileAppender
log4j.appender.apiLog.Threshold=INFO
log4j.appender.apiLog.File=${catalina.home}/logs/api.log
log4j.appender.apiLog.layout=org.apache.log4j.PatternLayout
log4j.appender.apiLog.layout.ConversionPattern=%5p %d{yyyy-MM-dd HH:mm:ss} %c %m %n
```
