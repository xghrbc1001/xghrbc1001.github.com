```
#查看80端口的tcp连接
#netstat -tan | grep "ESTABLISHED" | grep ":80" | wc -l
1
#当前WEB服务器中联接次数最多的ip地址:
#netstat -ntu |awk '{print $5}' |sort | uniq -c| sort -n -r
231 ::ffff:127.0.0.1:8095
23 ::ffff:192.168.50.201:5432
2 ::ffff:192.168.50.203:80
1 servers)
1 ::ffff:192.168.50.56:43314
1 ::ffff:192.168.50.21:2996
1 ::ffff:192.168.50.21:2989
1 ::ffff:192.168.50.200:8060
1 ::ffff:192.168.50.12:1300
1 ::ffff:192.168.50.12:1299
1 ::ffff:192.168.50.12:1298
1 ::ffff:127.0.0.1:57933
1 Address
1 192.168.50.41:65310
1 192.168.50.41:64949
1 192.168.50.41:49653
#查看日志中访问次数最多的前10个IP
#cat access_log |cut -d ' ' -f 1 |sort |uniq -c | sort -nr | awk '{print $0 }' | head -n 10 |less
14085 121.207.252.122
13753 218.66.36.119
11069 220.162.237.6
1188 59.63.158.118
1025 ::1
728 220.231.141.28
655 114.80.126.139
397 117.25.55.100
374 222.76.112.211
348 120.6.214.70
#查看日志中出现100次以上的IP
#cat access_log |cut -d ' ' -f 1 |sort |uniq -c | awk '{if ($1 > 100) print $0}'｜sort -nr |less
14085 121.207.252.122
13753 218.66.36.119
11069 220.162.237.6
1188 59.63.158.118
1025 ::1
728 220.231.141.28
655 114.80.126.139
397 117.25.55.100
374 222.76.112.211
348 120.6.214.70
252 58.211.82.150
252 159.226.126.21
206 121.204.57.94
192 59.61.111.58
186 218.85.73.40
145 221.231.139.30
134 121.14.148.220
123 222.246.128.220
122 61.147.123.46
119 121.204.105.58
107 116.9.75.237
105 118.123.5.173
#查看最近访问量最高的文件
#cat access_log |tail -10000|awk '{print $7}'|sort|uniq -c|sort -nr|less
8729 /server-status?auto
618 /
15 /favicon.ico
12 /manager/html
10 *
9 /top/icons.gif
8 /www.766.com/awstats.www.766.com.html
8 /awstatsicons/other/vv.png
8 /awstatsicons/other/vu.png
8 /awstatsicons/other/vp.png
8 /awstatsicons/other/vk.png
8 /awstatsicons/other/vh.png
8 /awstatsicons/other/hx.png
8 /awstatsicons/other/hp.png
8 /awstatsicons/other/hk.png
8 /awstatsicons/other/hh.png
8 /awstatsicons/other/he.png
8 /awstatsicons/other/awstats_logo6.png
8 /awstatsicons/os/win.png
8 /awstatsicons/os/unknown.png
8 /awstatsicons/os/unix.png
8 /awstatsicons/os/symbian.png
8 /awstatsicons/os/psp.png
#查看最近访问量最高的页面(.png)
#cat access_log |awk '{print $7}'|grep '.png'|sort|uniq -c|sort -nr |head -n 10
241 /awstatsicons/other/awstats_logo6.png
227 /awstatsicons/clock/hr12.png
226 /awstatsicons/other/vv.png
226 /awstatsicons/other/vu.png
226 /awstatsicons/other/vp.png
226 /awstatsicons/other/vk.png
226 /awstatsicons/other/vh.png
226 /awstatsicons/clock/hr9.png
226 /awstatsicons/clock/hr8.png
226 /awstatsicons/clock/hr7.png
#查看日志中访问超过100次的页面
#cat access_log | cut -d ' ' -f 7 | sort |uniq -c | awk '{if ($1 > 100) print $0}' | less
20107 /
1027 *
215 /awstatsicons/browser/chrome.png
215 /awstatsicons/browser/firefox.png
136 /awstatsicons/browser/mozilla.png
216 /awstatsicons/browser/msie.png
201 /awstatsicons/browser/netscape.png
123 /awstatsicons/browser/notavailable.png
214 /awstatsicons/browser/opera.png
215 /awstatsicons/browser/pdaphone.png
214 /awstatsicons/browser/safari.png
215 /awstatsicons/browser/unknown.png
226 /awstatsicons/clock/hr10.png
226 /awstatsicons/clock/hr11.png
227 /awstatsicons/clock/hr12.png
225 /awstatsicons/clock/hr1.png
226 /awstatsicons/clock/hr2.png
226 /awstatsicons/clock/hr3.png
226 /awstatsicons/clock/hr4.png
226 /awstatsicons/clock/hr5.png
226 /awstatsicons/clock/hr6.png
226 /awstatsicons/clock/hr7.png
226 /awstatsicons/clock/hr8.png
#access_log昨天一天的点击量(clicks);
cat access_log|grep '12/Nov/2009'|grep "******.jsp"|wc|awk '{print $1}'|uniq
0
#昨天访问网站的独立IP有多少；
cat access_log|grep '12/Aug/2009'|grep "******"|wc|awk '{print $1}'|uniq
194
#统计某url，一天的访问次数
#cat access_log|grep '12/Aug/2009'|grep '/images/index/e1.gif'|wc|awk '{print $1}'
2
#拉出前五天的访问次数最多的网页前20名清单；进行五天日志对比，找出排名靠前重复的网页，即可得出本周访问量最大的前几个网页；
#cat access_log|awk '{print $7}'|uniq -c |sort -n -r|head -20
10519 /
654 /manager/html
450 /manager/html
397 /
368 /manager/html
304 /
280 /manager/html
279 /
263 /manager/html
252 /manager/html
252 /manager/html
226 /
220 /
193 /
187 /
180 /
167 /
166 /
134 /
129 /
#从日志里查看该ip在干嘛:
#cat access_log | grep 218.66.36.119| awk '{print $1"/t"$7}' | sort | uniq -c | sort -nr | less
243 218.66.36.119 /
210 218.66.36.119 /awstatsicons/other/awstats_logo6.png
198 218.66.36.119 /awstatsicons/clock/hr12.png
197 218.66.36.119 /awstatsicons/other/vv.png
197 218.66.36.119 /awstatsicons/other/vu.png
197 218.66.36.119 /awstatsicons/other/vp.png
197 218.66.36.119 /awstatsicons/other/vk.png
197 218.66.36.119 /awstatsicons/other/vh.png
197 218.66.36.119 /awstatsicons/clock/hr9.png
197 218.66.36.119 /awstatsicons/clock/hr8.png
197 218.66.36.119 /awstatsicons/clock/hr7.png
197 218.66.36.119 /awstatsicons/clock/hr6.png
197 218.66.36.119 /awstatsicons/clock/hr5.png
197 218.66.36.119 /awstatsicons/clock/hr4.png
197 218.66.36.119 /awstatsicons/clock/hr3.png
197 218.66.36.119 /awstatsicons/clock/hr2.png
197 218.66.36.119 /awstatsicons/clock/hr1.png
197 218.66.36.119 /awstatsicons/clock/hr11.png
#列出传输时间超过 30 秒的文件
#cat access_log|awk ‘($NF > 30){print $7}’|sort -n|uniq -c|sort -nr|head -20
14058 /server-status?auto
8966 /
3955 /manager/html
1025 *
214 /www.766.com/awstats.www.766.com.html
211 /awstatsicons/other/awstats_logo6.png
199 /awstatsicons/clock/hr12.png
198 /awstatsicons/other/vv.png
198 /awstatsicons/other/vu.png
198 /awstatsicons/other/vp.png
198 /awstatsicons/other/vk.png
198 /awstatsicons/other/vh.png
198 /awstatsicons/clock/hr9.png
198 /awstatsicons/clock/hr8.png
198 /awstatsicons/clock/hr7.png
198 /awstatsicons/clock/hr6.png
198 /awstatsicons/clock/hr5.png
198 /awstatsicons/clock/hr4.png
198 /awstatsicons/clock/hr3.png
198 /awstatsicons/clock/hr2.png
#列出最最耗时的页面(超过60秒的)的以及对应页面发生次数
#cat access_log |awk ‘($NF > 60 && $7~//.php/){print $7}’|sort -n|uniq -c|sort -nr|head -100

```
