
/**
 * The DeleteLockedMessage program is used to test the deletion of a locked text message to a single recipient
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

public class DeleteLockedMessage extends SupportSetUp {
	@Test
	public void deleteLockedSMS() {
		// Click on Compose button
		WebElement composeBtn = driver.findElement(By.id(configuredCapabilities.getCOMPOSE_LAYOUT()));
		composeBtn.click();

		// Enter Recipient mobile number
		WebElement to = driver.findElement(By.id(configuredCapabilities.getCURRECIP()));
		to.sendKeys(configuredCapabilities.getMDN());
		to.click();

		// Message to be sent with a random number for better identification

		// for (int i = 0; i < 3; i++){
		Random r = new Random();

		String s1 = r.nextInt(10000) + " This is a test to delete a locked message";
//		System.out.println(s1);

		WebElement messageBox = driver.findElement(By.id(configuredCapabilities.getEMBEDDED_TEXT_EDITOR()));
		messageBox.sendKeys(s1);

		WebElement sendButton = driver.findElement(By.id(configuredCapabilities.getBTNSEND()));
		sendButton.click();

		driver.hideKeyboard();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		List<WebElement> el = driver.findElementsById(configuredCapabilities.getTEXT());

		TouchAction tAction = new TouchAction(driver);
		tAction.longPress(el.get(el.size() - 1)).perform();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement lockMsg = driver.findElement(By.name("Lock message"));
		lockMsg.click();

		TouchAction locateLockedMsg = new TouchAction(driver);
		locateLockedMsg.longPress(driver.findElementById(configuredCapabilities.getLOCKMSG()), 3000, 0).perform();

		WebElement deleteOption = driver.findElement(By.name("Delete messages"));
		deleteOption.click();

		WebElement deleteBtn = driver.findElementById(configuredCapabilities.getDELETE_BTN());
		deleteBtn.click();

		WebElement confirmDeleteLockedMessage = driver.findElementById(configuredCapabilities.getDELETE_LOCKED());
		confirmDeleteLockedMessage.click();

		WebElement confirmDelete = driver.findElementById(configuredCapabilities.getPOSITIVE_BUTTON());
		confirmDelete.click();

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
	public void tearDown() {
		boolean hasQuit = (driver.toString().contains("(null)")) ? true : false;

		driver.quit();
	}
}
