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

# setting.xml
* M2_HOME/conf/settings.xml 全局 ~/.m2/settings.xml 用户范围
```
# 需要通过配置上网时
<proxies>
	<proxy>
		<id>my-proxy</id>
		<active>true</active>
		<protocol>http</protocol>
		<host>192.168.0.2</host>
		<port>8888</port>
		<!--
		<username>abc</username>
		<password>123</password>
		<!-- 指定哪些主机不需要代理 -->
		<nonProxyHosts>*.google.com|*.baidu.com</nonProxyHosts>
		-->
	</proxy>
	<proxy>
	</proxy>
</proxies>
```

# m2eclipse
* wtp (web tool platform),开发j2ee web应用程序工具集
* Maven Integration for WTP (Optional) 可以让eclipse自动读取pom信息并配置wtp

# pom
* src/main/java src/test/java (maven约定)
```
<dependency>
<groupId>junit</groupId>
<!-- 该依赖只对测试有用 -->
<artifactId>junit</artifactId>
<version>4.7</version>
<scope>test</scope>
</dependency>

<!-- 默认,表示对主代码和测试代码都有效 -->
<scope>compile</scope>
```

## 默认compile只支持1.3,所以@Test会报错
```
<plugins>
	<!-- 支持1.5 -->
	<plugin>
		<groupId>org.apache.maven.plugins</groupId>
		<artifactId>maven-compiler-plugin</artifactId>
		<configuration>
			<source>1.5</source>
			<target>1.5</target>
		</configuration>
	</plugin>

	<!-- 打包可运行包 target 下生成两个，一个带main,一个不带 -->
	<plugin>
		<groupId>org.apache.maven.plugins</groupId>
		<artifactId>maven-shard-plugin</artifactId>
		<version>1.2.1</version>
		<exclutions>
			<exclution>
				<phase>package</phase>
				<goals>
					<goal>shade</goal>
				</goals>
			</exclution>
			<configuration>
				<transformers>
					<transformer implementation="org.apache.maven.plugins.shade.resource.MainfestResourceTransformer">
						<mainClass>com.x.HelloWorld</mainClass>
					</transformer>
				</transformers>
			</configuration>
		</exclutions>
	</plugin>
</plugins>
```

## 常用命令
```
mvn clean test
```

# archetype 项目框架
```
mvn archetype:generate
```

# 坐标
```
groupId
artifactId
version
packaging
classifier 附属构件,如javadoc,sources
```

# 依赖
```
compile
test
provided 对于编译和测试有效，但运行时1效,eg: servlet-api
runtime 如jdbc
system,系统依赖，必须通过systemPath显示指定路径
<scope>system</scope>
<systemPath>${java.home}/lib/rt.jar</systemPath>

```

# 传递性依赖
* 路径就近原则
```
A->B->C->X(1.0)  A->D->X(2.0) X(2.0)会被解7
```
* 第一声明优先
```
A->B->Y(1.0)  A->C->Y(2.0)  Y(1.0)优先
```

# 可选依赖
```
<dependency>
	<version>1.0.0</version>
	<optional>true</optional>
</dependency>
```

# setting.xml
```
# maven会check包是不是有量多新，如果有，下载到local repo中，若不需要，配置如下
<offline>true</offline>
```
# 己解7依赖
```
mvn dependency:list
mvn dependency:tree
mvn dependengy:analyze
```
# 仓库
## 本地仓库

## 远程仓库
