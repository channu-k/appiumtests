package test.com.test.appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

public class MediaSearchImage extends SupportSetUp {

	@Test
	public void send_an_image() throws Exception {
		try {

			WebElement compose = driver.findElement(By.id(configuredCapabilities.getCOMPOSE_LAYOUT()));
			compose.click();

			WebElement to = driver.findElement(By.id(configuredCapabilities.getCURRECIP()));
			to.sendKeys(configuredCapabilities.getMDN());

			WebElement attach = driver.findElement(By.id(configuredCapabilities.getBTNATTACH()));
			attach.click();

			WebElement mediaSearchbtn = driver.findElement(By.name("Media Search"));
			mediaSearchbtn.click();

			WebElement editBox = driver.findElementById(configuredCapabilities.getSEARCH_BAR_EDIT_TEXT());
			editBox.sendKeys("a");

			WebElement searchBtn = driver.findElementById(configuredCapabilities.getBUTTON_SEARCH());
			searchBtn.click();

			WebElement attachBtn = driver.findElementById(configuredCapabilities.getWEB_ATTACH_BUTTON());
			attachBtn.click();

			WebElement sendButton = driver.findElement(By.id(configuredCapabilities.getBTNSEND()));
			sendButton.click();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@BeforeClass
	public void setUp() {
		capabilities.setCapability(APIConstants.NORESET, configuredCapabilities.getNORESET());
		// capabilities.setCapability("newCommandTimeout", 60 * 1);
		try {
			super.setUp();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterClass
	public void tearDown() {
		// boolean hasQuit = (driver.toString().contains("(null)")) ? true :
		// false;

		// driver.quit();
	}
}
