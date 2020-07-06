node {
	stage ('SCM checkout'){
		git "https://github.com/RenjuMohanan/SeleniumPOMFramework"
		}
	stage ('Build'){
    	dir("SeleniumPOM") {
	   bat "mvn clean install"
       }
       	dir("SeleniumPOM/target") {
	   bat "java -jar Test-0.0.1-SNAPSHOT.jar"
       }
		}
}
