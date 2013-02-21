## linux常用的命令操作`
### 常用命令
* ctrl + l 清屏
* ctrl + u      清光标以前的内容 
* ctrl + u      清光标以前的内容 
* ctrl + k      清光标以后的内容 
* ctrl + a      跳到行首 
* ctrl + e      跳到行尾 
* ctrl + y      粘贴ctrl + u,ctrl + k,ctrl + w删除的内容 
* u表示文件主人， g 表示文件文件所在组。 o 表示其他人 ;r 表可读，w 表可写，x 表可以运行
* whoami:确认自己身份
* whereis:查询命令所在目录以及帮助文档所在目录 eg: whereis ls
* which:查询该命令所在目录(类似whereis) eg: which ls
* id:打印出自己的UID以及GID。(UID:用户身份唯一标识。GID:用户组身份唯一标识。每一个用户只能有一个唯一的UID和 GID)
* shutdown -h  = halt 停止

### alias
* alias zm='cd /home/name/Desktop/'  =号不能带空格，只在当前shell起效，永久生效，修改~/.bashrc文件

### curl

* curl http://www.baidu.com/

### du

* du -sh ./lib  查看文件夹的大小

### 查找与替换 
grep "https://cde.com" -rl * | xargs sed -i "s/https:\/\/abc.com/https:\/\/abc.com/g" 查找与替换* 

### scp secure copy
* eg: 复制文件 scp ntfs-3g-2011.1.15.tgz root@10.12.213.95:/root/
* eg: 复制目录 scp -r  ntfs-3g-2011.1.15.tgz root@10.12.213.95:/root/

### grep
* grep "resourceRestService" ./*.xml
* grep -R pcpHttpClientFactory *
* grep -r "9301" /home/vss_team/*    r  递归查找

### file
* file a.txt 查看件类型

### lsof
* lsof file.txt                显示文件被哪些进程打开
* lsof -p 29432                显示进程打开了哪些文件
* lsof | nl                显示所有打开的文件
* lsof -u username            显示username用户的操作

### dosunix
### awk
* tail -500 catalina.out  | awk '{print $1,$6}'  
* 分隔符的值，默认是空格或tab。我们可以通过-F命令行选项修改FS的值。如$ awk -F:
* ps -aux|awk '{print $4"\t"$11}'|grep -v MEM|sort -r  查看内存

### chown 
chown 只能root使用， eg: chown users:jessie file1.txt

### chmod 
* chmod 命令 权限修改 用法：chmod 一位8进制数 filename。
* eg: chmod u+x filenmame //只想给自己运行，别人只能读
* //u表示文件主人， g 表示文件文件所在组。 o 表示其他人 ;r 表可读，w 表可写，x 表可以运行

### free
* 查看内存free -m

### mount
* mount -t auto /dev/cdrom /mnt/cdrom
* u盘：mount -t auto /dev/sdb1 /mnt/usbmon1
* umount /mnt/cdrom

### wc
* ls -lh |wc -l 查看文件个数

### find
* find -name "telnet*"  // 查找文件名
* find . -name "*.xml"| xargs grep -r 9205  在所有的xml中查找

### ntsysv 
* ntsysv 图形化服务 chkconfig

### tar
* tar zcvf a.tar.gz  ./a
* tar zxvf a.tar.gz -C ./b
* -z 用gzip来压缩/解压缩文件，加上该选项后可以将档案文件进行压缩，但还原时也一定要使用该选项进行解压缩。
tar cfz c.tar.gz . --exclude ./b.tar --exclude ./a.tar.gz --exclude zhangba.tar 

### df
df -lh 查看磁盘情况

### chkconfig 
* chkconfig --list
* 添加自启动服务  chkconfig --add httpd

### netstat
* netstat   -anp   |   grep  portno

