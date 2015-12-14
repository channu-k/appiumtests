// The PostCards program is used to verify user can attach and send a postcard to a single recipient

package test.com.test.appium;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;

public class Postcards extends SupportSetUp {

	@Test
	public void clickPostcards() throws Exception {

		try {

			/*
			 * WebElement getStarted = driver.findElement(By.id(
			 * "com.verizon.messaging.vzmsgs:id/prov_acceptButton"));
			 * getStarted.click();
			 * 
			 * 
			 * WebElement myDynamicElement = (new WebDriverWait(driver, 45))
			 * .until(ExpectedConditions.presenceOfElementLocated(By.id(
			 * "com.verizon.messaging.vzmsgs:id/drawerIcon")));
			 */
			WebElement compose = driver.findElement(By.id(configuredCapabilities.getCOMPOSE_LAYOUT()));
			compose.click();

			WebElement to = driver.findElement(By.id(configuredCapabilities.getCURRECIP()));
			to.sendKeys(configuredCapabilities.getMDN());

			WebElement attach = driver.findElement(By.id(configuredCapabilities.getBTNATTACH()));
			attach.click();

			WebElement postcards = driver.findElement(By.name("Postcards"));
			postcards.click();

			WebElement selectPostcard = driver.findElement(By.name("Zenith"));
			selectPostcard.click();

			WebElement postcardCaption = driver.findElement(By.id(configuredCapabilities.getCAPTIONHINT()));

			TouchAction tAction = new TouchAction((MobileDriver) driver);
			// tAction.longPress(driver.findElement
			// (By.name("Tap to enter text.Drag and pinch to move and
			// scale"))).perform();
			tAction.tap(postcardCaption).perform();
			tAction.release();

			WebElement testCaption = driver.findElement(By.id(configuredCapabilities.getEDITVIEW()));
			testCaption.sendKeys("Greetings!");

			WebElement doneBtn = driver.findElementById(configuredCapabilities.getHEADER_BUTTON());

			doneBtn.click();

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			// WebElement postcardAttachbtn =
			// driver.findElement(By.id("com.verizon.messaging.vzmsgs:id/headerButton"));
			WebElement postcardAttachbtn = driver.findElement(By.name("Attach"));
			postcardAttachbtn.click();

			WebElement sendButton = driver.findElement(By.id(configuredCapabilities.getBTNSEND()));
			sendButton.click();

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterClass
	public void afterClass() {
	}

}
