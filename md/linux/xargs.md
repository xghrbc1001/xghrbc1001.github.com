# 它将输入输出给xargs后面的命令，作为那个命令的参数
```
ls |xargs rm
find -name *test* | xargs cat > a
```
