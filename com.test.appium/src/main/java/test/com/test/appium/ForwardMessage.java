/**
* The ForwardMessage program is used to test forwarding of a message
*
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

public class ForwardMessage extends SupportSetUp {

	@Test
	public void forwardMessage() {
		try {
			// Click on Compose button
			WebElement composeBtn = driver.findElement(By.id(configuredCapabilities.getCOMPOSE_LAYOUT()));
			composeBtn.click();

			// Enter Recipient mobile number
			WebElement to = driver.findElement(By.id(configuredCapabilities.getCURRECIP()));
			to.sendKeys(configuredCapabilities.getMDN());
			to.click();

			// Message to be sent with a random number for better identification

			Random r = new Random();

			String s1 = r.nextInt(10000) + " This is a test for forwarding a message";

			WebElement messageBox = driver.findElement(By.id(configuredCapabilities.getEMBEDDED_TEXT_EDITOR()));
			messageBox.sendKeys(s1);

			WebElement sendButton = driver.findElement(By.id(configuredCapabilities.getBTNSEND()));
			sendButton.click();

			driver.hideKeyboard();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// WebElement msgToBeForwarded = driver.findElementByName("Text1");

			List<WebElement> msgTobeForwarded = driver.findElementsById(configuredCapabilities.getTEXT());

			for (int i = 0; i < msgTobeForwarded.size(); i++) {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				if (msgTobeForwarded.get(i).getAttribute("text").equals(s1)) {
					TouchAction tAction = new TouchAction(driver);
					tAction.longPress(msgTobeForwarded.get(i)).perform();

					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

				}
			}

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			WebElement selectOption = driver.findElement(By.name("Forward Message"));
			selectOption.click();

			// WebElement replyMessage =
			// driver.findElement(By.id("com.verizon.messaging.vzmsgs:id/embedded_text_editor"));
			// replyMessage.sendKeys("This is a test Reply");

			WebElement toField = driver.findElementById(configuredCapabilities.getCURRECIP());
			toField.sendKeys(configuredCapabilities.getMDN());
			toField.click();

			WebElement sendBtn = driver.findElement(By.id(configuredCapabilities.getBTNSEND()));
			sendBtn.click();

		}

		catch (Exception e)

		{
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