FROM openjdk:17-jdk-alpine

COPY target/ingresoJobintApi-0.0.1-SNAPSHOT.jar /app/ingresoJobintApi.jar

RUN mkdir /app/files

EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app/ingresoJobintApi.jar"]