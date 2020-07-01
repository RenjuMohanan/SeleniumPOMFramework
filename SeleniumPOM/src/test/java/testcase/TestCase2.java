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

public class TestCase2 extends TestBase {

	 HomePage homePage;
	 SearchResultPage searchResultPage;
	 TestUtil testUtil;
	 
	 @BeforeMethod
	 public void beforeTest() {
		 
		  log = Logger.getLogger("TestCase2");
		  testreport = report.startTest("TestCase2");
		  homePage = new HomePage();
		  searchResultPage = new SearchResultPage();
		  testUtil = new TestUtil();
	 }
	 
	 @Test
	 public void test2Method() throws IOException {
		 log.info("Test2 log");
		 homePage.clearGoogleSerach();
		 homePage.enterGoogleSerach("CUCUMBER");
		 
		 testreport.log(LogStatus.PASS, "Test2 report");
		 testreport.log(LogStatus.PASS, "Snapshot2: "+testreport.addScreenCapture(testUtil.takeScreenshot(driver)));
	 }
	 
	 @AfterMethod
	 public void afterMethod() {
		 report.endTest(testreport);
	 }
}
