pipeline{
    agent any
    environment {
        withCredentials([aws(accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: 'AWS_KEY', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY')]) {
    // some block
        }
    }

    stages {
        stage('Show AWS Credentials') {
            steps {
                sh 'echo "AWS Access Key ID: $AWS_ACCESS_KEY_ID"'
                sh 'echo "AWS Secret Access Key: $AWS_SECRET_ACCESS_KEY"'
            }
        }
    }
}