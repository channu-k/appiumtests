/**
* The ChangeBackGround program is used to test the change of Background  
* 
* *
* @author  Guruprasad B. Gopinath
* @version 1.0
* @since   2015-09-01 
*/

package test.com.test.appium;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

import io.appium.java_client.TouchAction;

public class ChangeBackground extends SupportSetUp {

	@Test
	public void clickChangeBackGround() {
		WebElement convGalleryOption = driver.findElementById(configuredCapabilities.getIMGCONVGALLERYOPTION());
		convGalleryOption.click();

		WebElement customizeMenuBtn = driver.findElementByName("Customize");
		customizeMenuBtn.click();

		WebElement backGrounds = driver.findElementById(configuredCapabilities.getCUSTOMIZ_NAME());
		backGrounds.click();

		List<WebElement> identifyTile = driver.findElementsByClassName(configuredCapabilities.getRELATIVE_LAYOUT());

		// Tap on one of the tiles to change the background
		TouchAction selectBackGroundTile = new TouchAction(driver);
		selectBackGroundTile.tap(500, 1050).perform();

		// selectBackGroundTile.longPress(identifyTile, 500, 1100).perform();

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
