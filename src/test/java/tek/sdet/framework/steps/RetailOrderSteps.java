package tek.sdet.framework.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.*;

import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailOrderSteps extends CommonUtility {

	POMFactory pomFactory = new POMFactory();

	@When("User change the category to {string}")
	public void userChangeTheCategoryTo(String categorty) {

		selectByVisibleText(pomFactory.retailOrderPage().search, categorty);
		logger.info("User switched to Smart Home");
	}

	@When("User search for an item {string}")
	public void userSearchForAnItem(String itemName) {
		sendText(pomFactory.retailOrderPage().searchInput, itemName);
		logger.info("User enterd the item for search successfully");
	}

	@When("User click on Search icon")
	public void userClickOnSearchIcon() {
		click(pomFactory.retailOrderPage().searchBttn);
		logger.info("User clicked on the Search button successfully");
	}

	@When("User click on item")
	public void userClickOnItem() {
		click(pomFactory.retailOrderPage().theItem);
		logger.info("User clicked on the Item successfully");
	}

	@When("User select quantity {string}")
	public void userSelectQuantity(String itemQTY) {
		selectByVisibleText(pomFactory.retailOrderPage().itemQty, itemQTY);
		logger.info("User selected the item quantity successfully");
	}

	@When("User click add to Cart button")
	public void userClickAddToCartButton() {
		click(pomFactory.retailOrderPage().addToCartBttn);
		logger.info("User clicked on add to cart button successfully");
	}

	@Then("the cart icon quantity should change to {string}")
	public void theCartIconQuantityShouldChangeTo(String itemsOnCart) {
		Assert.assertEquals(itemsOnCart, pomFactory.retailOrderPage().numberOfItemsOnCart.getText());
		logger.info("The number of the items in the cart is equal to the expected quantity successfully");

	}

	@Then("User cleans the cart before moving on")
	public void userCleansTheCartBeforeMovingOn() {
		click(pomFactory.retailOrderPage().cart);
		List<WebElement> empty = pomFactory.retailOrderPage().emptycart;

		for (WebElement emp : empty) {
			click(emp);

		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("The cart is emptied for the next test");
	}

	@When("User change the category to {string} Apex Legends")
	public void userChangeTheCategoryToApexLegends(String electronics) {
		selectByVisibleText(pomFactory.retailOrderPage().searchElectronics, electronics);
		logger.info("User changed the category to Electronics Successfully");
	}

	@When("User search for an item {string} Apex Legends")
	public void userSearchForAnItemApexLegends(String ApexLegend) {
		sendText(pomFactory.retailOrderPage().searchInputElectronics, ApexLegend);
		logger.info("User search for an item Apex Legend Successfully");

	}

	@When("User click on item Apex Legends")
	public void userClickOnItemApexLegends() {
		click(pomFactory.retailOrderPage().apexSearchElectronics);
		logger.info("User clicked on Apex Legend item Successfully");

	}

	@When("User select quantity {string} Apex Legends")
	public void userSelectQuantityApexLegends(String apexQTY) {
		selectByVisibleText(pomFactory.retailOrderPage().qtySelectApex, apexQTY);
		logger.info("User selected quantity of Apex Legend");
	}

	@Then("the cart icon quantity should change to {string} Apex Legends")
	public void theCartIconQuantityShouldChangeToApexLegends(String apexCartQTY) {
		Assert.assertEquals(pomFactory.retailOrderPage().numberOfItemsOnCart.getText(), apexCartQTY);
		logger.info("The cart quantity chanded Successfully");
	}

	@Then("User click on Cart option")
	public void userClickOnCartOption() {
		click(pomFactory.retailOrderPage().cartBttnApex);
		logger.info("User click on Cart option");
	}

	@Then("User click on Proceed to Checkout button")
	public void userClickOnProceedToCheckoutButton() {
		click(pomFactory.retailOrderPage().proceedBttn);
		logger.info("User clicked on proceed to checkout Successfully");
	}

	@Then("User click on Place Your Order")
	public void userClickOnPlaceYourOrder() {
		click(pomFactory.retailOrderPage().placeOrderBttn);
		logger.info("User click on place your order Successfully");
	}

	@Then("A message should be displayed {string}")
	public void aMessageShouldBeDisplayed(String mssgDisplayed) {

		waitTillPresence(pomFactory.retailOrderPage().orderPlacedMssg);
		Assert.assertEquals(mssgDisplayed, pomFactory.retailOrderPage().orderPlacedMssg.getText());
		logger.info("The message was displayed Successfully");
	}

	@Then("User search for item named {string}")

	public void userSearchForItemNamed(String amazonTV) {
		sendText(pomFactory.retailOrderPage().searchInputElectronics, amazonTV);
		logger.info("User search for an item Apex Legend Successfully");

	}

	@Then("User click on item AmazonTV")

	public void userClickOnItemAmazonTV() {

		click(pomFactory.retailOrderPage().AmazonFireTV);

		logger.info("User clicked on Apex Legend item Successfully");

	}

	@When("User click on Orders section")
	public void userClickOnOrdersSection() {
		click(pomFactory.retailOrderPage().orderbttn);
		logger.info("User clickec on order button");

	}

	@When("User click on first order in list")
	public void userClickOnFirstOrderInList() {

		click(pomFactory.retailOrderPage().firstOrder);
		logger.info("User clicked on first order");

	}

	@When("User click on Cancel The Order button")
	public void userClickOnCancelTheOrderButton() {
		click(pomFactory.retailOrderPage().cancelBtn);
		logger.info("User clicked on cancel button");
	}

	@When("User select the cancelation Reason {string}")
	public void userSelectTheCancelationReason(String reason) {
		selectByVisibleText(pomFactory.retailOrderPage().cancelReason, reason);
		logger.info("User submitted cancel order reason");

	}

	@When("User click on Cancel Order button")
	public void userClickOnCancelOrderButton() {
		click(pomFactory.retailOrderPage().cancelBttn);
		logger.info("User clicked on cancel button successfully");

	}

	@Then("a cancelation message should be displayed {string}")
	public void aCancelationMessageShouldBeDisplayed(String mssgDisplayed) {

		if (mssgDisplayed.contains("Your Order Has Been Cancelled")) {
			waitTillPresence(pomFactory.retailOrderPage().cancelMssg);
			Assert.assertEquals(pomFactory.retailOrderPage().cancelMssg.getText(), mssgDisplayed);
			logger.info("a cancelation message was displayed successfully");
		}

	}

	@When("User click on Orders section on page")
	public void userClickOnOrdersSectionOnPage() {
		click(pomFactory.retailOrderPage().orderbttn);
		logger.info("User clicked on order button");
	}

	@When("User click on first order in list on page")
	public void userClickOnFirstOrderInListOnPage() {
		click(pomFactory.retailOrderPage().returnFirstOrder);
		logger.info("User clicked on First Return Order");
	}

	@When("User click on Return Items button")
	public void userClickOnReturnItemsButton() {
		click(pomFactory.retailOrderPage().returnBttn);
		logger.info("User clicked on return order button");
	}

	@When("User select the Return Reason {string}")
	public void userSelectTheReturnReason(String reason) {
		selectByVisibleText(pomFactory.retailOrderPage().returnReason, reason);
		logger.info("User clicked on return reason option");
	}

	@When("User select the drop off service {string}")
	public void userSelectTheDropOffService(String fedEx) {
		selectByVisibleText(pomFactory.retailOrderPage().fedEx, fedEx);
		logger.info("User clicked on Fedex Option");
	}

	@When("User click on Return Order button")
	public void userClickOnReturnOrderButton() {
		click(pomFactory.retailOrderPage().orderSubmitBtn);

	}

	// UserReview
	@When("User click on Orders section on home")
	public void userClickOnOrdersSectionOnHome() {
		click(pomFactory.retailOrderPage().ordersReview);
		logger.info("user clicked on the orders section successfully");
	}

	@When("User click on first order in list on first page")
	public void userClickOnFirstOrderInListOnFirstPage() {
		click(pomFactory.retailOrderPage().firstOrderReview);
		logger.info("user clicked on first order in the list successfully");
	}

	@When("User click on Review button")
	public void userClickOnReviewButton() {
		click(pomFactory.retailOrderPage().reviewBttn);
		logger.info("user clicked on review button successfully");
	}

	@When("User write Review headline {string} and {string}")
	public void userWriteReviewHeadlineAnd(String headline, String description) {
		sendText(pomFactory.retailOrderPage().headLineInput, headline);
		sendText(pomFactory.retailOrderPage().descriptionInput, description);
		logger.info("User wrote a headline and description for the order successfully");
	}

	@When("User click Add your Review button")
	public void userClickAddYourReviewButton() {
		click(pomFactory.retailOrderPage().reviewSubmitBttn);
		logger.info("user clicked on the review button successfully");
	}

	@Then("a review message should be displayed {string}")
	public void aReviewMessageShouldBeDisplayed(String reviewSbmtMssg) {
		waitTillPresence(pomFactory.retailOrderPage().reviewSubmitMssg);
		Assert.assertEquals(pomFactory.retailOrderPage().reviewSubmitMssg.getText(), reviewSbmtMssg);
		logger.info("The review message was displayed successfully");
	}

}
