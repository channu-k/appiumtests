package test.com.test.appium;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

public class ChangeSettings extends SupportSetUp {

	@BeforeClass
	public void setUp() {

		capabilities.setCapability(APIConstants.NORESET, configuredCapabilities.getNORESET());

		try {
			super.setUp();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	// @AfterClass
	public void tearDown() throws Exception {
		boolean hasQuit = (driver.toString().contains("(null)")) ? true : false;

		driver.quit();
	}

	@Test
	public void verifyDefaultSettings() throws MalformedURLException {

		WebElement drawerIcon = driver.findElement(By.id(configuredCapabilities.getDRAWER_ICON()));
		drawerIcon.click();

		WebElement settingsOption = driver.findElement(By.name("Settings"));
		settingsOption.click();

		List<WebElement> selectCheckBox1 = driver.findElements(By.className(configuredCapabilities.getCHECKBOX()));

		int sizeofList1 = selectCheckBox1.size();
		System.out.println(sizeofList1);

		for (int i = 0; i < 3; i++) {
			String checkedBoxesonScreen1 = selectCheckBox1.get(i).getAttribute("checked");
			// Uncheck the checkboxes

			selectCheckBox1.get(i).click();

			Assert.assertEquals("false", selectCheckBox1.get(i).getAttribute("checked"));
		}

		driver.scrollToExact("Send Read Receipts");

		List<WebElement> selectCheckBox2 = driver.findElements(By.className(configuredCapabilities.getCHECKBOX()));
		int sizeofList2 = selectCheckBox2.size();
		System.out.println(sizeofList2);
		for (int i = 0; i < (sizeofList2 - 1); i++) {
			String checkedBoxesonScreen2 = selectCheckBox2.get(i).getAttribute("checked");
			// Uncheck the checkboxes
			selectCheckBox1.get(i).click();
			// System.out.println(" The status of the following checkBoxes are "
			// +checkedBoxesonScreen2);
			Assert.assertEquals("true", selectCheckBox2.get(i).getAttribute("checked"));
		}

	}
}
