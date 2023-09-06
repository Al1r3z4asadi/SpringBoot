FROM openjdk:17-jdk-slim as builder

WORKDIR /app
MAINTAINER Al1r3z4asadi

COPY src ./src
COPY finacc-forex.jar .
COPY build.gradle .
COPY gradlew .
COPY gradle ./gradle


RUN ./gradlew clean build

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=builder /app/build/libs/finacc-klt.jar app.jar
EXPOSE 8080

CMD ["java", "-jar", "app.jar"]

