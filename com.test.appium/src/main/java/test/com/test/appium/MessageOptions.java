package test.com.test.appium;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

import io.appium.java_client.TouchAction;

public class MessageOptions extends SupportSetUp {
	@Test
	public void verifyMessageOptions() {
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

			String s1 = r.nextInt(10000) + " This is a Compose message test";
			System.out.println(s1);

			WebElement messageBox = driver.findElement(By.id(configuredCapabilities.getEMBEDDED_TEXT_EDITOR()));
			messageBox.sendKeys(s1);

			WebElement sendButton = driver.findElement(By.id(configuredCapabilities.getBTNSEND()));
			sendButton.click();

			driver.hideKeyboard();

			List<WebElement> msg = driver.findElementsById(configuredCapabilities.getMESSAGE());

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			TouchAction selectAction = new TouchAction(driver);
			selectAction.longPress(msg.get(msg.size() - 1), 5000, 0).release().perform();

			WebElement optionTitle = driver.findElementById(configuredCapabilities.getTITLETEXT());
			String title = optionTitle.getText();
			Assert.assertEquals("Message options", title);

			String availableOptions[] = { "Lock message", "Copy Message Text", "Forward Message", "Message Info",
					"Delete messages" };

			List<WebElement> options = driver.findElementsById(configuredCapabilities.getACTIONITEMCONTAINER());

			for (int i = 0; i < options.size() - 1; i++)
				for (int j = 0; j < availableOptions.length - 1; j++) {

					// Assert.assertEquals(availableOptions[j],
					// options.get(i).getText());

					System.out.printf("options are %s, available options are %s", options.get(i).getText(),
							availableOptions[j]);
				}

		} catch (Exception e)

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
	public void afterClass()

	{
	}

}