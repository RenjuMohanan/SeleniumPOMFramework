package com.selenium.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {

   public static WebDriver driver;
   public static Properties  prop;
   public static Logger log;
   public static ExtentReports report;
   public static ExtentTest testreport;
	
	@BeforeSuite
	public static void setUp()
	{
		try 
		{
			log = Logger.getLogger("TestBase");
			PropertyConfigurator.configure("log4j.properties");
			report = new ExtentReports(System.getProperty("user.dir")+"/ExtentReportResults.html", true);
		    prop = new Properties();
		    FileInputStream is = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/selenium/config/config.properties");
		    prop.load(is);    
		    String browser = prop.getProperty("browser"); 
		   if(browser.equals("chrome")) 
		   {
			  System.setProperty("webdriver.chrome.driver", "C:\\Users\\renju\\Desktop\\Automation\\Drivers\\chromedriver_win32\\chromedriver.exe");
			  driver = new ChromeDriver();
			   
		   }
		   else if(browser.equals("FF")) {
			   System.setProperty("webdriver.chrome.driver", "C:\\Users\\renju\\Desktop\\Automation\\Drivers\\IEDriverServer_x64\\geckodriver.exe");
			   driver = new FirefoxDriver();
		   }
		    driver.manage().window().maximize();
		    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		    driver.get(prop.getProperty("url"));
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
