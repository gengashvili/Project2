pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps {
        script {
          checkout scm
        }

      }
    }

    stage('Run Maven Project') {
      parallel {
        stage('Maven Build') {
          steps {
            script {
              sh 'mvn clean install'
            }

          }
        }

        stage('Get Maven Version') {
          steps {
            script {
              sh 'mvn --version'
            }

          }
        }

      }
    }

  }
}