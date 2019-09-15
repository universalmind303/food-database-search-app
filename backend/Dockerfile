FROM adoptopenjdk/maven-openjdk11

EXPOSE 8080
RUN mkdir /usr/src/java
WORKDIR /usr/src/java

# Install package dependencies
COPY src /usr/src/java/src
COPY pom.xml /usr/src/java/pom.xml
RUN ls /usr/src/java
RUN cd /usr/src/java && mvn clean verify 

# The applADDication's jar file

# Add the application's jar to the container

# Run the jar file 
ENTRYPOINT ["java","-jar","/usr/src/java/target/demo-0.0.1-SNAPSHOT.jar"]