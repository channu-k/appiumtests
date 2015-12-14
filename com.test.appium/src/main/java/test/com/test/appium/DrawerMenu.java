/**
* The DrawerMenu program is used to check the different options of the Drawer Menu
*
* @author  Guruprasad B. Gopinath
* @version 1.0
* @since   2015-09-01 
*/

package test.com.test.appium;

import java.net.MalformedURLException;

// import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

import io.appium.java_client.TouchAction;
import junit.framework.Assert;

public class DrawerMenu extends SupportSetUp {

	private TouchAction tContacts;
	private WebElement TouchAction;

	@Test
	public void displayDrawerMenu() {
		// Locate and Click the DrawerIcon
		WebElement drawerIcon = driver.findElementById(configuredCapabilities.getDRAWER_ICON());
		drawerIcon.click();

		// Edit profile
		WebElement editProfilePen = driver.findElementById(configuredCapabilities.getEDIT_NAME_CONTAINER());
		boolean isEditProfilePenDisplayed = editProfilePen.isDisplayed();
		Assert.assertEquals(true, isEditProfilePenDisplayed);

		// Driving Mode
		WebElement drivingMode = driver.findElementByAccessibilityId("Driving Mode");
		boolean isDrivingModeDisplayed = drivingMode.isDisplayed();
		Assert.assertEquals(true, isDrivingModeDisplayed);

		// Restore
		WebElement restoreMessages = driver.findElementByAccessibilityId("Restore Messages");
		boolean isRestoreMessagesDisplayed = restoreMessages.isDisplayed();
		Assert.assertEquals(true, isRestoreMessagesDisplayed);

		// Settings
		WebElement settingsOption = driver.findElementByAccessibilityId("Settings");
		boolean isSettingsDisplayed = settingsOption.isDisplayed();
		Assert.assertEquals(true, isSettingsDisplayed);

		// What's New
		WebElement whatsNewOption = driver.findElementByAccessibilityId("What's New");
		boolean isWhatsNewDisplayed = whatsNewOption.isDisplayed();
		Assert.assertEquals(true, isWhatsNewDisplayed);

		// About
		WebElement aboutOption = driver.findElementByAccessibilityId("About");
		boolean isAboutDisplayed = aboutOption.isDisplayed();
		Assert.assertEquals(true, isAboutDisplayed);

		// Terms and conditions
		WebElement termsAndConditions = driver.findElementByAccessibilityId("Terms & Conditions");
		boolean isTerms = termsAndConditions.isDisplayed();
		Assert.assertEquals(true, isTerms);

		driver.scrollToExact("Privacy Policy");

		// Privacy Policy
		WebElement privacyPolicy = driver.findElementByAccessibilityId("Privacy Policy");
		boolean isPrivacy = privacyPolicy.isDisplayed();
		Assert.assertEquals(true, isPrivacy);

	}

	@BeforeClass
	public void setUp() {

		// set up appium
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
