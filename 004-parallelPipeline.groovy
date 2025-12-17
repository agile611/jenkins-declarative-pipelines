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
        stage('Parallel Verification') {
            parallel {
                stage('Verify Stage 1') {
                    steps {
                        echo 'Verifying Stage 1'
                    }
                }
                stage('Verify Stage 2') {
                    steps {
                        echo 'Verifying Stage 2'
                    }
                }
                stage('Verify Stage 3') {
                    steps {
                        echo 'Verifying Stage 3'
                    }
                }
                stage('Verify Stage 4') {
                    steps {
                        echo 'Verifying Stage 4'
                    }
                }
                stage('Verify Stage 5') {
                    steps {
                        echo 'Verifying Stage 5'
                    }
                }
                stage('Verify Stage 6') {
                    steps {
                        echo 'Verifying Stage 6'
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
