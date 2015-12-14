
/**
* The DrivingMode program is used to test if the user is able to turn on the Driver Mode
*
* @author  Guruprasad B. Gopinath
* @version 1.0
* @since   2015-09-01 
*/

package test.com.test.appium;

import java.net.MalformedURLException;

// import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

public class DrivingMode extends SupportSetUp{


	@Test
	public void turnOnDrivingMode() {
		//
		WebElement drawerIcon = driver.findElementById(configuredCapabilities.getDRAWER_ICON());
		drawerIcon.click();

		WebElement slider = driver.findElementById(configuredCapabilities.getON_OFF_BTN_BOX());
		slider.click();

		WebElement closeBtn = driver.findElementById("com.verizon.messaging.vzmsgs:id/positive_button");
		closeBtn.click();
	}

	@BeforeClass
	public void setUp(){

		capabilities.setCapability(APIConstants.NORESET, configuredCapabilities.getNORESET());
		try {
			super.setUp();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@AfterClass
	public void afterClass() {
	}
}
