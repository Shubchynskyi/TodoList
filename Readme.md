# ToDo List Web Application

A web application for managing a ToDo list.

Developed as part of an educational project at [Javarush University](https://javarush.com/university).

## Features Implemented

- **Task Management**: Create, edit, and manage tasks in a structured ToDo list format.
- **Integration with Docker Compose**: Simplified deployment using Docker Compose for easy setup and management.

## Technologies Used

- **Backend**: Java with Spring Boot, Spring Data JPA, Liquibase for database migrations.
- **Frontend**: Thymeleaf for dynamic rendering of pages, combined with HTML and Bootstrap for responsive design.
- **Deployment**: The application is packaged and deployed using Docker and Docker Compose, managed by a Jenkins CI/CD pipeline.

## How to Start

1. **Ensure Docker is Running**: Make sure Docker is installed and running on your machine.
2. **Launch the Application**:
   - Run the setup using Docker Compose:
     ```bash
     docker-compose -f docker-compose-local.yaml up -d
     ```
   - [Link to docker-compose-local.yaml](./docker-compose-local.yaml)

## CI/CD Pipeline

- **Jenkins Pipeline**: Jenkins is used for automated building and deployment of the application within Docker.

### Live Version

Explore the live version of the project: [ToDo List Application](https://todo-list.shubchynskyi.pp.ua/)
