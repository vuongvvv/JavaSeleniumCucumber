package info.seleniumcucumber.methods;

public class ProgressMethods extends SelectElementByType implements BaseTest {
	/**
	 * Method to wait
	 * 
	 * @param time
	 *            : String : Time to wait
	 * @param method
	 *            : String : wait by sleep or implicit method
	 * @throws NumberFormatException
	 * @throws InterruptedException
	 */
	public void wait(String time) throws NumberFormatException, InterruptedException {
		// sleep method takes parameter in milliseconds
		Thread.sleep(Integer.parseInt(time) * 1000);
	}
}
