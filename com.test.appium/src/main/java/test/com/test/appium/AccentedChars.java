/**
* The AccentedChars program is used to send accented english characters to a single recipient
*
* @author  Guruprasad B. Gopinath
* @version 1.0
* @since   2015-09-01 
*/

package test.com.test.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;
import com.verizon.utility.ConfiguredCapabilities;
import com.verizon.utility.HandlerUtility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AccentedChars extends SupportSetUp {
	@Test
	public void sendAccentedCharacters() {

		// Click on Compose Button
		WebElement composeBtn = driver.findElement(By.id(configuredCapabilities.getCOMPOSE_LAYOUT()));
		composeBtn.click();

		// Enter Recipient mobile number
		WebElement to = driver.findElement(By.id(configuredCapabilities.getCURRECIP()));
		to.sendKeys(configuredCapabilities.getMDN());
		to.click();

		// Message to be sent
		WebElement messageBox = driver.findElement(By.id(configuredCapabilities.getEMBEDDED_TEXT_EDITOR()));
		messageBox.sendKeys("árvíztűrő tükörfúrógép");

	}

	@BeforeClass
	public void setUp() {

		capabilities.setCapability(APIConstants.NORESET, configuredCapabilities.getNORESET());
		capabilities.setCapability(APIConstants.UNICODEKEYBOARD, configuredCapabilities.getUNICODEKEYBOARD());

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
