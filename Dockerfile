FROM openjdk:18-jdk-alpine3.14 

WORKDIR /app

COPY . .

RUN ./gradlew clean build  --


EXPOSE 8080

CMD ["java", "-jar", "build/libs/finacc-klt.jar"]

