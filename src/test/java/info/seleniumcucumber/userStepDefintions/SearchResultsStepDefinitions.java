package info.seleniumcucumber.userStepDefintions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import env.DriverUtil;
import info.seleniumcucumber.methods.BaseTest;

public class SearchResultsStepDefinitions implements BaseTest {

	protected WebDriver driver = DriverUtil.getDefaultDriver();

	String pnlTravelInsurancePlans = "//div[@class='col-sm-4 card-full']";
	String chkInsurersFilter = "//div[@data-filter-name='_DYNAMIC_0']";
	String lblInsuranceCardName = "//h4[@class='name multi-name']";
	String lblNumberPlans = "//div[@class='results-text pull-left']/h5";
	String rdoSortOption = "//label[contains(text(),'_DYNAMIC_0')]//parent::div";
	String lblInsurancePlanPrice = "//div[@class='policy-price']/span[@class='value']";
	String rdoPolicyTypeDetail = "//label[contains(text(),'_DYNAMIC_0')]//parent::div";
	String drdDestination = "//div[@class='select-component']";
	String drdDestinationItem = "(//span[@class='two-col'][text()='_DYNAMIC_0'])[1]//following-sibling::link";
	String btnSeeMore = "//a[@class='btn-ripple more']";
	String btnSliderMin = "//label[contains(text(),'_DYNAMIC_0')]//following-sibling::div//div[@class='slider-handle min-slider-handle round']";
	String btnSliderMax = "//label[contains(text(),'_DYNAMIC_0')]//following-sibling::div//div[@class='slider-handle max-slider-handle round']";

	@When("^I select \"([^\"]*)\" filter in Insurers$")
	public void select_filter_option_insurers(String filterOption) throws Throwable {
		clickObj.click("xpath", chkInsurersFilter.replace("_DYNAMIC_0", filterOption));
		wait_until_number_of_insurance_plan_changed();
	}

	@When("^I select \"([^\"]*)\" sort option$")
	public void select_sort_option(String sortOption) throws Throwable {
		clickObj.click("xpath", rdoSortOption.replace("_DYNAMIC_0", sortOption));
		wait_until_number_of_insurance_plan_changed();
	}

	@When("^I select \"([^\"]*)\" policy details$")
	public void select_policy_details(String policyDetail) throws Throwable {
		clickObj.click("xpath", rdoPolicyTypeDetail.replace("_DYNAMIC_0", policyDetail));
		wait_until_number_of_insurance_plan_changed();
	}

	@When("^I select \"([^\"]*)\" destination$")
	public void select_destination(String destination) throws Throwable {
		clickObj.click("xpath", drdDestination);
		clickObj.click("xpath", drdDestinationItem.replace("_DYNAMIC_0", destination));
		wait_until_number_of_insurance_plan_changed();
	}

	@When("^I click on See More button$")
	public void click_see_more_button() throws Throwable {
		wait_until_number_of_insurance_plan_changed();
		clickObj.click("xpath", btnSeeMore);
	}

	@When("^I set (\\d+) min and (\\d+) max for \"([^\"]*)\" slider$")
	public void verify_number_travel_insurance_plans(int minValue, int maxValue, String sliderName) throws Throwable {
		String minSliderElement = btnSliderMin.replace("_DYNAMIC_0", sliderName);
		String maxSliderElement = btnSliderMax.replace("_DYNAMIC_0", sliderName);
		int xMinCoor = coordinationObj.getHorizontalPosition("xpath", minSliderElement);
		int xMaxCoor = coordinationObj.getHorizontalPosition("xpath", maxSliderElement);
		int minValueSlider = Integer
				.parseInt(assertionObj.getElementAttribute("xpath", minSliderElement, "aria-valuemin"));
		int maxValueSlider = Integer
				.parseInt(assertionObj.getElementAttribute("xpath", minSliderElement, "aria-valuemax"));

		int offsetToMoveMinSlider = (xMaxCoor - xMinCoor) * minValue / (maxValueSlider - minValueSlider);
		navigationObj.dragAndDropByOffset("xpath", minSliderElement, offsetToMoveMinSlider, 0);

		int offsetToMoveMaxSlider = (xMaxCoor - xMinCoor) * (maxValueSlider - maxValue)
				/ (maxValueSlider - minValueSlider) * -1;
		navigationObj.dragAndDropByOffset("xpath", maxSliderElement, offsetToMoveMaxSlider, 0);
		wait_until_number_of_insurance_plan_changed();
	}

	@Then("^I see more than (\\d+) travel insurance plans in the search results$")
	public void verify_number_travel_insurance_plans(int noOfTravelPlans) throws Throwable {
		assertionObj.checkNumberOfElementsMoreThan("xpath", pnlTravelInsurancePlans, noOfTravelPlans, true);
	}

	@Then("^I see all travel insurance plans match with \"([^\"]*)\"$")
	public void verify_travel_insurance_plan_name(String filterName) throws Throwable {
		assertionObj.checkElementsText("xpath", lblInsuranceCardName, filterName, true);
	}

	@Then("^I see all travel insurance plans sort by price High to Low$")
	public void verify_travel_insurance_plan_sort_by_price_hight_to_low() throws Throwable {
		assertionObj.checkElementsValueSort("xpath", lblInsurancePlanPrice, "desc", true);
	}

	public void wait_until_number_of_insurance_plan_changed() throws NumberFormatException, InterruptedException {
		String currentText = assertionObj.getElementText("xpath", lblNumberPlans);
		String checkedText;
		for (int i = 0; i < 3; i++) {
			checkedText = assertionObj.getElementText("xpath", lblNumberPlans);
			if (checkedText.equals(currentText)) {
				progressObj.wait("1");
			} else
				break;
		}
	}

}
