
/**
 * The Attachment program is used to test attachment of  a picture from the gallery and send it 
 *
 * @author  Guruprasad B. Gopinath
 * @version 1.0
 * @since   2015-09-01 
 */

package test.com.test.appium;

import java.net.MalformedURLException;
import java.util.List;

// import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

public class Attachment extends SupportSetUp {

	@Test
	public void composeWithImage() {

		WebElement compose = driver.findElement(By.id(configuredCapabilities.getCOMPOSE_LAYOUT()));
		compose.click();
		WebElement to = driver.findElement(By.id(configuredCapabilities.getCURRECIP()));
		to.sendKeys(configuredCapabilities.getMDN());
		to.click();

		// Attach Image here
		WebElement attachment = driver.findElement(By.id(configuredCapabilities.getBTNATTACH()));
		attachment.click();

		WebElement galleryBtn = driver.findElement(By.name("Gallery"));
		galleryBtn.click();

		WebElement picFolder = driver.findElement(By.name("Screenshots"));
		picFolder.click();

		List<WebElement> selectpic = driver.findElements(By.id(configuredCapabilities.getGRID()));
		selectpic.get(0).click();

		WebElement doneBtn = driver.findElement(By.id(configuredCapabilities.getNAVBAR_BUTTON1()));
		doneBtn.click();

		WebElement sendBtn = driver.findElement(By.id(configuredCapabilities.getBTNSEND()));
		sendBtn.click();

	}

	@BeforeClass
	public void setUp() {

		capabilities.setCapability(APIConstants.NORESET, configuredCapabilities.getNORESET());
		capabilities.setCapability("newCommandTimeout", 60 * 5);

		try {
			super.setUp();
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
