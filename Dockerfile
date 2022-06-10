FROM maven:3.8.5-openjdk-17 as dependencies

ARG PROXY_SET=false
WORKDIR /app
COPY pom.xml .
RUN mvn -Denv=prod -B dependency:go-offline -DproxySet=${PROXY_SET}

FROM dependencies as build

ARG PROXY_SET=false
COPY src ./src
RUN mvn -Denv=dev -Dmaven.test.skip=true -B clean package -DproxySet=${PROXY_SET}

FROM openjdk:17-jdk-alpine

WORKDIR /app
COPY --from=build ./app/target/*.jar app.jar

CMD ["java", "-jar", "app.jar", "--spring.profiles.active=dev"]