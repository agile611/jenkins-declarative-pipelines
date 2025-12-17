pipeline {
    agent any
    tools {
        maven "maven_363"
    }
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/jglick/simple-maven-project-with-tests.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }
        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }
    }
    post {
        success {
            archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            //emailext (
            //        subject: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
            //        body: """SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]': Check console output at ${env.BUILD_URL}""",
            //        to: 'guillem@gromenaware.com'
            //)

        }
        //failure {
            //emailext (
            //        subject: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
            //        body: """FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]': Check console output at ${env.BUILD_URL}""",
            //        to: 'guillem@gromenaware.com'
            //)
        //}
        always{
            junit '**/target/surefire-reports/TEST-*.xml'
            // publish html
            publishHTML target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: 'target/surefire-reports/',
                    reportFiles: 'emailable-report.html',
                    reportName: 'Emailable Report'
            ]
        }
    }
}