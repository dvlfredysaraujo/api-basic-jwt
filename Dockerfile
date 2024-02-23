FROM maven:3.9.3-eclipse-temurin-8-alpine

WORKDIR /app
COPY . /app
RUN mvn clean package -DskipTests

ENTRYPOINT ["java", "-jar", "/app/target/demo-0.0.1-SNAPSHOT.jar"]

