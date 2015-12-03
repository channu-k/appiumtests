package com.verizon.utility;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import io.appium.java_client.remote.MobileCapabilityType;

public class UtilityParser extends DefaultHandler {

	/*
	 * <BROWSER_NAME>Android</BROWSER_NAME> <VERSION>4.4.2</VERSION>
	 * <DEVICE_NAME>Android Emulator</DEVICE_NAME>
	 * <PLATFORM_NAME>Android</PLATFORM_NAME>
	 * <APP_PACKAGE>com.twitter.android</APP_PACKAGE>
	 * <APP_ACTIVITY>.LoginActivity</APP_ACTIVITY>
	 */

	DesiredCapabilities capabilities;
	private static String APP_ACTIVITY = "app-activity";
	private static String APP_PACKAGE = "app-package";
	ElementsUtility elementsUtility = new ElementsUtility();

	private static String FILE_PATH;
	private static String URL;

	boolean bMDN = false;

	boolean bURL = false;

	boolean bBROWSER_NAME = false;
	boolean bVERSION = false;
	boolean bDEVICE_NAME = false;
	boolean bPLATFORM_NAME = false;
	boolean bAPP_PACKAGE = false;
	boolean bAPP_ACTIVITY = false;
	boolean bFILE_PATH = false;

	boolean bDIALOG_TITLE = false;
	boolean bPOSITIVE_BUTTON = false;
	boolean bDRAWER_ICON = false;

	boolean bCOMPOSE_LAYOUT = false;
	boolean bCURRECIP = false;
	boolean bEMBEDDED_TEXT_EDITOR = false;

	boolean bBTNATTACH = false;
	boolean bGRID = false;
	boolean bNAVBAR_BUTTON1 = false;
	boolean bBTNSEND = false;

	boolean bOKAYBUTTON;
	boolean bPAGER;

	boolean bIMGCONVGALLERYOPTION;
	boolean bCUSTOMIZ_NAME;
	boolean bHEADERTEXT;
	boolean bSUBHEADERTEXT;
	boolean bFROM;
	boolean bSUBJECT;
	boolean bUNREADCOUNT;
	boolean bDATE;
	boolean bUPBUTTON;

	boolean bCAPTURE;

	boolean bDEFAULTBUBBLETYPE;
	boolean bDEFAULTFONTSIZE;
	boolean bDEFAULTFONTSTYLE;
	boolean bSEEKBAR;
	boolean bCOLORCIRCLETEXTVIEW;

	boolean bCHECKBOX;
	boolean bBUTTON1;

