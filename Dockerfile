# Stage 1: Build the application using Maven
FROM maven:3.9.6-eclipse-temurin-21-jammy AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

# Stage 2: Create the final Docker image
FROM amazoncorretto:21-alpine-full
WORKDIR /app

# Install wget
RUN apk update && \
    apk add --no-cache wget && \
    rm -rf /var/lib/apt/lists/*

# Install Dockerize
ENV DOCKERIZE_VERSION v0.6.1
RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && rm dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz

COPY --from=build /app/target/*.jar ToDoList-1.0.0.jar
ENTRYPOINT ["dockerize", "-wait", "tcp://mysql:3306", "-timeout", "100s", "java", "-jar", "ToDoList-1.0.0.jar"]