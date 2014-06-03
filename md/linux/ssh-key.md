# V1 
* ~/.ssh2目录 ssh-keygen 默认按回车 生成一个私钥一个公钥
* echo "IdKey id_dsa_2048_a" >> ~/.ssh2/identification 
* 将公钥放至可以不需密码登录的服务器 echo "Key id_dsa_2048_a.pub" >> ~/.ssh2/authorization
* 即可不需密码访问

# V2
* 11要访问155,在155上,ssh-keygen ，按回车生成私钥，公钥
* 将172_27.24_11.pub放至155的~/.ssh2中
* 155上 ,echo "Key 172_27_24_11.pub" >> ~/.ssh2//authorization
* 在11上即可访问155
