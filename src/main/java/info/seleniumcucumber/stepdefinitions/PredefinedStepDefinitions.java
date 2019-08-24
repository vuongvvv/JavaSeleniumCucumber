package info.seleniumcucumber.stepdefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import env.DriverUtil;
import info.seleniumcucumber.methods.BaseTest;

public class PredefinedStepDefinitions implements BaseTest {
	protected WebDriver driver = DriverUtil.getDefaultDriver();
	@Given("^I navigate to \"([^\"]*)\"$")
	public void navigate_to(String link) {
		navigationObj.navigateTo(link);
	}
}