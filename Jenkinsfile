pipeline {
    agent any

    stages {
        stage('Build') {
            agent {
                docker {
                    // Используем образ Maven с поддержкой Java 21 для сборки проекта
                    image 'maven:3.9.6-eclipse-temurin-21'
                    args '-v /var/run/docker.sock:/var/run/docker.sock'
                }
            }
            steps {
                // Копируем исходный код в рабочий каталог в контейнере и выполняем сборку
                sh 'cp -r * /usr/src/app'
                sh 'cd /usr/src/app && mvn clean package -DskipTests'
            }
        }
        stage('Build Docker Image') {
            steps {
                // Собираем Docker образ приложения
                sh 'docker build -t to-do-image .'
            }
        }
        stage('Deploy') {
            steps {
                // Запускаем приложение и зависимости через docker-compose
                sh 'docker-compose up -d'
            }
        }
    }
    post {
            success {
                // Действия, которые должны выполняться после успешной сборки
            }
            failure {
                // Очистка после сборки
                sh 'docker-compose down'
            }
        }
}