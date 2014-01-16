* ~/.ssh2目录 ssh-keygen 默认按回车 生成一个私钥一个公钥
* echo "IdKey id_dsa_2048_a" >> ~/.ssh2/identification 
* 将公钥放至可以不需密码登录的服务器 echo "Key id_dsa_2048_a.pub" >> ~/.ssh2/authorization
* 即可不需密码访问
