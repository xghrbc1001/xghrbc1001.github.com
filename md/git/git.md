# git常用命令
* git init
* git add //git默认不会跟踪修改
* git log
* git log -p #查看版本信息并显示每次修改的diff
* git commit -a 可设置自动跟踪己被track,没有track的不可跟踪到
* git log -t 查看修改内容
* git fetch 相当于是从远程获取最新版本到本地，不会自动merge
```Bash
git fetch origin master:tmp  #获取最新版本到tmp分支
git diff tmp #比较 
git merge tmp #合并

git fetch origin master #远程的origin的master主分支下载最新的版本到origin/master分支上
git log -p master..origin/master #比较本地的master分支和origin/master分支的差别
git merge origin/master
```
* git pull # 相当于是从远程获取最新版本并merge到本地 pull = fetch + merge
* git rebase origin/master 分支历史看起来像没有经过任何合并一样
* git branch
* git branch AAA 切换分支
* git branch -a  查看所有分支
* git branch -d AAA 删除分支
* git diff 只会应用于被跟踪的,(working directory和staging)
* git diff version
* git diff staged
* git diff HEAD
* git diff version1 version2
* git checkout -b test 创建新分支test
* git diff master test 比较分支的head的不同
* git reset
* git show version ＃查看指定版本信息
* git revert 是撤销某次操作，此次操作之前的commit都会被保留
* git reset 会将所有stage的文件状态，都变成非stage状态
# .git/config 
* vim .git/config
# .gitconfig

* git config --global core.editor vim 设置默认的编辑器

```
[user]
	name=
	email=
[core]
	editor=vim
[alias]
	ci=commit -a -v
```
# tig
* sudo apt-get install tig

# diff
* diff aaa bbb
* diff -Nurp v0.1/ v0.2/

# 区域
* working directory <--> staging area <--> repository

# ignore
```Bash
如果要忽略的文件已被git管理,需要先移除,命令如下:

e.g.:
git rm -r --cached  WebRoot/WEB-INF/classes/**/*
```
