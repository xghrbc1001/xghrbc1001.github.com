# mvn clean package -Pdev -DskipTests
# mvn install
# mvn deploy
# mvn package -X
# 若有打不开zip或jar包的，为jar包下载失败，在repository中删除后重新下载 
# mvn jetty ,通过mvn jetty:run运行 mvn -Djetty.port=8888 jetty:run 指定端口
# 创建web工程

mvn archetype:generate -DgroupId=com.guilin -DartifactId=luyou -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
