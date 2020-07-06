node {
	stage ('SCM checkout'){
		git "https://github.com/RenjuMohanan/SeleniumPOMFramework"
		}
	stage ('Build'){
    	dir("SeleniumPOM") {
	   bat "mvn clean install"
       }
       	dir("SeleniumPOM/target") {
	   bat "java -jar com.test-1.0-SNAPSHOT.jar"
       }
		}
}
