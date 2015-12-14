package test.com.test.appium;
//import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

public class SwitchApp extends SupportSetUp {

	@BeforeClass
	public void setUp() {
		capabilities.setCapability(APIConstants.NORESET, configuredCapabilities.getNORESET());
		try {
			super.setUp();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void switchBetweenApps() throws InterruptedException, MalformedURLException {
		// Perform activity in message plus
		String MessagePlusAppPackageName = configuredCapabilities.getVZMESSAGES();
		String MessagePlusAppActivityName = configuredCapabilities.getAPP_ACTIVITY();

		// App2 capabilities
		String calculatorAppPackageName = "fidias.ioannides";
		String calculatorAppActivityName = "fidias.ioannides.DecActivity";

		for (int i = 0; i < 11; i++) {

			driver.startActivity(calculatorAppPackageName, calculatorAppActivityName);
			System.out.println("Switching to Messageplus from Calculator App....");
			driver.startActivity(MessagePlusAppPackageName, MessagePlusAppActivityName);
			WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(
					ExpectedConditions.presenceOfElementLocated(By.id(configuredCapabilities.getCOMPOSEBUTTON())));
			System.out.println("Switching from Messageplus to Calculator App....");
			System.out.printf("The value of iteration is %d\n", i);

		}

	}

	// @AfterClass
	public void tearDown() throws Exception {
		boolean hasQuit = (driver.toString().contains("(null)")) ? true : false;

		driver.quit();
	}

}