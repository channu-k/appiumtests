
/**
 * The Conversation Bubble program is used to check the Header, and Sub-Header of the Conversation Bubble Screen
 *
 * @author  Guruprasad B. Gopinath
 * @version 1.0
 * @since   2015-09-01 
 */

package test.com.test.appium;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

public class ConversationBubble extends SupportSetUp {

	@Test
	public void viewConversationBubble() {
		WebElement convGalleryOption = driver.findElementById(configuredCapabilities.getIMGCONVGALLERYOPTION());
		convGalleryOption.click();

		WebElement customizeMenuBtn = driver.findElementByName("Customize");
		customizeMenuBtn.click();

		WebElement conversationBubble = driver.findElementByName("Conversation Bubble");
		conversationBubble.click();

		// Verify Header
		WebElement convBubbleHeader = driver.findElementById(configuredCapabilities.getTXTNAME());
		String convBubbleHeaderTxt = convBubbleHeader.getText();
		Assert.assertEquals(convBubbleHeaderTxt, "All Conversations");

		// Verify Sub-Header
		WebElement convBubbleSubHeader = driver.findElementById(configuredCapabilities.getSUBHEADERTEXT());
		String convBubbleSubHeaderTxt = convBubbleSubHeader.getText();
		Assert.assertEquals(convBubbleSubHeaderTxt, "Manage Conversation Bubble");

		WebElement backBtn = driver.findElementById(configuredCapabilities.getUPBUTTON());
		if (backBtn.isDisplayed() && backBtn.isEnabled()) {
			backBtn.click();

		}

		else {
			System.out.println("Back button is either disabled or not displayed");

		}

		// com.verizon.messaging.vzmsgs:id/upButton

	}

	@BeforeClass
	public void setUp() {

		capabilities.setCapability(APIConstants.NORESET, configuredCapabilities.getNORESET());
		try {
			super.setUp();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
	}
}
