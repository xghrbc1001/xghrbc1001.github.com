# grep���ǰ����
```
# ǰһ��
grep -B1 'aaa' test.txt

# �����
grep -A2 'aaa' test.txt
```
# ��ĳһĿ¼�µݹ�[������Ŀ¼]����ĳһ�ִ�
```
grep -r ���ִ��� Ŀ¼��
```

# find grep
```
# ע�⣬*.md��������
find -name '*.md' | xargs grep -r 'aaa'
```
