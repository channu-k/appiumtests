
/**
* The About program is used to test the availability of the About Option
*
* @author  Guruprasad B. Gopinath
* @version 1.0
* @since   2015-09-01 
*/

package Test.com.test.appium;

import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;
import com.verizon.utility.ConfiguredCapabilities;
import com.verizon.utility.HandlerUtility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class About {

	AppiumDriver driver;
	ConfiguredCapabilities loadedCapabilities;
	private static String ABOUT = "About";

	@Test
	public void clickAbout() {

		WebElement drawerIcon = driver.findElementById(loadedCapabilities.getDRAWER_ICON());
		drawerIcon.click();

		WebElement aboutOption = driver.findElementByAccessibilityId(ABOUT);
		aboutOption.click();

		String str = loadedCapabilities.getDIALOG_TITLE();
		str.toCharArray();

		WebElement aboutDialog = driver.findElementById(loadedCapabilities.getDIALOG_TITLE());
		boolean isaboutDialogDisplayed = aboutDialog.isDisplayed();
		Assert.assertEquals(true, isaboutDialogDisplayed);

		if (isaboutDialogDisplayed) {
			WebElement OkBtn = driver.findElementById(loadedCapabilities.getPOSITIVE_BUTTON());
			OkBtn.click();
		}

		else {
			System.out.println("No About Dialog displayed");
		}
		driver.closeApp();
	}

	@BeforeClass
	public void setUp() throws Exception {

		// set up appium

		DesiredCapabilities capabilities = new DesiredCapabilities();
		loadedCapabilities = HandlerUtility.getCapabilities();
		capabilities.setCapability(APIConstants.DEVICE, loadedCapabilities.getDEVICE());
		capabilities.setCapability(APIConstants.PLATFORMNAME, loadedCapabilities.getPLATFORM_NAME());
		capabilities.setCapability(APIConstants.DEVICENAME, loadedCapabilities.getDEVICE_NAME());
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability(CapabilityType.VERSION, loadedCapabilities.getVERSION());
		capabilities.setCapability(CapabilityType.PLATFORM, loadedCapabilities.getPLATFORM());
		capabilities.setCapability(APIConstants.NORESET, loadedCapabilities.getNORESET());
		capabilities.setCapability(APIConstants.APP, loadedCapabilities.getFILE_PATH());
		capabilities.setCapability(APIConstants.APP_PACKAGE, loadedCapabilities.getAPP_PACKAGE());
		capabilities.setCapability(APIConstants.APP_ACTIVITY, loadedCapabilities.getAPP_ACTIVITY()); // my

		// RootActivity

		driver = new AndroidDriver(new URL(loadedCapabilities.getURL()), capabilities);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}