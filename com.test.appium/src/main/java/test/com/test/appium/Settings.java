/**
 * The Settings program is used to test whether the Settings Screen is displayed
 *
 * @author  Guruprasad B. Gopinath
 * @version 1.0
 * @since   2015-09-01 
 */

package test.com.test.appium;

import java.net.MalformedURLException;

// import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

public class Settings extends SupportSetUp {

	/*
	 * private TouchAction tContacts; private WebElement TouchAction;
	 */
	@Test
	public void clickSettings() {
		//
		WebElement drawerIcon = driver.findElementById(configuredCapabilities.getDRAWER_ICON());
		drawerIcon.click();

		WebElement settings = driver.findElementByAccessibilityId("Settings");
		settings.click();

		WebElement settingsScreen = driver.findElementByName("Settings");
		boolean isSettingsScreenDisplayed = settingsScreen.isDisplayed();
		Assert.assertEquals(true, isSettingsScreenDisplayed);

	}

	@BeforeClass
	public void setUp() {

		capabilities.setCapability(APIConstants.NORESET, configuredCapabilities.getNORESET());

		try {
			super.setUp();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
	}
}
