package test.com.test.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;
import com.verizon.utility.ConfiguredCapabilities;
import com.verizon.utility.HandlerUtility;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

public class SanityTest {
	AndroidDriver driver;
	ConfiguredCapabilities loadedCapabilities;

	@Test(priority = 1, alwaysRun = true)

	public void composeMessage() {

		// Click on Compose button
		WebElement composeBtn = driver.findElement(By.id(loadedCapabilities.getCOMPOSE_LAYOUT()));
		composeBtn.click();

		// Enter Recipient mobile number
		WebElement to = driver.findElement(By.id(loadedCapabilities.getCURRECIP()));
		to.sendKeys(loadedCapabilities.getMDN());
		to.click();

		// Message to be sent with a random number for better identification

		Random r = new Random();

		String s1 = r.nextInt(10000) + " This is a Compose message test";
		System.out.println(s1);

		// Type Message into message Box
		WebElement messageBox = driver.findElement(By.id(loadedCapabilities.getEMBEDDED_TEXT_EDITOR()));
		messageBox.sendKeys(s1);

		// Click on the send button
		WebElement sendButton = driver.findElement(By.id(loadedCapabilities.getBTNSEND()));
		sendButton.click();

		/*
		 * driver.hideKeyboard();
		 * 
		 * WebElement backButton = driver.findElementById(
		 * "com.verizon.messaging.vzmsgs:id/back_conv_ico"); backButton.click();
		 */
		driver.closeApp();
	}

	@Test(priority = 2, alwaysRun = true) // (dependsOnMethods = {
											// "composeMessage" })
	public void composeWithImage() {
		driver.launchApp();
		WebElement compose = driver.findElement(By.id(loadedCapabilities.getCOMPOSE_LAYOUT()));
		compose.click();

		WebElement to = driver.findElement(By.id(loadedCapabilities.getCURRECIP()));
		to.sendKeys(loadedCapabilities.getMDN());
		to.click();

		// Attach Image here
		WebElement attachment = driver.findElement(By.id(loadedCapabilities.getBTNATTACH()));
		attachment.click();

		WebElement galleryBtn = driver.findElement(By.name("Gallery"));
		galleryBtn.click();

		WebElement picFolder = driver.findElement(By.name("Screenshots"));
		picFolder.click();

		List<WebElement> selectpic = driver.findElements(By.id(loadedCapabilities.getGRID()));
		selectpic.get(0).click();

		WebElement doneBtn = driver.findElement(By.id(loadedCapabilities.getNAVBAR_BUTTON1()));
		doneBtn.click();

		WebElement sendBtn = driver.findElement(By.id(loadedCapabilities.getBTNSEND()));
		sendBtn.click();

		// driver.hideKeyboard();

		/*
		 * WebElement backButton = driver.findElementById(
		 * "com.verizon.messaging.vzmsgs:id/back_conv_ico"); backButton.click();
		 */
		driver.closeApp();

	}

	@Test(priority = 3, alwaysRun = true)
	public void composeRecording() throws MalformedURLException {

		driver.launchApp();

		// Click on Compose button
		WebElement composeBtn = driver.findElement(By.id(loadedCapabilities.getCOMPOSE_LAYOUT()));
		composeBtn.click();

		// Enter Recipient mobile number
		WebElement to = driver.findElement(By.id(loadedCapabilities.getCURRECIP()));
		to.sendKeys(loadedCapabilities.getMDN());
		to.click();

		// Message to be sent with a random number for better identification

		WebElement messageBox = driver.findElement(By.id(loadedCapabilities.getEMBEDDED_TEXT_EDITOR()));
		messageBox.click();

		TouchAction tapOnMic = new TouchAction(driver);
		tapOnMic.longPress(driver.findElementById(loadedCapabilities.getBTNSEND()), 10000).release().perform();

		WebElement sendButton = driver.findElement(By.id(loadedCapabilities.getBTNSEND()));
		sendButton.click();

		driver.closeApp();

		/*
		 * driver.hideKeyboard();
		 * 
		 * WebElement backButton = driver.findElementById(
		 * "com.verizon.messaging.vzmsgs:id/back_conv_ico"); backButton.click();
		 * 
		 */
	}

