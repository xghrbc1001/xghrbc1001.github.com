# 定义分隔符 
awk -F '|' ,默认为空格
echo a b c d | awk '{OFS="|";print $1,$2,$3,$4}' 输出分隔符

# 格式
Awk ‘[patten]{action}……’
pattern缺省为1，action缺省为{print}。那么awk ‘1’完整的写法就是awk ‘1{print}’; 同理，awk ‘{print}’完整的写法也是awk ‘1{print}’

# NR和FNR的区别
NR: 当前行记录数。
FNR: 当前文件的行记录数。
当awk处理的文件数超过1时，NR和FNR才会有区别

# 同样的代码，别人运行成功，为什么我运行失败？
文本格式的问题，cat-A file查看一下，如果是，dos2unix应该可以解决

# BEGIN 和END 到底是怎么一回事？

BEGIN {action} : 读取文本之前进行的操作

# “a==b?c:d” 
i完整写法为：if(a==b) {c} else {d}

# $4代表员工所在的部门，如果等于 Technology 则打印出整行
awk '$4 ~/Technology/' employee.txt  

# {print $2,"\t",$3}
# {print $2"\t"$3} 中间无空格

# cat brand.txt | awk '/品牌/{print}'  找出含品牌的所有的行

# 输出 

输出的结果用制表符(Tab键)隔开的话，可以用
cat 123.txt | awk '{ print $1 "\t" $3 }'
输出的结果用空格隔开的话，可以用逗号","隔开
cat 123.txt | awk '{ print $1 , $3 }'

# 求平均值
```
awk '{ sum+=$NF} END {print sum/NR}'    time.log
```
