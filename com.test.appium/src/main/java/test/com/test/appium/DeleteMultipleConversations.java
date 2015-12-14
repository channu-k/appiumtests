/**
* The Delete Multiple Conversations program deletes multiple conversations
* 
* *
* @author  Guruprasad B. Gopinath
* @version 1.0
* @since   2015-09-01 
*/

package test.com.test.appium;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

public class DeleteMultipleConversations extends SupportSetUp {

	@Test
	public void deleteMultipleConversations() {

		/*
		 * //Click on Compose button WebElement composeBtn =
		 * driver.findElement(By.id(
		 * "com.verizon.messaging.vzmsgs:id/compose_layout"));
		 * composeBtn.click();
		 * 
		 * // Enter Recipient mobile number WebElement to =
		 * driver.findElement(By.id("com.verizon.messaging.vzmsgs:id/curRecip"))
		 * ; to.sendKeys("prashanth.nrao86@gmail.com"); to.click();
		 * 
		 * // Message to be sent with a random number for better identification
		 * 
		 * Random r = new Random();
		 * 
		 * String s1 = r.nextInt(10000) + " This is a Delete Conversation test";
		 * System.out.println(s1);
		 * 
		 * WebElement messageBox = driver.findElement(By.id(
		 * "com.verizon.messaging.vzmsgs:id/embedded_text_editor"));
		 * messageBox.sendKeys(s1);
		 * 
		 * WebElement sendButton =
		 * driver.findElement(By.id("com.verizon.messaging.vzmsgs:id/btnSend"));
		 * sendButton.click();
		 * 
		 * WebElement backBtn = driver.findElementById(
		 * "com.verizon.messaging.vzmsgs:id/back_conv_ico"); backBtn.click();
		 * 
		 * 
		 * (new WebDriverWait(driver, 20))
		 * .until(ExpectedConditions.presenceOfElementLocated(By.id(
		 * "com.verizon.messaging.vzmsgs:id/avatar")));
		 * 
		 * 
		 */
		// Select 2 avatars
		List<WebElement> avatar = driver.findElementsById(configuredCapabilities.getAVATAR());
		avatar.get(5).click();
		avatar.get(6).click();

		WebElement deleteBtn = driver.findElementById(configuredCapabilities.getDELETEBTN());
		deleteBtn.click();

		(new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id(configuredCapabilities.getPOSITIVE_BUTTON())));

		WebElement deleteConfirmation = driver.findElementById(configuredCapabilities.getPOSITIVE_BUTTON());
		deleteConfirmation.click();

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