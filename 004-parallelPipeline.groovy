pipeline {
    agent none
    stages {
            stage("Primer") {
                steps {
                    parallel(
                            first: {
                                    echo "First branch"
                                },
                            second: {
                                    echo "Second branch"
                                }
                            )
                }
            }
            stage("Second") {
                steps {
                    parallel(
                            first: {
                                    echo "First branch"
                                },
                            second: {
                                    echo "Second branch"
                                }
                            third: {
                                    echo "Third branch"
                                },
                            fourth: {
                                    echo "Fourth branch"
                                }
                            )
                    }
                }
        }
}
