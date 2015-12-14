/**
 * The ChangeFontSize program is used to test the change of Font Size for a conversation Bubble  
 * 
 * *
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

import io.appium.java_client.TouchAction;

public class ChangeFontSize extends SupportSetUp {

	@Test
	public void changeFontSize() {
		WebElement convGalleryOption = driver.findElementById(configuredCapabilities.getIMGCONVGALLERYOPTION());
		convGalleryOption.click();

		WebElement customizeMenuBtn = driver.findElementByName("Customize");
		customizeMenuBtn.click();

		WebElement fontOption = driver.findElementByName("Font");
		fontOption.click();

		// Header

		WebElement useDefaultFontSize = driver.findElementById(configuredCapabilities.getDEFAULTFONTSIZE());

		// get the position and size of the slider
		WebElement changeFontSizeSlider = driver.findElementById(configuredCapabilities.getSEEKBAR());
		int xAxisStartPoint = changeFontSizeSlider.getLocation().getX();
		int width = changeFontSizeSlider.getSize().getWidth();
//		System.out.println("The Width is " + width);
		int xAxisEndPoint = xAxisStartPoint + changeFontSizeSlider.getSize().getWidth();
//		System.out.println("The start point is " + xAxisStartPoint);
//		System.out.println("The end point is " + xAxisEndPoint);

		int yAxis = changeFontSizeSlider.getLocation().getY();
//		System.out.println("The y axis " + yAxis);

		useDefaultFontSize.click();
		yAxis += 56;
		TouchAction act = new TouchAction(driver);
		act.longPress(changeFontSizeSlider, 704, 1000).perform();

		WebElement useDefaultFontStyle = driver.findElementById(configuredCapabilities.getDEFAULTFONTSTYLE());
		String isUseDefaultFontStyleChecked = useDefaultFontStyle.getAttribute("checked");
		Assert.assertEquals(isUseDefaultFontStyleChecked, "true");

		WebElement backBtn = driver.findElementById(configuredCapabilities.getUPBUTTON());
		if (backBtn.isDisplayed() && backBtn.isEnabled()) {
			backBtn.click();

		}

		else {

			System.out.println("Back button is either disabled or not displayed");

		}

		// com.verizon.messaging.vzmsgs:id/upButton

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
