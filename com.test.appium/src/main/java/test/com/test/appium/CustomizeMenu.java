
/**
 * The CustomizeMenu program is used to test the presence of various options in the Customize Menu Screen and to test if they are enabled
 *
 * @author  Guruprasad B. Gopinath
 * @version 1.0
 * @since   2015-09-01 
 */

package test.com.test.appium;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

public class CustomizeMenu extends SupportSetUp {

	@Test
	public void clickCustomizeMenu() {

		// verify if all Customize Options are available

		WebElement convGalleryoption = driver.findElementById(configuredCapabilities.getIMGCONVGALLERYOPTION());
		convGalleryoption.click();

		WebElement customizeMenuBtn = driver.findElementByName("Customize");
		customizeMenuBtn.click();

		List<WebElement> optionHeader = driver.findElementsById(configuredCapabilities.getCUSTOMIZ_NAME());
		String[] customizeOptions = { "Backgrounds", "Avatar Color", "Conversation Bubble", "Font", "Tones",
				"LED Color", "Vibrate", "Reset to Default" };

		for (int i = 0; i < optionHeader.size(); i++) {

			if (i == optionHeader.size()) {
				driver.scrollToExact("Reset to Default");

			}

			Assert.assertEquals(optionHeader.get(i).getText(), customizeOptions[i]);

		}

		WebElement customHeader = driver.findElementById(configuredCapabilities.getHEADERTEXT());
		String customHeaderText = customHeader.getText();
		Assert.assertEquals(customHeaderText, "Customization");

		WebElement backgrounds = driver.findElementByName("Backgrounds");
		boolean isbgEnabled = backgrounds.isEnabled();
		Assert.assertEquals(isbgEnabled, true);

		WebElement avatarColor = driver.findElementByName("Avatar Color");
		boolean isavatarColorEnabled = avatarColor.isEnabled();
		Assert.assertEquals(isavatarColorEnabled, true);

		WebElement convBubble = driver.findElementByName("Conversation Bubble");
		boolean isConvBubbleEnabled = convBubble.isEnabled();
		Assert.assertEquals(isConvBubbleEnabled, true);

		WebElement font = driver.findElementByName("Font");
		boolean isFontEnabled = font.isEnabled();
		Assert.assertEquals(isFontEnabled, true);

		WebElement tones = driver.findElementByName("Tones");
		boolean isToneEnabled = tones.isEnabled();
		Assert.assertEquals(isToneEnabled, true);

		WebElement ledColor = driver.findElementByName("LED Color");
		boolean isLedColorEnabled = ledColor.isEnabled();
		Assert.assertEquals(isLedColorEnabled, true);

		WebElement vibrate = driver.findElementByName("Vibrate");
		boolean isVibrateEnabled = vibrate.isEnabled();
		Assert.assertEquals(isVibrateEnabled, true);

		driver.scrollToExact("Reset to Default");

		WebElement resetToDefault = driver.findElementByName("Reset to Default");
		boolean isResetToDefaultEnabled = resetToDefault.isEnabled();
		Assert.assertEquals(isResetToDefaultEnabled, true);

	}

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

	@AfterClass
	public void afterClass() {
	}
}
