/**
* The ReplyText program is used to test a reply to a message
*
* @author  Guruprasad B. Gopinath
* @version 1.0
* @since   2015-09-01 
*/

package test.com.test.appium;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

import io.appium.java_client.TouchAction;

public class ReplyText extends SupportSetUp {

	@Test
	public void replyToAMessage() {
		try {
			(new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(By.name("Synchronoss Shivaprasad")));

			WebElement selectConversation = driver.findElement(By.name("Synchronoss Shivaprasad"));
			selectConversation.click();
			TouchAction tAction = new TouchAction(driver);
			tAction.tap(driver.findElement(By.name("Synchronoss Shivaprasad"))).perform();

			WebElement replyMessage = driver.findElement(By.id(configuredCapabilities.getEMBEDDED_TEXT_EDITOR()));
			replyMessage.sendKeys("This is a test Reply");

			// WebElement sendBtn =
			// driver.findElement(By.id("com.verizon.messaging.vzmsgs:id/btnSend"));
			// sendBtn.click();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@BeforeClass
	public void setUp() {
		capabilities.setCapability(APIConstants.NORESET, configuredCapabilities.getNORESET());
		capabilities.setCapability("newCommandTimeout", 60 * 5);
		try {
			super.setUp();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterClass
	public void afterClass() {
	}

}