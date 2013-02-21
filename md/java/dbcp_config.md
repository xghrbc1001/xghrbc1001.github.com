## ������Ϣ
* username ���ݿ��û���
* password ���ݿ�����
* url ���ݿ��jdbc URL������ʽ
* driverClassName ���ݿ��JDBC�������ȫ����
* connectionProperties �������ԣ���������ʱ�ᷢ��JDBC��������ʽ�磺 [propertyName=property;]*

## �������
* defaultAutoCommit Ĭ��true �����Ƿ��Զ��ύ �Լ���������ʱ�����ó�false
* defaultTransactionIsolation ������뼶��,Ĭ��ֵΪJDBC����Ĭ��
  + ������뼶��
    - NONE
    - READ_COMMITTED
    - READ_UNCOMMITTED
    - REPEATABLE_READ
    - SERIALIZABLE

* defaultCatalog ���ݿ�catalog�����ݿ���,һ�㲻����

## ���ӷ�������գ�����������⣩
* initialSize Ĭ��ֵ0 ���ӳ�����ʱ�����ĳ�ʼ��������,����ϵͳ�����minIdle��ͬ
* maxActive Ĭ��ֵ8 ͬһʱ�̴����ӳط�������������������Ϊ������ ����ʱ�����ӳػ�ȡ�����������
* maxIdle default 8 ���ӳ��б��ֿ��еĵ���������������������������ӻᱻ�ͷţ�����Ϊ������,Ϊ�˱��ֲ������ܣ�һ�����óɽӽ���maxActive���Ƽ���maxIdle=maxActive * 2/3
* minIdle default 0 ���ӳ��б��ֿ��еĵ���С������ �Ƽ���minIdle = maxActive * 2/3 
* maxWait default ���޵ȴ� �����ӳ����޿�������ʱ����ȡ���ӵȴ���ʱ��(����)������Ϊ���޵ȴ���

## �����أ�������粻�ȶ����⣩
* validationQuery		�����ߴ����ӳػ�ȡjdbc��ض���(Connection��Statement��ResultSet��)֮ǰ����У���sql��������һ��SELECT��䣬�ұ��뷵������һ������
* testOnBorrow	true	"�����ߴ����ӳػ�ȡjdbc��ض���(Connection��Statement��ResultSet��)֮ǰ�Ƿ���ҪУ�飬���У��ʧ�ܣ������ӽ�������ӳ���ɾ������������һ�����ӡ�
ע�⣺���Ϊtrue����validationQuery����Ϊ��"
* testOnReturn	false	"jdbc��ض���(Connection��Statement��ResultSet��)�ڷ��ظ����ӳ�֮ǰ�Ƿ���ҪУ��
ע�⣺���Ϊtrue����validationQuery����Ϊ��"
* testWhileIdle	false	"��������ʱ�Ƿ���ҪУ�飬���У��ʧ�ܣ������ӽ�������ӳ���ɾ������������һ�����ӡ�
ע�⣺���Ϊtrue����validationQuery����Ϊ��"
* timeBetweenEvictionRunsMillis	-1	�������������̵߳����м��ʱ�䣬С�ڵ���0ʱ�����̲߳�������
* numTestsPerEvictionRun	3	�������������̵߳Ĳ���������
* minEvictableIdleTimeMillis	1000 * 60 * 30	�������ӱ�������ӳص���Сʱ��
* connectionInitSqls	null	�����ӵ�һ�α�����������ʱ��ִ�е�sql��䣬����ִ��һ��

## �������ӳص�prepared		
* poolPreparedStatements	false	�����ص�prepared
* maxOpenPreparedStatements	unlimited	�����ص�prepared ���ͬʱ���������
		
## ���ʵײ����ӣ����������ӳأ�Σ�գ�		
* accessToUnderlyingConnectionAllowed	false	"�Ƿ�������ʵײ��JDBC�������ӣ����������ӳأ����������£�
  
    Connection conn = ds.getConnection();
    Connection dconn = ((DelegatingConnection) conn).getInnermostDelegate();
    ...
    conn.close()
		
## �Զ��ر��������ԣ��������й©���⣨���ǹر����ӣ�		
* s	false	�����Ӵﵽ����ʱ��ʱ���Ƿ��Ƴ�����������
* removeAbandonedTimeout	300	���ӵķ���ʱ��
* logAbandoned	false	��Statement��Connection������ʱ�Ƿ������־

