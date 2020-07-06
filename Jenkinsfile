node {
	stage ('SCM checkout'){
		git "https://github.com/RenjuMohanan/SeleniumPOMFramework"
		              }
	stage ('Build'){
    	dir("SeleniumPOM") {
	   bat "mvn clean install"
                           }
		        }
}
