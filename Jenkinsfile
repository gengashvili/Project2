pipeline {
  agent any
  tools {
    maven 'mvn'
  }
  stages {
    stage('Checkout to master Branch') {
      steps {
        script {
          checkout([$class: 'GitSCM', branches: [[name: '*/master']], userRemoteConfigs: [[url: 'https://github.com/gengashvili/Project2']]])
        }
      }
    }
    stage('Run Maven Project') {
      parallel {
        stage('Run Maven Tests') {
          steps {
            script {
              sh 'mvn clean test'
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
