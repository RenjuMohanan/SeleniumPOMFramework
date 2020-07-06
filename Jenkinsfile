node {
	stage ('SCM checkout'){
		git "https://github.com/RenjuMohanan/SeleniumPOMFramework"
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
