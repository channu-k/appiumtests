/**
 * The FontScreen program is used to test presence and enabling of default elements such as Header, SubHeader and the 
 * checking of boxes of default font size and style
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

public class FontScreen extends SupportSetUp {

	@Test
	public void viewFontScreen() {
		WebElement convGalleryOption = driver.findElementById(configuredCapabilities.getIMGCONVGALLERYOPTION());
		convGalleryOption.click();

		WebElement customizeMenuBtn = driver.findElementByName("Customize");
		customizeMenuBtn.click();

		WebElement fontOption = driver.findElementByName("Font");
		fontOption.click();

		// Header
		WebElement fontScreenHeader = driver.findElementById(configuredCapabilities.getHEADERTEXT());
		String fontScreenHeaderTxt = fontScreenHeader.getText();
		Assert.assertEquals(fontScreenHeaderTxt, "All Conversations");

		WebElement fontScreenSubHeader = driver.findElementById(configuredCapabilities.getSUBHEADERTEXT());
		String fontScreenSubHeaderTxt = fontScreenSubHeader.getText();
		Assert.assertEquals(fontScreenSubHeaderTxt, "Manage Font");

		WebElement useDefaultFontSize = driver.findElementById(configuredCapabilities.getDEFAULTFONTSIZE());
		boolean isUseDefaultFontSizeChecked = useDefaultFontSize.isEnabled();
		Assert.assertEquals(isUseDefaultFontSizeChecked, true);

		WebElement useDefaultFontStyle = driver.findElementById(configuredCapabilities.getDEFAULTFONTSTYLE());
		boolean isUseDefaultFontStyleChecked = useDefaultFontStyle.isEnabled();
		Assert.assertEquals(isUseDefaultFontStyleChecked, true);

		WebElement backBtn = driver.findElementById(configuredCapabilities.getUPBUTTON());
		if (backBtn.isDisplayed() && backBtn.isEnabled()) {
			backBtn.click();
		}

		else {
			System.out.println("Back button is either disabled or not displayed");

		}

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
