package com.stepDefinitions;

import org.testng.Assert;

import com.pages.CreateAuthPage;
import com.pages.HomePage;
import com.utils.AppConstants;
import com.utils.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CreateAuthorizationSteps {
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	private CreateAuthPage createAuthPage = new CreateAuthPage(DriverFactory.getDriver());
	private String empName;

	@Given("User is on Authorization HomePage after clicking on Create Authorization button.")
	public void user_is_on_authorization_home_page_after_clicking_on_create_authorization_button() {
		Assert.assertTrue(homePage.isCreateAuthButtonVisible());
		homePage.clickOnAuthorization();
	}
	
	@Given("User create new transfer or assignment authorization by entering mandatory information on initiation form for authorization creation.")
	public void user_create_new_transfer_or_assignment_authorization_by_entering_mandatory_information_on_initiation_form_for_authorization_creation() {
		empName = createAuthPage.setManuallyInputInfoAndName();
		createAuthPage.setEmployeeInformation();
		System.out.println(empName);
	}

	@When("User click on Submit to Aires button")
	public void user_click_on_submit_to_aires_button() {
		createAuthPage.submitToAires();
	}

	@Then("User should navigate to the dashboard page of MobilityX application displaying submission success message")
	public void user_should_navigate_to_the_dashboard_page_of_mobility_x_application_displaying_submission_success_message() {
		Assert.assertEquals(homePage.getSubmissionSuccessMessage(),
				AppConstants.INITIATION_SUBMISSION_SUCCESS_MESSAGE.replace("#", empName.trim()),
				"Submission success message did not match");
	}

}
