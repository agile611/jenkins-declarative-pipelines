// Mejor instalar Ansible en el nodo Jenkins 
// Si se quiere usar el plugin de Ansible para Jenkins se tiene que buscar el Zip de Instalación y luego instalarlo en el nodo Jenkins  
// NOTA IMPORTANTE: Hace falta tener python para que la tool de Ansible funcione correctamente
pipeline {
    agent {
            label 'pelado' // Nodo donde está instalado Ansible
    }

    tools {
        ansible 'ansible' // Nombre de la instalación de Ansible en Jenkins
    }

     environment {
        PYTHON = 'python3' // Definir versión de Python
    }

    stages{
        stage('Git Clone'){
            steps{
                git branch: 'main', url: 'https://github.com/agile611/ansible-ci-example.git' // Clonar repositorio con Playbooks de Ansible
            }
        }

        stage('Install ansible'){
            steps{
                sh '${PYTHON} -m venv venv' // Crear entorno virtual
                sh '. venv/bin/activate && ${PYTHON} -m pip install --upgrade pip'
                sh '. venv/bin/activate && pip install ansible ansible-lint'
            }
        }

        stage('Ansible Version'){
            steps{
                sh '. venv/bin/activate && ansible --version'
            }
        }

        stage('Pasar Ansible Lint en nuestros Playbooks'){
            steps{
                sh '. venv/bin/activate && ansible-lint playbooks/'
            }
        }


        stage('Pasar Ansible Lint en nuestros Playbooks'){
            steps{
                sh '. venv/bin/activate && ansible-lint playbooks/'
            }
        }
        
        stage('Pasar Ansible Lint en nuestros Playbooks'){
            steps{
                sh '. venv/bin/activate && ansible-playbook playbooks/site.yml -i localhost'
            }
        }
    }
}