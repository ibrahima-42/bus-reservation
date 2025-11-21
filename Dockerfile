# Dockerfile pour ton application
FROM openjdk:26-trixie
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
