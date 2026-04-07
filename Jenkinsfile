pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Bhushanmore25/login_using_ExcelData_Jenkins.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Report') {
            steps {
                publishHTML([
                    reportDir: 'target',
                    reportFiles: 'index.html',
                    reportName: 'Extent Report'
                ])
            }
        }
    }
}