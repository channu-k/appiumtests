
/**
 * The Audio program is used to test selection, attachment and sending of an available audio clip
 *
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

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Audio {
	AndroidDriver driver;
	ConfiguredCapabilities loadedCapabilities;
	@Test
	public void selectAudio() throws Exception {

		try {

			//Locate and click the Compose button 

			WebElement compose = driver.findElement(By.id(loadedCapabilities.getCOMPOSE_LAYOUT()));
			compose.click();

			//Add recipient number
			WebElement to = driver.findElement(By.id(loadedCapabilities.getCURRECIP()));
			to.sendKeys(loadedCapabilities.getMDN());

			driver.hideKeyboard();


			//Locate and click the attach button
			WebElement attach = driver.findElement(By.id(loadedCapabilities.getBTNATTACH()));
			attach.click();

			 WebElement screen1 = driver.findElementById(loadedCapabilities.getPAGER());
			//driver.findElementById("com.verizon.messaging.vzmsgs:id/pager"),
			
			
			TouchAction swipeAction = new TouchAction(driver);
			swipeAction.press(screen1, 707, 968).moveTo(screen1, 100, 968).release();
			
			
			
			//Locate and click the audio attachment
			WebElement audioIcon = driver.findElement(By.name("Audio"));
			audioIcon.click();

			//WebElement selectCompleteAction = driver.findElement(By.id("android:id/button_once"));
			//selectCompleteAction.click();

			// Locate and select the exact audio clip
			driver.scrollToExact("Hangouts Call").click();

			// Click on Ok button to complete attaching the Audio clip
			WebElement clickOK = driver.findElement(By.id(loadedCapabilities.getOKAYBUTTON()));
			clickOK.click();


		}catch (Exception e){e.printStackTrace();}
	}
	@BeforeClass
	public void setUp() throws MalformedURLException{
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
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}


