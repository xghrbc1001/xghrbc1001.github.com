# 快速删除
如果一个目录件太多，如几百万个，rm -rf 删除太慢，可以通过
```
# 删除log
mkdir /tmp/null
rsync --delete-before -a -H -v -P --stats /tmp/null/ log 
```
