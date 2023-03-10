FROM maven:3.8.3-openjdk-17 AS builder
ADD . /app
WORKDIR /app
RUN --mount=type=cache,target=/root/.m2 mvn -f /app/pom.xml clean package
FROM openjdk:17.0.1-jdk-slim

COPY --from=builder /app/target/RabbitMQ-SpringBoot-0.0.1.jar  RabbitMQ-SpringBoot.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","RabbitMQ-SpringBoot.jar"]