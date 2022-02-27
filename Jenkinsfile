pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/tuser6794/eStoreBackend.git'

                // Run Maven Wrapper Commands
                sh "./mvnw compile"

                echo 'Building the Project with maven compile'
            }
        }

        stage('Test') {
            steps {

                // Run Maven Wrapper Commands
                sh "./mvnw test"

                echo 'Testing the Project with maven test'
            }
        }

        stage('Package') {
            steps {

                // Run Maven Wrapper Commands
                sh "./mvnw package"

                echo 'Packaging the Project with maven package'
            }
        }
   
        stage('Containerize') {
            steps {

                // Run Docker Build Command
                sh "docker build -t eStoreBackend ."

                echo 'Containerizing the App with Docker'
            }
        }
        
        stage('Deploy') {
            steps {

                // Run docker run command with detached mode
                sh "docker run -d -p 9090:9090 eStoreBackend"

                echo 'Deploy the App with Docker'
            }
        }
  
    }
}