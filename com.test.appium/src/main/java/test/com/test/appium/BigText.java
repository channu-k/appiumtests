package test.com.test.appium;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

import io.appium.java_client.MobileElement;

public class BigText extends SupportSetUp {

	@Test
	public void sendBigText() {

		String str = "It is a truth universally acknowledged, that a single man in possession of a good fortune, must be in want of a wife."
				+ "  However little known the feelings or views of such a man may be on his first entering a neighbourhood, this truth is so well fixed in the minds of the surrounding families, that he is considered the rightful property of some one or other of their daughters."
				+ "  My dear Mr. Bennet, said his lady to him one day, have you heard that Netherfield Park is let at last?  "
				+ "  Mr. Bennet replied that he had not." + "  But it is, returned she;"
				+ "for Mrs. Long has just been here, and she told me all about it." + "  Mr. Bennet made no answer."
				+ "  Do you not want to know who has taken it? cried his wife impatiently."
				+ "  You want to tell me, and I have no objection to hearing it." + "  This was invitation enough.";

		MobileElement composeBtn = (MobileElement) driver.findElementById(configuredCapabilities.getCOMPOSE_LAYOUT());

		composeBtn.click();

		// Enter Recipient mobile number
		WebElement to = driver.findElement(By.id(configuredCapabilities.getCURRECIP()));
		to.sendKeys(configuredCapabilities.getMDN());
		to.click();

		MobileElement messageBox = (MobileElement) driver
				.findElementById(configuredCapabilities.getEMBEDDED_TEXT_EDITOR());
		messageBox.sendKeys(str);

		int x = messageBox.getLocation().getX();
		int y = messageBox.getLocation().getY();
		System.out.printf("x is %d, y is %d", x, y);

		messageBox.sendKeys(Keys.ENTER);

		int p = messageBox.getLocation().getX();
		int q = messageBox.getLocation().getY();
		System.out.printf("p is %d, q is %d", p, q);

		/*
		 * // TouchAction tAction = new TouchAction(driver);
		 * tAction.longPress(messageBox).perform();
		 * 
		 * MobileElement selectAll =
		 * driver.findElementById("android:id/selectAll"); selectAll.click();
		 * 
		 * MobileElement copyAction = driver.findElementById("android:id/copy");
		 * copyAction.click();
		 * 
		 * TouchAction tapAction = new TouchAction(driver);
		 * tapAction.tap(messageBox).perform();
		 * 
		 * tAction.longPress(messageBox).perform(); MobileElement pasteAction =
		 * driver.findElementById("android:id/paste"); pasteAction.click();
		 * 
		 * MobileElement sendButton=
		 * driver.findElementById("com.verizon.messaging.vzmsgs:id/btnSend");
		 * sendButton.click();
		 */

	}

	@BeforeClass
	public void setUp() {
		capabilities.setCapability(APIConstants.NORESET, configuredCapabilities.getNORESET());
		capabilities.setCapability("newCommandTimeout", 60 * 2);
		try {
			super.setUp();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
