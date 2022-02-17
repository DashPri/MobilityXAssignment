package com.stepDefinitions;

import java.util.List;

import org.testng.Assert;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private HomePage homePage = new HomePage(DriverFactory.getDriver());

	/**
	 * Prerequisite- You should be in MobilityX Login Page
	 */
	@Given("User is on the login page of MobilityX application")
	public void user_is_on_the_login_page_of_mobility_x_application() {	
		Assert.assertTrue(loginPage.getTitle().contains("MobilityX"));
	}
	
	@When("User logs into the Application by entering Username {string}, password {string}")
	public void user_logs_into_the_application_by_entering_username_password(String username, String password) {
		loginPage.setUsername(username);
		loginPage.clickNext();
		loginPage.setPassword(password);
		loginPage.clickLogin();
	}

	@Then("User should navigate to the dashboard page of MobilityX application with same user {string}")
	public void user_should_navigate_to_the_dashboard_page_of_mobility_x_application_with_same_user(String userProfile) {
		Assert.assertTrue(homePage.isUserNavigatedtoHomePage(),"User did not navigate to HomePage! Please enter correct credentials");
		Assert.assertEquals(homePage.getProfileName(), userProfile, "Different User Profile is appearing");
	}

	@Then("User should be able to logout from the application by clicking on Logout button")
	public void user_should_be_able_to_logout_from_the_application_by_clicking_on_logout_button() {
		homePage.clickOnLogout();
		Assert.assertTrue(loginPage.isUserNavigatedtoLoginPage(),"User did not navigate to Login Page after clicking on Logout");
	}

	@Given("User is already logged into MobilityX application with following credentials")
	public void user_is_already_logged_into_mobility_x_application_with_following_credentials(DataTable dataTable) {
		
		  List<String> credentials = dataTable.asList();
		  loginPage.setUsername(credentials.get(0)); 
		  loginPage.clickNext();
		  loginPage.setPassword(credentials.get(1)); 
		  loginPage.clickLogin();
		  
		  Assert.assertTrue(homePage.isUserNavigatedtoHomePage()
		  ,"User did not navigated to HomePage!! Please enter correct credentials");
		  Assert.assertEquals(homePage.getProfileName(), credentials.get(2),
		  "Different User Profile is appearing");
		 
	}

}
