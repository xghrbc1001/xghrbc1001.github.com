һ����ά���õ�server������
��   TIME �鿴ʱ�����΢����

    DBSIZE �鿴��ǰ���е�key����

    BGREWRITEAOF ��̨������дAOF

    BGSAVE       ��̨����rdb����

    SAVE         ����rdb����

    LASTSAVE     �ϴα���ʱ��

    SLAVEOF      ��Ϊslave������

    FLUSHALL     �������db

    FLUSHDB      ��յ�ǰdb

    SHUTDOWN[""|save|nosave]     �Ͽ�����,�رշ�����

    SLOWLOG   ��ʾ����ѯ

    INFO      ��ʾ��������Ϣ

    CONFIG GET ��ȡ������Ϣ

    CONFIG SET ����������Ϣ

    MONITOR    �򿪿���̨

    SYNC       ����ͬ��

    CLIENT LIST �ͻ����б�

    CLIENT KILL �ر�ĳ���ͻ���

    CLIENT SETNAME Ϊ�ͻ�����������

    CLIENT GETNAME ��ȡ�ͻ�������

������άʱ�Ĺ۲����
1: �ڴ�

# Memory

used_memory:859192 ���ݽṹ�Ŀռ�

used_memory_rss:7634944 ʵռ�ռ�

mem_fragmentation_ratio:8.89 ǰ2�ߵı���,1.NΪ��

2: ���Ӹ���

# Replication

role:slave

master_host:192.168.1.128

master_port:6379

master_link_status:up

 

3:�־û�

# Persistence

rdb_changes_since_last_save:0

rdb_last_save_time:1375224063

 

4: fork��ʱ

#Status

latest_fork_usec:936  �ϴγ־û�����΢��

 

5: ����־

config get/set slowlog-log-slower-than

CONFIG get/SET slowlog-max-len

slow log get ��ȡ����־

