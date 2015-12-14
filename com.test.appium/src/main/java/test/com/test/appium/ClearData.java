package test.com.test.appium;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

public class ClearData extends SupportSetUp {

	@Test
	public void clearDataFromSettings() {

		// Perform activity in message plus
		String MessagePlusAppPackageName = configuredCapabilities.getVZMESSAGES();
		String MessagePlusAppActivityName = "com.verizon.mms.ui.activity.Provisioning";

		// App2 capabilities
		String deviceSettingsAppPackageName = "com.android.settings";
		String settingsAppActivityName = "com.android.settings.Settings";

		driver.startActivity(deviceSettingsAppPackageName, settingsAppActivityName);
		driver.scrollToExact("Apps");

		WebElement apps = driver.findElementByName("Apps");
		apps.click();

		driver.scrollToExact("Message+");

		WebElement messagePlus = driver.findElementByName("Message+");
		messagePlus.click();

		WebElement clearDataBtn = driver.findElementByName("Clear data");
		clearDataBtn.click();

		WebElement confirmClearDataBtn = driver.findElementByName("OK");
		confirmClearDataBtn.click();

	}

	@AfterClass
	public void tearDown() throws Exception {
		boolean hasQuit = (driver.toString().contains("(null)")) ? true : false;

		driver.quit();
	}

	@BeforeClass
	public void setUp() {
		// set up appium
		// App1 capabilities
		capabilities.setCapability(APIConstants.NORESET, configuredCapabilities.getNORESET());
		try {
			super.setUp();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

}
