#FROM openjdk:17
#LABEL maintainer="javaguides.net"
#ADD target/template-0.0.1-SNAPSHOT.jar temp.jar
#EXPOSE 9090
#ENTRYPOINT ["java", "-jar", "temp.jar"]



FROM openjdk:17-jdk-alpine
ENV uname="raja"

LABEL "version"="raja.1.2"
#WORKDIR /app

#COPY pom.xml .
#RUN mvn install
#ARG JAR_FILE=target/*.jar

COPY ./target/template-0.0.1-SNAPSHOT.jar temp.jar

#EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/temp.jar"]
#docker run -p 8086:8092 yellow2
