package test.com.test.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.verizon.utility.APIConstants;
import com.verizon.utility.ConfiguredCapabilities;
import com.verizon.utility.HandlerUtility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class SupportSetUp {

	DesiredCapabilities capabilities = new DesiredCapabilities();
	ConfiguredCapabilities configuredCapabilities = HandlerUtility.getCapabilities();
	AppiumDriver driver;

	public void setUp() throws MalformedURLException {

		capabilities.setCapability(APIConstants.DEVICE, configuredCapabilities.getDEVICE());
		capabilities.setCapability(APIConstants.PLATFORMNAME, configuredCapabilities.getPLATFORM_NAME());
		capabilities.setCapability(APIConstants.DEVICENAME, configuredCapabilities.getDEVICE_NAME());
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability(CapabilityType.VERSION, configuredCapabilities.getVERSION());
		capabilities.setCapability(CapabilityType.PLATFORM, configuredCapabilities.getPLATFORM());
		capabilities.setCapability(APIConstants.APP, configuredCapabilities.getFILE_PATH());
		capabilities.setCapability(APIConstants.APP_PACKAGE, configuredCapabilities.getAPP_PACKAGE());
		capabilities.setCapability(APIConstants.APP_ACTIVITY, configuredCapabilities.getAPP_ACTIVITY());

		driver = new AndroidDriver(new URL(configuredCapabilities.getURL()), capabilities);
	}

}
