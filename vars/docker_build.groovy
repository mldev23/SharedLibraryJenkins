def call(String ProjectName,String Imagtag,String DockerHubUser){
  sh "docker build -t ${DockerHubUser}/${ProjectName}:${Imagetag} ."
  echo "Build Successfull"
}
