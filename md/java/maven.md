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
