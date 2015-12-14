/**
 * The ResetToDefault program is used to test whether the changes made to the customization Options can be reset
 * 
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

public class ResetToDefault extends SupportSetUp {

	@Test
	public void clickResetToDefault() {
		WebElement convGalleryOption = driver.findElementById(configuredCapabilities.getIMGCONVGALLERYOPTION());
		convGalleryOption.click();

		WebElement customizeMenuBtn = driver.findElementByName("Customize");
		customizeMenuBtn.click();

		driver.scrollToExact("Reset to Default");

		WebElement currentDefaultMessage = driver.findElementByName("Clears all user set customization.");
		String currentDefaultMessageTxt = currentDefaultMessage.getText();
		Assert.assertEquals(currentDefaultMessageTxt, "Clears all user set customization.");

		WebElement resetToDefaultOption = driver.findElementByName("Reset to Default");
		resetToDefaultOption.click();

		WebElement headerResetToDefault = driver.findElementById(configuredCapabilities.getDIALOG_TITLE());
		String headerResetToDefaultTxt = headerResetToDefault.getText();
		Assert.assertEquals(headerResetToDefaultTxt, "Reset to Default");

		WebElement headerResetMessage = driver.findElementById(configuredCapabilities.getDIALOG_MESSAGE());
		String headerResetMessageTxt = headerResetMessage.getText();
		Assert.assertEquals(headerResetMessageTxt, "Are you sure you want to continue?");

		WebElement selectOKBtn = driver.findElementById(configuredCapabilities.getPOSITIVE_BUTTON());
		selectOKBtn.click();

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
