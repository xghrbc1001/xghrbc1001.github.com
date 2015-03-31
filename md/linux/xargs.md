# 它将输入输出给xargs后面的命令，作为那个命令的参数
```
ls |xargs rm
find -name *test* | xargs cat > a

# 找到件复制到目录
find -name *.jpg | xargs -i cp {} /data/i/
```
