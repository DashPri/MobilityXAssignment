package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementHelper {
	
	private static WebDriverWait wait;
	private WebDriver driver;

	
	public ElementHelper(WebDriver driver) {
		this.driver = driver;
	}
	
	public static void waitForElementVisibility(By locator) {
		wait = new WebDriverWait(DriverFactory.getDriver(), 20L);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void waitForElementVisibility(WebElement element) {
		wait = new WebDriverWait(DriverFactory.getDriver(), 20L);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitForElementInvisibility(By locator) {
		wait = new WebDriverWait(DriverFactory.getDriver(), 20L);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	
	public boolean isElementPresent(By locatorKey) {
	    try {
	        driver.findElement(locatorKey);
	        return true;
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}
	
	public  void switchFrame(By locator) {
		driver.switchTo().frame(driver.findElement(locator));
	}
	
	public  void switchFrame(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void selectRadioButton(By locator) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(locator));
	}
	
	public static void waitForIframeToLoad(By locator) {
		wait = new WebDriverWait(DriverFactory.getDriver(), 5000L);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	
	public void waitForFrameToLoad(WebElement element) {
		wait = new WebDriverWait(DriverFactory.getDriver(), 5);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		
	}
	
	public void selectByVisibeText(By locator, String label) {
		Select select = new Select(driver.findElement(locator));
		select.selectByVisibleText(label);
	}
	
	public void selectByVisibeText(WebElement element, String label) {
		Select select = new Select(element);
		select.selectByVisibleText(label);
	}
	
	public void check(WebElement element) {
		
		if(!element.isSelected()) {
			element.click();
		}	
	}
}
