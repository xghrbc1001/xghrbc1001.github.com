# ������������ϵͳ

## ��ֱ����

* ͨ�����������ӵ�̨������Ӳ����֧�ַ������������������ķ�ʽ
* �����Ѷȵ�
* Ӳ���޷��������������ӣ����������߼���������ɱ�ָ������

## ˮƽ����

* ͨ�����ӻ�����֧�ַ������������������ķ�ʽ
* �������нϸߵ�Ҫ��
* ������û��ƿ��
* Ӳ�����ϻ��ʴ����������google���飬10000̨������ÿ�춼Ҫ����һ̨)

# cpu����
* ����top�������PIDΪ28555��Java����ռ��CPU�ߴ�200%�����ֹ��ϡ�
* ps -mp pid -o THREAD,tid,time ,�ҵ�cpu���ߵ�tid ��top -Hp pid
* printf "%x\n" tid
* jstack pid |grep tid -A 30 ��ӡ����Ϣ,��7���� 

-XX:CMSInitiatingOccupancyFraction=40


/data/jdk1.6.0_29/bin/jmap -histo:live 22117 > /tmp/jmap.log

cat /proc/sys/net/ipv4/tcp_tw_reuse
cat /proc/sys/net/ipv4/tcp_tw_recycle
��������Ϊ1��Ҳ�ܼ������time-wait


sudo /usr/sbin/iptables -D INPUT -i eth1 -p tcp --dport 8111  -j REJECT

lsof -p 11754 -an | grep TCP | grep LISTEN

