
/**
 * The DeleteSMS program is used to test the deletion of a simple text message to a single recipient
 * 
 * *
 * @author  Guruprasad B. Gopinath
 * @version 1.0
 * @since   2015-09-01 
 */

package test.com.test.appium;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

import io.appium.java_client.TouchAction;

public class DeleteSMS extends SupportSetUp {
	@Test
	public void deleteSMS() {

		// Click on Compose button
		WebElement composeBtn = driver.findElement(By.id(configuredCapabilities.getCOMPOSEBUTTON()));
		// composeBtn.click();

		// Message to be sent with a random number for better identification

		Random r = new Random();
		String message = new String();

		message = r.nextInt(10000) + " Test msg";

		// System.out.println(s1);

		// Send 3 messages back-to-back

		composeBtn.click();
		WebElement to = driver.findElement(By.id(configuredCapabilities.getCURRECIP()));
		to.sendKeys(configuredCapabilities.getMDN());
		to.click();

		WebElement messageBox = driver.findElement(By.id(configuredCapabilities.getEMBEDDED_TEXT_EDITOR()));
		messageBox.click();
		messageBox.sendKeys(message);

		WebElement sendButton = driver.findElement(By.id(configuredCapabilities.getBTNSEND()));
		sendButton.click();

		driver.hideKeyboard();

		// Identify messages in the conversation
		List<WebElement> el = driver.findElementsById(configuredCapabilities.getTEXT());
		for (int k = 0; k < el.size(); k++) {
			if (el.get(k).getText().equalsIgnoreCase(message)) {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				TouchAction tAction = new TouchAction(driver);
				tAction.longPress(el.get(k)).perform();

				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

				WebElement messageOptions = driver.findElement(By.name("Delete messages"));
				messageOptions.click();

				WebElement deleteBtn = driver.findElementById(configuredCapabilities.getDELETE_BTN());
				deleteBtn.click();

				WebElement confirmDelete = driver.findElementById(configuredCapabilities.getPOSITIVE_BUTTON());
				confirmDelete.click();

			}

			// Tap on the latest message

			// TouchAction tAction = new TouchAction(driver);
			// tAction.longPress(el.get(el.size()-1)).perform();

			/*
			 * WebElement messageOptions = driver.findElement(By.name(
			 * "Delete messages")); messageOptions.click();
			 * 
			 * WebElement deleteBtn = driver.findElementById(
			 * "com.verizon.messaging.vzmsgs:id/delete_btn"); deleteBtn.click();
			 * 
			 * WebElement confirmDelete = driver.findElementById(
			 * "com.verizon.messaging.vzmsgs:id/positive_button");
			 * confirmDelete.click();
			 */

		}

	}

	@BeforeClass
	public void setUp() {

		capabilities.setCapability(APIConstants.NORESET, configuredCapabilities.getNORESET());
		try {
			super.setUp();
			capabilities.setCapability("newCommandTimeout", 60 * 5);
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
