package com.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//*[@id='tsf']/div[2]/div[1]/div[1]/div/div[2]/input")
	WebElement searchText;
	
	@FindBy(name = "btnk")
	WebElement  searchButton;

	@FindBy(xpath = "//*[@id='hplogo']")
	WebElement googleLogo;
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		
		return driver.getTitle();
	}
	
	public boolean validateGoogleLogo() {
		
		return googleLogo.isDisplayed();
	}
	
	public void enterGoogleSerach(String text) {
		searchText.sendKeys(text);
	}
	
	public void clearGoogleSerach() {
		searchText.clear();
	}
	public SearchResultPage clickOnSerachButton() {
		searchText.click();
		return new SearchResultPage();
	}
	
}
