/**
 * The RestoreMessages program is used to test whether messages can be restored
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

import junit.framework.Assert;

public class RestoreMessages extends SupportSetUp {

	@Test
	public void clickRestoreMessages() {
		//
		WebElement drawerIcon = driver.findElementById(configuredCapabilities.getDRAWER_ICON());
		drawerIcon.click();

		WebElement RestoreMessages = driver.findElementByAccessibilityId("Restore Messages");
		RestoreMessages.click();

		WebElement restoreDialog = driver.findElementById(configuredCapabilities.getDIALOG_TITLE());
		boolean isRestoreDialogDisplayed = restoreDialog.isDisplayed();
		Assert.assertEquals(true, isRestoreDialogDisplayed);

		WebElement restoreFromSDCardOption = driver.findElementById(configuredCapabilities.getNEGATIVE_BUTTON());
		restoreFromSDCardOption.click();

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
