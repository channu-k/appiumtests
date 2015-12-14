package test.com.test.appium;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;

public class DefaultAdvancedSettings extends SupportSetUp {

	@BeforeClass
	public void setUp() {

		// set up appium
		capabilities.setCapability(APIConstants.NORESET, configuredCapabilities.getNORESET());
		try {
			super.setUp();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @AfterClass
	public void tearDown() throws Exception {
		boolean hasQuit = (driver.toString().contains("(null)")) ? true : false;

		driver.quit();
	}

	@Test
	public void verifyDefaultAdvancedSettings() throws MalformedURLException {

		AndroidElement drawerIcon = (AndroidElement) driver.findElementById(configuredCapabilities.getDRAWER_ICON());
		drawerIcon.click();

		AndroidElement settingsOption = (AndroidElement) driver.findElement(By.name("Settings"));
		settingsOption.click();

		driver.scrollToExact("Advanced");

		TouchAction tAction = new TouchAction(driver);
		tAction.tap(driver.findElementByName("Advanced")).perform();

		List<WebElement> selectCheckBox1 = driver.findElements(By.className(configuredCapabilities.getCHECKBOX()));
		int chkboxesonScreen1 = selectCheckBox1.size();
//		System.out.println("The number of checkboxes on Screen1 are " + chkboxesonScreen1);
		for (int i = 0; i < chkboxesonScreen1; i++) {
			String checkedBoxes = selectCheckBox1.get(i).getAttribute("checked");
			// System.out.println(" The checked status of this checkbox is " +
			// checkedBoxes);
		}

		driver.scrollToExact("Change Name and Avatar");
		List<WebElement> selectCheckBox2 = driver.findElements(By.className(configuredCapabilities.getCHECKBOX()));
		int chkboxesonScreen2 = selectCheckBox2.size();
		// System.out.println("The number of checkboxes on Screen2 are " +
		// chkboxesonScreen2);
		for (int i = 0; i < chkboxesonScreen2; i++) {
			String checkedBoxes = selectCheckBox2.get(i).getAttribute("checked");
//			System.out.println(" The checked  status of this checkbox is " + checkedBoxes);

		}

	}
}
