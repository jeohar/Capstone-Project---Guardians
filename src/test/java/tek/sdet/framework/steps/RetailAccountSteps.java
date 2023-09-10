package tek.sdet.framework.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tek.sdet.framework.utilities.DataGenerator;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailAccountSteps extends CommonUtility {

	POMFactory pomFactory = new POMFactory();
	private String randomPhone;
	private String randomInfo;

// User Updata her information	
	@When("User click on Account option")
	public void userClickOnAccountOption() {
		click(pomFactory.retailAccountPage().accountLink);
		logger.info("Account link was clicked successfully");
	}

	@When("User update Name {string} and Phone {string}")
	public void userUpdateNameAndPhone(String name, String phoneNumber) {
		randomPhone = DataGenerator.RandomPhoneNumber();
		clearTextUsingSendKeys(pomFactory.retailAccountPage().nameField);
		sendText(pomFactory.retailAccountPage().nameField, name);
		logger.info("Name was entered successfully");
		clearTextUsingSendKeys(pomFactory.retailAccountPage().phoneField);
		sendText(pomFactory.retailAccountPage().phoneField, randomPhone);
		logger.info("Phone Number was entered successfully");
	}

	@When("User click on Update button")
	public void userClickOnUpdateButton() {
		click(pomFactory.retailAccountPage().updateBttn);
		logger.info("Update button was clicked successfully");
	}

	@Then("user profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(pomFactory.retailAccountPage().personalInfoUpdateSuccessMssg);
		String expectedMssg = "Personal Information Updated Successfully";
		String actualMssg = pomFactory.retailAccountPage().personalInfoUpdateSuccessMssg.getText();
		Assert.assertEquals(expectedMssg, actualMssg);
		logger.info("Account information was updated successfully");
	}

	// userAddPaymentMethod

	@When("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
		click(pomFactory.retailAccountPage().addAPaymentMethodLink);
		logger.info("Add Payment Method link was clicked successfully");
	}

	@When("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(DataTable dataTable) {

		randomInfo = DataGenerator.cardNumber();
		List<Map<String, String>> paymentInfo = dataTable.asMaps(String.class, String.class);
		
		sendText(pomFactory.retailAccountPage().cardNumber, randomInfo);
		sendText(pomFactory.retailAccountPage().nameOnCard, paymentInfo.get(0).get("nameOnCard"));
		selectByVisibleText(pomFactory.retailAccountPage().expirationMonth,
				paymentInfo.get(0).get("expirationMonth"));
		selectByVisibleText(pomFactory.retailAccountPage().expirationYear,
				paymentInfo.get(0).get("expirationYear"));
		sendText(pomFactory.retailAccountPage().securityCode, paymentInfo.get(0).get("securityCode"));
		logger.info("Payment Information was entered successfully");

	}

	@When("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
		click(pomFactory.retailAccountPage().paymentSubmitBtn);
		logger.info("Payment Method Submit bttn clicked successfully");
		waitTillPresence(pomFactory.retailAccountPage().clickOnCardfirst);
		logger.info("The card is present");
	}

	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayed(String expectedMssg) {

		if (expectedMssg.contains("Payment Method added")) {
			waitTillPresence(pomFactory.retailAccountPage().paymentMethodSuccessMssg);
			Assert.assertEquals(expectedMssg, pomFactory.retailAccountPage().paymentMethodSuccessMssg.getText());
			logger.info("Expected Message: " + expectedMssg);
		} else if (expectedMssg.contains("Address Added")) {
			waitTillPresence(pomFactory.retailAccountPage().addressSuccessMssg);
			Assert.assertEquals(expectedMssg, pomFactory.retailAccountPage().addressSuccessMssg.getText());
			logger.info("Expected Message: " + expectedMssg);
		} // else if(expectedMssg.contains("Order Placed")) {
//			waitTillPresence(pomFactory.retailOrderPage().orderPlacedSuccessfullyMssg);
//			Assert.assertEquals(expectedMssg, pomFactory.retailOrderPage().orderPlacedSuccessfullyMssg.getText());
//		}

	}

//userUpdateCardInformation

	@Then("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() {
		click(pomFactory.retailAccountPage().clickOnCardfirst);
		logger.info("User clicked on the card option successfully");

	}

	@Then("user edit information with below data")
	public void userEditInformationWithBelowData(io.cucumber.datatable.DataTable dataTable) {
		click(pomFactory.retailAccountPage().editButtn);
		logger.info("User clicked on eidt button sucessfully");
		randomInfo = DataGenerator.cardNumber();

		List<Map<String, String>> editFields = dataTable.asMaps(String.class, String.class);
		clearTextUsingSendKeys(pomFactory.retailAccountPage().cardNumber);
		sendText(pomFactory.retailAccountPage().cardNumber, randomInfo);

		clearTextUsingSendKeys(pomFactory.retailAccountPage().nameOnCard);
		sendText(pomFactory.retailAccountPage().nameOnCard, editFields.get(0).get("nameOnCard"));

		clearTextUsingSendKeys(pomFactory.retailAccountPage().expirationMonth);
		sendText(pomFactory.retailAccountPage().expirationMonth, editFields.get(0).get("expirationMonth"));

		clearTextUsingSendKeys(pomFactory.retailAccountPage().expirationYear);
		sendText(pomFactory.retailAccountPage().expirationYear, editFields.get(0).get("expirationYear"));

		clearTextUsingSendKeys(pomFactory.retailAccountPage().securityCode);
		sendText(pomFactory.retailAccountPage().securityCode, editFields.get(0).get("securityCode"));
		logger.info("The infromation was filled by user successfully");

	}

	@Then("user click on Update Your Card button")
	public void userClickOnUpdateYourCardButton() {
		click(pomFactory.retailAccountPage().updateButton);
		logger.info("User updated card information successfully");
	}

	// @removeCard

	@When("User click on selected card")
	public void userClickOnSelectedCard() {
		click(pomFactory.retailAccountPage().clickOnCardfirst);
		logger.info("the card was clicked successfully");
	}

	@When("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSection() {
		click(pomFactory.retailAccountPage().removeCard);
		logger.info("User clicked on the remove card option successfully");
	}

	// @addAddress
	@When("User click on Add address option")
	public void userClickOnAddAddressOption() {
		click(pomFactory.retailAccountPage().addAddressLink);
		logger.info("Add Address Link was clicked successfully");
	}

	@When("user fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(DataTable dataTable) {
		List<Map<String, String>> addressInfo = dataTable.asMaps(String.class, String.class);
		selectByVisibleText(pomFactory.retailAccountPage().AddressCountryDropdown,
				DataGenerator.addressGenerator(addressInfo.get(0).get("country")));
		sendText(pomFactory.retailAccountPage().addressNameField,
				DataGenerator.addressGenerator(addressInfo.get(0).get("fullName")));
		sendText(pomFactory.retailAccountPage().addressPhoneField,
				DataGenerator.addressGenerator(addressInfo.get(0).get("phoneNumber")));
		sendText(pomFactory.retailAccountPage().addressStreetField,
				DataGenerator.addressGenerator(addressInfo.get(0).get("streetAddress")));
		sendText(pomFactory.retailAccountPage().addressApartmentNum,
				DataGenerator.addressGenerator(addressInfo.get(0).get("apt")));
		sendText(pomFactory.retailAccountPage().addressCityField,
				DataGenerator.addressGenerator(addressInfo.get(0).get("city")));
		selectByVisibleText(pomFactory.retailAccountPage().addressStateDropdown,
				DataGenerator.addressGenerator(addressInfo.get(0).get("state")));
		sendText(pomFactory.retailAccountPage().addressZipCodeField,
				DataGenerator.addressGenerator(addressInfo.get(0).get("zipCode")));

		logger.info("Address form was filled out successfully");
	}

	@When("User click Add Your Address button")
	public void userClickAddYourAddressButton() {
		
		click(pomFactory.retailAccountPage().addressAddBttn);
		logger.info("Add Address Button was clicked successfully");
	}
//	edit address
	@When("User click on edit address option")
	public void userClickOnEditAddressOption() throws InterruptedException {
		
//		WebDriver driver = new FirefoxDriver();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for up to 10 seconds
//		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		click(pomFactory.retailAccountPage().editAddress);
		logger.info("User clicked on Edit Address button");
	}
	@When("User fill new address form with following information")
	public void userFillNewAddressFormWithFollowingInformation(DataTable dataTable) {
	    List<Map<String, String>> addressFields = dataTable.asMaps(String.class, String.class);
	    randomPhone = DataGenerator.RandomPhoneNumber();
	    
	    selectByVisibleText(pomFactory.retailAccountPage().AddressCountryDropdown, addressFields.get(0).get("country"));
	    
	    clearTextUsingSendKeys(pomFactory.retailAccountPage().addressNameField);
	    sendText(pomFactory.retailAccountPage().addressNameField, addressFields.get(0).get("fullName"));
	    
	    clearTextUsingSendKeys(pomFactory.retailAccountPage().addressPhoneField);
//	    sendText(pomFactory.retailAccountPage().addressPhoneField, addressFields.get(0).get("phoneNumber"));
	    sendText(pomFactory.retailAccountPage().addressPhoneField, randomPhone);
	    clearTextUsingSendKeys(pomFactory.retailAccountPage().addressStreetField);
	    sendText(pomFactory.retailAccountPage().addressStreetField, addressFields.get(0).get("streetAddress"));
	
	    clearTextUsingSendKeys(pomFactory.retailAccountPage().addressApartmentNum);
	    sendText(pomFactory.retailAccountPage().addressApartmentNum, addressFields.get(0).get("apt"));
	    
	    clearTextUsingSendKeys(pomFactory.retailAccountPage().addressCityField);
	    sendText(pomFactory.retailAccountPage().addressCityField, addressFields.get(0).get("city"));
	    
	    clearTextUsingSendKeys(pomFactory.retailAccountPage().addressStateDropdown);
	    sendText(pomFactory.retailAccountPage().addressStateDropdown, addressFields.get(0).get("state"));
	    
	    clearTextUsingSendKeys(pomFactory.retailAccountPage().addressZipCodeField);
	    sendText(pomFactory.retailAccountPage().addressZipCodeField, addressFields.get(0).get("zipCode"));
	    
	}
	@When("User click update Your Address button")
	public void userClickUpdateYourAddressButton() throws InterruptedException {
		click(pomFactory.retailAccountPage().updateAddButton);
		logger.info("The user clicked on update your address button successfully");
	    Thread.sleep(2000);
	}
	
	@When("User click on remove option of Address section")
	public void userClickOnRemoveOptionOfAddressSection() throws InterruptedException {
		Thread.sleep(2000);
		click(pomFactory.retailAccountPage().removeBttn);
		logger.info("The remove button was clicked successfully");
	}
	@Then("Address details should be removed")
	public void addressDetailsShouldBeRemoved() {
		if(!isElementDisplayed(pomFactory.retailAccountPage().removeBttn));
		logger.info("Address Removed Successfully");
	   
	}

}
