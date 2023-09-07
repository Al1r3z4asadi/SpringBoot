FROM openjdk:18-jdk-alpine3.14 as build

WORKDIR /home
MAINTAINER Al1r3z4asadi

COPY . .


RUN ./gradlew clean build --refresh-dependencies

FROM openjdk:18-jdk-alpine3.14

WORKDIR /home

COPY --from=build ./build/libs/finacc-klt.jar ups.jar
EXPOSE 8080

CMD ["java", "-jar", "ups.jar"]

