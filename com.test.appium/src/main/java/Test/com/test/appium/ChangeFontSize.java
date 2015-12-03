/**
 * The ChangeFontSize program is used to test the change of Font Size for a conversation Bubble  
 * 
 * *
 * @author  Guruprasad B. Gopinath
 * @version 1.0
 * @since   2015-09-01 
 */



package Test.com.test.appium;

import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;
import com.verizon.utility.ConfiguredCapabilities;
import com.verizon.utility.HandlerUtility;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;



public class ChangeFontSize
{

	AndroidDriver driver;
	ConfiguredCapabilities loadedCapabilities;
	@Test
	public void changeFontSize() 
	{
		WebElement convGalleryOption = driver.findElementById(loadedCapabilities.getIMGCONVGALLERYOPTION());
		convGalleryOption.click();

		WebElement customizeMenuBtn = driver.findElementByName("Customize");
		customizeMenuBtn.click();



		WebElement fontOption = driver.findElementByName("Font");
		fontOption.click();

		//Header

		WebElement useDefaultFontSize = driver.findElementById(loadedCapabilities.getDEFAULTFONTSIZE());


		//get the position and size of the slider
		WebElement changeFontSizeSlider = driver.findElementById(loadedCapabilities.getSEEKBAR());
		int xAxisStartPoint = changeFontSizeSlider.getLocation().getX();
		int width = changeFontSizeSlider.getSize().getWidth();
		System.out.println("The Width is " +width);
		int xAxisEndPoint = xAxisStartPoint +
				changeFontSizeSlider.getSize().getWidth();
		System.out.println("The start point is " +xAxisStartPoint);
		System.out.println("The end point is " +xAxisEndPoint);

		int yAxis = changeFontSizeSlider.getLocation().getY();
		System.out.println("The y axis " +yAxis);


		useDefaultFontSize.click();
		yAxis += 56;
		TouchAction act=new TouchAction(driver);
		act.longPress(changeFontSizeSlider, 704 , 1000).perform();


		WebElement useDefaultFontStyle = driver.findElementById(loadedCapabilities.getDEFAULTFONTSTYLE());
		String isUseDefaultFontStyleChecked = useDefaultFontStyle.getAttribute("checked");
		Assert.assertEquals(isUseDefaultFontStyleChecked, "true");



		WebElement backBtn = driver.findElementById(loadedCapabilities.getUPBUTTON());
		if (backBtn.isDisplayed()&& backBtn.isEnabled())
		{
			backBtn.click();

		}

		else 
		{
			
			System.out.println("Back button is either disabled or not displayed");

		}

		//com.verizon.messaging.vzmsgs:id/upButton

	}

	@BeforeClass
	public void setUp() throws Exception
	{
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
	}



	@AfterClass
	public void afterClass()
	{
		driver.quit();
	}
}




