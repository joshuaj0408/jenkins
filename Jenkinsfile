pipeline{
 
 agent any 
  
  environment{
	NEW_VERSION = '1.3.0'
	SERVER_CREDENTIALS = credentials('dummy')
  }
  
  tools{
	maven 'Maven'
  }
  
  stages{
    stage("build"){
		when{
			expression{
				BRANCH_NAME == 'main'
			}
		}
        steps{
            echo 'building the app'
			echo "building version ${NEW_VERSION}"
			echo 'building version ${NEW_VERSION}'
			sh "mvn install"
          }
    }
	
    stage("test"){
		when{
			expression{
				BRANCH_NAME == 'dev'
			}
		}
        steps{
            echo 'testing the app'
        }
    }
	
    stage("deploy"){
        steps{
            echo 'deploying the app'
			echo "Deploying with ${SERVER_CREDENTIALS}"
        }
    }
  }
  
  post{
    always {
      echo 'Post Always'
    }
	
    success{
      echo 'Post Success'
    }
	
	failure{
	  echo 'Post failure'
	}
  }
}
