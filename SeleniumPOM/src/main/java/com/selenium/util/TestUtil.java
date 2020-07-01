package com.selenium.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import com.selenium.base.TestBase;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil extends TestBase{
	
	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")
          + "/src/main/java/com/selenium/testdata/testdata.txt";
	static Workbook book;
	static Sheet sheet;
	
	public String takeScreenshot(WebDriver driver) throws IOException
	{
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"\\Screenshots\\"+System.currentTimeMillis()+".png";
		FileUtils.copyFile(srcFile, new File(dest));
		return dest;
	}
	
	@DataProvider(name = "TestData")
	public static Object[][] getTestData(String sheetName){
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch(InvalidFormatException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i = 0; i< sheet.getLastRowNum();i++) {
			for(int k = 0; k< sheet.getRow(0).getLastCellNum();k++) {
			   data[i][k] = sheet.getRow(i+1).getCell(k).toString();	
			}
		}
		return data;
	}
	
}
