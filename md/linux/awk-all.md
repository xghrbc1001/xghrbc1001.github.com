* awk 'pattern{action}' eg:awk ‘$1= =1001{print $2}’ data.txt 打印符合第一列等于1001的第二列
* NF 字段总数 FS 分隔符 OFS 输出分隔符 ORS 输出记录分隔符
* awk '/beni/' a.txt  打印含beni的行
* awk '/beni/{print $1,$1} a.txt 只打印找到beni
* date | awk '{print "Date:"$1 }'
* $0 当前行
* awk '{print NR,$0}' a.txt  NR 行号
* awk -F: '{print $1,$2}' a.txt  修改域
* awk '$3 < 4000' a.txt
* awk '{max=($2>$4)?$2:$4 print max}' a.txt
* awk '!($3>4000 && $3<6000)' a.atxt
* awk '{print $1,$2 | "sort" }' a.txt
* awk '{if($1=="http://www.baidu.com") print $1 }' a.txt
* NR全局行 FNR当前件行数 awk处理多个件
* ' 用\047 代替
* BEGIN 在第一行读取前执行 END在最后一行处理后执行
* 打印第8行 awk 'NR==8{print $0}' a.txt
* awk 'BEGIN { num=0;} {num++} END{print num}' a.txt
* awk 函数 sin(x) cos(x) rand() 
* 写script文件时，BEGIN或END后必须紧跟{
* 输出多列须用“，”（逗号）隔开
* awk ‘{print NR $1 $NF}’ data.txt 打印行号，第一列和最后一列，中间无分隔符
* awk ‘{print $1,$NF}’ data.txt 打印第一列和最后一列，并且中间有分隔符
* awk ‘{print FILENAME,$0}’ data1.txt data2.txt >data_all.t,把第一个文件和第二个文件合并到data_all.txt中,新文件第一列为原始文件名,后面列为原始文件内容
* awk 'BEGIN{"date"|getline d;split(d,a);print a[2]}
* awk 'ARGIND==1 {a[$1]=$0}  ARGIND>1 && ($1 in a) {print a[$1], $2}' a b > c  求件的交集 注意，file注意要dos2unix
* awk '{if($1 ~ /^[0-9]+$/) print}' text 查找数字
* 第一列在a文件中，不在b文件第一列中awk ,注意b和a的顺序 awk 'NR==FNR{++a[$1]}a[$1]==0{print $0}' b a
* awk '{if ($2 != "null" ) {print $2} else{ print $1}}' test
* 模糊匹配 awk '$0~/中国/' test
* group by 求合
```
所有第1列相同的行，按第2列的和，求和的结果倒序输出（类似SQL中的group by求sum()）
        awk '{arr[$1]+=$2}END{for (i in arr) print i,arr[i]}' src.txt  | sort -k2nr -g > dest.txt

```
* 打印最后一列 awk '{print $NF}' a
* 打印倒数第二列 awk '{print $(NF-1)}' a
