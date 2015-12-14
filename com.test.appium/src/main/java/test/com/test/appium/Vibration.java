/**
 * The Vibration program is used to test whether the user can change the Vibrate options
 *
 * @author  Guruprasad B. Gopinath
 * @version 1.0
 * @since   2015-09-01 
 */

package test.com.test.appium;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

public class Vibration extends SupportSetUp {

	@Test
	public void viewVibrationScreen() {
		WebElement convGalleryOption = driver.findElementById(configuredCapabilities.getIMGCONVGALLERYOPTION());
		convGalleryOption.click();

		WebElement customizeMenuBtn = driver.findElementByName("Customize");
		customizeMenuBtn.click();

		WebElement vibrateOption = driver.findElementByName("Vibrate");
		vibrateOption.click();

		// Header
		WebElement headerVibration = driver.findElementById(configuredCapabilities.getDIALOG_TITLE());
		String headerVibrationTxt = headerVibration.getText();
		Assert.assertEquals(headerVibrationTxt, "Vibration");

		WebElement subHeaderVibration = driver.findElementById(configuredCapabilities.getDIALOG_SUB_TITLE());
		String subHeaderVibrationTxt = subHeaderVibration.getText();
		Assert.assertEquals(subHeaderVibrationTxt, "Select an option from below:");
		/*
		 * // Change vibrate option WebElement alwaysVibrateOption =
		 * driver.findElementByName("Always"); alwaysVibrateOption.click();
		 * 
		 * 
		 */
		WebElement selectSaveBtn = driver.findElementById(configuredCapabilities.getPOSITIVE_BUTTON());
		selectSaveBtn.click();

	}

	@BeforeClass
	public void setUp() {

		capabilities.setCapability(APIConstants.NORESET, configuredCapabilities.getNORESET());
		try {
			super.setUp();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
	}
}
