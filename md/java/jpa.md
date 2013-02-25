## JPA - Java Persistence API
### ʵ��״̬ 
* �½�״̬  
* �й�״̬ 
* ����״̬ 
* ɾ��״̬ 

### ʵ�ֲ�Ʒ(JPA��һ�׹淶������һ�ײ�Ʒ,�����һֱ����������������׷���Ŀ�꣬ʹ��JPA���Ϳ��԰����ǵ�Ӧ����ȫ��Hibernate�н��ѳ�����) 
* Hibernate
* OpenJPA
* TopLink

### CascadeType
* CascadeType.PERSIST �־ò�������
* CascadeType.REMOVE  ɾ����������
* CascadeType.REFRESH ˢ�²�������
* CascadeType.MERGE   merge��������
* CascadeType.ALL     ���в������ἶ��

```Java
/** Ӧ�ó������⣺�����ּ��������������Ƕ����еĲ����������ã�ֻ�е����ǵ���ʵ���������persist������ʱ��CascadeType.PERSIST�Ż������ã�ͬ������ֻ�е����ǵ���ʵ���������merge������ʱ��CascadeType.MERGE�Ż�������,���������������á�ͬ������ֻ�е����ǵ���ʵ���������remove������ʱ��CascadeType.REMOVE�Ż������á�

ע�⣺ Query query = em.createQuery("delete from Person o where o.id=?1");����ɾ���᲻���������أ��ǲ��������õģ���Ϊ����������������ʵ��������Ķ�Ӧ�ķ���*/

   @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
```

### fetch
* CascadeType.EAGER ���ص�ǰʵ���ʱ�򣬻������ص�ʵ��
  
  ��ȱ��: һ�μ������ݣ�ռ�����ڴ�󣬵��������ʿ�

* CascadeType.LAZY  ����ʵ��ǰ������أ�ֻ�з���ʱ�Ż����(ΪĬ��ֵ)
  
  ��ȱ�㣺��Ҫ��ʱ��Ӵ�����ռ���ڴ�ռ�С���������ٶ���

### ע��
* @Entity ��ʵ��
* @Id  ������
* @GeneratedValue �����������ԣ�ͨ��strategy����ָ������SqlServer��Ӧidentity��MySql��Ӧauto increment
* @Transient ���־û�������

