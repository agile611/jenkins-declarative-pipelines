pipeline {
    tools{
        ansible 'ansible'
    }
    agent pelado
    stages{
        stage('Ansible Version'){
            steps{
                sh 'ansible --version'
            }
        }
    }
}