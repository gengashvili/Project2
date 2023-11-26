pipeline {
    agent any

    stages {
        stage('Build and Test') {
            parallel {
                stage('Run Selenium Tests') {
                    steps {
                        script {
                            sh 'mvn clean test'
                        }
                    }
                    post {
                        always {
                            junit 'target/surefire-reports/**/*.xml'
                        }
                        success {
                            allure([
                                includeProperties: false,
                                jdk: '',
                                properties: [],
                                reportBuildPolicy: 'ALWAYS',
                                results: [[path: 'target/allure-results']]
                            ])
                        }
                    }
                }
                stage('Get Maven Version') {
                    steps {
                        script {
                            sh 'mvn -v'
                        }
                    }
                }
            }
        }
    }
}
