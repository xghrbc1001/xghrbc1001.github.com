# 类图知识点
1 类图分为三部分，依次是类名、属性、方法
2 以<<开头和以>>结尾的为注释信息
3 修饰符+代表public，-代表private，#代表protected，什么都没有代表包可见。
4 带下划线的属性或方法代表是静态的。

# 类与类之间主要有6种关系

http://blog.csdn.net/zhengzhb/article/details/7187278

## 信赖(dependence)  --------->
```Java
public class People {
	public void read(Book book) {
	}
}
```

## 关联(association) 
## 聚合(aggregation)
## 组合(composition)
## 继承(generalization)
## 实现(implementation)
