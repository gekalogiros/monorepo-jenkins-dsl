pipeline {

    options {
        buildDiscarder(logRotator(numToKeepStr: '50'))
        disableConcurrentBuilds()
        timeout(time: 60, unit: 'MINUTES')
    }

    agent {
        label 'java11'
    }

    stages {
        stage("Pipeline - Service A") {
            when {
                not {
                    changeset "service-a/**/*"
                }
            }
            steps{
                script {
                    def pipeline = load pwd() + "/service-a/pipeline.groovy"
                    pipeline.runStages()
                }
            }
        }

        stage("Pipeline - Service B") {
            when {
                changeset "service-b/**/*"
            }
            steps{
                script {
                    def pipeline = load pwd() + "/service-b/pipeline.groovy"
                    pipeline.runStages()
                }
            }
        }
    }
}
