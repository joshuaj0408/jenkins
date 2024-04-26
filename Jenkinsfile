def gv
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
	booleanParam(name: 'executeTests', defaultValue: true, description:'')
  }
  
  stages{
  	stage("init"){
        	steps{
		       script{
			 gv = load "script.groovy"
			}
        	}	
    	}
	
	stage("build"){
		when{
			expression{
				BRANCH_NAME == 'main' && params.executeTests
			}
		}
        	steps{
           		 script{
			gv.buildApp()
			}
          	}
    	}
	
    stage("test"){
		when{
			expression{
				BRANCH_NAME == 'dev'
			}
		}
        steps{
            gv.testApp()
        }
    }
	
    stage("deploy"){
        steps{
			script{
			gv.deployApp()
			}
			//echo "Deploying with ${SERVER_CREDENTIALS}"
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
