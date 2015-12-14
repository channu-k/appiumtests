/**
 * The Collate program is used to test the collate feature on 2 pictures 
 * 
 * *
 * @author  Guruprasad B. Gopinath
 * @version 1.0
 * @since   2015-09-01 
 */

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

public class Collate extends SupportSetUp {

	@Test
	public void collatePictures() throws Exception {

		try {

			WebElement compose = driver.findElement(By.id(configuredCapabilities.getCOMPOSE_LAYOUT()));
			compose.click();

			WebElement to = driver.findElement(By.id(configuredCapabilities.getCURRECIP()));
			to.sendKeys(configuredCapabilities.getMDN());

			WebElement attach = driver.findElement(By.id(configuredCapabilities.getBTNATTACH()));
			attach.click();

			WebElement collage = driver.findElement(By.name("Collage"));
			collage.click();

			List<WebElement> selectLayout = driver.findElementsByClassName(configuredCapabilities.getFRAMELAYOUT());
			TouchAction tAction = new TouchAction(driver);
			tAction.tap(selectLayout.get(0)).perform();

			List<WebElement> sizeofLayout = driver.findElementsById(configuredCapabilities.getADDCONTAINER());
			int j = sizeofLayout.size();
			System.out.println(j);

			// tAction.release();
			for (int i = 0; i < j; i++) {
				WebElement choosePicture1 = driver.findElement(By.id(configuredCapabilities.getADD()));
				choosePicture1.click();

				WebElement picFolder = driver.findElement(By.name("Screenshots"));
				picFolder.click();

				List<WebElement> selectpic = driver.findElements(By.id(configuredCapabilities.getGRID()));
				selectpic.get(i).click();

				WebElement doneBtn = driver.findElement(By.id(configuredCapabilities.getNAVBAR_BUTTON1()));
				doneBtn.click();
			}

			WebElement headerDoneBtn = driver.findElementById(configuredCapabilities.getHEADER_BUTTON());
			headerDoneBtn.click();

			WebElement sendBtn = driver.findElement(By.id(configuredCapabilities.getBTNSEND()));
			sendBtn.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void setUp() {

		capabilities.setCapability(APIConstants.NORESET, configuredCapabilities.getNORESET());
		try {
			super.setUp();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	@AfterClass
	public void afterClass() {
		driver.closeApp();
	}

}
