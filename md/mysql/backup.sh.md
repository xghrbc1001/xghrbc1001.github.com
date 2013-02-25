## mysql ±¸·Ý
```Bash
#!/bin/bash
 
# mysql_backup.sh: backup mysql databases and keep newest $MAX days backup.
 
#set -x
 
# your mysql login information
db_user="root"
db_passwd="password"
db_host="localhost"
 
# the directory for storing your backup file.
backup_dir="/root/mybackup"
 
# date format for backup file (dd-mm-yyyy)
#time="$(date +"%Y%m%d")"
time="$(date +"%F_%T")"
 
# mysql, mysqldump and some other bin's path
MYSQL="/usr/bin/mysql"
MYSQLDUMP="/usr/bin/mysqldump"
MKDIR="/bin/mkdir"
RM="/bin/rm"
MV="/bin/mv"
GZIP="/bin/gzip"
MAX=9
 
# check the directory for store backup is writeable
test ! -w $backup_dir && echo "Error: $backup_dir is un-writeable." && exit 0
 
# delete the oldest backup
test -d "$backup_dir/backup.$MAX/" && $RM -rf "$backup_dir/backup.$MAX"
 
# rotate backup directory
for (( int=$MAX; int >= 0; int--)); 
do 
	if(test -d "$backup_dir"/backup."$int")
	then
		next_int=`expr $int + 1`
		$MV "$backup_dir"/backup."$int" "$backup_dir"/backup."$next_int"
	fi
done
 
# the directory for store the newest backup
test ! -d "$backup_dir/backup.0/" && $MKDIR "$backup_dir/backup.0/"
 
# get all databases
all_db="$($MYSQL -u $db_user -h $db_host -p$db_passwd -Bse 'show databases')"
 
for db in $all_db
do
	$MYSQLDUMP -u $db_user -h $db_host -p$db_passwd $db | $GZIP -9 > "$backup_dir/backup.0/$time.$db.gz"
done
 
exit 0;

```

## cron

```
[root@localhost ~]# crontab -l

    m h dom mon dow command 

0 0 * * * /root/bin/mysql_backup 

```
