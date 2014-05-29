## linux���õ��������`
### ��������
* ctrl + l ����
* ctrl + u      ������ǰ������ 
* ctrl + w      ���һ������
* ctrl + k      �����Ժ������ 
* ctrl + a      �������� 
* ctrl + b /f   ������ǰ��
* ctrl + h �˸��
* ctrl + r history�е�����
* ctrl + e      ������β 
* ctrl + y      ճ��ctrl + u,ctrl + k,ctrl + wɾ�������� 
* u��ʾ�ļ����ˣ� g ��ʾ�ļ��ļ������顣 o ��ʾ������ ;r ��ɶ���w ���д��x ���������
* whoami:ȷ���Լ����
* whereis:��ѯ��������Ŀ¼�Լ������ĵ�����Ŀ¼ eg: whereis ls ,ֻ�����ڳ�����������������ֻ�����������ļ�
* which:��ѯ����������Ŀ¼(����whereis) eg: which ls which����������ǣ���PATH����ָ����·���У�����ĳ��ϵͳ�����λ��
* id:��ӡ���Լ���UID�Լ�GID��(UID:�û����Ψһ��ʶ��GID:�û������Ψһ��ʶ��ÿһ���û�ֻ����һ��Ψһ��UID�� GID)
* shutdown -h  = halt ֹͣ
* esc+. ���԰��ϴ������еĲ������ظ�����
* echo ��ls -l�� | at midnight ��ĳ��ʱ������ĳ������
* ssh user@server bash < /path/to/local/script.sh ��Զ�̻���������һ�νű��������������ĺô����ǲ��ðѽű�����Զ�̻�����

### ^M
^M(ctrl + v + m)�����ֶ�����
linux�У�\n��س�����
windows�У�\r\n��س�����
��ͨ���������ת����dos2unix,unix2dos

### alias
* alias zm='cd /home/name/Desktop/'  =�Ų��ܴ��ո�ֻ�ڵ�ǰshell��Ч��������Ч���޸�~/.bashrc�ļ�

### top
*��P����ǿ���� CPU ʹ������
*��M����ǿ���� �ڴ� ʹ������

### curl

* curl http://www.baidu.com/
* ����post���� -d Ϊpost���������
*  curl -d {"id":'100'} baike5.soso.com/z/imageGroupQuery
* curl -d "f=xml" -d "appname=sstcjx" -d "clientip=172.23.24.41" -d "to=408866256" -d "cc=" -d "bcc=" -d "subject=xxx" -d "content=xxx" -d "texttype=html" -d "sendmethod=1" -d "defaultfrom=1" -d "from=408866256" -b "uin=o0408866256;skey=@GDmDHU5IP" 'http://10.166.138.169:12028/cgi-bin/compose_send' > w.txt  curl cookie,ע��cookie��Ҫ������-b,��һ���Ϳ�����
* curl -x 172.18.33.210:65470 -F file=/tmp/test.txt http://push.wenwen.sogou.com/baike/datarecv/recv.php 
### �鿴�ļ�����
cat file.ext | wc -l

### source

source FileName
����:�ڵ�ǰbash�����¶�ȡ��ִ��FileName�е�����

### du

* du -sh ./lib  �鿴�ļ��еĴ�С s:summary h:human-readable
* du -s * | sort -n | tail  �г���ǰĿ¼������10���ļ�
* du -sh | grep G  grep��G������ļ�
* grep ".*a\|.*b" a.txt

### iconv

iconv -f gbk -t utf8 shujujiegou.txt > shujujiegou.txt.utf8  

��linux����ϵͳ�£�������ʱ����windows�µ�txt�ļ���������windows����������ʾ��txt�ļ���������������

### vim ���ļ�������

�޸�.vimrc�ļ�

�������һ�д���

set fileencodings=ucs-bom,utf-8,cp936,gb18030,big5,euc-jp,euc-kr,latin1

