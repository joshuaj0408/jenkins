pipeline{
  agent any 
  stages{
    stage("build"){
		when{
			expression{
				branch '*/main'
			}
		}
        steps{
            echo 'building the app'
          }
    }
    stage("test"){
		when{
			expression{
				branch '*/dev'
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
  /*post{
    always {
      //
    }
    success{
      
    }
  }*/
}
