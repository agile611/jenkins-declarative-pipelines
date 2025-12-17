pipeline {
    agent any
    tools {
        maven "maven_363"
        nodejs "nodejs"
    }
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/agile611/ionic-example-app.git'
            }
        }
        stage('Clean') {
            steps {
                sh 'killall node'
            }
        }
        stage('Build') {
            steps {
                sh 'npm install -g cordova'
                sh 'npm install -g ios-sim'
                sh 'npm install -g ios-deploy'
                sh 'npm config set prefix /usr/local'
                sh 'npm root -g'
                sh '/usr/local/lib/node_modules/ionic/bin/ionic serve --nobrowser &'
            }
        }
        stage('Test') {
            steps {
                echo 'Tests here'
                sh 'sleep 2m'
            }
        }
    }
}