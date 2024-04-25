pipeline{
  agent any 
  stages{
    stage("build"){
		when{
			expression{
				BRANCH_NAME == 'main'
			}
		}
        steps{
            echo 'building the app'
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
