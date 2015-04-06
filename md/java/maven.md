# mvn clean package -Pdev -DskipTests
# mvn install
# mvn deploy
# mvn package -X
# ���д򲻿�zip��jar���ģ�Ϊjar������ʧ�ܣ���repository��ɾ������������ 
# mvn jetty ,ͨ��mvn jetty:run���� mvn -Djetty.port=8888 jetty:run ָ���˿�
# ����web����

mvn archetype:generate -DgroupId=com.guilin -DartifactId=luyou -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false

# mvn dependency:sources ����������Դ

# project is not a java projetc
mvn eclipse:eclipse

```
# �Ӽ��е�����
  mvn archetype:create-from-project
  cd target\generated-sources\archetype
  mvn install

# ���ɹ���
  mvn archetype:generate -B -DarchetypeCatalog=local -DarchetypeRepository=local -DarchetypeGroupId=com.sogou.baike.user -DarchetypeArtifactId=bk-user-archetype -DarchetypeVersion=1.0.0-SNAPSHOT -DgroupId=com.sogou.baike -DartifactId=dict
```

# setting.xml
* M2_HOME/conf/settings.xml ȫ�� ~/.m2/settings.xml �û���Χ
```
# ��Ҫͨ����������ʱ
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
		<!-- ָ����Щ��������Ҫ���� -->
		<nonProxyHosts>*.google.com|*.baidu.com</nonProxyHosts>
		-->
	</proxy>
	<proxy>
	</proxy>
</proxies>
```

# m2eclipse
* wtp (web tool platform),����j2ee webӦ�ó��򹤾߼�
* Maven Integration for WTP (Optional) ������eclipse�Զ���ȡpom��Ϣ������wtp

# pom
* src/main/java src/test/java (mavenԼ��)
```
<dependency>
<groupId>junit</groupId>
<!-- ������ֻ�Բ������� -->
<artifactId>junit</artifactId>
<version>4.7</version>
<scope>test</scope>
</dependency>

<!-- Ĭ��,��ʾ��������Ͳ��Դ��붼��Ч -->
<scope>compile</scope>
```

## Ĭ��compileֻ֧��1.3,����@Test�ᱨ��
```
<plugins>
	<!-- ֧��1.5 -->
	<plugin>
		<groupId>org.apache.maven.plugins</groupId>
		<artifactId>maven-compiler-plugin</artifactId>
		<configuration>
			<source>1.5</source>
			<target>1.5</target>
		</configuration>
	</plugin>

	<!-- ��������а� target ������������һ����main,һ������ -->
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

## ��������
```
mvn clean test
```

# archetype ��Ŀ���
```
mvn archetype:generate
```

# ����
```
groupId
artifactId
version
packaging
classifier ��������,��javadoc,sources
```

# ����
```
compile
test
provided ���ڱ���Ͳ�����Ч��������ʱ1Ч,eg: servlet-api
runtime ��jdbc
system,ϵͳ����������ͨ��systemPath��ʾָ��·��
<scope>system</scope>
<systemPath>${java.home}/lib/rt.jar</systemPath>

```

# ����������
* ·���ͽ�ԭ��
```
A->B->C->X(1.0)  A->D->X(2.0) X(2.0)�ᱻ��7
```
* ��һ��������
```
A->B->Y(1.0)  A->C->Y(2.0)  Y(1.0)����
```

# ��ѡ����
```
<dependency>
	<version>1.0.0</version>
	<optional>true</optional>
</dependency>
```

# setting.xml
```
# maven��check���ǲ����������£�����У����ص�local repo�У�������Ҫ����������
<offline>true</offline>
```
# ����7����
```
mvn dependency:list
mvn dependency:tree
mvn dependengy:analyze
```
# �ֿ�
## ���زֿ�

## Զ�ֿ̲�
