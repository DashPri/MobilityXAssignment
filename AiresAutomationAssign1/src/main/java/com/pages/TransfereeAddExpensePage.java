package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.Map;

import com.utils.DriverFactory;
import com.utils.ElementHelper;

public class TransfereeAddExpensePage extends Base{

	private ElementHelper elementHelper = new ElementHelper(DriverFactory.getDriver());	

	/************ TransfereeAddExpensePage : Object Repository ***********/

	@FindBy(id = "dcefhp1:logoicon")
	private WebElement pageLogo;

	@FindBy(xpath = "//div[contains(@id,'popup-container')]//div[contains(@class,'inlineFrame')]/iframe[@title='Content']")
	private WebElement popUpIFrame;

	@FindBy(id = "expenseCurrency::content")
	private WebElement receiptCurrency_Dropdown;

	@FindBy(id = "reimAccount::content")
	private WebElement reimbursementAccount_Dropdown;

	@FindBy(xpath = "//span[contains(text(),'Continue')]/parent::a[@class='af_button_link']")
	private WebElement createExpenseContinueButton;

	@FindBy(id = "efRgn:0:formName::content")
	private WebElement expenseReportName_TextField;

	@FindBy(xpath = "//label[@for='efRgn:0:sendReceiptByMId::content']")
	private WebElement mailEmailReceipts_Checkbox;

	@FindBy(id = "efRgn:0:category_1::content")
	private WebElement expenseCategoryAndType_Dropdown;

	/*-----Meals during househunting trip------*/

	@FindBy(id = "efRgn:0:startDate_1::content")
	private WebElement startDate_TextField;

	@FindBy(id = "efRgn:0:endDate_1::content")
	private WebElement endDate_CalendarField;

	@FindBy(id = "efRgn:0:GSARate_1::content")
	private WebElement gsaRate_TextField;

	@FindBy(id = "efRgn:0:familyTravelersCount_1::content")
	private WebElement numberofDependentTravellers12YrAndOlder_TextField;

	@FindBy(id = "efRgn:0:familyTravelersCountUnder12_1::content")
	private WebElement numberofDependentTravellersUnder12Yr_TextField;

	@FindBy(id = "efRgn:0:zipCode_1::content")
	private WebElement lodgingZipCode_TextField;

	@FindBy(id = "efRgn:0:employeeTravel_1::content")
	private WebElement employeeTravel_Dropdown;

	@FindBy(id = "efRgn:0:expAmount_1::content")
	private WebElement expenseAmount_TextField;

	@FindBy(id = "efRgn:0:comment_1::content")
	private WebElement expenseDetail_TextField;

	@FindBy(id = "efRgn:0:otaefb32")
	private WebElement continueToItemization_Button;

	@FindBy(id = "efRgn:1:pglaefb5")
	private WebElement reviewAndSubmitExpenseForm_Button;

	@FindBy(xpath = "//div[@id='growls']//div[@class='growl-message']")
	private WebElement expenseSubmissionMessage;

	/************ TransfereeAddExpensePage class Constructor ***********/

	public TransfereeAddExpensePage(WebDriver driver) {
		super(driver);
	}

	public void enterReceiptCurrencyReimAccountDetails(List<Map<String, String>> expenseFormMap) {

		elementHelper.waitForFrameToLoad(popUpIFrame);
		ElementHelper.waitForElementVisibility(popUpIFrame);
		elementHelper.switchFrame(popUpIFrame);
		ElementHelper.waitForElementVisibility(receiptCurrency_Dropdown);
		elementHelper.selectByVisibeText(receiptCurrency_Dropdown, expenseFormMap.get(0).get("Receipt Currency"));
		elementHelper.selectByVisibeText(reimbursementAccount_Dropdown,
				expenseFormMap.get(0).get("Reimbursement Account"));
		continueToExpenseForm();

	}

	public void continueToExpenseForm() {
		createExpenseContinueButton.click();
	}

	public void fillExpenseForm(List<Map<String, String>> expenseFormValues) {

		String startDate = expenseFormValues.get(0).get("Start Date");
		String endDate = expenseFormValues.get(0).get("End Date");
		String expenseAmount = expenseFormValues.get(0).get("ExpenseAmount");
		String details = expenseFormValues.get(0).get("Detail");
		ElementHelper.waitForElementVisibility(expenseReportName_TextField);
		expenseReportName_TextField.sendKeys(expenseFormValues.get(0).get("Expense Report Name"));
		if (expenseFormValues.get(0).get("Check here to mail receipts instead of uploading").equals("Yes")) {
			elementHelper.check(mailEmailReceipts_Checkbox);
		}
		elementHelper.selectByVisibeText(expenseCategoryAndType_Dropdown,
				expenseFormValues.get(0).get("Expense Category"));
		startDate_TextField.sendKeys(startDate);
		endDate_CalendarField.sendKeys(endDate);
		expenseAmount_TextField.sendKeys(expenseAmount);
		expenseDetail_TextField.sendKeys(details);


	}

	public void continueToItemization() {
		continueToItemization_Button.click();
	}

	public void reviewAndSubmitExpenseForm() {
		ElementHelper.waitForElementVisibility(reviewAndSubmitExpenseForm_Button);
		reviewAndSubmitExpenseForm_Button.click();
	}

	public String getSubmissionSuccessMessage() {

		ElementHelper.waitForElementVisibility(expenseSubmissionMessage);
		return expenseSubmissionMessage.getText();
	}

}
