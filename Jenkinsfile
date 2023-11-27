pipeline {
  agent any
  
  stages {
    
    stage('Checkout') {
      steps {
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], userRemoteConfigs: [[url: 'https://github.com/gengashvili/Project2']]])
      }
    }
    
    stage('Build and Version') {
      
      parallel {
        stage('Build Project') {
          steps {
            script {
              bat 'mvn clean test'
            }

          }
        }

        stage('Get Maven Version') {
          steps {
            script {
              bat 'mvn --version'
            }
          }
        }

      }
    }

  }
}
