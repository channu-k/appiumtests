
/**
* The About program is used to test the availability of the About Option
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

public class About extends SupportSetUp {

	private static String ABOUT = "About";

	@Test
	public void clickAbout() {

		WebElement drawerIcon = driver.findElementById(configuredCapabilities.getDRAWER_ICON());
		drawerIcon.click();

		WebElement aboutOption = driver.findElementByAccessibilityId(ABOUT);
		aboutOption.click();

		String str = configuredCapabilities.getDIALOG_TITLE();
		str.toCharArray();

		WebElement aboutDialog = driver.findElementById(configuredCapabilities.getDIALOG_TITLE());
		boolean isaboutDialogDisplayed = aboutDialog.isDisplayed();
		Assert.assertEquals(true, isaboutDialogDisplayed);

		if (isaboutDialogDisplayed) {
			WebElement OkBtn = driver.findElementById(configuredCapabilities.getPOSITIVE_BUTTON());
			OkBtn.click();
		}

		else {
			System.out.println("No About Dialog displayed");
		}
		driver.closeApp();
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
		driver.quit();
	}
}