pipeline {

    agent any

    stages {

        stage('Checkout') {
            steps {
                echo 'Checking out source code...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Building the application...'
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                echo 'Building Docker image...'
                sh 'docker build -t basic-cicd-app:latest .'
            }
        }

        stage('Deploy') {
            steps {

                echo 'Stopping old container...'

                sh '''
                    docker stop basic-cicd-container || true
                '''

                echo 'Removing old container...'

                sh '''
                    docker rm basic-cicd-container || true
                '''

                echo 'Starting new container...'

                sh '''
                    docker run -d \
                    --name basic-cicd-container \
                    -p 8081:8081 \
                    basic-cicd-app:latest
                '''
            }
        }
    }

    post {

        success {
            echo 'CI/CD Pipeline completed successfully!'
        }

        failure {
            echo 'CI/CD Pipeline failed.'
        }
    }
}
