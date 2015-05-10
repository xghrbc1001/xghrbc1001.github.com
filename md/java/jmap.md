# command
```
jmap -histo $pid > jmap.txt

jmap -dump:format=b,file=a.map $pid

jmap -dump:live,file=a.map $pid

jhat a.map
```
