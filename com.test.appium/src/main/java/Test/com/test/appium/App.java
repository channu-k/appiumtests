package Test.com.test.appium;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { About.class, Attachment.class, Audio.class, BackGroundsScreen.class,
				BigText.class, Camera.class, ChangeConversationBubble.class, ChangeFontSize.class, ChangeLEDColor.class, ChangeTones.class });

		testng.addListener(tla);
		testng.run();

	}
}
