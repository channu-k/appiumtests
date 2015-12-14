/**
 * The LedColor program is used to verify the presence and enabling of GUI elements
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

public class LedColor extends SupportSetUp{


	@Test
	public void viewLEDColorScreen() {
		WebElement convGalleryOption = driver.findElementById(configuredCapabilities.getIMGCONVGALLERYOPTION());
		convGalleryOption.click();

		WebElement customizeMenuBtn = driver.findElementByName("Customize");
		customizeMenuBtn.click();
		/// LED color needs to be re written go through relative layout and spot
		/// led color and then go to the index which shows the default color

		/*
		 * List<WebElement> el = driver.findElementsById(
		 * "com.verizon.messaging.vzmsgs:id/customiz_name");
		 * System.out.println(el.get(5));
		 * 
		 * 
		 * 
		 * List <WebElement> currentDefaultLedColor =
		 * driver.findElementsByClassName("android.widget.RelativeLayout"); //
		 * String currentDefaultLedColorTxt =
		 * currentDefaultLedColor.get(5).getText();
		 * 
		 * System.out.println(currentDefaultLedColor.get(5).getText());
		 * 
		 * //sysout(com.verizon.messaging.vzmsgs:id/customiz_name)
		 * 
		 * Assert.assertEquals(currentDefaultLedColor, "Green");
		 */

		WebElement ledColorOption = driver.findElementByName("LED Color");
		ledColorOption.click();

		// Header
		WebElement headerLedColors = driver.findElementById(configuredCapabilities.getDIALOG_TITLE());
		String headerLedColorsTxt = headerLedColors.getText();
		Assert.assertEquals(headerLedColorsTxt, "LED Color");

		WebElement subHeaderLedColors = driver.findElementById(configuredCapabilities.getDIALOG_SUB_TITLE());
		String subHeaderLedColorsTxt = subHeaderLedColors.getText();
		Assert.assertEquals(subHeaderLedColorsTxt, "Select an option from below:");

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
