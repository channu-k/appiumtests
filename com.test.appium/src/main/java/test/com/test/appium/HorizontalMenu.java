/**
* The HorizontalMenu program is used to test the text of the tab headers in the Horizontal Menu
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

import io.appium.java_client.TouchAction;

public class HorizontalMenu extends SupportSetUp{

	private TouchAction tContacts;
	private WebElement TouchAction;

	@Test
	public void getHorizontalMenuHeadings() {
		// Photos and videos
		TouchAction pandv = new TouchAction(driver);
		pandv.tap(driver.findElementByName("Photos & Videos")).perform();

		WebElement pandvHeader = driver.findElementById(configuredCapabilities.getFRAGMENTTYPE());
		String pandvHeaderTxt = pandvHeader.getText();
		Assert.assertEquals(pandvHeaderTxt, "Shared In All Conversations");

		WebElement pandvSubHeader = driver.findElementById(configuredCapabilities.getSHAREDINALLCONVERSATION());
		String pandvSubHeaderTxt = pandvSubHeader.getText();
		Assert.assertEquals(pandvSubHeaderTxt, "Photos & Videos");

		// eGift

		TouchAction eGift = new TouchAction(driver);
		eGift.tap(driver.findElementByName("eGIFT")).perform();

		WebElement eGiftHeader = driver.findElementById(configuredCapabilities.getFRAGMENTTYPE());
		String eGiftHeaderTxt = eGiftHeader.getText();
		Assert.assertEquals(eGiftHeaderTxt, "eGift Card");

		WebElement eGiftSubHeader = driver.findElementById(configuredCapabilities.getSHAREDINALLCONVERSATION());
		String eGiftSubHeaderTxt = eGiftSubHeader.getText();
		Assert.assertEquals(eGiftSubHeaderTxt, "With a remaining balance");
		// Swipe

		// TouchAction swipeTotheRight=new TouchAction(driver);
		// swipeTotheRight.press(500,200).moveTo(000,661).release()
		// .perform();

		// Contacts

		TouchAction tContacts = new TouchAction(driver);
		tContacts.tap(driver.findElementByName("Contacts")).perform();

		WebElement contactsHeader = driver.findElementById(configuredCapabilities.getFRAGMENTTYPE());
		String contactsHeaderTxt = contactsHeader.getText();
		Assert.assertEquals(contactsHeaderTxt, "Shared In All Conversations");

		WebElement contactsSubHeader = driver.findElementById(configuredCapabilities.getSHAREDINALLCONVERSATION());
		String contactsSubHeaderTxt = contactsSubHeader.getText();
		Assert.assertEquals(contactsSubHeaderTxt, "Contacts");

		// Links

		TouchAction links = new TouchAction(driver);
		links.tap(driver.findElementByName("Links")).perform();

		WebElement linksHeader = driver.findElementById(configuredCapabilities.getFRAGMENTTYPE());
		String linksHeaderTxt = linksHeader.getText();
		Assert.assertEquals(linksHeaderTxt, "Shared In All Conversations");

		WebElement linksSubHeader = driver.findElementById(configuredCapabilities.getSHAREDINALLCONVERSATION());
		String linksSubHeaderTxt = linksSubHeader.getText();
		Assert.assertEquals(linksSubHeaderTxt, "Links");

		// Audio

		TouchAction audio = new TouchAction(driver);
		audio.tap(driver.findElementByName("Audio")).perform();

		WebElement audioHeader = driver.findElementById(configuredCapabilities.getFRAGMENTTYPE());
		String audioHeaderTxt = audioHeader.getText();
		Assert.assertEquals(audioHeaderTxt, "Shared In All Conversations");

		WebElement audioSubHeader = driver.findElementById(configuredCapabilities.getSHAREDINALLCONVERSATION());
		String audioSubHeaderTxt = audioSubHeader.getText();
		Assert.assertEquals(audioSubHeaderTxt, "Audio");

	}

	@BeforeClass
	public void setUp() {

		// 
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
