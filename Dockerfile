# Этап 1: Сборка приложения с использованием Maven
FROM maven:3.9.6-eclipse-temurin-21-jammy as build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

# Этап 2: Создание окончательного Docker образа
FROM amazoncorretto:21-alpine-full
WORKDIR /app

# Установка wget
RUN apk update && \
    apk add --no-cache wget && \
    rm -rf /var/lib/apt/lists/*

# Установка Dockerize
ENV DOCKERIZE_VERSION v0.6.1
RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && rm dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz

COPY --from=build /app/target/*.jar ToDoList-1.0.0.jar
ENTRYPOINT ["dockerize", "-wait", "tcp://mysql:3306", "-timeout", "60s", "java", "-jar", "ToDoList-1.0.0.jar"]




#FROM openjdk:21-jdk
#MAINTAINER d.shubchynskyi@gmail.com
#
#ENV DOCKERIZE_VERSION v0.6.1
#RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
#    && tar -C /usr/local/bin -xzvf dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
#    && rm dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz
#
#COPY target/ToDoList-1.0.0.jar ToDoList-1.0.0.jar
#
#ENTRYPOINT ["dockerize", "-wait", "tcp://mysql:3306", "-timeout", "60s", "java", "-jar", "/ToDoList-1.0.0.jar"]
