/**
 * The LedColor program is used to verify the presence and enabling of GUI elements
 *
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

public class ChangeLEDColor extends SupportSetUp{


	@Test
	public void viewLEDColorScreen() {
		WebElement convGalleryOption = driver.findElementById(configuredCapabilities.getIMGCONVGALLERYOPTION());
		convGalleryOption.click();

		WebElement customizeMenuBtn = driver.findElementByName("Customize");
		customizeMenuBtn.click();

		WebElement ledColorOption = driver.findElementByName("LED Color");
		ledColorOption.click();

		List<WebElement> selectLedColor = driver.findElementsById(configuredCapabilities.getCOLORCIRCLETEXTVIEW());
		selectLedColor.get(2).click();

		WebElement selectSaveBtn = driver.findElementById(configuredCapabilities.getPOSITIVE_BUTTON());
		selectSaveBtn.click();

		// Assert.assertEquals(currentDefaultLedColor, selectLedColor);

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
		driver.quit();
	}
}
