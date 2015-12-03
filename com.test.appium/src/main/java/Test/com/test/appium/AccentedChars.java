/**
* The AccentedChars program is used to send accented english characters to a single recipient
*
* @author  Guruprasad B. Gopinath
* @version 1.0
* @since   2015-09-01 
*/



package Test.com.test.appium;

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

public class AccentedChars {
	AppiumDriver driver;
	ConfiguredCapabilities loadedCapabilities;
  @Test
  public void sendAccentedCharacters() {
	  
	  
	 // Click on Compose Button 	  
	  	WebElement composeBtn = driver.findElement(By.id(loadedCapabilities.getCOMPOSE_LAYOUT()));
	  	composeBtn.click();
		
	 // Enter Recipient mobile number
		WebElement to = driver.findElement(By.id(loadedCapabilities.getCURRECIP()));
		to.sendKeys(loadedCapabilities.getMDN());
		to.click();
		
	// Message to be sent
		WebElement messageBox= driver.findElement(By.id(loadedCapabilities.getEMBEDDED_TEXT_EDITOR()));
		messageBox.sendKeys("árvíztűrő tükörfúrógép");
	  			
  }
  
  @BeforeClass
  public void setUp() throws Exception {

	  DesiredCapabilities capabilities = new DesiredCapabilities();
      loadedCapabilities = HandlerUtility.getCapabilities();
      
      capabilities.setCapability(APIConstants.DEVICE,loadedCapabilities.getDEVICE());
      capabilities.setCapability(APIConstants.PLATFORMNAME, loadedCapabilities.getPLATFORM_NAME());
      capabilities.setCapability(APIConstants.DEVICENAME,loadedCapabilities.getDEVICE_NAME());
      capabilities.setCapability(CapabilityType.BROWSER_NAME,  "");
      capabilities.setCapability(CapabilityType.VERSION, loadedCapabilities.getVERSION());
      capabilities.setCapability(CapabilityType.PLATFORM, loadedCapabilities.getPLATFORM());
      capabilities.setCapability(APIConstants.NORESET, loadedCapabilities.getNORESET());
      capabilities.setCapability(APIConstants.UNICODEKEYBOARD,loadedCapabilities.getUNICODEKEYBOARD());
      capabilities.setCapability(APIConstants.APP, loadedCapabilities.getFILE_PATH());
      capabilities.setCapability(APIConstants.APP_PACKAGE, loadedCapabilities.getAPP_PACKAGE());  
      capabilities.setCapability(APIConstants.APP_ACTIVITY,loadedCapabilities.getAPP_ACTIVITY());
      driver = new AndroidDriver(new URL(loadedCapabilities.getURL()), capabilities);
	  
  }

  @AfterClass
  public void tearDown() {
	  boolean hasQuit = (driver.toString().contains("(null)")) ? true : false;
      
  	   driver.quit();
  }
  
  
  
  
  
  
  
  
  
  
}
