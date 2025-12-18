pipeline {
    agent label 'pelado'

    tools{
        ansible 'ansible'
    }

    stages{
        stage('Ansible Version'){
            steps{
                sh 'ansible --version'
            }
        }
    }
}