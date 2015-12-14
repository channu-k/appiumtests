package test.com.test.appium;

import static org.testng.AssertJUnit.assertEquals;

import java.net.MalformedURLException;

// import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;

public class VerifyText extends SupportSetUp {

	@Test
	public void verifyConversationScreenHeader() {
		/*
		 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 * WebElement accept = driver.findElement(By.id(
		 * "com.verizon.messaging.vzmsgs:id/prov_acceptButton"));
		 * accept.click();
		 */

		WebElement appHeader = driver.findElement(By.id(configuredCapabilities.getHEADER()));
		String s = appHeader.getText();
		System.out.println("value " + s);
		assertEquals(s, "Conversations");

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
