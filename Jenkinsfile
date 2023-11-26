pipeline {
  agent any
  stages {
    stage('run maven project') {
      parallel {
        stage('run maven project') {
          steps {
            build 'job'
          }
        }

        stage('get maven version') {
          steps {
            sh 'mvn --version'
          }
        }

      }
    }

  }
}