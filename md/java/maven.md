# mvn clean package -Pdev -DskipTests
# mvn install
# mvn deploy
# mvn package -X
# 若有打不开zip或jar包的，为jar包下载失败，在repository中删除后重新下载 
# mvn jetty ,通过mvn jetty:run运行 mvn -Djetty.port=8888 jetty:run 指定端口
# 创建web工程

mvn archetype:generate -DgroupId=com.guilin -DartifactId=luyou -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false

# mvn dependency:sources 下载依赖包源

# project is not a java projetc
mvn eclipse:eclipse

```
# 从己有的生成
  mvn archetype:create-from-project
  cd target\generated-sources\archetype
  mvn install

# 生成工程
  mvn archetype:generate -B -DarchetypeCatalog=local -DarchetypeRepository=local -DarchetypeGroupId=com.sogou.baike.user -DarchetypeArtifactId=bk-user-archetype -DarchetypeVersion=1.0.0-SNAPSHOT -DgroupId=com.sogou.baike -DartifactId=dict
```
