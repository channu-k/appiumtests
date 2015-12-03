
/**
* The BackGroundsScreen program is used to test BackgroundScreen option in customization
* This test script focuses on the display of text and the enabling of message components
* *
* @author  Guruprasad B. Gopinath
* @version 1.0
* @since   2015-09-01 
*/


package Test.com.test.appium;

import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;
import com.verizon.utility.ConfiguredCapabilities;
import com.verizon.utility.HandlerUtility;

import org.testng.Assert;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BackGroundsScreen {
	
	
//	app-activity - application activity to fetched by the device by connecting the device to 
// the  
	
	AndroidDriver driver;
	ConfiguredCapabilities loadedCapabilities;
	
  @Test
  public void viewBackGroundsScreen() {
	  WebElement convGalleryOption = driver.findElementById(loadedCapabilities.getIMGCONVGALLERYOPTION());
	  	convGalleryOption.click();
	  
	  //Locate and click on the customize menu
	  WebElement customizeMenuBtn = driver.findElementByName("Customize");
	  	customizeMenuBtn.click();
	  
	  WebElement backGrounds = driver.findElementById(loadedCapabilities.getCUSTOMIZ_NAME());
	  	backGrounds.click();
	  
	  // Verify the text of the Header
	  WebElement backGroundHeader =driver.findElementById(loadedCapabilities.getHEADERTEXT());
	  	String backGroundHeaderTxt= backGroundHeader.getText();
	  	Assert.assertEquals(backGroundHeaderTxt, "All Conversations");
	 
	 // Verify the text of the SubHeader
	  WebElement backgroundSubHeader =driver.findElementById(loadedCapabilities.getSUBHEADERTEXT());
	  	String backGroundSubHeaderTxt= backgroundSubHeader.getText();
	  	Assert.assertEquals(backGroundSubHeaderTxt, "Backgrounds");
	 
	 //Verify if the From field is displayed
	  WebElement fromField=driver.findElementById(loadedCapabilities.getFROM());
	  	boolean isFromFieldDisplayed=fromField.isDisplayed();
	  	Assert.assertEquals(isFromFieldDisplayed, true);
	
	  	//Verify if the Subject field is displayed
	  WebElement subjectField=driver.findElementById(loadedCapabilities.getSUBJECT());
	  	boolean isSubjectFieldDisplayed=subjectField.isDisplayed();
	  	Assert.assertEquals(isSubjectFieldDisplayed, true);
	 
	//Verify if the unread counter is displayed
	  WebElement unreadCountField=driver.findElementById(loadedCapabilities.getUNREADCOUNT());
	  	boolean isUnreadCountFieldDisplayed=unreadCountField.isDisplayed();
	  	Assert.assertEquals(isUnreadCountFieldDisplayed, true);
	  
	//Verify if the date field is displayed		  
	  WebElement dateField=driver.findElementById(loadedCapabilities.getDATE());
	  	boolean isDateFieldDisplayed=dateField.isDisplayed();
	  	Assert.assertEquals(isDateFieldDisplayed, true);
	 
    //Verify if theBackbuton is displayed and enabled
	  WebElement backBtn = driver.findElementById(loadedCapabilities.getUPBUTTON());
	  	if (backBtn.isDisplayed()&& backBtn.isEnabled()){
		   backBtn.click();
		  
	  	}
	  
	  	else { System.out.println("Display button is either disabled or not displayed");
		  
	  	}

	  
  }
  
  @BeforeClass
  public void setUp() throws Exception {
    
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
      capabilities.setCapability("app-activity",".GiftChooseActivity");  //my case RootActivity
      driver = new AndroidDriver(new URL(loadedCapabilities.getURL()), capabilities);
  }
  
    
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
}



