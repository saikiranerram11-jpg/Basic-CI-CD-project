FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN ./mvnw test
