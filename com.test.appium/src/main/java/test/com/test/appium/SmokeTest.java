
/**
 * The FirstLaunch program is used to install and launch the VMA app for the first time
 *
 * @author  Guruprasad B. Gopinath
 * @version 1.0
 * @since   2015-09-01 
 */

package test.com.test.appium;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

public class SmokeTest extends SupportSetUp {

	@Test
	public void firstLaunch() {
		WebElement firstDialogMessage = driver.findElementById(configuredCapabilities.getFIRST_DIALOG_MESSAGE());
		Assert.assertEquals(firstDialogMessage.getText(), "Go Beyond Text.");

		WebElement dialogMessage = driver.findElementById(configuredCapabilities.getDIALOG_MESSAGE());
		Assert.assertEquals(dialogMessage.getText(),
				"Draw on pictures, share locations in real time, send audio clips and more!");

		WebElement tAndC = driver.findElementById(configuredCapabilities.getPROV_DECLINEBUTTON());
		Assert.assertEquals(tAndC.getText(), "Terms & Conditions");
		Assert.assertEquals(tAndC.isEnabled(), true);

		/*
		 * WebElement yesBtn = driver.findElementById("android:id/button1");
		 * yesBtn.click();
		 */
		WebElement getStarted = driver.findElement(By.id(configuredCapabilities.getPROV_ACCEPTBUTTON()));
		getStarted.click();

		driver.manage().timeouts().implicitlyWait(75, TimeUnit.SECONDS);

		WebElement whatsNew = driver.findElementById(configuredCapabilities.getTITLETEXT());
		if (whatsNew.isDisplayed()) {
			WebElement closeBtn = driver.findElementById(configuredCapabilities.getCLOSEBUTTON());
			closeBtn.click();

		}

		(new WebDriverWait(driver, 45))
				.until(ExpectedConditions.presenceOfElementLocated(By.id(configuredCapabilities.getDRAWER_ICON())));

	}

	/*
	 * @Test (dependsOnMethods = { "firstlaunch" }) public void removeApp() {
	 * 
	 * driver.removeApp("com.verizon.messaging.vzmsgs");
	 * 
	 * }
	 */

	@BeforeClass
	public void setUp() {

		capabilities.setCapability(APIConstants.APPWAITACTVITY, configuredCapabilities.getAPP_ACTIVITY());
		try {
			super.setUp();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterClass
	public void tearDown() throws Exception {
		// driver.quit();
	}

}
