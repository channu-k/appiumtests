package test.com.test.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
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

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class EmoticonHeart extends SupportSetUp{

	@BeforeClass
	public void setUp(){
		// set up appium
		// App1 capabilities
		capabilities.setCapability(APIConstants.NORESET, configuredCapabilities.getNORESET());
		capabilities.setCapability("newCommandTimeout", 60 * 2);
		try {
			super.setUp();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@AfterClass
	public void afterClass() {
	}

	@Test
	public void send_an_emoticon() {

		WebElement composeBtn = driver.findElement(By.id(configuredCapabilities.getCOMPOSE_LAYOUT()));
		composeBtn.click();

		WebElement to = driver.findElement(By.id(configuredCapabilities.getCURRECIP()));
		to.sendKeys(configuredCapabilities.getMDN());
		to.click();

		WebElement messageBox = driver.findElement(By.id(configuredCapabilities.getEMBEDDED_TEXT_EDITOR()));
		messageBox.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement emojiButton = driver.findElementById(configuredCapabilities.getBTNEMOJI());
		emojiButton.click();

		// driver.swipe(900, 1000, 150, 1000, 2000);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		List<WebElement> emoji = driver.findElementsById(configuredCapabilities.getPAGER());
		emoji.get(0).click();

		WebElement sendButton = driver.findElement(By.id(configuredCapabilities.getBTNSEND()));
		sendButton.click();

		/*
		 * driver.swipe(900, 1000, 150, 1000, 2000); for(int i = 0; i< 24; i++){
		 * 
		 * emojih1.get(i).click(); }
		 */

		/*
		 * TouchAction action = new TouchAction(driver); action.tap(emojih1,500,
		 * 600);
		 */

	}
}
