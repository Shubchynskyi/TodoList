FROM openjdk:17-jdk-alpine
MAINTAINER d.shubchynskyi@gmail.com
COPY target/TodoList-0.0.1-SNAPSHOT.jar TodoList-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","TodoList-0.0.1-SNAPSHOT.jar"]