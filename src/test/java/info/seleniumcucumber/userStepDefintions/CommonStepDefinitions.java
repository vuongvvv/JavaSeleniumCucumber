package info.seleniumcucumber.userStepDefintions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import env.DriverUtil;
import info.seleniumcucumber.methods.BaseTest;

public class CommonStepDefinitions implements BaseTest {

	protected WebDriver driver = DriverUtil.getDefaultDriver();
	
	String dtpStartDate = "//input[contains(@name,'startdate')]";
	String dtpEndDate = "//input[contains(@name,'enddate')]";
	String btnDatePickerYearSwitch = "//div[@class='datepicker-years']//th[@class='datepicker-switch']";
	String btnDatePickerMonthSwitch = "//div[@class='datepicker-months']//th[@class='datepicker-switch']";
	String btnDatePickerDaySwitch = "//div[@class='datepicker-days']//th[@class='datepicker-switch']";
	String btnSelectYearOnYearPicker = "//div[@class='datepicker-years']//span[text()='_DYNAMIC_0']";
	String btnNextOnYearPicker = "//div[@class='datepicker-years']//th[@class='next']";
	String btnSelectMonthOnMonthPicker = "//div[@class='datepicker-months']//span[text()='_DYNAMIC_0']";
	String btnSelectDateOnDatePicker = "//div[@class='datepicker-days']//td[@class='day'][text()='_DYNAMIC_0']";

	@Given("^I select \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" as start date$")
	public void select_start_date(String day, String month, String year) throws Throwable {
		clickObj.click("xpath", dtpStartDate);
		clickObj.click("xpath", btnDatePickerDaySwitch);
		clickObj.click("xpath", btnDatePickerMonthSwitch);
		selectYearOnYearPicker(year);
		clickObj.click("xpath", btnSelectMonthOnMonthPicker.replace("_DYNAMIC_0", month));
		clickObj.click("xpath", btnSelectDateOnDatePicker.replace("_DYNAMIC_0", day));
	}
	
	@Given("^I select \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" as end date$")
	public void select_end_date(String day, String month, String year) throws Throwable {
		clickObj.click("xpath", dtpEndDate);
		clickObj.click("xpath", btnDatePickerDaySwitch);
		clickObj.click("xpath", btnDatePickerMonthSwitch);
		selectYearOnYearPicker(year);
		clickObj.click("xpath", btnSelectMonthOnMonthPicker.replace("_DYNAMIC_0", month));
		clickObj.click("xpath", btnSelectDateOnDatePicker.replace("_DYNAMIC_0", day));
	}

	public void selectYearOnYearPicker(String year) {
		String element = btnSelectYearOnYearPicker.replace("_DYNAMIC_0", year);
		Boolean isElementDisplayed = false;
		try {
			isElementDisplayed = assertionObj.isElementDisplayed("xpath", element);
		} catch (Exception e) {
		}
		for (int i = 0; i < 5; i++) {
			if (isElementDisplayed == true) {
				clickObj.click("xpath", element);
				break;
			} else {
				clickObj.click("xpath", btnNextOnYearPicker);
				try {
					isElementDisplayed = assertionObj.isElementDisplayed("xpath", element);
				} catch (Exception e) {
				}
			}
		}
	}
}
