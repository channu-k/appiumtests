
/**
* The BackGroundsScreen program is used to test BackgroundScreen option in customization
* This test script focuses on the display of text and the enabling of message components
* *
* @author  Guruprasad B. Gopinath
* @version 1.0
* @since   2015-09-01 
*/

package test.com.test.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

import io.appium.java_client.android.AndroidDriver;

public class BackGroundsScreen extends SupportSetUp {

	// app-activity - application activity to fetched by the device by
	// connecting the device to
	// the

	@Test
	public void viewBackGroundsScreen() {
		WebElement convGalleryOption = driver.findElementById(configuredCapabilities.getIMGCONVGALLERYOPTION());
		convGalleryOption.click();

		// Locate and click on the customize menu
		WebElement customizeMenuBtn = driver.findElementByName("Customize");
		customizeMenuBtn.click();

		WebElement backGrounds = driver.findElementById(configuredCapabilities.getCUSTOMIZ_NAME());
		backGrounds.click();

		// Verify the text of the Header
		WebElement backGroundHeader = driver.findElementById(configuredCapabilities.getHEADERTEXT());
		String backGroundHeaderTxt = backGroundHeader.getText();
		Assert.assertEquals(backGroundHeaderTxt, "All Conversations");

		// Verify the text of the SubHeader
		WebElement backgroundSubHeader = driver.findElementById(configuredCapabilities.getSUBHEADERTEXT());
		String backGroundSubHeaderTxt = backgroundSubHeader.getText();
		Assert.assertEquals(backGroundSubHeaderTxt, "Backgrounds");

		// Verify if the From field is displayed
		WebElement fromField = driver.findElementById(configuredCapabilities.getFROM());
		boolean isFromFieldDisplayed = fromField.isDisplayed();
		Assert.assertEquals(isFromFieldDisplayed, true);

		// Verify if the Subject field is displayed
		WebElement subjectField = driver.findElementById(configuredCapabilities.getSUBJECT());
		boolean isSubjectFieldDisplayed = subjectField.isDisplayed();
		Assert.assertEquals(isSubjectFieldDisplayed, true);

		// Verify if the unread counter is displayed
		WebElement unreadCountField = driver.findElementById(configuredCapabilities.getUNREADCOUNT());
		boolean isUnreadCountFieldDisplayed = unreadCountField.isDisplayed();
		Assert.assertEquals(isUnreadCountFieldDisplayed, true);

		// Verify if the date field is displayed
		WebElement dateField = driver.findElementById(configuredCapabilities.getDATE());
		boolean isDateFieldDisplayed = dateField.isDisplayed();
		Assert.assertEquals(isDateFieldDisplayed, true);

		// Verify if theBackbuton is displayed and enabled
		WebElement backBtn = driver.findElementById(configuredCapabilities.getUPBUTTON());
		if (backBtn.isDisplayed() && backBtn.isEnabled()) {
			backBtn.click();

		}

		else {
			System.out.println("Display button is either disabled or not displayed");

		}

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
