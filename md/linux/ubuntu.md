# 常用命令
* apt-get update
* apt-get update && apt-get upgrade
* apt-get dist-upgrade 关联
* apt-get --reinstall install nodejs
* apt-get remove nodejs
* apt-get purge nodejs

# 删除软件包
* sudo apt-get remove 软件包名,不删除配置文件
* sudo apt-get remove 软件包名 --purge  删除配置文件

# 更新己安装的包
* sudo apt-get upgrade(与update区别,如update只是告诉你qq2014己出来了,而upgrade会让你安装的qq2013升级到2014)

# 查询
* sudo apt-cache search 软件包名,eg: sudo apt-cache search qq
* sudo apt-cache depends 软件包名 ,显示软件包的依赖信息

# 软件源
* /etc/apt/sources.list
