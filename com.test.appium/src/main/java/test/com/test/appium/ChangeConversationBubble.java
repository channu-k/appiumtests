/**
 * The ChangeConversationBubble program is used to test the change of template for a conversation Bubble  
 * 
 * *
 * @author  Guruprasad B. Gopinath
 * @version 1.0
 * @since   2015-09-01 
 */

package test.com.test.appium;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

public class ChangeConversationBubble extends SupportSetUp {

	@Test
	public void clickChangeBackGround() {
		WebElement convGalleryOption = driver.findElementById(configuredCapabilities.getIMGCONVGALLERYOPTION());
		convGalleryOption.click();

		WebElement customizeMenuBtn = driver.findElementByName("Customize");
		customizeMenuBtn.click();

		WebElement conversationBubble = driver.findElementByName("Conversation Bubble");
		conversationBubble.click();

		// Locate and select a different bubble template
		WebElement identifyBubble = driver.findElementByAccessibilityId("Colored");
		identifyBubble.click();

		// Locate and enable display of Avatar
		WebElement showAvatarOn = driver.findElementById(configuredCapabilities.getDEFAULTBUBBLETYPE());
		showAvatarOn.click();

	}

	@BeforeClass
	public void setUp() {

		capabilities.setCapability(APIConstants.NORESET, configuredCapabilities.getNORESET());
		try {
			super.setUp();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
