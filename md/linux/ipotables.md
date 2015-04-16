# ≈‰÷√
```
#! /bin/sh
#
# Copyright (c) 2002 SuSE Linux AG Nuernberg, Germany.  All rights reserved.
#
# Author: Werner Fink <werner@suse.de>, 1996
#         Burchard Steinbild, 1996
#
# /etc/init.d/boot.local
#
# script with local commands to be executed from init on system startup
#
# Here you should add things, that should happen directly after booting
# before we're going to the first run level.
#
# DROP eth0's tcp udp transport except igmp
/usr/sbin/iptables -F
/usr/sbin/iptables -A INPUT -i eth0 -p tcp -j DROP
/usr/sbin/iptables -A INPUT -i eth0 -p udp -j DROP
# iptables for 10.204.19.234 port: 6379
/usr/sbin/iptables -A INPUT -s 10.137.12.23 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.137.17.149 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.137.17.150 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.137.17.153 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.137.17.154 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.137.17.83 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.137.17.84 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.137.17.85 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.204.0.29 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.204.0.30 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.204.0.31 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.204.0.32 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.204.19.233 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.204.19.234 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.204.20.111 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.204.7.93 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.204.7.94 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.204.9.22 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.204.9.23 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.137.17.140 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.137.17.141 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.137.17.142 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.204.19.153 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.204.19.160 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.240.125.106 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.240.125.104 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.241.96.97 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.241.96.96 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.241.96.95 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.241.96.94 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.241.96.98 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.137.17.140 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.137.17.141 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.137.17.142 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.209.1.144 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -s 10.241.81.31 -p tcp --dport 6379 -j ACCEPT
/usr/sbin/iptables -A INPUT -p tcp --dport 6379 -j REJECT

# ADDAGENTSTART
/usr/local/agenttools/agent/startagent.sh /usr/local/agenttools/agent >/dev/null 2>&1
#secu-tcs-agent bootstart, install at Mon May 28 04:21:59 CST 2012.
/usr/local/sa/agent/secu-tcs-agent-mon-safe.sh > /dev/null 2>&1
#Initilize SOL
/usr/sbin/iptables -A INPUT -i eth0 --protocol udp --dport 123 -j DROP
cd /usr/local/TsysAgent/bin && ./start.sh
cd /usr/local/TsysAgent/bin && ./start_proxy.sh

```
# …˙–ß
cat /etc/rc.d/boot.local | grep iptables | sh
