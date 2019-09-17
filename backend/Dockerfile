FROM adoptopenjdk/maven-openjdk11

EXPOSE 8080
RUN mkdir /usr/src/java
WORKDIR /usr/src/java

COPY src /usr/src/java/src
COPY pom.xml /usr/src/java/pom.xml
RUN cd /usr/src/java && mvn clean verify 

ENTRYPOINT ["java","-jar","/usr/src/java/target/demo-0.0.1-SNAPSHOT.jar"]