### sed (stream editor)
```Bash
# ����д��a.txt
sed "s/my/xgh/g" a.txt

# y�����Сд�滻Ϊ��д
 sed '1,3y/abcdef/ABCDEF/' datafile

# ɾ����һ��
sed -i "1d" a.txt

# ĩβ���
sed -i "s/$/,/g" a.txt

# �ڿ�ͷ���
sed -i "s/^/www./g" a.txt

# �滻����
sed -i ":a;N;$!ba;s/\n/w/g" a.txt

# д��a.txt
sed -i "s/my/xgh/g" a.txt

#��ÿһ����ǰ��ӵ㶫��
sed -i 's/^/#/g' pets.txt

#��ÿһ�������ӵ㶫��
sed 's/$/ --- /g' pets.txt

sed "3s/my/your/g" pets.txt ֻ�滻��3��
sed "3,6s/my/your/g" pets.txt �滻3-6��
sed 's/s/S/1' my.txt ֻ�滻ÿһ�еĵ�һ��s
sed 's/s/S/2' my.txt ֻ�滻ÿһ�еĵڶ���s��
sed 's/s/S/3g' my.txt ֻ�滻��һ�еĵ�3���Ժ��s
sed '1,3s/my/your/g; 3,$s/This/That/g' my.txt ��һ��ģʽ�ѵ�һ�е������е�my�滻��your���ڶ�����ѵ�3���Ժ��This�滻����That
a�������append�� i�������insert 
# ���е�1i��������Ҫ�ڵ�1��ǰ����һ�У�insert��
sed "1 i This is my monkey, my monkey's name is wukong" my.txt
sed -i '/abc/d;/efg/d' a.txt ɾ�����ַ���abc,efg����,abc��������������

# ���е�1a��������Ҫ�����һ�к�׷��һ�У�append��
sed "$ a This is my monkey, my monkey's name is wukong" my.txt

# ע�����е�/fish/a������˼��ƥ�䵽/fish/���׷��һ��
sed "/fish/a This is my monkey, my monkey's name is wukong" my.txt

# ɾ��ƥ����
sed '/fish/d' my.txt

# �滻Ϊ�س�
sed -i "s#xx#\n#g" a.txt
```

### �������滻 
* grep "https://cde.com" -rl * | xargs sed -i "s/https:\/\/abc.com/https:\/\/abc.com/g" �������滻* 
* grep ^log happy.txt
* grep Ĭ�϶Դ�Сд����
* grep �CI log log.txt  ���Դ�Сд
* grep �Cw log log.txt ֻ����logΪ���ʵ�
* grep ��\<log�� log.txt ǰ�߽�
* grep ��log\>�� log.txt ��߽�
* grep log ��find .��
* grep log ��find . �Cmmin �C3�� ���ļ��޸�ʱ��С��3���ӵĲ���
* grep -r hello /home ����home���ļ��в���hello
* grep -i (--ignore-case-senstive)
* grep -e "����" �ļ���
* grep -v "����Ѱ�ַ���" �ļ���  ��ƥ��ָ���ַ�������

### ls 
* ls -lt ��ʱ������
* ls -lrt ʱ���ǰ����
* -S ����С����

### scp secure copy
* eg: �����ļ� scp ntfs-3g-2011.1.15.tgz root@10.12.213.95:/root/
* eg: ����Ŀ¼ scp -r  ntfs-3g-2011.1.15.tgz root@10.12.213.95:/root/
* scp�Ӷ˿� scp -P36000

