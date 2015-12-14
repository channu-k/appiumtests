
package test.com.test.appium;

import java.net.MalformedURLException;

// import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

public class ClickYes extends SupportSetUp {

	/**
	 * @param args
	 */
	// private AndroidDriver driver;

	@BeforeClass
	public void setUp() {

		capabilities.setCapability(APIConstants.APP, configuredCapabilities.getFILE_PATH());
		try {
			super.setUp();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	// @AfterClass
	public void tearDown() throws Exception {
		boolean hasQuit = (driver.toString().contains("(null)")) ? true : false;

		driver.quit();
	}

	@Test
	// public void loginTest() throws InterruptedException
	public void clickyes() {

		// do more native testing if we want

		// driver.switchTo().window("NATIVE_APP");
		WebElement abc = driver.findElement(By.id(configuredCapabilities.getPROV_ACCEPTBUTTON()));
		abc.click();

		// driver.findElement(By.id("com.verizon.messaging.vzmsgs:id/composebutton")).click();

	}
}
