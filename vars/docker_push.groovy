def call(String Project,String ImageTag,String DockerHubUser){
  withCredentials([usernamePassword(credentialsId:'dockerHubCred',passwordVariable:'dockerhubpass',usernameVariable:'dockerhubuser')]){
  sh "docker login -u ${env.dockerhubuser} -p ${env.dockerhubpass}"
  }
  sh "docker push ${env.dockerhubuser}/${Project}:${ImageTag}"
  
}
