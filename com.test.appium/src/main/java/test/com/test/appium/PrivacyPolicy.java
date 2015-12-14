/**
 * The PrivacyPolicy program is used to test whether the user navigates to the right url,
 *  which contains the Privacy Policy
 *
 * @author  Guruprasad B. Gopinath
 * @version 1.0
 * @since   2015-09-01 
 */

package test.com.test.appium;

import java.net.MalformedURLException;

// import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;




public class PrivacyPolicy extends SupportSetUp{

	@Test
	public void clickPrivacyPolicy() {
		//
		WebElement drawerIcon= driver.findElementById(configuredCapabilities.getDRAWER_ICON());
		drawerIcon.click();
		
		driver.scrollToExact("Privacy Policy").click();

		/*WebElement privacyPolicyOption=driver.findElementByAccessibilityId("Privacy Policy");
		privacyPolicyOption.click();
*/
		/*WebElement selectJustOnce = driver.findElementById("android:id/button_once");
		selectJustOnce.click();*/

		WebElement privacyPolicyPage= driver.findElementById(configuredCapabilities.getURL_BAR());
		String url = privacyPolicyPage.getText();


		Assert.assertEquals(url, configuredCapabilities.getVZMESSAGES());


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




