package testcase;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.base.TestBase;
import com.selenium.pages.HomePage;
import com.selenium.pages.SearchResultPage;
import com.selenium.util.TestUtil;

public class TestCase1 extends TestBase {

	 HomePage homePage;
	 SearchResultPage searchResultPage;
	 TestUtil testUtil;
	 
	 @BeforeMethod
	 public void beforeTest() {
		 
		  log = Logger.getLogger("TestCase1");
		  testreport = report.startTest("TestCase1");
		  homePage = new HomePage();
		  searchResultPage = new SearchResultPage();
		  testUtil = new TestUtil();
	 }
	 
	 @Test
	 public void test1Method() throws IOException {
		 log.info("Test1 log");
		 Boolean googleLogo = homePage.validateGoogleLogo();
		 if(googleLogo) {
			 testreport.log(LogStatus.PASS, "Google Logo Validated");
			 log.info("Google Logo validation");
		 }
		 homePage.validateHomePageTitle();
		 if(homePage.validateHomePageTitle().equals("Google")) {
			 testreport.log(LogStatus.PASS, "Google Title Validated");
			 log.info("Home Page Title validation");
		 }
		 
		 testreport.log(LogStatus.PASS, "Test1 report");
		 testreport.log(LogStatus.PASS, "Snapshot1: "+testreport.addScreenCapture(testUtil.takeScreenshot(driver)));
	 }
	 
	 @AfterMethod
	 public void afterMethod() {
		 report.endTest(testreport);
	 }
	
}
