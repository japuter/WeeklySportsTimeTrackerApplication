pipeline {
    agent any

    environment {
        DOCKER_HUB_CREDENTIALS = credentials('japuter') // Use your Docker Hub credential ID
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from GitHub from the master branch
                git branch: 'master', credentialsId: '46a2d923-b2a1-4814-a043-34e8f6307adc', url: 'https://github.com/japuter/WeeklySportsTimeTrackerApplication'
            }
        }

        stage('Build') {
            steps {
                // Use bat for Windows-based systems to run Maven or Gradle
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                // Use bat for running tests in Windows
                bat 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build Docker image using Dockerfile
                    docker.build("japuter/sports-time-tracker:latest")
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'DOCKER_HUB_CREDENTIALS') {
                        docker.image('japuter/sports-time-tracker:latest').push('latest') // Replace with your Docker Hub repository
                    }
                }
            }
        }
    }

    post {
        always {
            // Clean up workspace after build without a node block
            cleanWs()
        }
    }
}