### grep
* grep "resourceRestService" ./*.xml
* grep -R pcpHttpClientFactory *
* grep -r "9301" /home/vss_team/*    r  �ݹ����
*  grep -F -f ids1.txt  ids2.txt  �ҳ�����
* grep -Ff file1 file2 ͳ�������ı��ļ�����ͬ��
* grep -vFf file1 file2 ͳ��file1���У�file2��û�е���


### file
* file a.txt �鿴������

```Bash
i mine
[root@localhost ~]# file -i install.log
install.log: text/plain; charset=utf-8

```

### lsof
* lsof file.txt                ��ʾ�ļ�����Щ���̴�
* lsof -p 29432                ��ʾ���̴�����Щ�ļ�
* lsof | nl                ��ʾ���д򿪵��ļ�
* lsof -u username            ��ʾusername�û��Ĳ���

### dosunix
### awk
* tail -500 catalina.out  | awk '{print $1,$6}'  
* �ָ�����ֵ��Ĭ���ǿո��tab�����ǿ���ͨ��-F������ѡ���޸�FS��ֵ����$ awk -F:
* ps -aux|awk '{print $4"\t"$11}'|grep -v MEM|sort -r  �鿴�ڴ�
* awk '$3==0 && $6=="LISTEN" ' netstat.txt
* ls -l  *.cpp *.c *.h | awk '{sum+=$5} END {print sum}' �������е�C�ļ���CPP�ļ���H�ļ����ļ���С�ܺ�
* awk 'length>80' file ��file�ļ����ҳ����ȴ���80����

### ����ļ�
* split -l 10 # ���в��
* split -b

### �ϲ��ļ�
```Bash
cat file1 file2 > file3

# ȡ�������ļ��Ĳ������ظ�����ֻ����һ�ݣ�

  cat file1 file2 | sort | uniq > file3

# ȡ�������ļ��Ľ�����ֻ����ͬʱ�����������ļ��е��ļ���

  cat file1 file2 | sort | uniq -d > file3

# ɾ��������������������

  cat file1 file2 | sort | uniq -u > file3

 sort file |uniq

# �ظ�����ȫ��ȥ��

  sort file |uniq -u
  sort -k1,1 ֻ����һ������ע�⣬k1��ʾ����һ�м��Ժ����е���������
  sort -k1,1 -k3,3n ����һ�͵���������
```

### chown 
chown ֻ��rootʹ�ã� eg: chown users:jessie file1.txt

### cd �C
�ص���һ�ε�Ŀ¼
������������ǰĿ¼Ϊ/home/a����cd ../b�л���/home/b����ʱ����ͨ������ִ��cd �C������/home/a��/home/b֮�����ط�����л���
��cd ~ �ǻص��Լ���HomeĿ¼��cd ~user���ǽ���ĳ���û���HomeĿ¼��


### chmod 
* chmod ���� Ȩ���޸� �÷���chmod һλ8������ filename��
* eg: chmod u+x filenmame //ֻ����Լ����У�����ֻ�ܶ�
* //u��ʾ�ļ����ˣ� g ��ʾ�ļ��ļ������顣 o ��ʾ������ ;r ��ɶ���w ���д��x ���������

### free
* �鿴�ڴ�free -m

### mount
* mount -t auto /dev/cdrom /mnt/cdrom
* u�̣�mount -t auto /dev/sdb1 /mnt/usbmon1
* umount /mnt/cdrom

### wc
* ls -lh |wc -l �鿴�ļ�����

### find
* find -name "telnet*"  // �����ļ���
* find . -name "*.xml"| xargs grep -r 9205  �����е�xml�в���
* find . -name "*c" | xargs grep "strings" �����ļ���grepһ���ַ���
* find . -type f 

### type

type������ʵ������������������������ĳ�����������shell�Դ��ģ�������shell�ⲿ�Ķ����������ļ��ṩ��

type cd

### locate

locate ��find -name ����һ��д������find -name �죬��������/var/lib/locatedb�⣬�˿�ÿ�����һ�Σ�Ϊ��ʵʱ����ͨ��updatedb�ֶ��������ݿ�
```Bash

locate /etc/sh

```

### ubuntu�鿴����ϵͳλ��
getconf LONG_BIT

### ntsysv 
* ntsysv ͼ�λ����� chkconfig

### tar
* tar zcvf a.tar.gz  ./a
* tar zxvf a.tar.gz -C ./b
* -z ��gzip��ѹ��/��ѹ���ļ������ϸ�ѡ�����Խ������ļ�����ѹ��������ԭʱҲһ��Ҫʹ�ø�ѡ����н�ѹ����
tar cfz c.tar.gz . --exclude ./b.tar --exclude ./a.tar.gz --exclude zhangba.tar 

### df
df -lh �鿴�������

### chkconfig 
* chkconfig --list
* �������������  chkconfig --add httpd

### netstat
* netstat   -anp   |   grep  portno

### ldd

### apt-get

	��װtig

	apt-get install tig

	ɾ��tig

	apt-get purge tig

### dpkg

  debian package

### linux��������

���û������� /etc/profile���޸ĺ�����������Ч��ִ��source /etc/profile

��ʱ�������� export

### ��̨����

һ������¹ر��ն�ʱ����ô������ն��������ĺ�̨����Ҳ����ֹ��Ҫʹ�ն˹رպ󣬺�̨���򱣳�ִ�У�ʹ�����ָ�nohup test.sh &

### ����
* ^ ��ʾһ�еĿ�ͷ���磺/^#/ ��#��ͷ��ƥ��
* $ ��ʾһ�еĽ�β���磺/}$/ ��}��β��ƥ��
* \< ��ʾ���ס� �� \<abc ��ʾ�� abc Ϊ�׵��~
* \> ��ʾ��β�� �� abc\> ��ʾ�� abc �Yβ���~
* . ��ʾ�κε����ַ�
* ��ʾĳ���ַ�������0�λ���
* [ ] �ַ����ϡ� �磺[abc]��ʾƥ��a��b��c������[a-zA-Z]��ʾƥ�����е�26���ַ������������^��ʾ������[^a]��ʾ��a���ַ�

### ����bash
tar -zcvf /export/home/bak/a'date -d today +%Y%m%d'.tar.gz tomcatROOT/

### sudoers
/etc/sudoers
eg: snswenwen ALL=(root) NOPASSWD:/usr/sbin/iptables


### ���ж�ȡ�ļ�
cat file | while read line
echo $line
done

### �������
cat a | sort --random-sort

### host�޸ĺ���Ч
/etc/init.d/nscd restart  or /etc/rc.d/init.d/nscd restart


### uptime
��ʾϵͳ�����˶೤ʱ��

### ����
* /etc/profile �����û�
* .bashrc ��ǰ�û�
* env �鿴��������
