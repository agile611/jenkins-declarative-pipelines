pipeline {
    tools{
        ansible 'ansible'
    }
    agent label 'pelado'
    stages{
        stage('Ansible Version'){
            steps{
                sh 'ansible --version'
            }
        }
    }
}