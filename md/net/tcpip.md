# ��������
## �������ֵĹ���

* ��һ�����֣���������ʱ���ͻ��˷���syn��(syn=j)����������������SYN_SEND״̬���ȴ�������ȷ�ϣ���Ӧ�ͻ��˵�connect������Linux�� 

* �ڶ������֣��������յ�syn��������ȷ�Ͽͻ���SYN��ack=j+1����ͬʱ�Լ�Ҳ����һ��SYN����syn=k������SYN+ACK������ʱ����������SYN_RECV״̬����Ӧ�������˵�accept����

* ���������֣��ͻ����յ���������SYN��ACK���������������ȷ�ϰ�ACK(ack=k+1)���˰�������ϣ��ͻ��˺ͷ���������ESTABLISHED״̬������������֡���Ӧ�ͻ��˵�connect����


![tcpip����ͼ](../imgs/8.png)

## ΪʲôҪ3������

TCP ʹ���������ֵ���Ҫԭ�����Ҫ�������������е�SYN��Ϣ�������ӵĸ��š� 
���⣺ 
��ΪIP�������������б���ʱ�� 
�����ϴοͻ���A�������ӵ�����SYN a�����������ݰ������������ж�ʧ���Ǳ���ʱ�ˣ���A�˶�ʱ����ʱ�������ط�����SYN c���������ݰ�����һ���棬�ϴ������з��͵�SYN����ȴ�ڴ�ʱ�����������B�����Խ��ն˶�SYN����Ч�����޷������жϣ�������ѯ�ʶԷ�A��ȷ�����SYN�� 
�򵥵�˵����ΪIP�����������п�����ʱ�ﵽ�ͻ��˶�ʱ���ĳ�ʱʱ�䣬��˽��ն��޷�ȷ���յ��ı����Ƿ�Ϊ��Ч���ģ�����Ҫ���ͻ���ȷ�ϡ� 

# ��ȫ����
## DOS (�ܾ����񹥻� Denial Of Service)

ԭ�� �������߹��ⲻ�����������ȫ���� �����·�������Դ���ģ�ֱ��̱��
