#  �汾
* api.example.com/v1
* ���汾�ŷ���ͷ��

# endpoint
* ·�����ֳ��յ㣬��ʾapi�ľ�����ַ
* ��ַ�в��ܳ��ֶ���,ֻ�ܳ�������,����ø���
```
// ok
api.example.com/v1/zoos
api.example.com/v1/animals

// bad
/getProducts
/listOrders
/retreiveClientByOrder?orderId=1

```

# http����
* GET��SELECT�����ӷ�����ȡ����Դ��һ�������
* POST��CREATE�����ڷ������½�һ����Դ��
* PUT��UPDATE�����ڷ�����������Դ���ͻ����ṩ�ı���������Դ����
* PATCH��UPDATE�����ڷ�����������Դ���ͻ����ṩ�ı�����ԣ���
* DELETE��DELETE�����ӷ�����ɾ����Դ��
```
GET /zoos
POST /zoos
GET /zoos/ID
PUT /zoos/ID �ͻ����ṩ��������Ϣ
PATCH /zoos/ID �ͻ����ṩ������Ϣ
DELETE /zoos/ID
```

# ������Ϣ
* �����¼�϶࣬������������ȫ�����ظ��û���api�ṩ���������˷��ؽ��
```
?limit=10
?offset=10
?page=2&per_page=10
?sortby=name&order=asc
?animal_type_id=1 ָ��ɸѡ����
```

# ״̬��
```
200 OK - [GET]���������ɹ������û���������ݣ��ò������ݵȵģ�Idempotent����
201 CREATED - [POST/PUT/PATCH]���û��½����޸����ݳɹ���
202 Accepted - [*]����ʾһ�������Ѿ������̨�Ŷӣ��첽����
204 NO CONTENT - [DELETE]���û�ɾ�����ݳɹ���
400 INVALID REQUEST - [POST/PUT/PATCH]���û������������д��󣬷�����û�н����½����޸����ݵĲ������ò������ݵȵġ�
401 Unauthorized - [*]����ʾ�û�û��Ȩ�ޣ����ơ��û�����������󣩡�
403 Forbidden - [*] ��ʾ�û��õ���Ȩ����401������ԣ������Ƿ����Ǳ���ֹ�ġ�
404 NOT FOUND - [*]���û�������������Ե��ǲ����ڵļ�¼��������û�н��в������ò������ݵȵġ�
406 Not Acceptable - [GET]���û�����ĸ�ʽ���ɵã������û�����JSON��ʽ������ֻ��XML��ʽ����
410 Gone -[GET]���û��������Դ������ɾ�����Ҳ����ٵõ��ġ�
422 Unprocesable entity - [POST/PUT/PATCH] ������һ������ʱ������һ����֤����
500 INTERNAL SERVER ERROR - [*]�����������������û����޷��жϷ����������Ƿ�ɹ���
```

# ������
* ���״̬����4xx,Ӧ�����û����س�����Ϣ
```
{
	error: "Invalid API key"
}

HTTP/1.1 401 Unauthorized
{
    "status": "Unauthorized",
    "message": "No access token provided.",
    "request_id": "594600f4-7eec-47ca-8012-02e7b89859ce"
}
```

# HATEOAS
* �ܹ��г����е�api
```
eg: https://api.github.com/
���� api.example.com/v1/*

```
* https://github.com/thovid/play-hateoas-client
* https://github.com/mikekelly/hal_specification/wiki/Libraries

# ʵ����ַ
* https://bourgeois.me/rest/
* http://codeplanet.io/principles-good-restful-api-design/
