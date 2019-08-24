package info.seleniumcucumber.methods;

public interface BaseTest {
	NavigateMethods navigationObj = new NavigateMethods();
	AssertionMethods assertionObj = new AssertionMethods();
	ClickElementsMethods clickObj = new ClickElementsMethods();
	ProgressMethods progressObj = new ProgressMethods();
	ScreenShotMethods screenshotObj = new ScreenShotMethods();
	CoordinationMethods coordinationObj = new CoordinationMethods();
}
