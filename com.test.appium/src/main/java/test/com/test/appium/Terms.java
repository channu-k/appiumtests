/**
 * The Terms program is used to test the presence of GUI elements and if the Terms dialog is displayed
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

public class Terms extends SupportSetUp {

	/*
	 * private TouchAction tContacts; private WebElement TouchAction;
	 */
	@Test
	public void clickTerms() {
		//
		WebElement drawerIcon = driver.findElementById(configuredCapabilities.getDRAWER_ICON());
		drawerIcon.click();

		WebElement termsOption = driver.findElementByAccessibilityId("Terms & Conditions");
		termsOption.click();

		WebElement termsDialog = driver.findElementById(configuredCapabilities.getDIALOG_TITLE());
		boolean isTermsDialogDisplayed = termsDialog.isDisplayed();
		Assert.assertEquals(true, isTermsDialogDisplayed);

		if (isTermsDialogDisplayed) {
			WebElement OkBtn = driver.findElementById(configuredCapabilities.getPOSITIVE_BUTTON());
			OkBtn.click();
		}

		else {
			System.out.println("No Terms Dialog displayed");
		}

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
