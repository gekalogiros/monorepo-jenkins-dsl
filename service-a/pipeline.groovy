def runStages() {

    stage('Build, Unit tests & Quality gates') {

        parallel (
                'Build': {
                    sh "Building..."
                },
                'Build Documentation': {
                    sh "Building Documentation..."
                }
        )
    }


}
return this;
