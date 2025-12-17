pipeline{
    agent any
    environment {
        AWS_ACCESS_KEY_ID     = credentials('aws-access-key-id')
        AWS_SECRET_ACCESS_KEY = credentials('aws-secret-access-key')
        withCredentials([[
            $class: 'AmazonWebServicesCredentialsBinding',
            credentialsId: 'AWS_KEY' //ID en el que se almacenan las credenciales en Jenkins con el nombre que hemos puesto
        ]]) 
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