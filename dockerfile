FROM maven:3.9-eclipse-temurin-17

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn test

RUN mvn package

CMD ["java", "-cp", "target/basic-cicd-project-1.0-SNAPSHOT.jar", "com.devops.App"]