	@Test(priority = 4, alwaysRun = true)
	public void sendCameraPicture() throws Exception {

		try {

			driver.launchApp();

			WebElement compose = driver.findElement(By.id(loadedCapabilities.getCOMPOSE_LAYOUT()));
			compose.click();

			WebElement to = driver.findElement(By.id(loadedCapabilities.getCURRECIP()));
			to.sendKeys(loadedCapabilities.getMDN());

			WebElement attach = driver.findElement(By.id(loadedCapabilities.getBTNATTACH()));
			attach.click();

			WebElement camera = driver.findElement(By.name("Camera"));
			camera.click();

			WebElement cameraClickBtn = driver.findElement(By.id(loadedCapabilities.getCAPTURE()));
			cameraClickBtn.click();

			WebElement doneBtn = driver.findElementById(loadedCapabilities.getNAVBAR_BUTTON1());
			doneBtn.click();

			WebElement sendButton = driver.findElement(By.id(loadedCapabilities.getBTNSEND()));
			sendButton.click();

			driver.closeApp();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 5, alwaysRun = true)
	public void clickMediaSearch() throws Exception {

		try {

			driver.launchApp();

			WebElement compose = driver.findElement(By.id(loadedCapabilities.getCOMPOSE_LAYOUT()));
			compose.click();

			WebElement to = driver.findElement(By.id(loadedCapabilities.getCURRECIP()));
			to.sendKeys(loadedCapabilities.getMDN());

			WebElement attach = driver.findElement(By.id(loadedCapabilities.getBTNATTACH()));
			attach.click();

			WebElement mediaSearchbtn = driver.findElement(By.name("Media Search"));
			mediaSearchbtn.click();

			List<MobileElement> selectTopic = driver.findElements(By.id(loadedCapabilities.getTIP()));
			selectTopic.get(2).click();

			WebDriverWait wait1 = new WebDriverWait(driver, 60);
			wait1.until(ExpectedConditions.elementToBeClickable(By.className(loadedCapabilities.getIMAGEVIEW())));

			WebElement attachResultLinkBtn = driver.findElementById(loadedCapabilities.getWEB_ATTACH_BUTTON());
			attachResultLinkBtn.click();

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			WebElement sendButton = driver.findElement(By.id(loadedCapabilities.getBTNSEND()));
			sendButton.click();

			driver.closeApp();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 6, alwaysRun = true)
	public void forwardMessage() {
		try {
			driver.launchApp();

			// Click on Compose button
			WebElement composeBtn = driver.findElement(By.id(loadedCapabilities.getCOMPOSE_LAYOUT()));
			composeBtn.click();

			// Enter Recipient mobile number
			WebElement to = driver.findElement(By.id(loadedCapabilities.getCURRECIP()));
			to.sendKeys(loadedCapabilities.getMDN());
			to.click();

			// Message to be sent with a random number for better identification

			Random r = new Random();

			String s1 = r.nextInt(10000) + " This is a test for forwarding a message";

			WebElement messageBox = driver.findElement(By.id(loadedCapabilities.getEMBEDDED_TEXT_EDITOR()));
			messageBox.sendKeys(s1);

			WebElement sendButton = driver.findElement(By.id(loadedCapabilities.getBTNSEND()));
			sendButton.click();

			driver.hideKeyboard();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// WebElement msgToBeForwarded = driver.findElementByName("Text1");

			List<WebElement> msgTobeForwarded = driver.findElementsById(loadedCapabilities.getTEXT());

			for (int i = 0; i < msgTobeForwarded.size(); i++) {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				if (msgTobeForwarded.get(i).getAttribute("text").equals(s1)) {
					TouchAction tAction = new TouchAction(driver);
					tAction.longPress(msgTobeForwarded.get(i)).perform();

					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

				}
			}

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			WebElement selectOption = driver.findElement(By.name("Forward Message"));
			selectOption.click();

			// WebElement replyMessage =
			// driver.findElement(By.id("com.verizon.messaging.vzmsgs:id/embedded_text_editor"));
			// replyMessage.sendKeys("This is a test Reply");

			WebElement toField = driver.findElementById(loadedCapabilities.getCURRECIP());
			toField.sendKeys(loadedCapabilities.getMDN());
			toField.click();

			WebElement sendBtn = driver.findElement(By.id(loadedCapabilities.getBTNSEND()));
			sendBtn.click();

			driver.closeApp();

		}

		catch (Exception e)

		{
			e.printStackTrace();
		}
	}

	@Test(priority = 7, alwaysRun = true)
	public void displayDrawerMenu()

	{
		driver.launchApp();
		// Locate and Click the DrawerIcon
		WebElement drawerIcon = driver.findElementById(loadedCapabilities.getDRAWER_ICON());
		drawerIcon.click();

		// Edit profile
		WebElement editProfilePen = driver.findElementById(loadedCapabilities.getEDIT_NAME_CONTAINER());
		boolean isEditProfilePenDisplayed = editProfilePen.isDisplayed();
		Assert.assertEquals(true, isEditProfilePenDisplayed);

		// Driving Mode
		WebElement drivingMode = driver.findElementByAccessibilityId("Driving Mode");
		boolean isDrivingModeDisplayed = drivingMode.isDisplayed();
		Assert.assertEquals(true, isDrivingModeDisplayed);

		// Restore
		WebElement restoreMessages = driver.findElementByAccessibilityId("Restore Messages");
		boolean isRestoreMessagesDisplayed = restoreMessages.isDisplayed();
		Assert.assertEquals(true, isRestoreMessagesDisplayed);

		// Settings
		WebElement settingsOption = driver.findElementByAccessibilityId("Settings");
		boolean isSettingsDisplayed = settingsOption.isDisplayed();
		Assert.assertEquals(true, isSettingsDisplayed);

		// What's New
		WebElement whatsNewOption = driver.findElementByAccessibilityId("What's New");
		boolean isWhatsNewDisplayed = whatsNewOption.isDisplayed();
		Assert.assertEquals(true, isWhatsNewDisplayed);

		// About
		WebElement aboutOption = driver.findElementByAccessibilityId("About");
		boolean isAboutDisplayed = aboutOption.isDisplayed();
		Assert.assertEquals(true, isAboutDisplayed);

		// Terms and conditions
		WebElement termsAndConditions = driver.findElementByAccessibilityId("Terms & Conditions");
		boolean isTerms = termsAndConditions.isDisplayed();
		Assert.assertEquals(true, isTerms);

		driver.scrollToExact("Privacy Policy");

		// Privacy Policy
		WebElement privacyPolicy = driver.findElementByAccessibilityId("Privacy Policy");
		boolean isPrivacy = privacyPolicy.isDisplayed();
		Assert.assertEquals(true, isPrivacy);

		driver.closeApp();
	}

	@Test(priority = 8, alwaysRun = true)
	public void clickAbout() {
		driver.launchApp();
		//
		WebElement drawerIcon = driver.findElementById(loadedCapabilities.getDRAWER_ICON());
		drawerIcon.click();

		WebElement aboutOption = driver.findElementByAccessibilityId("About");
		aboutOption.click();

		WebElement aboutDialog = driver.findElementById(loadedCapabilities.getDIALOG_TITLE());
		boolean isaboutDialogDisplayed = aboutDialog.isDisplayed();
		Assert.assertEquals(true, isaboutDialogDisplayed);

		if (isaboutDialogDisplayed) {
			WebElement OkBtn = driver.findElementById(loadedCapabilities.getPOSITIVE_BUTTON());
			OkBtn.click();
		}

		else {
			System.out.println("No About Dialog displayed");
		}

		driver.closeApp();

	}

	@Test(priority = 9, alwaysRun = true)
	public void clickTerms() {
		driver.launchApp();
		//
		WebElement drawerIcon = driver.findElementById(loadedCapabilities.getDRAWER_ICON());
		drawerIcon.click();

		WebElement termsOption = driver.findElementByAccessibilityId("Terms & Conditions");
		termsOption.click();

		WebElement termsDialog = driver.findElementById(loadedCapabilities.getDIALOG_TITLE());
		boolean isTermsDialogDisplayed = termsDialog.isDisplayed();
		Assert.assertEquals(true, isTermsDialogDisplayed);

		if (isTermsDialogDisplayed) {
			WebElement OkBtn = driver.findElementById(loadedCapabilities.getPOSITIVE_BUTTON());
			OkBtn.click();
		}

		else {
			System.out.println("No Terms Dialog displayed");
		}

		driver.closeApp();
	}

	@Test(priority = 10, alwaysRun = true)
	public void clickWhatsNew() {
		driver.launchApp();
		//
		WebElement drawerIcon = driver.findElementById(loadedCapabilities.getDRAWER_ICON());
		drawerIcon.click();

		WebElement whatsNew = driver.findElementByAccessibilityId("What's New");
		whatsNew.click();

		WebElement whatsNewScreen = driver.findElementById(loadedCapabilities.getTITLETEXT());
		boolean isWhatsNewScreenDisplayed = whatsNewScreen.isDisplayed();
		Assert.assertEquals(true, isWhatsNewScreenDisplayed);
		driver.closeApp();

	}

	@Test(priority = 11, alwaysRun = true)
	public void turnOnDrivingMode() {
		driver.launchApp();
		//
		WebElement drawerIcon = driver.findElementById(loadedCapabilities.getDRAWER_ICON());
		drawerIcon.click();

		WebElement slider = driver.findElementById(loadedCapabilities.getON_OFF_BTN_BOX());
		slider.click();

		WebElement closeBtn = driver.findElementById(loadedCapabilities.getPOSITIVE_BUTTON());
		closeBtn.click();

		driver.closeApp();
	}

	@Test(priority = 12, alwaysRun = true)
	public void clickPrivacyPolicy() {
		driver.launchApp();
		//
		WebElement drawerIcon = driver.findElementById(loadedCapabilities.getDRAWER_ICON());
		drawerIcon.click();

		driver.scrollToExact("Privacy Policy").click();

		WebElement privacyPolicyPage = driver.findElementById(loadedCapabilities.getURL_BAR());
		String url = privacyPolicyPage.getText();

		Assert.assertEquals(url, loadedCapabilities.getVZMESSAGES());

		driver.closeApp();

	}

	@Test(priority = 13, alwaysRun = true)
	public void clickSettings() {

		driver.launchApp();
		//
		WebElement drawerIcon = driver.findElementById(loadedCapabilities.getDRAWER_ICON());
		drawerIcon.click();

		WebElement settings = driver.findElementByAccessibilityId("Settings");
		settings.click();

		WebElement settingsScreen = driver.findElementByName("Settings");
		boolean isSettingsScreenDisplayed = settingsScreen.isDisplayed();
		Assert.assertEquals(true, isSettingsScreenDisplayed);
		driver.closeApp();

	}

	@Test(priority = 13, alwaysRun = true)
	public void clickRestoreMessages() {

		driver.launchApp();
		//
		WebElement drawerIcon = driver.findElementById(loadedCapabilities.getDRAWER_ICON());
		drawerIcon.click();

		WebElement RestoreMessages = driver.findElementByAccessibilityId("Restore Messages");
		RestoreMessages.click();

		WebElement restoreDialog = driver.findElementById(loadedCapabilities.getDIALOG_TITLE());
		boolean isRestoreDialogDisplayed = restoreDialog.isDisplayed();
		Assert.assertEquals(true, isRestoreDialogDisplayed);

		WebElement restoreFromSDCardOption = driver.findElementById(loadedCapabilities.getNEGATIVE_BUTTON());
		restoreFromSDCardOption.click();

		driver.closeApp();

	}

	@Test(priority = 14, alwaysRun = true)
	public void verifyDefaultSettings() throws MalformedURLException {

		WebElement drawerIcon = driver.findElement(By.id(loadedCapabilities.getDRAWER_ICON()));
		drawerIcon.click();

		WebElement settingsOption = driver.findElement(By.name("Settings"));
		settingsOption.click();

		List<WebElement> selectCheckBox1 = driver.findElements(By.className(loadedCapabilities.getCHECKBOX()));

		int sizeofList1 = selectCheckBox1.size();
		System.out.println(sizeofList1);
		for (int i = 0; i < 3; i++) {
			String checkedBoxesonScreen1 = selectCheckBox1.get(i).getAttribute("checked");
			System.out.println(checkedBoxesonScreen1);
			Assert.assertEquals("true", checkedBoxesonScreen1);
		}

		driver.scrollToExact("Send Read Receipts");

		List<WebElement> selectCheckBox2 = driver.findElements(By.className(loadedCapabilities.getCHECKBOX()));
		int sizeofList2 = selectCheckBox2.size();
		System.out.println(sizeofList2);
		for (int i = 0; i < sizeofList2; i++) {
			String checkedBoxesonScreen2 = selectCheckBox2.get(i).getAttribute("checked");
			System.out.println(" The status of the following checkBoxes are  " + checkedBoxesonScreen2);
			Assert.assertEquals("true", checkedBoxesonScreen2);
		}
	}

	@Test(priority = 15, alwaysRun = true)
	public void verifyDefaultAdvancedSettings() throws MalformedURLException {

		AndroidElement drawerIcon = (AndroidElement) driver.findElementById(loadedCapabilities.getDRAWER_ICON());
		drawerIcon.click();

		AndroidElement settingsOption = (AndroidElement) driver.findElement(By.name("Settings"));
		settingsOption.click();

		driver.scrollToExact("Advanced");

		TouchAction tAction = new TouchAction(driver);
		tAction.tap(driver.findElementByName("Advanced")).perform();

		List<WebElement> selectCheckBox1 = driver.findElements(By.className(loadedCapabilities.getCHECKBOX()));
		int chkboxesonScreen1 = selectCheckBox1.size();
		System.out.println("The number of checkboxes on Screen1 are " + chkboxesonScreen1);
		for (int i = 0; i < chkboxesonScreen1; i++) {
			String checkedBoxes = selectCheckBox1.get(i).getAttribute("checked");
			System.out.println(" The checked  status of this checkbox is " + checkedBoxes);
		}

		driver.scrollToExact("Change Name and Avatar");
		List<WebElement> selectCheckBox2 = driver.findElements(By.className(loadedCapabilities.getCHECKBOX()));
		int chkboxesonScreen2 = selectCheckBox2.size();
		System.out.println("The number of checkboxes on Screen2 are " + chkboxesonScreen2);
		for (int i = 0; i < chkboxesonScreen2; i++) {
			String checkedBoxes = selectCheckBox2.get(i).getAttribute("checked");
			System.out.println(" The checked  status of this checkbox is " + checkedBoxes);

		}

	}

	@Test (priority = 16, alwaysRun = true)
	  public void viewBackGroundsScreen() {
		  WebElement convGalleryOption = driver.findElementById(loadedCapabilities.getIMGCONVGALLERYOPTION());
		  	convGalleryOption.click();
		  
		  //Locate and click on the customize menu
		  WebElement customizeMenuBtn = driver.findElementByName("Customize");
		  	customizeMenuBtn.click();
		  
		  WebElement backGrounds = driver.findElementById(loadedCapabilities.getCUSTOMIZ_NAME());
		  	backGrounds.click();
		  
		  // Verify the text of the Header
		  WebElement backGroundHeader =driver.findElementById(loadedCapabilities.getHEADERTEXT());
		  	String backGroundHeaderTxt= backGroundHeader.getText();
		  	Assert.assertEquals(backGroundHeaderTxt, "All Conversations");
		 
		 // Verify the text of the SubHeader
		  WebElement backgroundSubHeader =driver.findElementById(loadedCapabilities.getSUBHEADERTEXT());
		  	String backGroundSubHeaderTxt= backgroundSubHeader.getText();
		  	Assert.assertEquals(backGroundSubHeaderTxt, "Backgrounds");
		 
		 //Verify if the From field is displayed
		  WebElement fromField=driver.findElementById(loadedCapabilities.getFROM());
		  	boolean isFromFieldDisplayed=fromField.isDisplayed();
		  	Assert.assertEquals(isFromFieldDisplayed, true);
		
		  	//Verify if the Subject field is displayed
		  WebElement subjectField=driver.findElementById(loadedCapabilities.getSUBJECT());
		  	boolean isSubjectFieldDisplayed=subjectField.isDisplayed();
		  	Assert.assertEquals(isSubjectFieldDisplayed, true);
		 
		//Verify if the unread counter is displayed
		  WebElement unreadCountField=driver.findElementById(loadedCapabilities.getUNREADCOUNT());
		  	boolean isUnreadCountFieldDisplayed=unreadCountField.isDisplayed();
		  	Assert.assertEquals(isUnreadCountFieldDisplayed, true);
		  
		//Verify if the date field is displayed		  
		  WebElement dateField=driver.findElementById(loadedCapabilities.getDATE());
		  	boolean isDateFieldDisplayed=dateField.isDisplayed();
		  	Assert.assertEquals(isDateFieldDisplayed, true);
		 
	    //Verify if theBackbuton is displayed and enabled
		  WebElement backBtn = driver.findElementById(loadedCapabilities.getUPBUTTON()
		  	if (backBtn.isDisplayed()&& backBtn.isEnabled()){
			   backBtn.click();
			  
		  	}
		  
		  	else { System.out.println("Display button is either disabled or not displayed");
			  
		  	}

		  
	  }

	@Test(priority = 17, alwaysRun = true)

	public void clickChangeBackGround() {
		WebElement convGalleryOption = driver.findElementById(loadedCapabilities.getIMGCONVGALLERYOPTION());
		convGalleryOption.click();

		WebElement customizeMenuBtn = driver.findElementByName("Customize");
		customizeMenuBtn.click();

		WebElement backGrounds = driver.findElementById(loadedCapabilities.getCUSTOMIZ_NAME());
		backGrounds.click();

		List<WebElement> identifyTile = driver.findElementsByClassName(loadedCapabilities.getRELATIVE_LAYOUT());

		// Tap on one of the tiles to change the background
		TouchAction selectBackGroundTile = new TouchAction(driver);
		selectBackGroundTile.tap(500, 1050).perform();

		// selectBackGroundTile.longPress(identifyTile, 500, 1100).perform();

	}

	@Test(priority = 18, alwaysRun = true)
	public void viewFontScreen() {
		WebElement convGalleryOption = driver.findElementById(loadedCapabilities.getIMGCONVGALLERYOPTION());
		convGalleryOption.click();

		WebElement customizeMenuBtn = driver.findElementByName("Customize");
		customizeMenuBtn.click();

		WebElement fontOption = driver.findElementByName("Font");
		fontOption.click();

		// Header
		WebElement fontScreenHeader = driver.findElementById(loadedCapabilities.getHEADERTEXT());
		String fontScreenHeaderTxt = fontScreenHeader.getText();
		Assert.assertEquals(fontScreenHeaderTxt, "All Conversations");

		WebElement fontScreenSubHeader = driver.findElementById(loadedCapabilities.getSUBHEADERTEXT());
		String fontScreenSubHeaderTxt = fontScreenSubHeader.getText();
		Assert.assertEquals(fontScreenSubHeaderTxt, "Manage Font");

		WebElement useDefaultFontSize = driver.findElementById(loadedCapabilities.getDEFAULTFONTSIZE());
		boolean isUseDefaultFontSizeChecked = useDefaultFontSize.isEnabled();
		Assert.assertEquals(isUseDefaultFontSizeChecked, true);

		WebElement useDefaultFontStyle = driver.findElementById(loadedCapabilities.getDEFAULTFONTSTYLE());
		boolean isUseDefaultFontStyleChecked = useDefaultFontStyle.isEnabled();
		Assert.assertEquals(isUseDefaultFontStyleChecked, true);

		WebElement backBtn = driver.findElementById(loadedCapabilities.getUPBUTTON());
		if (backBtn.isDisplayed() && backBtn.isEnabled()) {
			backBtn.click();
		}

		else {
			System.out.println("Back button is either disabled or not displayed");

		}

	}

	@Test(priority = 19, alwaysRun = true)
	public void changeFontSize() {
		WebElement convGalleryOption = driver.findElementById(loadedCapabilities.getIMGCONVGALLERYOPTION());
		convGalleryOption.click();

		WebElement customizeMenuBtn = driver.findElementByName("Customize");
		customizeMenuBtn.click();

		WebElement fontOption = driver.findElementByName("Font");
		fontOption.click();

		// Header

		WebElement useDefaultFontSize = driver.findElementById(loadedCapabilities.getDEFAULTFONTSIZE());

		// get the position and size of the slider
		WebElement changeFontSizeSlider = driver.findElementById(loadedCapabilities.getSEEKBAR());
		int xAxisStartPoint = changeFontSizeSlider.getLocation().getX();
		int width = changeFontSizeSlider.getSize().getWidth();
		System.out.println("The Width is " + width);
		int xAxisEndPoint = xAxisStartPoint + changeFontSizeSlider.getSize().getWidth();
		System.out.println("The start point is " + xAxisStartPoint);
		System.out.println("The end point is " + xAxisEndPoint);

		int yAxis = changeFontSizeSlider.getLocation().getY();
		System.out.println("The y axis " + yAxis);

		useDefaultFontSize.click();
		yAxis += 56;
		TouchAction act = new TouchAction(driver);
		act.longPress(changeFontSizeSlider, 704, 1000).perform();

		WebElement useDefaultFontStyle = driver.findElementById(loadedCapabilities.getDEFAULTFONTSTYLE());
		String isUseDefaultFontStyleChecked = useDefaultFontStyle.getAttribute("checked");
		Assert.assertEquals(isUseDefaultFontStyleChecked, "true");

		WebElement backBtn = driver.findElementById(loadedCapabilities.getUPBUTTON());
		if (backBtn.isDisplayed() && backBtn.isEnabled()) {
			backBtn.click();

		}

		else {

			System.out.println("Back button is either disabled or not displayed");

		}

		// com.verizon.messaging.vzmsgs:id/upButton

	}

	@Test(priority = 20, alwaysRun = true)
	public void changeFontStyle() {
		WebElement convGalleryOption = driver.findElementById(loadedCapabilities.getIMGCONVGALLERYOPTION());
		convGalleryOption.click();

		WebElement customizeMenuBtn = driver.findElementByName("Customize");
		customizeMenuBtn.click();

		WebElement fontOption = driver.findElementByName("Font");
		fontOption.click();

		// Uncheck the existing default font style
		WebElement changeFontStyle = driver.findElementById(loadedCapabilities.getDEFAULTFONTSTYLE());
		String isUseDefaultFontStyleChecked = changeFontStyle.getAttribute("checked");
		changeFontStyle.click();

		// Select the font style Sketch block bold
		WebElement fontStyle = driver.findElementByAccessibilityId("SKETCH_BLOCK_BOLD");
		fontStyle.click();

	}

	@Test(priority = 21, alwaysRun = true)
	public void viewLEDColorScreen() {
		WebElement convGalleryOption = driver.findElementById(loadedCapabilities.getIMGCONVGALLERYOPTION());
		convGalleryOption.click();

		WebElement customizeMenuBtn = driver.findElementByName("Customize");
		customizeMenuBtn.click();

		WebElement ledColorOption = driver.findElementByName("LED Color");
		ledColorOption.click();

		// Header
		WebElement headerLedColors = driver.findElementById(loadedCapabilities.getDIALOG_TITLE());
		String headerLedColorsTxt = headerLedColors.getText();
		Assert.assertEquals(headerLedColorsTxt, "LED Color");

		WebElement subHeaderLedColors = driver.findElementById(loadedCapabilities.getDIALOG_SUB_TITLE());
		String subHeaderLedColorsTxt = subHeaderLedColors.getText();
		Assert.assertEquals(subHeaderLedColorsTxt, "Select an option from below:");

	}

	@Test
	public void changeLEDColorScreen() {
		WebElement convGalleryOption = driver.findElementById(loadedCapabilities.getIMGCONVGALLERYOPTION());
		convGalleryOption.click();

		WebElement customizeMenuBtn = driver.findElementByName("Customize");
		customizeMenuBtn.click();

		WebElement ledColorOption = driver.findElementByName("LED Color");
		ledColorOption.click();

		List<WebElement> selectLedColor = driver.findElementsById(loadedCapabilities.getCOLORCIRCLETEXTVIEW());
		selectLedColor.get(2).click();

		WebElement selectSaveBtn = driver.findElementById(loadedCapabilities.getPOSITIVE_BUTTON());
		selectSaveBtn.click();

		// Assert.assertEquals(currentDefaultLedColor, selectLedColor);

	}

	@BeforeClass
	public void setUp() throws MalformedURLException {

		// set up appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		loadedCapabilities = HandlerUtility.getCapabilities();
		capabilities.setCapability(APIConstants.DEVICE, loadedCapabilities.getDEVICE());
		capabilities.setCapability(APIConstants.PLATFORMNAME, loadedCapabilities.getPLATFORM_NAME());
		capabilities.setCapability(APIConstants.DEVICENAME, loadedCapabilities.getDEVICE_NAME());
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability(CapabilityType.VERSION, loadedCapabilities.getVERSION());
		capabilities.setCapability(CapabilityType.PLATFORM, loadedCapabilities.getPLATFORM());
		capabilities.setCapability(APIConstants.NORESET, loadedCapabilities.getNORESET());
		capabilities.setCapability(APIConstants.APP, loadedCapabilities.getFILE_PATH());
		capabilities.setCapability(APIConstants.APP_PACKAGE, loadedCapabilities.getAPP_PACKAGE());
		capabilities.setCapability(APIConstants.APP_ACTIVITY, loadedCapabilities.getAPP_ACTIVITY());
		capabilities.setCapability(APIConstants.APPWAITACTVITY, loadedCapabilities.getAPP_ACTIVITY());
		driver = new AndroidDriver(new URL(loadedCapabilities.getURL()), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@AfterClass
	public void tearDown() throws Exception {
		// driver.quit();
	}

}
