// Mejor instalar Ansible en el nodo Jenkins 
// Si se quiere usar el plugin de Ansible para Jenkins se tiene que buscar el Zip de Instalación y luego instalarlo en el nodo Jenkins  
// NOTA IMPORTANTE: Hace falta crear un environment de python para que la tool de Ansible funcione correctamente
pipeline {
    agent {
            label 'pelado' // Nodo donde está instalado Ansible
    }

    tools {
        ansible 'ansible' // Nombre de la instalación de Ansible en Jenkins
    }

    stages{
        stage('Git Clone'){
            steps{
                git url: 'https://github.com/agile611/ansible-ci-example.git'
            }
        }

        stage('Install ansible'){
            steps{
                sh 'python -m pip install --upgrade pip'
                sh 'pip install ansible ansible-lint'
            }
        }

        stage('Ansible Version'){
            steps{
                sh 'ansible --version'
            }
        }
    }
}