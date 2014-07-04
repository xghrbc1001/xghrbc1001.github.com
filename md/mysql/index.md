# fulltext
```Bash
FULLTEXT (title,body)
SELECT * FROM articles
             WHERE MATCH (title,body) AGAINST ('database');
```

# 中文分词
 my.cnf中，记得将ft_min_word_len=1 ,默认值为4
 show variables like 'ft_min_word_len'查看
 mysql不支持中文分词，中文间用空格，逗号等分开
 记住，修改ft_min_word_len后，要重新生成索引(REPAIR TABLE tbl_name QUICK;)

