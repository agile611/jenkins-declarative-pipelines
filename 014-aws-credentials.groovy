pipeline{
    agent any
    environment {
        AWS_ACCESS_KEY_ID = credentials('AWS_KEY')
    }

    stages {
        stage('Show AWS Credentials') {
            steps {
                sh 'echo "AWS Access Key ID: $AWS_ACCESS_KEY_ID"'
            }
        }
    }
}