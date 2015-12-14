/**
 * The SearchMessages program is used to test whether messages can be searched
 *  
 *
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

public class SearchMessages extends SupportSetUp {
	@Test
	public void searchAMessage() {
		try {

			WebElement searchIcon = driver.findElement(By.id(configuredCapabilities.getSEARCH_BUTTON()));
			searchIcon.click();

			WebElement searchEditbox = driver.findElementById(configuredCapabilities.getSEARCHEDIT());
			searchEditbox.sendKeys("Verizon");
			searchEditbox.click();

			driver.hideKeyboard();

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			List<WebElement> selectMessage = driver
					.findElementsByClassName(configuredCapabilities.getRELATIVE_LAYOUT());

			TouchAction tapAction = new TouchAction(driver);
			tapAction.tap(selectMessage.get(1)).perform();

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterClass
	public void afterClass() {
	}

}