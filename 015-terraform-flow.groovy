pipeline{
    agent any
    
    options{
        timeout(time: 1, unit: 'MINUTES') //Limita la ejecución del pipeline a 1 minuto
    }
    
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
        stage('Aprobación manual'){
            steps{
                //Pausa la ejecución hasta que un usuario apruebe manualmente
                input message: '¿Aprobar la aplicación de los cambios de Terraform?', ok: 'Sí, desplegar'
            }
        }
        stage('Desplegar con Terraform'){
            steps{
                //Aplica los cambios según el plan guardado en 'tfplan'
                sh 'terraform apply -auto-approve tfplan'
            }
        }
        stage('Verificar despliegue'){
            steps{
                //Verifica el estado actual de los recursos gestionados por Terraform
                sh 'terraform show'
                sh 'ls -l mensaje.txt'
                sh 'cat mensaje.txt'
            }
        }
        stage('Destroy Terraform'){
            steps{
                //Destruye los recursos creados por Terraform
                sh 'terraform destroy -auto-approve'
            }
        }   
    }
}