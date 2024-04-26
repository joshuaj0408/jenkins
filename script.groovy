def buildApp(){
	echo "Building the application"
	echo "VERSION: ${NEW_VERSION}"
}

def testApp(){
	echo "Testing the application"
}

def DeployApp(){
	echo "Deploying the application"
	echo "Deploying VERSION ${VERSION}"
}


return this
