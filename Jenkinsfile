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
    }

    post {
        failure {
            echo 'Build failed.'
        }
        success {
            // Restart Nginx to update connections
            sh 'docker exec webserver nginx -s reload'
            echo 'Build succeeded!'
        }
    }
}