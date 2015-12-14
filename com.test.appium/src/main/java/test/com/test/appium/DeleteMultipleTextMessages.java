/**
 * The DeleteMultipleMessages program is used to test the deletion of a multiple text messages sent to a single recipient
 * 
 * *
 * @author  Guruprasad B. Gopinath
 * @version 1.0
 * @since   2015-09-01 
 */

package test.com.test.appium;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

import io.appium.java_client.TouchAction;

public class DeleteMultipleTextMessages extends SupportSetUp {

	@Test
	public void deleteMultipleMessages() throws Exception {
		/*
		 * // WebElement conversation = driver.findElementByName(
		 * "Synchronoss Shivaprasad"); //conversation.click();
		 * 
		 * //Click on Compose button WebElement composeBtn =
		 * driver.findElement(By.id(
		 * "com.verizon.messaging.vzmsgs:id/composebutton"));
		 * composeBtn.click();
		 * 
		 * // Enter the recipient WebElement to =
		 * driver.findElement(By.id("com.verizon.messaging.vzmsgs:id/curRecip"))
		 * ; to.sendKeys("9253248931"); to.click();
		 * 
		 * 
		 * 
		 * // Message to be sent with a random number for better identification
		 * 
		 * Random r = new Random(); String[] messages = new String[2];
		 * 
		 * for (int i = 0; i < messages.length; i++) { messages[i] =
		 * r.nextInt(10000) + " Test msg"; WebElement messageBox =
		 * driver.findElement(By.id(
		 * "com.verizon.messaging.vzmsgs:id/embedded_text_editor"));
		 * messageBox.click(); messageBox.sendKeys(messages[i]);
		 * 
		 * WebElement sendButton =
		 * driver.findElement(By.id("com.verizon.messaging.vzmsgs:id/btnSend"));
		 * sendButton.click();
		 * 
		 * }
		 * 
		 * 
		 * driver.hideKeyboard(); driver.manage().timeouts().implicitlyWait(30,
		 * TimeUnit.SECONDS);
		 * 
		 */

		WebElement conversation = driver.findElementByName("Nexus 1");
		conversation.click();

		List<WebElement> optionBtn = driver.findElementsById(configuredCapabilities.getMSG_LIST_ITEM());
		int sizeOfRelativeLayout = optionBtn.size();
		int a = optionBtn.lastIndexOf(optionBtn);

		/*
		 * System.out.printf("The last index is %d", sizeOfRelativeLayout);
		 * System.out.printf("The size of the message Id is %d",
		 * sizeOfRelativeLayout);
		 */

		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		TouchAction tAction = new TouchAction(driver);
		tAction.longPress(optionBtn.get(optionBtn.size() - 1), 5000, a).perform();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement messageOptions = driver.findElement(By.name("Delete messages"));
		messageOptions.click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		List<WebElement> el = driver.findElementsById("com.verizon.messaging.vzmsgs:id/checkBox");

		System.out.println(el.size());
		el.get(el.size() - 2).click();

		WebElement deleteBtn = driver.findElementById(configuredCapabilities.getDELETE_BTN());
		deleteBtn.click();

		WebElement confirmDelete = driver.findElementById(configuredCapabilities.getPOSITIVE_BUTTON());
		confirmDelete.click();

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
