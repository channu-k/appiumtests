package test.com.test.appium;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

import io.appium.java_client.TouchAction;

public class ContactCard extends SupportSetUp {

	@Test
	public void send_vcard() {

		WebElement compose = driver.findElement(By.id(configuredCapabilities.getCOMPOSE_LAYOUT()));
		compose.click();

		WebElement to = driver.findElement(By.id(configuredCapabilities.getCURRECIP()));
		to.sendKeys(configuredCapabilities.getMDN());

		WebElement attach = driver.findElement(By.id(configuredCapabilities.getBTNATTACH()));
		attach.click();

		WebElement vCards = driver.findElement(By.name("Contact Card"));
		vCards.click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement searchIcon = driver.findElementById(configuredCapabilities.getMENU_SEARCH());
		searchIcon.click();
		WebElement searchTerm = driver.findElementById(configuredCapabilities.getSEARCH_SRC_TEXT());
		searchTerm.sendKeys("a");
		searchTerm.click();

		List<WebElement> card = driver.findElementsById(configuredCapabilities.getCLIV_NAME_TEXTVIEW());

		TouchAction tapAction = new TouchAction(driver);
		tapAction.tap(card.get(0)).perform();

		WebElement sendBtn = driver.findElementById(configuredCapabilities.getBTNSEND());
		sendBtn.click();

	}

	@BeforeClass
	public void setUp() {

		capabilities.setCapability(APIConstants.NORESET, configuredCapabilities.getNORESET());
		try {
			super.setUp();
			capabilities.setCapability("newCommandTimeout", 60 * 5);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	@AfterClass
	public void tearDown() {
		boolean hasQuit = (driver.toString().contains("(null)")) ? true : false;

		driver.quit();
	}

}
