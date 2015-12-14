/**
 * The Location program is used to test the selection, attachment and sending of the user's current location
 * 
 * *
 * @author  Guruprasad B. Gopinath
 * @version 1.0
 * @since   2015-09-01 
 */
package test.com.test.appium;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

public class Location extends SupportSetUp {

	@Test
	public void sendLocation() throws Exception {

		try {

			WebElement compose = driver.findElement(By.id(configuredCapabilities.getCOMPOSE_LAYOUT()));
			compose.click();

			WebElement to = driver.findElement(By.id(configuredCapabilities.getCURRECIP()));
			to.sendKeys(configuredCapabilities.getMDN());

			WebElement attach = driver.findElement(By.id(configuredCapabilities.getBTNATTACH()));
			attach.click();

			WebElement location = driver.findElement(By.name("Location"));
			location.click();

			/*
			 * (new WebDriverWait(driver, 10))
			 * .until(ExpectedConditions.presenceOfElementLocated(By.id(
			 * "com.verizon.messaging.vzmsgs:id/positive_button")));
			 */
			WebElement confirmImproveLocation = driver.findElementById(configuredCapabilities.getPOSITIVE_BUTTON());
			confirmImproveLocation.click();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			WebElement attachBtn = driver.findElementById(configuredCapabilities.getATTACHBUTTON());
			attachBtn.click();
			//

			WebElement sendButton = driver.findElement(By.id(configuredCapabilities.getBTNSEND()));
			sendButton.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void setUp() {
		capabilities.setCapability(APIConstants.NORESET, configuredCapabilities.getNORESET());
		try {
			super.setUp();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	@AfterClass
	public void afterClass() {
	}

}
