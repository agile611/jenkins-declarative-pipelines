pipeline{
    agent any
    stages{
        stage('Checkout codigo'){
            steps{
                git branch: 'main', url: 'https://github.com/agile611/terraform-local-deploy.git'
            }
        }
        stage('Init Terraform'){
            steps{
                //Inicializa y descarga los proveedores necesarios, en este caso LOCAL
                sh 'terraform init'                
            }
        }
    }
}