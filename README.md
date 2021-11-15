# Docker SpringBoot Sample
A sample SpringBoot application developed for learning purpose.

------------
- Base URL: /n4smh/api
- Port: 8090
- Endpoints: 
 - SpringBoot actuator 
 - /samplecontroller
   - /info - Returns  string consist of HostName HostAddress and LocalDateTime
   - /properties/{name} - Returns key value combination of environment variable specified by path variable 'name'
   

------------
###  Containerization of application
Could be achived in 2 ways
#### 1. JIB plug-in

One approach is to add its plug-in in pom.xml and use following  command to run `mvm clean compile jib:dockerBuild`.
````xml
<plugin>
	<groupId>com.google.cloud.tools</groupId>
	<artifactId>jib-maven-plugin</artifactId>
	<version>3.1.4</version>
	<configuration>
		<to>
			<image>n4smh/dockersample:tagname</image>
		</to>					
	</configuration>
</plugin> 
````

Note: 
- Docker deamon should be running if the code is being pushed to local
- For push to docker hub ~./m2/setting.xml has to be updated with docker hub credentials as follows in server section and image has to be updated with docker hub registory URL `<image>registry.hub.docker.comn4smh/dockersample:${version}</image>`
```xml
<server>
	<id>registry.hub.docker.com</id>
	<username>n4smh</username>
	<password>********</password>
</server>
```

JBL allows same functionality without modifing the pom.xml by specifing the build details in maven build command mvn clean install `mvn com.google.cloud.tools:jib-maven-plugin:build -Dimage=n4smh/dockersample:tagname`
#### 2. Docker file
A simple docker file is contructed in project root directory.  For image build use `docker build -t n4smh/dockersample:tagname .` command.
```bash
FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/dockersample-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```
------------
