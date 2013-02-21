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

### alias
* alias zm='cd /home/name/Desktop/'  =�Ų��ܴ��ո�ֻ�ڵ�ǰshell��Ч��������Ч���޸�~/.bashrc�ļ�

### curl

* curl http://www.baidu.com/

### du

* du -sh ./lib  �鿴�ļ��еĴ�С

### �������滻 
grep "https://cde.com" -rl * | xargs sed -i "s/https:\/\/abc.com/https:\/\/abc.com/g" �������滻* 

### scp secure copy
* eg: �����ļ� scp ntfs-3g-2011.1.15.tgz root@10.12.213.95:/root/
* eg: ����Ŀ¼ scp -r  ntfs-3g-2011.1.15.tgz root@10.12.213.95:/root/

### grep
* grep "resourceRestService" ./*.xml
* grep -R pcpHttpClientFactory *
* grep -r "9301" /home/vss_team/*    r  �ݹ����

### file
* file a.txt �鿴������

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

### chown 
chown ֻ��rootʹ�ã� eg: chown users:jessie file1.txt

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

