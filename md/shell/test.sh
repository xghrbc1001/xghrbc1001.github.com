#! /bin/bash

function sayHi() {
    echo "inpurt user"
    read user
    echo "Hi,$user"
}

echo "input your name:"
read name 
echo "hello $name \c"

# 默认读入赋值给$RAPLY
read
echo "$REPLY will come"

# 调用sayHi函数
sayHi

