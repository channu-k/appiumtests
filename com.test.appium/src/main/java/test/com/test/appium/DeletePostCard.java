/**
 * The DeletePostcard program is used to test the deletion of a Postcard sent to a single recipient
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

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;

public class DeletePostCard extends SupportSetUp {
	@Test
	public void deletePostCard() {

		WebElement compose = driver.findElement(By.id(configuredCapabilities.getCOMPOSE_LAYOUT()));
		compose.click();

		WebElement to = driver.findElement(By.id(configuredCapabilities.getCURRECIP()));
		to.sendKeys(configuredCapabilities.getMDN());

		WebElement attach = driver.findElement(By.id(configuredCapabilities.getBTNATTACH()));
		attach.click();

		WebElement postCards = driver.findElement(By.name("Postcards"));
		postCards.click();

		// List <WebElement> selectPostcard =
		// driver.findElements(By.className("android.widget.GridView"));
		List<WebElement> selectPostcard = driver.findElements(By.id(configuredCapabilities.getALBUMS()));
		if (selectPostcard.size() > 0)
			selectPostcard.get(0).click();

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

		WebElement attachBtn = driver.findElementById(configuredCapabilities.getBTNATTACH());
		attachBtn.click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// delete a Postcard
		TouchAction tap = new TouchAction(driver);
		tap.longPress(driver.findElement(By.id(configuredCapabilities.getMEDIAIMAGE()))).perform();

		WebElement messageOptions = driver.findElement(By.name("Delete messages"));
		messageOptions.click();

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
