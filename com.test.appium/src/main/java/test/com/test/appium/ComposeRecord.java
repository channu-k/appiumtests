/**
 * The ComposeRecord program is used to test the sending of a recording to a single recipient
 * 
 * *
 * @author  Guruprasad B. Gopinath
 * @version 1.0
 * @since   2015-09-01 
 */

package test.com.test.appium;

import java.net.MalformedURLException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

import io.appium.java_client.TouchAction;

@Test
public class ComposeRecord extends SupportSetUp {
	public void composeRecording() {

		// Click on Compose button
		WebElement composeBtn = driver.findElement(By.id(configuredCapabilities.getCOMPOSE_LAYOUT()));
		composeBtn.click();

		// Enter Recipient mobile number
		WebElement to = driver.findElement(By.id(configuredCapabilities.getCURRECIP()));
		to.sendKeys(configuredCapabilities.getMDN());
		to.click();

		// Message to be sent with a random number for better identification

		Random r = new Random();

		// String s1 = r.nextInt(10000) + " This is a Compose message test";
		// System.out.println(s1);
		WebElement messageBox = driver.findElement(By.id(configuredCapabilities.getEMBEDDED_TEXT_EDITOR()));
		messageBox.click();

		TouchAction tapOnMic = new TouchAction(driver);
		tapOnMic.longPress(driver.findElementById(configuredCapabilities.getBTNSEND()), 10000, 0).release().perform();

		WebElement sendButton = driver.findElement(By.id(configuredCapabilities.getBTNSEND()));
		sendButton.click();

	}

	@BeforeClass
	public void setUp() {
		capabilities.setCapability(APIConstants.NORESET, configuredCapabilities.getNORESET());
		try {
			super.setUp();
			capabilities.setCapability("newCommandTimeout", 60 * 3);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterClass
	public void tearDown() {
		boolean hasQuit = (driver.toString().contains("(null)")) ? true : false;

		driver.quit();
	}
}
