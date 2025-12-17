pipeline {
    agent none
    stages {
        stage('Setup') {
            steps {
                echo 'Setting up the environment...'
            }
        }
        stage('Parallel Stages') {
            parallel {
                stage('Stage 1') {
                    steps {
                        echo 'Executing Stage 1'
                    }
                }
                stage('Stage 2') {
                    steps {
                        echo 'Executing Stage 2'
                    }
                }
                stage('Stage 3') {
                    steps {
                        echo 'Executing Stage 3'
                    }
                }
            }
        }
        stage('Teardown') {
            steps {
                echo 'Cleaning up the environment...'
            }
        }
    }
}
