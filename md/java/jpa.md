## JPA - Java Persistence API
### 实体状态 
* 新建状态  
* 托管状态 
* 游离状态 
* 删除状态 

### 实现产品(JPA是一套规范，不是一套产品,低耦合一直是我们在软件设计上追求的目标，使用JPA，就可以把我们的应用完全从Hibernate中解脱出来了) 
* Hibernate
* OpenJPA
* TopLink

### CascadeType
* CascadeType.PERSIST 持久操作级联
* CascadeType.REMOVE  删除操作级联
* CascadeType.REFRESH 刷新操作级联
* CascadeType.MERGE   merge操作级联
* CascadeType.ALL     所有操作都会级联

```Java
/** 应用场合问题：这四种级联操作，并不是对所有的操作都起作用，只有当我们调用实体管理器的persist方法的时候，CascadeType.PERSIST才会起作用；同样道理，只有当我们调用实体管理器的merge方法的时候，CascadeType.MERGE才会起作用,其他方法不起作用。同样道理，只有当我们调用实体管理器的remove方法的时候，CascadeType.REMOVE才会起作用。

注意： Query query = em.createQuery("delete from Person o where o.id=?1");这种删除会不会起作用呢？是不会起作用的，因为配置里那四项都是针对实体管理器的对应的方法*/

   @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
```

### fetch
* CascadeType.EAGER 加载当前实体的时候，会加载相关的实体
  
  优缺点: 一次加载数据，占有用内存大，但后续访问快

* CascadeType.LAZY  加载实体前不会加载，只有访问时才会加载(为默认值)
  
  优缺点：需要的时候加戴对象，占用内存空间小，但访问速度慢

### 注解
* @Entity 表实体
* @Id  表主键
* @GeneratedValue 主键产生策略，通过strategy属性指定，如SqlServer对应identity，MySql对应auto increment
* @Transient 不持久化的属性