	boolean bTEXT1;
	boolean bPROV_ACCEPTBUTTON;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) {

		if (qName.equalsIgnoreCase("BROWSER_NAME")) {
			bBROWSER_NAME = true;
		} else if (qName.equalsIgnoreCase("VERSION")) {
			bVERSION = true;
		} else if (qName.equalsIgnoreCase("DEVICE_NAME")) {
			bDEVICE_NAME = true;
		} else if (qName.equalsIgnoreCase("PLATFORM_NAME")) {
			bPLATFORM_NAME = true;
		} else if (qName.equalsIgnoreCase("APP_PACKAGE")) {
			bAPP_PACKAGE = true;
		} else if (qName.equalsIgnoreCase("APP_ACTIVITY")) {
			bAPP_ACTIVITY = true;
		} else if (qName.equalsIgnoreCase("FILE_PATH")) {
			bFILE_PATH = true;
		} else if (qName.equalsIgnoreCase("DIALOG_TITLE")) {
			bDIALOG_TITLE = true;
		} else if (qName.equalsIgnoreCase("POSITIVE_BUTTON")) {
			bPOSITIVE_BUTTON = true;
		} else if (qName.equalsIgnoreCase("DRAWER_ICON")) {
			bDRAWER_ICON = true;
		} else if (qName.equalsIgnoreCase("URL")) {
			bURL = true;
		} else if (qName.equalsIgnoreCase("MDN")) {
			bMDN = true;
		} else if (qName.equalsIgnoreCase("COMPOSE_LAYOUT")) {
			bCOMPOSE_LAYOUT = true;
		} else if (qName.equalsIgnoreCase("CURRECIP")) {
			bCURRECIP = true;
		} else if (qName.equalsIgnoreCase("EMBEDDED_TEXT_EDITOR")) {
			bEMBEDDED_TEXT_EDITOR = true;
		} else if (qName.equalsIgnoreCase("BTNATTACH")) {
			bBTNATTACH = true;
		} else if (qName.equalsIgnoreCase("GRID")) {
			bGRID = true;
		} else if (qName.equalsIgnoreCase("NAVBAR_BUTTON1")) {
			bNAVBAR_BUTTON1 = true;
		} else if (qName.equalsIgnoreCase("BTNSEND")) {
			bBTNSEND = true;
		} else if (qName.equalsIgnoreCase("OKAYBUTTON")) {
			bOKAYBUTTON = true;
		} else if (qName.equalsIgnoreCase("PAGER")) {
			bPAGER = true;
		} else if (qName.equalsIgnoreCase("IMGCONVGALLERYOPTION")) {
			bIMGCONVGALLERYOPTION = true;
		} else if (qName.equalsIgnoreCase("CUSTOMIZ_NAME")) {
			bCUSTOMIZ_NAME = true;
		} else if (qName.equalsIgnoreCase("HEADERTEXT")) {
			bHEADERTEXT = true;
		} else if (qName.equalsIgnoreCase("SUBHEADERTEXT")) {
			bSUBHEADERTEXT = true;
		} else if (qName.equalsIgnoreCase("FROM")) {
			bFROM = true;
		} else if (qName.equalsIgnoreCase("SUBJECT")) {
			bSUBJECT = true;
		} else if (qName.equalsIgnoreCase("UNREADCOUNT")) {
			bUNREADCOUNT = true;
		} else if (qName.equalsIgnoreCase("DATE")) {
			bDATE = true;
		} else if (qName.equalsIgnoreCase("UPBUTTON")) {
			bUPBUTTON = true;
		} else if (qName.equalsIgnoreCase("CAPTURE")) {
			bCAPTURE = true;
		} else if (qName.equalsIgnoreCase("DEFAULTBUBBLETYPE")) {
			bDEFAULTBUBBLETYPE = true;
		} else if (qName.equalsIgnoreCase("DEFAULTFONTSIZE")) {
			bDEFAULTFONTSIZE = true;
		} else if (qName.equalsIgnoreCase("DEFAULTFONTSTYLE")) {
			bDEFAULTFONTSTYLE = true;
		} else if (qName.equalsIgnoreCase("SEEKBAR")) {
			bSEEKBAR = true;
		} else if (qName.equalsIgnoreCase("COLORCIRCLETEXTVIEW")) {
			bCOLORCIRCLETEXTVIEW = true;
		} else if (qName.equalsIgnoreCase("CHECKBOX")) {
			bCHECKBOX = true;
		} else if (qName.equalsIgnoreCase("BUTTON1")) {
			bBUTTON1 = true;
		} else if (qName.equalsIgnoreCase("TEXT1")) {
			bTEXT1 = true;
		} else if (qName.equalsIgnoreCase("PROV_ACCEPTBUTTON")) {
			bPROV_ACCEPTBUTTON = true;
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {

		if (bBROWSER_NAME) {
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, new String(ch, start, length));
			bBROWSER_NAME = false;
		} else if (bVERSION) {
			capabilities.setCapability(MobileCapabilityType.VERSION, new String(ch, start, length));
			bVERSION = false;
		} else if (bDEVICE_NAME) {
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, new String(ch, start, length));
			bDEVICE_NAME = false;
		} else if (bPLATFORM_NAME) {
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, new String(ch, start, length));
			bPLATFORM_NAME = false;
		} else if (bAPP_PACKAGE) {
			capabilities.setCapability(APP_PACKAGE, new String(ch, start, length));
			bAPP_PACKAGE = false;
		} else if (bAPP_ACTIVITY) {
			capabilities.setCapability(APP_ACTIVITY, new String(ch, start, length));
			bAPP_ACTIVITY = false;
		} else if (bFILE_PATH) {
			FILE_PATH = new String(ch, start, length);
			bFILE_PATH = false;
		} else if (bDIALOG_TITLE) {
			elementsUtility.setDialog_title(new String(ch, start, length));
			bDIALOG_TITLE = false;
		} else if (bPOSITIVE_BUTTON) {
			elementsUtility.setPositive_button(new String(ch, start, length));
			bPOSITIVE_BUTTON = false;
		} else if (bDRAWER_ICON) {
			elementsUtility.setDrawerIcon(new String(ch, start, length));
			bDRAWER_ICON = false;
		} else if (bURL) {
			URL = new String(ch, start, length);
			bURL = false;
		} else if (bMDN) {
			elementsUtility.setMDN(new String(ch, start, length));
			bMDN = false;
		} else if (bCOMPOSE_LAYOUT) {
			elementsUtility.setCompose_layout(new String(ch, start, length));
			bCOMPOSE_LAYOUT = false;
		} else if (bCURRECIP) {
			elementsUtility.setCurRecip(new String(ch, start, length));
			bCURRECIP = false;
		} else if (bEMBEDDED_TEXT_EDITOR) {
			elementsUtility.setEmbedded_text_editor(new String(ch, start, length));
			bEMBEDDED_TEXT_EDITOR = false;
		} else if (bBTNATTACH) {
			elementsUtility.setBtnAttach(new String(ch, start, length));
			bBTNATTACH = false;
		} else if (bGRID) {
			elementsUtility.setGrid(new String(ch, start, length));
			bGRID = false;
		} else if (bNAVBAR_BUTTON1) {
			elementsUtility.setNavbar_button1(new String(ch, start, length));
			bNAVBAR_BUTTON1 = false;
		} else if (bBTNSEND) {
			elementsUtility.setBtnSend(new String(ch, start, length));
			bBTNSEND = false;
		} else if (bOKAYBUTTON) {
			elementsUtility.setOkayButton(new String(ch, start, length));
			bOKAYBUTTON = false;
		} else if (bPAGER) {
			elementsUtility.setPager(new String(ch, start, length));
			bPAGER = false;
		} else if (bIMGCONVGALLERYOPTION) {
			elementsUtility.setImgConvGalleryOption(new String(ch, start, length));
			bIMGCONVGALLERYOPTION = false;
		} else if (bCUSTOMIZ_NAME) {
			elementsUtility.setCustomiz_name(new String(ch, start, length));
			bCUSTOMIZ_NAME = false;
		} else if (bHEADERTEXT) {
			elementsUtility.setHeaderText(new String(ch, start, length));
			bHEADERTEXT = false;
		} else if (bSUBHEADERTEXT) {
			elementsUtility.setSubHeaderText(new String(ch, start, length));
			bSUBHEADERTEXT = false;
		} else if (bFROM) {
			elementsUtility.setFrom(new String(ch, start, length));
			bFROM = false;
		} else if (bSUBJECT) {
			elementsUtility.setSubject(new String(ch, start, length));
			bSUBJECT = false;
		} else if (bUNREADCOUNT) {
			elementsUtility.setUnreadcount(new String(ch, start, length));
			bUNREADCOUNT = false;
		} else if (bDATE) {
			elementsUtility.setDate(new String(ch, start, length));
			bDATE = false;
		} else if (bUPBUTTON) {
			elementsUtility.setUpButton(new String(ch, start, length));
			bUPBUTTON = false;
		} else if (bCAPTURE) {
			elementsUtility.setCapture(new String(ch, start, length));
			bCAPTURE = false;
		} else if (bDEFAULTBUBBLETYPE) {
			elementsUtility.setDefaultBubbleType(new String(ch, start, length));
			bDEFAULTBUBBLETYPE = false;
		} else if (bDEFAULTFONTSIZE) {
			elementsUtility.setDefaultFontSize(new String(ch, start, length));
			bDEFAULTFONTSIZE = false;
		} else if (bDEFAULTFONTSTYLE) {
			elementsUtility.setDefaultFontStyle(new String(ch, start, length));
			bDEFAULTFONTSTYLE = false;
		} else if (bSEEKBAR) {
			elementsUtility.setSeekbar(new String(ch, start, length));
			bSEEKBAR = false;
		} else if (bCOLORCIRCLETEXTVIEW) {
			elementsUtility.setColorCircleTextView(new String(ch, start, length));
			bCOLORCIRCLETEXTVIEW = false;
		} else if (bCHECKBOX) {
			elementsUtility.setCheckBox(new String(ch, start, length));
			bCHECKBOX = false;
		} else if (bBUTTON1) {
			elementsUtility.setButton1(new String(ch, start, length));
			bBUTTON1 = false;
		} else if (bTEXT1) {
			elementsUtility.setText1(new String(ch, start, length));
			bTEXT1 = false;
		} else if (bPROV_ACCEPTBUTTON) {
			elementsUtility.setProv_acceptButton(new String(ch, start, length));
			bPROV_ACCEPTBUTTON = false;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
	}

	public DesiredCapabilities getCapabilities() {
		return capabilities;
	}

	public String getFilePath() {
		return FILE_PATH;
	}

	public String getURL() {
		return URL;
	}
}