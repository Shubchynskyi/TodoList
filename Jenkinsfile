pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Fetch the source code from the repository
                checkout scm
            }
        }

        stage('Build and Run') {
            steps {
                script {
                    // Start Docker containers using docker-compose
                    sh "docker-compose up --build -d"
                }
            }
        }

        stage('Restart Nginx') {
            steps {
                script {
                    // Restart Nginx to update connections
                    sh 'docker exec webserver nginx -s reload'
                }
            }
        }
    }

    post {
            success {
                // Actions upon successful build
                echo 'Build was successful!'
            }

            failure {
                // Actions upon failed build
                echo 'Build failed'
            }
    }
}