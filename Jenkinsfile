pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'docker build -t to-do-image .'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Deploy') {
            steps {
                sh 'docker-compose up -d'
            }
        }
    }
}