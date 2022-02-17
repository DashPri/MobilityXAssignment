package com.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.AppConstants;
import com.utils.DriverFactory;
import com.utils.ElementHelper;

public class CreateAuthPage {
	
	private WebDriver driver;

	// Object Repositories: By Locators
	
	private By iframePresent =By.xpath("//div[@class=\"af_inlineFrame \"]/iframe");
	private By createNewAuthorizationText = By.xpath("//span[contains(string(),'Create a new authorization')]");
	private By manuallyInputButton = By.xpath(
			"//label[contains(text(),'Manually input employee information')]/preceding-sibling::input[@type='radio']");
	private By firstName = By.id("fname::content");
	private By lastName = By.id("lname::content");
	private By createAuthContinueButton = By
			.xpath("//span[contains(text(),'Continue')]/parent::a[@class='af_button_link']");
	private By newTransferAssignment = By.xpath("//span[contains(text(),'A new transfer or assignment')]");
	private By preacceptanceInitiation_RadioButton = By.id("aRegion:0:authorizationType101::content");
	private By employeeInfoFillPage= By.xpath("//label[contains(text(),'Employee Information')]");
	private By relocationPolicySelection = By.xpath("//*[@title='Relocation Policy*']");
	private By originCity_section = By.id("aRegion:0:originCity::content");
	private By originState_section = By.id("aRegion:0:originState::content");
	private By originCountry_section = By.id("aRegion:0:originCountry::content");
	private By destinatioCity_section = By.id("aRegion:0:destCity::content");
	private By destinationState_section = By.id("aRegion:0:destinationState::content");
	private By destinationCountry_section = By.id("aRegion:0:destCountry::content");
	private By homeStatus_section = By.id("aRegion:0:homeStatus101::content");
	private By assignmentType_section = By.id("aRegion:0:assignmentType::content");
	private By authorizedBy_section = By.id("aRegion:0:authorizedBy::content");
	private By submitToAires_button = By.xpath("//span[contains(text(),'Submit to Aires')]");
	
	private ElementHelper elementHelper = new ElementHelper(DriverFactory.getDriver());
	
	public CreateAuthPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String setManuallyInputInfoAndName() {
		
		 ElementHelper.waitForIframeToLoad(iframePresent);
		 ElementHelper.waitForElementVisibility(iframePresent);
		 elementHelper.switchFrame(iframePresent);
		 ElementHelper.waitForElementVisibility(createNewAuthorizationText);
		 elementHelper.selectRadioButton(manuallyInputButton);
		 driver.findElement(createAuthContinueButton).click();
		 ElementHelper.waitForElementVisibility(firstName);
		 String fName = AppConstants.EmployeeFirstName + AppConstants.randomStringGenerator(4);
		 driver.findElement(firstName).sendKeys(fName);
		 ElementHelper.waitForElementVisibility(lastName);
		 String lName = AppConstants.EmployeeLastName + AppConstants.randomStringGenerator(4);
		 driver.findElement(lastName).sendKeys(lName);
		 driver.findElement(createAuthContinueButton).click();
		 ElementHelper.waitForElementVisibility(newTransferAssignment);
		 driver.findElement(newTransferAssignment).click();
		 
		 return fName + " " + lName; 
	}
	

	public void setEmployeeInformation() {
		
		 ElementHelper.waitForElementVisibility(newTransferAssignment);
		 driver.findElement(newTransferAssignment).click(); 
		 ElementHelper.waitForElementVisibility(employeeInfoFillPage);
		 elementHelper.selectRadioButton(preacceptanceInitiation_RadioButton);
		 elementHelper.selectByVisibeText(relocationPolicySelection, AppConstants.RelocationPolicyType);
		 driver.findElement(originCity_section).sendKeys(AppConstants.OriginCity);
		 elementHelper.selectByVisibeText(originState_section, AppConstants.OriginState);
		 elementHelper.selectByVisibeText(originCountry_section, AppConstants.OriginCountry);
		 driver.findElement(destinatioCity_section).sendKeys(AppConstants.DestCity);
		 elementHelper.selectByVisibeText(destinationState_section, AppConstants.DestState);
		 elementHelper.selectByVisibeText(destinationCountry_section, AppConstants.DestCountry);
		 elementHelper.selectRadioButton(homeStatus_section);
		 elementHelper.selectByVisibeText(assignmentType_section, AppConstants.AssignmentType);
		 driver.findElement(authorizedBy_section).clear();
		 driver.findElement(authorizedBy_section).sendKeys(AppConstants.AuthorizedBy);	 
		 
	}
	
	public void submitToAires() {
		driver.switchTo().defaultContent();
		driver.findElement(submitToAires_button).click();
	}

}