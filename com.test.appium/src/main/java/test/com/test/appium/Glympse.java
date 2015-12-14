/**
* The Glympse program is used to test sharing of a location
*
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

public class Glympse extends SupportSetUp{


	@BeforeClass
	public void setUp(){

		capabilities.setCapability(APIConstants.NORESET, configuredCapabilities.getNORESET());
		try {
			super.setUp();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void clickGlympse() throws Exception {
		try {

			WebElement compose = driver.findElement(By.id(configuredCapabilities.getCOMPOSE_LAYOUT()));
			compose.click();

			WebElement to = driver.findElement(By.id(configuredCapabilities.getCURRECIP()));
			to.sendKeys(configuredCapabilities.getMDN());

			WebElement attach = driver.findElement(By.id(configuredCapabilities.getBTNATTACH()));
			attach.click();

			WebElement glympse = driver.findElement(By.name("Glympse"));
			glympse.click();

			 WebElement accept =
			 driver.findElement(By.id("com.verizon.messaging.vzmsgs:id/accept"));
			 accept.click();

			WebElement requestCheckBox = driver.findElement(By.id(configuredCapabilities.getREQUEST_CHECKBOX()));
			requestCheckBox.click();

			WebElement meetMeCheckBox = driver.findElement(By.id(configuredCapabilities.getDESTINATION_CHECKBOX()));
			meetMeCheckBox.click();

			WebElement glympseSendbtn = driver.findElement(By.id(configuredCapabilities.getSENDBUTT()));
			glympseSendbtn.click();

			// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@AfterClass
	public void tearDown() throws Exception {

		// boolean hasQuit = (driver.toString().contains("(null)")) ? true :
		// false;

		// driver.closeApp();
	}

}
