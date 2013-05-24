## linux���õ��������`
### ��������
* ctrl + l ����
* ctrl + u      ������ǰ������ 
* ctrl + u      ������ǰ������ 
* ctrl + k      �����Ժ������ 
* ctrl + a      �������� 
* ctrl + e      ������β 
* ctrl + y      ճ��ctrl + u,ctrl + k,ctrl + wɾ�������� 
* u��ʾ�ļ����ˣ� g ��ʾ�ļ��ļ������顣 o ��ʾ������ ;r ��ɶ���w ���д��x ���������
* whoami:ȷ���Լ����
* whereis:��ѯ��������Ŀ¼�Լ������ĵ�����Ŀ¼ eg: whereis ls
* which:��ѯ����������Ŀ¼(����whereis) eg: which ls
* id:��ӡ���Լ���UID�Լ�GID��(UID:�û����Ψһ��ʶ��GID:�û������Ψһ��ʶ��ÿһ���û�ֻ����һ��Ψһ��UID�� GID)
* shutdown -h  = halt ֹͣ
* esc+. ���԰��ϴ������еĲ������ظ�����
* echo ��ls -l�� | at midnight ��ĳ��ʱ������ĳ������
* ssh user@server bash < /path/to/local/script.sh ��Զ�̻���������һ�νű��������������ĺô����ǲ��ðѽű�����Զ�̻�����

### alias
* alias zm='cd /home/name/Desktop/'  =�Ų��ܴ��ո�ֻ�ڵ�ǰshell��Ч��������Ч���޸�~/.bashrc�ļ�

### top
*��P����ǿ���� CPU ʹ������
*��M����ǿ���� �ڴ� ʹ������

### curl

* curl http://www.baidu.com/

### source

source FileName
����:�ڵ�ǰbash�����¶�ȡ��ִ��FileName�е�����

### du

* du -sh ./lib  �鿴�ļ��еĴ�С s:summary h:human-readable
* du -s * | sort -n | tail  �г���ǰĿ¼������10���ļ�

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

# ���е�1a��������Ҫ�����һ�к�׷��һ�У�append��
sed "$ a This is my monkey, my monkey's name is wukong" my.txt

# ע�����е�/fish/a������˼��ƥ�䵽/fish/���׷��һ��
sed "/fish/a This is my monkey, my monkey's name is wukong" my.txt

# ɾ��ƥ����
sed '/fish/d' my.txt


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

### scp secure copy
* eg: �����ļ� scp ntfs-3g-2011.1.15.tgz root@10.12.213.95:/root/
* eg: ����Ŀ¼ scp -r  ntfs-3g-2011.1.15.tgz root@10.12.213.95:/root/

### grep
* grep "resourceRestService" ./*.xml
* grep -R pcpHttpClientFactory *
* grep -r "9301" /home/vss_team/*    r  �ݹ����

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
