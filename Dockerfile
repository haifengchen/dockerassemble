FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/namechoose-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} namechoose.jar
ENTRYPOINT ["java","-jar","/namechoose.jar"]
EXPOSE 8080