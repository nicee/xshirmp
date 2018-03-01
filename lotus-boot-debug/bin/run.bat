rem JVM options on maven
rem if have to reset default server port, we should edit value of '-Dserver.port'
set MAVEN_OPTS=-Xms512m -Xmx1024m -Xss256K -XX:NewRatio=2 -XX:SurvivorRatio=8 -Dserver.port=8080
rem run this project
mvn spring-boot:run