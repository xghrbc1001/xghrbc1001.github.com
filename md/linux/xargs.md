# �������������xargs����������Ϊ�Ǹ�����Ĳ���
```
ls |xargs rm
find -name *test* | xargs cat > a

# �ҵ������Ƶ�Ŀ¼
find -name *.jpg | xargs -i cp {} /data/i/
```
