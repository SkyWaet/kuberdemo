FROM eclipse-temurin:17-alpine
ARG JAR_FILE=target/kuberdemo-0.0.1.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]