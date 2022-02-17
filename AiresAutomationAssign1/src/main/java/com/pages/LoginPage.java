package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.utils.ElementHelper;

public class LoginPage {
	
	private WebDriver driver;

	// Object Repositories: By Locators
	private By userName = By.id("username::content");
	private By nextButton = By.id("nextButton");
	private By password = By.id("password::content");
	private By loginButton = By.id("loginButton");
	private By signInSection = By.xpath("//*[contains(text(),'Sign in')]");


	// 2. Constructor of the Login page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTitle() {
		return driver.getTitle();
		
	}
	
	public void setUsername(String uName) {
		driver.findElement(userName).sendKeys(uName);
	}

	public void clickNext() {
		driver.findElement(nextButton).click();
	}
	
	public boolean validatePasswordTextFieldPresent() {
		try {
			boolean ispwdPresent = driver.findElement(password).isDisplayed();
			return ispwdPresent;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public void setPassword(String pwd) {
		ElementHelper.waitForElementVisibility(password);
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickLogin() {
		driver.findElement(loginButton).click();
	}
	
	public boolean isUserNavigatedtoLoginPage() {
		ElementHelper.waitForElementVisibility(signInSection);
		return driver.findElement(signInSection).isDisplayed();
	}
}
