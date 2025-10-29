def call(String Project, String ImageTag, String DockerHubUser) {
    withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'dockerhubpass', usernameVariable: 'dockerhubuser')]) {
        sh """
            echo $dockerhubpass | docker login -u $dockerhubuser --password-stdin
            docker push ${DockerHubUser}/${Project}:${ImageTag}
        """
    }
    echo "Docker image pushed successfully: ${DockerHubUser}/${Project}:${ImageTag}"
}
