
/**
 * The Audio program is used to test selection, attachment and sending of an available audio clip
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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

import io.appium.java_client.TouchAction;

public class Audio extends SupportSetUp {
	@Test
	public void selectAudio() throws Exception {

		try {

			// Locate and click the Compose button

			WebElement compose = driver.findElement(By.id(configuredCapabilities.getCOMPOSE_LAYOUT()));
			compose.click();

			// Add recipient number
			WebElement to = driver.findElement(By.id(configuredCapabilities.getCURRECIP()));
			to.sendKeys(configuredCapabilities.getMDN());

			driver.hideKeyboard();

			// Locate and click the attach button
			WebElement attach = driver.findElement(By.id(configuredCapabilities.getBTNATTACH()));
			attach.click();

			WebElement screen1 = driver.findElementById(configuredCapabilities.getPAGER());
			// driver.findElementById("com.verizon.messaging.vzmsgs:id/pager"),

			TouchAction swipeAction = new TouchAction(driver);
			swipeAction.press(screen1, 707, 968).moveTo(screen1, 100, 968).release();

			// Locate and click the audio attachment
			WebElement audioIcon = driver.findElement(By.name("Audio"));
			audioIcon.click();

			// WebElement selectCompleteAction =
			// driver.findElement(By.id("android:id/button_once"));
			// selectCompleteAction.click();

			// Locate and select the exact audio clip
			driver.scrollToExact("Hangouts Call").click();

			// Click on Ok button to complete attaching the Audio clip
			WebElement clickOK = driver.findElement(By.id(configuredCapabilities.getOKAYBUTTON()));
			clickOK.click();

		} catch (Exception e) {
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
		driver.quit();
	}

}
