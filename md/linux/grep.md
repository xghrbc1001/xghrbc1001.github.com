# grep后的前后行
```
# 前一行
grep -B1 'aaa' test.txt

# 后二行
grep -A2 'aaa' test.txt
```
# 在某一目录下递归[所有子目录]查找某一字串
```
grep -r “字串” 目录名
```

# find grep
```
# 注意，*.md带上引号
find -name '*.md' | xargs grep -r 'aaa'
```
