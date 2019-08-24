package info.seleniumcucumber.userStepDefintions;

import cucumber.api.java.Before;
import cucumber.api.java.After;
import env.DriverUtil;

public class Hooks {
//	@After("@NegativeTest")
//	public void beforeScenario(Scenario scenario) {
//		// System.out.println("In hooks");
//		// System.out.println(scenario.getName());
//		// System.out.println(scenario.getStatus());
//	}
	@After
	public void afterScenario() {
		System.out.println("Hooks");
		DriverUtil.closeDriver();
	}

}
