package test.com.test.appium;

import java.net.MalformedURLException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

public class SendMultipleTextMessages extends SupportSetUp {

	@Test
	public void sendMultipleTextMessages() {

		// Click on Compose button
		WebElement composeBtn = driver.findElement(By.id(configuredCapabilities.getCOMPOSEBUTTON()));
		composeBtn.click();

		// Enter the recipient
		WebElement to = driver.findElement(By.id(configuredCapabilities.getCURRECIP()));
		to.sendKeys(configuredCapabilities.getMDN());
		to.click();

		// Message to be sent with a random number for better identification

		Random r = new Random();
		String[] messages = new String[2];

		for (int i = 0; i < messages.length; i++) {
			messages[i] = r.nextInt(10000) + " Test msg";
			WebElement messageBox = driver.findElement(By.id(configuredCapabilities.getEMBEDDED_TEXT_EDITOR()));
			messageBox.click();
			messageBox.sendKeys(messages[i]);

			WebElement sendButton = driver.findElement(By.id(configuredCapabilities.getBTNSEND()));
			sendButton.click();

		}

		driver.hideKeyboard();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@BeforeClass
	public void setUp() {
		capabilities.setCapability(APIConstants.NORESET, configuredCapabilities.getNORESET());
		capabilities.setCapability("newCommandTimeout", 60 * 5);
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
