package test.com.test.appium;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

public class ChangeTones extends SupportSetUp {

	@Test
	public void changeTone() {
		WebElement convGalleryOption = driver.findElementById(configuredCapabilities.getIMGCONVGALLERYOPTION());
		convGalleryOption.click();

		WebElement customizeMenuBtn = driver.findElementByName("Customize");
		customizeMenuBtn.click();

		WebElement tonesOption = driver.findElementByName("Tones");
		tonesOption.click();

		// Select a tone from the list
		List<WebElement> toneList = driver.findElementsById(configuredCapabilities.getTEXT1());
		toneList.get(5).click();

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
		driver.quit();
	}
}