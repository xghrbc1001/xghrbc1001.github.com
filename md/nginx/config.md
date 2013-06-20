# upstream hash
```
upstream tomcat_bkcategory {
   hash $key;
}
```
# upstream weight
```
upstream tomcat_bkcategory {
    server 127.0.0.1:9011 weight=10
    server 127.0.0.2:9011 weight=10
}
```
