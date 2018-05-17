# Install and run Spring-Maven
FROM openjdk:8-jdk-alpine
# WORKDIR /usr/src/app/api
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
