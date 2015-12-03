
/**
 * The Attachment program is used to test attachment of  a picture from the gallery and send it 
 *
 * @author  Guruprasad B. Gopinath
 * @version 1.0
 * @since   2015-09-01 
 */

package Test.com.test.appium;

import io.appium.java_client.android.AndroidDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.*;
import java.io.File;
import java.net.URL;
import org.openqa.selenium.internal.Locatable;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
// import java.util.List;
import org.openqa.selenium.By;
// import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasTouchScreen;
import org.openqa.selenium.interactions.TouchScreen;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteTouchScreen;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;
import com.verizon.utility.ConfiguredCapabilities;
import com.verizon.utility.HandlerUtility;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Attachment {
	WebDriver driver;
	ConfiguredCapabilities loadedCapabilities;

	@Test
	public void composeWithImage() {

		WebElement compose = driver.findElement(By.id(loadedCapabilities.getCOMPOSE_LAYOUT()));
		compose.click();
		WebElement to = driver.findElement(By.id(loadedCapabilities.getCURRECIP()));
		to.sendKeys(loadedCapabilities.getMDN());
		to.click();

		// Attach Image here
		WebElement attachment = driver.findElement(By.id(loadedCapabilities.getBTNATTACH()));
		attachment.click();

		WebElement galleryBtn = driver.findElement(By.name("Gallery"));
		galleryBtn.click();

		WebElement picFolder = driver.findElement(By.name("Screenshots"));
		picFolder.click();

		List<WebElement> selectpic = driver.findElements(By.id(loadedCapabilities.getGRID()));
		selectpic.get(0).click();

		WebElement doneBtn = driver.findElement(By.id(loadedCapabilities.getNAVBAR_BUTTON1()));
		doneBtn.click();

		WebElement sendBtn = driver.findElement(By.id(loadedCapabilities.getBTNSEND()));
		sendBtn.click();

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

		capabilities.setCapability("newCommandTimeout", 60 * 5);
		capabilities.setCapability(APIConstants.APP, loadedCapabilities.getFILE_PATH());
		capabilities.setCapability(APIConstants.APP_PACKAGE, loadedCapabilities.getAPP_PACKAGE());
		capabilities.setCapability(APIConstants.APP_ACTIVITY, loadedCapabilities.getAPP_ACTIVITY());
		driver = new AndroidDriver(new URL(loadedCapabilities.getURL()), capabilities);

	}

	@AfterClass
	public void tearDown() {
		boolean hasQuit = (driver.toString().contains("(null)")) ? true : false;

		driver.quit();
	}

}
