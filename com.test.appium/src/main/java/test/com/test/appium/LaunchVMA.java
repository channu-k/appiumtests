
/**
 * The LaunchVMA program is used to install and launch the VMA app 
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LaunchVMA extends SupportSetUp {

	@Test
	public void launchApp() {

		WebElement getStarted = driver.findElement(By.id(configuredCapabilities.getPROV_ACCEPTBUTTON()));
		getStarted.click();

		(new WebDriverWait(driver, 45))
				.until(ExpectedConditions.presenceOfElementLocated(By.id(configuredCapabilities.getDRAWER_ICON())));

	}

	@BeforeClass
	public void setUp() {

		try {
			super.setUp();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}

}
