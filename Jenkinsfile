pipeline{
 
 agent any 
  
  environment{
	NEW_VERSION = '1.3.0'
	SERVER_CREDENTIALS = credentials('dummy')
  }
  
  tools{
	maven 'Maven'
  }
  
  parameters{
	//string(name: 'VERSION', defaultValue: '', description: 'version to deploy on prod')
	choice(name: 'VERSION', choices: ['1.1.0','1.2.0','1.3.0'], description: '')
	booleanParam(name: 'executeTests', defaultValue: false, description:'')
  }
  
  stages{
    stage("build"){
		when{
			expression{
				BRANCH_NAME == 'main' && params.executeTests
			}
		}
        steps{
            echo 'building the app'
			echo "building version ${NEW_VERSION}"
			echo 'building version ${NEW_VERSION}'
			bat 'mvn -v'
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
			echo "Deploying with ${params.VERSION}"
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
