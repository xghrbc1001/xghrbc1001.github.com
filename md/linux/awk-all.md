* awk 'pattern{action}' eg:awk ��$1= =1001{print $2}�� data.txt ��ӡ���ϵ�һ�е���1001�ĵڶ���
* NF �ֶ����� FS �ָ��� OFS ����ָ��� ORS �����¼�ָ���
* awk '/beni/' a.txt  ��ӡ��beni����
* awk '/beni/{print $1,$1} a.txt ֻ��ӡ�ҵ�beni
* date | awk '{print "Date:"$1 }'
* $0 ��ǰ��
* awk '{print NR,$0}' a.txt  NR �к�
* awk -F: '{print $1,$2}' a.txt  �޸���
* awk '$3 < 4000' a.txt
* awk '{max=($2>$4)?$2:$4 print max}' a.txt
* awk '!($3>4000 && $3<6000)' a.atxt
* awk '{print $1,$2 | "sort" }' a.txt
* awk '{if($1=="http://www.baidu.com") print $1 }' a.txt
* NRȫ���� FNR��ǰ������ awk��������
* ' ��\047 ����
* BEGIN �ڵ�һ�ж�ȡǰִ�� END�����һ�д����ִ��
* ��ӡ��8�� awk 'NR==8{print $0}' a.txt
* awk 'BEGIN { num=0;} {num++} END{print num}' a.txt
* awk ���� sin(x) cos(x) rand() 
* дscript�ļ�ʱ��BEGIN��END��������{
* ����������á����������ţ�����
* awk ��{print NR $1 $NF}�� data.txt ��ӡ�кţ���һ�к����һ�У��м��޷ָ���
* awk ��{print $1,$NF}�� data.txt ��ӡ��һ�к����һ�У������м��зָ���
* awk ��{print FILENAME,$0}�� data1.txt data2.txt >data_all.t,�ѵ�һ���ļ��͵ڶ����ļ��ϲ���data_all.txt��,���ļ���һ��Ϊԭʼ�ļ���,������Ϊԭʼ�ļ�����
* awk 'BEGIN{"date"|getline d;split(d,a);print a[2]}
* awk 'ARGIND==1 {a[$1]=$0}  ARGIND>1 && ($1 in a) {print a[$1], $2}' a b > c  ����Ľ��� ע�⣬fileע��Ҫdos2unix
