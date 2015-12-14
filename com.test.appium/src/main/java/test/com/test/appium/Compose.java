/**
* The Compose program is used to test the sending of a simple text message to a single recipient
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

@Test
public class Compose extends SupportSetUp {

	public void composeMessage() {

		// Click on Compose button
		WebElement composeBtn = driver.findElement(By.id(configuredCapabilities.getCOMPOSE_LAYOUT()));
		composeBtn.click();

		// Enter Recipient mobile number
		WebElement to = driver.findElement(By.id(configuredCapabilities.getCURRECIP()));
		to.sendKeys(configuredCapabilities.getMDN());
		to.click();

		// Message to be sent with a random number for better identification

		Random r = new Random();

		String s1 = r.nextInt(10000) + " This is a Compose message test";
//		System.out.println(s1);

		WebElement messageBox = driver.findElement(By.id(configuredCapabilities.getEMBEDDED_TEXT_EDITOR()));
		messageBox.sendKeys(s1);

		WebElement sendButton = driver.findElement(By.id(configuredCapabilities.getBTNSEND()));
		sendButton.click();

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
	public void tearDown() {
		boolean hasQuit = (driver.toString().contains("(null)")) ? true : false;

		driver.quit();
	}
}
