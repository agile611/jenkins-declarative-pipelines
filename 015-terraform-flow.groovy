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
        stage('Apply Terraform'){
            steps{
                //Genera el plan y lo guarda en un archivo binario 'tfplan'
                // -out es vital para guardar el plan en un archivo
                sh 'terraform plan -out=tfplan'

                //Opcional: Mostrar el plan en texto para que el usuario vea los cambios que se van a aplicar
                sh 'terraform show -no-color tfplan'
            }   
        }   
    }
}