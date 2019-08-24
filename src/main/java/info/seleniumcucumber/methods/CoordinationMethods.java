package info.seleniumcucumber.methods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CoordinationMethods extends SelectElementByType implements BaseTest {
	private WebElement element = null;

	public int getHorizontalPosition(String accessType, String accessName) {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		return element.getLocation().x;
	}
}