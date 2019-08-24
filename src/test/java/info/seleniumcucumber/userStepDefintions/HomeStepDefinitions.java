package info.seleniumcucumber.userStepDefintions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import env.DriverUtil;
import info.seleniumcucumber.methods.BaseTest;

public class HomeStepDefinitions implements BaseTest {

	protected WebDriver driver = DriverUtil.getDefaultDriver();

	String tabServiceName = "//ul[@class='nav nav-tabs nav-justified']//li[@data-gb-name='_DYNAMIC_0']";
	String tabSubTabInsurance = "//div[@id='Insurance']//li[@data-gb-name='_DYNAMIC_0']";
	String drdTravelPlan = "(//button[@class='btn btn-default'])[1]";
	String drdTravelPlanItem = "//span[@class='two-col'][contains(text(),'_DYNAMIC_0')]//following-sibling::link";
	String drdTravelPeople = "(//button[@class='btn btn-default'])[2]";
	String drdTravelPeopleItem = "//span[contains(text(),'_DYNAMIC_0')]//following-sibling::link";
	String drdTravelLocation = "(//button[@class='btn btn-default'])[3]";
	String drdTravelLocationItem = "//span[contains(text(),'_DYNAMIC_0')]//following-sibling::link";
	String btnShowMyResults = "//button[@name='product-form-submit']//link[@class='rippleJS']";

	@Given("^I select \"([^\"]*)\" tab$")
	public void select_service_tab(String tabName) throws Throwable {
		clickObj.click("xpath", tabServiceName.replace("_DYNAMIC_0", tabName));
	}

	@Given("^I select \"([^\"]*)\" subtab of insurance$")
	public void select_sub_tab_insurance(String subTabName) throws Throwable {
		clickObj.click("xpath", tabSubTabInsurance.replace("_DYNAMIC_0", subTabName));
	}

	@Given("^I select \"([^\"]*)\" option for travel plan$")
	public void select_travel_plan(String travelPlan) throws Throwable {
		clickObj.click("xpath", drdTravelPlan);
		clickObj.click("xpath", drdTravelPlanItem.replace("_DYNAMIC_0", travelPlan));
	}

	@Given("^I select \"([^\"]*)\" option for people dropdown$")
	public void select_travel_people(String travelPeople) throws Throwable {
		clickObj.click("xpath", drdTravelPeople);
		clickObj.click("xpath", drdTravelPeopleItem.replace("_DYNAMIC_0", travelPeople));
	}

	@Given("^I select \"([^\"]*)\" option for travel location$")
	public void select_travel_location(String travelLocation) throws Throwable {
		clickObj.click("xpath", drdTravelLocation);
		clickObj.click("xpath", drdTravelLocationItem.replace("_DYNAMIC_0", travelLocation));
	}

	@When("^I click on Show My Results button$")
	public void click_show_my_results() throws Throwable {
		clickObj.click("xpath", btnShowMyResults);
	}
}
