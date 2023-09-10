package tek.sdet.framework.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;

public class RetailHomeSteps extends CommonUtility {
	POMFactory pomFactory = new POMFactory();

	@Given("User is on retail website homepage")
	public void userIsOnRetailWebsiteHomepage() {

		Assert.assertTrue(pomFactory.homePage().tekSchoolLogo.isDisplayed());
		logger.info("Tekschool logo is displayed");
	}

	@When("User click on All section")
	public void userClickOnAllSection() {
		click(pomFactory.homePage().allOptions);
	}

	@Then("below options are present in Shop by Department sidebar")
	public void belowOptionsArePresentInShopByDepartmentSidebar(DataTable dataTable) {
	    List<List<String>> shopByDepartment = dataTable.asLists(String.class);
	    for(int i =0; i< shopByDepartment.get(0).size();i++) {
	    Assert.assertTrue(isElementDisplayed(getDriver().findElement(By.xpath("//div[@class='sidebar__content']//span[text()='"+shopByDepartment.get(0).get(i)+"']"))));
	    logger.info("options " + shopByDepartment.get(0).get(i) + " is displayed");
	    }
	    }
	  

	@When("User on {string}")
	public void userOn(String department) {
		List<WebElement> departments = pomFactory.homePage().sideBarOptions;
		for(int i = 0; i< departments.size(); i++) {
			if(departments.get(i).getText().equalsIgnoreCase(department)) {
				departments.get(i).click();
				break;
			}
			
		}
	  }
	@Then("below options are present in department")
	public void belowOptionsArePresentInDepartment(DataTable dataTable) {
		List<List<String>> departmentOptions = dataTable.asLists(String.class);
		List<WebElement> options =pomFactory.homePage().sidebarAllOptions;
		for(int i =0; i< departmentOptions.get(0).size();i++) {
			for(WebElement elements : options) {
				if(elements.getText().equalsIgnoreCase(departmentOptions.get(0).get(i))) {
			
	    Assert.assertTrue(elements.isDisplayed());
	    logger.info("The options " + elements.getText() + " is present");
	    }
		}
	  }
	}
}
	


