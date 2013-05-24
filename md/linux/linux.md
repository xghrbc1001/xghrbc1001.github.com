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
* esc+. 可以把上次命令行的参数给重复出来
* echo “ls -l” | at midnight 在某个时间运行某个命令
* ssh user@server bash < /path/to/local/script.sh 在远程机器上运行一段脚本。这条命令最大的好处就是不用把脚本拷到远程机器上

### alias
* alias zm='cd /home/name/Desktop/'  =号不能带空格，只在当前shell起效，永久生效，修改~/.bashrc文件

### top
*【P】、强制以 CPU 使用排序
*【M】、强制以 内存 使用排序

### curl

* curl http://www.baidu.com/

### source

source FileName
作用:在当前bash环境下读取并执行FileName中的命令

### du

* du -sh ./lib  查看文件夹的大小 s:summary h:human-readable
* du -s * | sort -n | tail  列出当前目录里最大的10个文件

### iconv

iconv -f gbk -t utf8 shujujiegou.txt > shujujiegou.txt.utf8  

在linux操作系统下，我们有时打开在windows下的txt文件，发现在windows下能正常显示的txt文件出现了中文乱码

### vim 打开文件乱码解决

修改.vimrc文件

添加下面一行代码

set fileencodings=ucs-bom,utf-8,cp936,gb18030,big5,euc-jp,euc-kr,latin1

### sed (stream editor)
```Bash
# 不会写入a.txt
sed "s/my/xgh/g" a.txt

# 写入a.txt
sed -i "s/my/xgh/g" a.txt

#在每一行最前面加点东西
sed -i 's/^/#/g' pets.txt

#在每一行最后面加点东西
sed 's/$/ --- /g' pets.txt

sed "3s/my/your/g" pets.txt 只替换第3行
sed "3,6s/my/your/g" pets.txt 替换3-6行
sed 's/s/S/1' my.txt 只替换每一行的第一个s
sed 's/s/S/2' my.txt 只替换每一行的第二个s：
sed 's/s/S/3g' my.txt 只替换第一行的第3个以后的s
sed '1,3s/my/your/g; 3,$s/This/That/g' my.txt 第一个模式把第一行到第三行的my替换成your，第二个则把第3行以后的This替换成了That
a命令就是append， i命令就是insert 
# 其中的1i表明，其要在第1行前插入一行（insert）
sed "1 i This is my monkey, my monkey's name is wukong" my.txt

# 其中的1a表明，其要在最后一行后追加一行（append）
sed "$ a This is my monkey, my monkey's name is wukong" my.txt

# 注意其中的/fish/a，这意思是匹配到/fish/后就追加一行
sed "/fish/a This is my monkey, my monkey's name is wukong" my.txt

# 删除匹配行
sed '/fish/d' my.txt


```

### 查找与替换 
* grep "https://cde.com" -rl * | xargs sed -i "s/https:\/\/abc.com/https:\/\/abc.com/g" 查找与替换* 
* grep ^log happy.txt
* grep 默认对大小写敏感
* grep –I log log.txt  忽略大小写
* grep –w log log.txt 只查找log为单词的
* grep ‘\<log’ log.txt 前边界
* grep ‘log\>’ log.txt 后边界
* grep log ‘find .’
* grep log ‘find . –mmin –3’ 将文件修改时间小于3分钟的查找

### scp secure copy
* eg: 复制文件 scp ntfs-3g-2011.1.15.tgz root@10.12.213.95:/root/
* eg: 复制目录 scp -r  ntfs-3g-2011.1.15.tgz root@10.12.213.95:/root/

### grep
* grep "resourceRestService" ./*.xml
* grep -R pcpHttpClientFactory *
* grep -r "9301" /home/vss_team/*    r  递归查找

### file
* file a.txt 查看件类型

```Bash
i mine
[root@localhost ~]# file -i install.log
install.log: text/plain; charset=utf-8

```

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
* awk '$3==0 && $6=="LISTEN" ' netstat.txt
* ls -l  *.cpp *.c *.h | awk '{sum+=$5} END {print sum}' 计算所有的C文件，CPP文件和H文件的文件大小总和
* awk 'length>80' file 从file文件中找出长度大于80的行

### chown 
chown 只能root使用， eg: chown users:jessie file1.txt

### cd –
回到上一次的目录
场景举例：当前目录为/home/a，用cd ../b切换到/home/b。这时可以通过反复执行cd –命令在/home/a和/home/b之间来回方便的切换。
（cd ~ 是回到自己的Home目录，cd ~user，是进入某个用户的Home目录）


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

### ldd

### apt-get

	安装tig

	apt-get install tig

	删除tig

	apt-get purge tig

### dpkg

  debian package

### linux环境变量

永久环境变量 /etc/profile，修改后若想立即生效，执行source /etc/profile

临时环境变量 export

### 后台运行

一般情况下关闭终端时，那么在这个终端中启动的后台程序也会终止，要使终端关闭后，后台程序保持执行，使用这个指令：nohup test.sh &

### 正则
* ^ 表示一行的开头。如：/^#/ 以#开头的匹配
* $ 表示一行的结尾。如：/}$/ 以}结尾的匹配
* \< 表示词首。 如 \<abc 表示以 abc 为首的詞
* \> 表示词尾。 如 abc\> 表示以 abc 結尾的詞
* . 表示任何单个字符
* 表示某个字符出现了0次或多次
* [ ] 字符集合。 如：[abc]表示匹配a或b或c，还有[a-zA-Z]表示匹配所有的26个字符。如果其中有^表示反，如[^a]表示非a的字符

### 备份bash
tar -zcvf /export/home/bak/a'date -d today +%Y%m%d'.tar.gz tomcatROOT/
