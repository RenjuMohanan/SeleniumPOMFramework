node {
	stage ('SCM checkout'){
		git "https://gitlab.com/mbabilo/experitest"
		}
	stage ('Build'){
    	dir("SeleniumPOM") {
	   sh "mvn clean install"
       }
       	dir("SeleniumPOM/target") {
	   sh "java -jar com.test-1.0-SNAPSHOT.jar"
       }
		}
}
