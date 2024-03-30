pipeline {
    agent any
    tools {
        maven "M3"
        jdk "JDK_21"
    }
    stages {
        stage('Preparation') {
            steps {
                git 'https://github.com/Shubchynskyi/TodoList'
            }
        }
        stage('Build') {
            steps {
                withMaven {
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
