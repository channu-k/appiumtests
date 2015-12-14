/**
* The Camera program is used to test the clicking and sending  of a picture  to a single recipient
* 
* *
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

public class Camera extends SupportSetUp {

	@Test
	public void sendCameraPicture() throws Exception {

		try {

			WebElement compose = driver.findElement(By.id(configuredCapabilities.getCOMPOSE_LAYOUT()));
			compose.click();

			WebElement to = driver.findElement(By.id(configuredCapabilities.getCURRECIP()));
			to.sendKeys(configuredCapabilities.getMDN());

			WebElement attach = driver.findElement(By.id(configuredCapabilities.getBTNATTACH()));
			attach.click();

			WebElement camera = driver.findElement(By.name("Camera"));
			camera.click();

			WebElement cameraClickBtn = driver.findElement(By.id(configuredCapabilities.getCAPTURE()));
			cameraClickBtn.click();

			WebElement doneBtn = driver.findElementById(configuredCapabilities.getNAVBAR_BUTTON1());
			doneBtn.click();

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
		driver.quit();
	}

}
