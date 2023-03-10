# Build stage
FROM maven:3.8.3-openjdk-17 AS build
COPY pom.xml /app/
COPY src /app/src
RUN mvn -f /app/pom.xml clean package

# Run stage
FROM openjdk:17-jdk-alpine
COPY --from=build /app/target/ingresoJobintApi-0.0.1-SNAPSHOT.jar /app/ingresoJobintApi.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app/ingresoJobintApi.jar"]