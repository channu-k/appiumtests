/**
* The GroupMessaging program is used to test sending of a group m essage to 2 recipients
*
* @author  Guruprasad B. Gopinath
* @version 1.0
* @since   2015-09-01 
*/

package test.com.test.appium;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

// import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

public class GroupMessage extends SupportSetUp {

	@Test
	public void sendGroupMessage() {

		WebElement composeBtn = driver.findElementById(configuredCapabilities.getCOMPOSEBUTTON());
		composeBtn.click();

		WebElement toField1 = driver.findElementByClassName(configuredCapabilities.getEDITTEXT());
		toField1.sendKeys(configuredCapabilities.getMDN());

		WebElement messageBox = driver.findElement(By.id(configuredCapabilities.getEMBEDDED_TEXT_EDITOR()));
		messageBox.click();

		driver.hideKeyboard();

		/*
		 * WebElement toField2 =
		 * driver.findElementByClassName("android.widget.EditText");
		 * toField1.sendKeys("9253248951");
		 */

		// WebElement addressBook =
		// driver.findElementById("com.verizon.messaging.vzmsgs:id/addContact");
		WebElement addressBook = driver.findElementByAccessibilityId("Address Book");
		addressBook.click();

		WebElement searchIcon = driver.findElementById(configuredCapabilities.getMENU_SEARCH());
		searchIcon.click();

		WebElement editBox = driver.findElementById(configuredCapabilities.getSEARCH_SRC_TEXT());
		editBox.sendKeys(configuredCapabilities.getMDN());

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.hideKeyboard();

		/*
		 * WebDriverWait wait1 = new WebDriverWait(driver, 10);
		 * wait1.until(ExpectedConditions.elementToBeClickable(By.name("Nexus"))
		 * );
		 */

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		List<WebElement> ml = driver.findElements(By.className(configuredCapabilities.getVIEW()));
		ml.get(0).click();

		// messageBox.click();
		// messageBox.sendKeys("Test Group Message");

		// WebElement sendButton=
		// driver.findElement(By.id("com.verizon.messaging.vzmsgs:id/btnSend"));
		// sendButton.click();
	}

	@BeforeClass
	public void setUp() {
		capabilities.setCapability(APIConstants.NORESET, configuredCapabilities.getNORESET());
		capabilities.setCapability("newCommandTimeout", 60 * 2);
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