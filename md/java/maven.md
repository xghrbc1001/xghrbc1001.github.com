# mvn clean package -Pdev -DskipTests
# mvn install
# mvn deploy
# mvn package -X
# ���д򲻿�zip��jar���ģ�Ϊjar������ʧ�ܣ���repository��ɾ������������ 
# mvn jetty ,ͨ��mvn jetty:run���� mvn -Djetty.port=8888 jetty:run ָ���˿�
# ����web����

mvn archetype:generate -DgroupId=com.guilin -DartifactId=luyou -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
