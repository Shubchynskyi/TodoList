FROM openjdk:21-jdk-alpine
MAINTAINER d.shubchynskyi@gmail.com

ENV DOCKERIZE_VERSION v0.6.1
RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && rm dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz

COPY target/ToDoList-1.0.0.jar ToDoList-1.0.0.jar

ENTRYPOINT ["dockerize", "-wait", "tcp://mysql:3306", "-timeout", "60s", "java", "-jar", "/ToDoList-1.0.0.jar"]
