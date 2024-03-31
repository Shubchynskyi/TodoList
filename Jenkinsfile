pipeline {
    agent any
    tools {
        maven "M3"
    }
    stages {
        stage('Preparation') {
            steps {
                git 'https://github.com/Shubchynskyi/TodoList'
            }
        }
        stage('Build') {
            steps {
                withMaven(maven: 'M3') {
                    sh 'mvn clean package'
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t to-do-image .'
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker-compose up -d'
            }
        }
    }
}
