package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.DriverFactory;
import com.utils.ElementHelper;

public class HomePage {
	
	private WebDriver driver;

	// Object Repositories: By Locators
	private By userProfileName = By.cssSelector("span[id$='openUserProfileText");	
	private By logout = By.xpath("//span[@id='dcmjhhr:logout::text']/div");
	private By okCookieButton = By.id("cookiePupupButtonId");
	private By createAnAuthButton = By.id("creatAuthForm");
	private By initiationSuccessMessage = By.xpath("//div[@id='growls']//div[@class='growl-message']");
	private By addExpenseButton = By.xpath("//span[@class='AddExpenseLinkTextFont'][contains(string(),'add')]/parent::div");
	
	private ElementHelper elementHelper = new ElementHelper(DriverFactory.getDriver());
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public boolean isUserNavigatedtoHomePage() {

		try {
			ElementHelper.waitForElementVisibility(okCookieButton);
			driver.findElement(okCookieButton).click();
			ElementHelper.waitForElementInvisibility(okCookieButton);
		} catch (Exception e) {
		}
		return elementHelper.isElementPresent(userProfileName);

	}
	
	public void clickOnLogout() {
		ElementHelper.waitForElementVisibility(userProfileName);
		driver.findElement(userProfileName).click();
		ElementHelper.waitForElementVisibility(logout);
		driver.findElement(logout).click();
	}
	
	public String getProfileName() {
		ElementHelper.waitForElementVisibility(userProfileName);
		return driver.findElement(userProfileName).getText();	
	}
	
	public boolean isCreateAuthButtonVisible() {
		return elementHelper.isElementPresent(createAnAuthButton);
	}
	
	public void clickOnAuthorization() {
		driver.findElement(createAnAuthButton).click();	
	}
	
	public boolean isSubmissionSuccessMessageDisplayed() {
		ElementHelper.waitForElementVisibility(initiationSuccessMessage);
		return elementHelper.isElementPresent(initiationSuccessMessage);
	}
	
	public String getSubmissionSuccessMessage() {
		ElementHelper.waitForElementVisibility(initiationSuccessMessage);
		return driver.findElement(initiationSuccessMessage).getText();
	}
	
	public void clickAddExpense() {		
		ElementHelper.waitForElementVisibility(addExpenseButton);
		driver.findElement(addExpenseButton).click();
	}
	

	
}
