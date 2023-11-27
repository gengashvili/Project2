pipeline {
  agent any
  stages {
    stage('run project') {
      parallel {
        stage('run project') {
          steps {
            sh '''stage(\'Run Maven Project\') {
    steps {
        script {
            sh \'/path/to/your/script_run_maven_project.sh\'
        }
    }
}'''
            }
          }

          stage('check maven version') {
            steps {
              sh '''stage(\'Get Maven Version\') {
    steps {
        script {
            sh \'/path/to/your/script_get_maven_version.sh\'
        }
    }
}
'''
              }
            }

          }
        }

      }
    }