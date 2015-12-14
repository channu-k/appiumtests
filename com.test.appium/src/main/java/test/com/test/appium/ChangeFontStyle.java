/**
 * The ChangeFontStyle program is used to test the change of font style for a conversation Bubble  
 * 
 * *
 * @author  Guruprasad B. Gopinath
 * @version 1.0
 * @since   2015-09-01 
 */

package test.com.test.appium;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

public class ChangeFontStyle extends SupportSetUp {

	@Test
	public void changeFontStyle() {
		WebElement convGalleryOption = driver.findElementById(configuredCapabilities.getIMGCONVGALLERYOPTION());
		convGalleryOption.click();

		WebElement customizeMenuBtn = driver.findElementByName("Customize");
		customizeMenuBtn.click();

		WebElement fontOption = driver.findElementByName("Font");
		fontOption.click();

		// Uncheck the existing default font style
		WebElement changeFontStyle = driver.findElementById(configuredCapabilities.getDEFAULTFONTSTYLE());
		String isUseDefaultFontStyleChecked = changeFontStyle.getAttribute("checked");
		changeFontStyle.click();

		// Select the font style Sketch block bold
		WebElement fontStyle = driver.findElementByAccessibilityId("SKETCH_BLOCK_BOLD");
		fontStyle.click();

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
