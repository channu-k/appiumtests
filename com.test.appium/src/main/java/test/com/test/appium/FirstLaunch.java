
/**
 * The FirstLaunch program is used to install and launch the VMA app for the first time
 * This program also has tests for verifying the dialog texts and the enabling of the terms and conditions button
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

public class FirstLaunch extends SupportSetUp {

	@Test
	public void launchVMA() {

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

		/*
		 * (new WebDriverWait(driver, 75))
		 * .until(ExpectedConditions.presenceOfElementLocated(By.id(
		 * "com.verizon.messaging.vzmsgs:id/drawerIcon")));
		 */
		driver.manage().timeouts().implicitlyWait(75, TimeUnit.SECONDS);

		WebElement whatsNew = driver.findElementById(configuredCapabilities.getTITLETEXT());
		if (whatsNew.isDisplayed()) {
			WebElement closeBtn = driver.findElementById(configuredCapabilities.getCLOSEBUTTON());
			closeBtn.click();

		}

		(new WebDriverWait(driver, 45))
				.until(ExpectedConditions.presenceOfElementLocated(By.id(configuredCapabilities.getDRAWER_ICON())));

	}

	@BeforeClass
	public void setUp() {

		try {
			super.setUp();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}

}
