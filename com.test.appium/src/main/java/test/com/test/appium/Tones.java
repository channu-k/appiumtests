package test.com.test.appium;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

public class Tones extends SupportSetUp{


	@Test
	public void viewTonesScreen() {
		WebElement convGalleryOption = driver.findElementById(configuredCapabilities.getIMGCONVGALLERYOPTION());
		convGalleryOption.click();

		WebElement customizeMenuBtn = driver.findElementByName("Customize");
		customizeMenuBtn.click();

		WebElement tonesOption = driver.findElementByName("Tones");
		tonesOption.click();

		// Header
		WebElement headerTones = driver.findElementById(configuredCapabilities.getALERTTITLE());
		String headerTonesTxt = headerTones.getText();
		Assert.assertEquals(headerTonesTxt, "Pick notification tone");

		WebElement selectOKButton = driver.findElementById(configuredCapabilities.getBUTTON1());
		selectOKButton.click();

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
