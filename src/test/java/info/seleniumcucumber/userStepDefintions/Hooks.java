package info.seleniumcucumber.userStepDefintions;

import cucumber.api.java.After;
import env.DriverUtil;

public class Hooks {
	@After
	public void afterScenario() {
		DriverUtil.closeDriver();
	}

}
