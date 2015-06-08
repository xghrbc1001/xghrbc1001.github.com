# 判断数字 
```
Pattern.compile("[0-9]+").matcher(str).matches()
```

# 正则
* \\ 匹配反斜线
* \t 制表符
* \n 换行
* [abc] 字符a,b或c
* [^abc] 除abc外的任意字符
* [a-zA-Z0-9] 由字母，数字组成
* \d 数字
* \D 非数字
* \w 字母，数字，下划线
* \W 非字母，数字，下划线
* \s 所有空白字符（换行，空格等)
* \S 非空白字符
* ^ 行的开头
* $ 行结尾
* . 匹配换行符之外的任意字符

# 规范，假设X为一组规范
* X 必须出现一次
* X? 没有也可以
* X* 0，1 多次
* X+ 1次或多次
* X{5} 必须为5次
* X{5,} 必须出现5次以上
* X{5,8} 5至8次
* XY X与Y规范 
* X|Y X或Y规范
* (X)
# Pattern Matcher
```
Pattern
split()
Matcher
replaceAll()
matches()
```

# String 正则
```
matches()
replaceAll
split
```

# 特殊
* |在正则中有定义，所以要用\\|
