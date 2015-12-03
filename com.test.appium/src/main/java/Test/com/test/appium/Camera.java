/**
* The Camera program is used to test the clicking and sending  of a picture  to a single recipient
* 
* *
* @author  Guruprasad B. Gopinath
* @version 1.0
* @since   2015-09-01 
*/
package Test.com.test.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

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

import io.appium.java_client.android.AndroidDriver;

public class Camera {
	AndroidDriver driver;
	ConfiguredCapabilities loadedCapabilities;

	@Test
	public void sendCameraPicture() throws Exception {

		try {

			WebElement compose = driver.findElement(By.id(loadedCapabilities.getCOMPOSE_LAYOUT()));
			compose.click();

			WebElement to = driver.findElement(By.id(loadedCapabilities.getCURRECIP()));
			to.sendKeys(loadedCapabilities.getMDN());

			WebElement attach = driver.findElement(By.id(loadedCapabilities.getBTNATTACH()));
			attach.click();

			WebElement camera = driver.findElement(By.name("Camera"));
			camera.click();

			WebElement cameraClickBtn = driver.findElement(By.id(loadedCapabilities.getCAPTURE()));
			cameraClickBtn.click();

			WebElement doneBtn = driver.findElementById(loadedCapabilities.getNAVBAR_BUTTON1());
			doneBtn.click();

			WebElement sendButton = driver.findElement(By.id(loadedCapabilities.getBTNSEND()));
			sendButton.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		loadedCapabilities = HandlerUtility.getCapabilities();
		capabilities.setCapability(APIConstants.DEVICE, loadedCapabilities.getDEVICE());
		capabilities.setCapability(APIConstants.PLATFORMNAME, loadedCapabilities.getPLATFORM_NAME());
		capabilities.setCapability(APIConstants.DEVICENAME, loadedCapabilities.getDEVICE_NAME());
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability(CapabilityType.VERSION, loadedCapabilities.getVERSION());
		capabilities.setCapability(CapabilityType.PLATFORM, loadedCapabilities.getPLATFORM());
		capabilities.setCapability(APIConstants.NORESET, loadedCapabilities.getNORESET());
		capabilities.setCapability(APIConstants.APP, loadedCapabilities.getFILE_PATH());
		capabilities.setCapability(APIConstants.APP_PACKAGE, loadedCapabilities.getAPP_PACKAGE());
		capabilities.setCapability(APIConstants.APP_ACTIVITY, loadedCapabilities.getAPP_ACTIVITY());
		driver = new AndroidDriver(new URL(loadedCapabilities.getURL()), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
