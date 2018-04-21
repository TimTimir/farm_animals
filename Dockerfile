FROM openjdk:jdk-alpine

MAINTAINER sns@caimito.net

COPY target/animals-*.jar /opt/app.jar

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/app.jar"]