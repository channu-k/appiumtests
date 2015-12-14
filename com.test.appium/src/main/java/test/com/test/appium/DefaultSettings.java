package test.com.test.appium;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

public class DefaultSettings extends SupportSetUp {

	@BeforeClass
	public void setUp() {

		// set up appium
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

		// driver.findElementByAndroidUIAutomator("new
		// UiSelector().className(\"android.widget.LinearLayout\").index(7).childSelector(new
		// UiSelector().className(\"android.widget.CheckBox\").index(2));").click();

		// driver.findElementByAndroidUIAutomator("new
		// UiSelector().descriptionStartsWith(A Popup)").getAttribute("");
		// Try locating by bounds and get the attribute

		/*
		 * UiObject object = new UiObject(new
		 * UiSelector().classname(\"android.widget.FrameLayout\")); int cnt =
		 * object.getChildCount(); for(int i = 0; i < cnt; i++) { UiObject
		 * eachItem = object.getChild(new UiSelector().index(i))
		 */
		// WebElement el = driver.findElement(By.name("Enable Popup"));
		// el.click();
		List<WebElement> selectCheckBox1 = driver.findElements(By.className(configuredCapabilities.getCHECKBOX()));

		int sizeofList1 = selectCheckBox1.size();
//		System.out.println(sizeofList1);
		for (int i = 0; i < 3; i++) {
			String checkedBoxesonScreen1 = selectCheckBox1.get(i).getAttribute("checked");
//			System.out.println(checkedBoxesonScreen1);
			Assert.assertEquals("true", checkedBoxesonScreen1);
		}

		driver.scrollToExact("Send Read Receipts");

		List<WebElement> selectCheckBox2 = driver.findElements(By.className(configuredCapabilities.getCHECKBOX()));
		int sizeofList2 = selectCheckBox2.size();
//		System.out.println(sizeofList2);
		for (int i = 0; i < sizeofList2; i++) {
			String checkedBoxesonScreen2 = selectCheckBox2.get(i).getAttribute("checked");
//			System.out.println(" The status of the following checkBoxes are  " + checkedBoxesonScreen2);
			Assert.assertEquals("true", checkedBoxesonScreen2);
		}

		/*
		 * for(int j=4 ;j>=3;j--){ //String uncheckedBoxes=
		 * selectCheckBox.get(j).click(); //getAttribute("checked"); //String
		 * state_of_settings =((WebElement)
		 * selectCheckBox).getAttribute("checked");
		 * //Assert.assertEquals("false",uncheckedBoxes); }
		 */

	}
}
