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

/**
 * The Delete Active Glympse program is used to delete an Active Glympse
 *
 * @author Guruprasad B. Gopinath
 * @version 1.0
 * @since 2015-09-01
 */

public class DeleteActiveGlympse extends SupportSetUp {
	@Test
	public void deleteActiveGlympse() {

		/*
		 * WebElement compose = driver.findElement(By.id(
		 * "com.verizon.messaging.vzmsgs:id/compose_layout")); compose.click();
		 * 
		 * WebElement to =
		 * driver.findElement(By.id("com.verizon.messaging.vzmsgs:id/curRecip"))
		 * ; to.sendKeys("9253248931");
		 * 
		 * WebElement attach =
		 * driver.findElement(By.id("com.verizon.messaging.vzmsgs:id/btnAttach")
		 * ); attach.click();
		 * 
		 * WebElement glympse = driver.findElement(By.name("Glympse"));
		 * glympse.click();
		 * 
		 * // WebElement accept =
		 * driver.findElement(By.id("com.verizon.messaging.vzmsgs:id/accept"));
		 * // accept.click();
		 * 
		 * WebElement requestCheckBox = driver.findElement(By.id(
		 * "com.verizon.messaging.vzmsgs:id/request_checkbox"));
		 * requestCheckBox.click();
		 * 
		 * WebElement meetMeCheckBox = driver.findElement(By.id(
		 * "com.verizon.messaging.vzmsgs:id/destination_checkbox"));
		 * meetMeCheckBox.click();
		 * 
		 * WebElement glympseSendbtn =
		 * driver.findElement(By.id("com.verizon.messaging.vzmsgs:id/sendbutt"))
		 * ; glympseSendbtn.click();
		 * 
		 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 */

		WebElement conversation = driver.findElementByName("(925) 324-8931");
		conversation.click();

		// Expire the glympse
		WebElement optionsBtn = driver.findElementById(configuredCapabilities.getOPTIONS_DLG());
		optionsBtn.click();

		// com.verizon.messaging.vzmsgs:id/options_dlg

		WebElement stopSharingBtn = driver.findElementById(configuredCapabilities.getSTOP_SHARING());
		stopSharingBtn.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement activeGlympseMsg = driver.findElementById(configuredCapabilities.getTIME_LEFT());
		if (activeGlympseMsg.getAttribute("text").equalsIgnoreCase("Request Sent")) {
			TouchAction tap = new TouchAction(driver);
			tap.longPress(activeGlympseMsg).perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			WebElement messageOptions = driver.findElement(By.name("Delete messages"));
			messageOptions.click();

			WebElement deleteBtn = driver.findElementById(configuredCapabilities.getDELETE_BTN());
			deleteBtn.click();

			WebElement confirmDelete = driver.findElementById(configuredCapabilities.getPOSITIVE_BUTTON());
			confirmDelete.click();

		}

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
