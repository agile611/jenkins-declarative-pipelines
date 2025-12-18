pipeline {
    tools{
        ansible 'ansible'
    }
    agent any
    stages{
        stage('Ansible Version'){
            steps{
                sh 'ansible --version'
            }
        }
    }
}