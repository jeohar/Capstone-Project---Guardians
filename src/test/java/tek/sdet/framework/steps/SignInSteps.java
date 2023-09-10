package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;
import tek.sdet.framework.utilities.DataGenerator;

public class SignInSteps extends CommonUtility{
	
	private String randomEmail;
	
	POMFactory pomFactory = new POMFactory();
	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
	    Assert.assertTrue(pomFactory.homePage().tekSchoolLogo.isDisplayed());
	    logger.info("TEKSCHOOL logo is displayed");
	}
	@When("User click on Sign in option")
	public void userClickOnSignInOption() {
		click(pomFactory.signInPage().signInFeild);
		logger.info("Login link was cliked successfully");
	}
	@When("User enter email {string} and password {string}")
	public void userEnterEmailAndPassword(String email, String password) {
		sendText(pomFactory.signInPage().emailField, email);
		sendText(pomFactory.signInPage().passwordField, password);
		logger.info("User entered email and password successfully");
			   	}
	
	@When("User click on login button")
	public void userClickOnLoginButton() {
	    click(pomFactory.signInPage().logginBtfField);
	    logger.info("User clikced on loggin button");
	    
	}
	@Then("User should be logged in into Account")
	public void userShouldBeLoggedInIntoAccount() {
	    Assert.assertTrue(pomFactory.signInPage().loggoutBtn.isDisplayed());
	    logger.info("User is logged in Successfully");
	}
	@When("User click on Create New Account button")
	public void userClickOnCreateNewAccountButton() {
		click(pomFactory.signInPage().newAccountField);
		logger.info("New Account Button is clicked successfully");
	   
	}
	
	@When("User fill the signUp information with below data")
	public void userFillTheSignUpInformationWithBelowData(DataTable dataTable) {
		
		randomEmail = DataGenerator.getEmail();
		
		
	    List<Map<String, String>> signUpForm = dataTable.asMaps(String.class, String.class);
	    sendText(pomFactory.signInPage().nameInputField, signUpForm.get(0).get("name"));
//	    sendText(pomFactory.signInPage().emailInputField, signUpForm.get(0).get("email"));
	    sendText(pomFactory.signInPage().emailInputField, randomEmail);
	    sendText(pomFactory.signInPage().passwordInputField,signUpForm.get(0).get("password"));
	    sendText(pomFactory.signInPage().confPasswordInputField, signUpForm.get(0).get("confirmPassword"));
	    logger.info("User registered successfully");
	    
	}
	@When("User click on SignUp button")
	public void userClickOnSignUpButton() {
	    click(pomFactory.signInPage().signUpInputField);
		logger.info("Signup button was clicked sucessfully");

	}
	@Then("User should be logged into account page")
	public void userShouldBeLoggedIntoAccountPage() {
		click(pomFactory.signInPage().loggoutBtn);
		logger.info("User clicked on logout button successfully after signed up");
	    
	}
}
