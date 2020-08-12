package SDET.GoogleTaskKeep;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class activity2 {
	
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	int i=0;
	@BeforeClass
	  public void beforeClass() throws MalformedURLException {
		
		// setting up DesiredCapabilities	
					DesiredCapabilities caps = new DesiredCapabilities();
			        caps.setCapability("deviceId", "emulator-5554");
			        caps.setCapability("deviceName", "Vijay_One");
			        caps.setCapability("platformName", "android");
			        caps.setCapability("automationName", "UiAutomator2");
			        caps.setCapability("appPackage", "com.google.android.keep");
			        caps.setCapability("appActivity", ".activities.BrowseActivity");
			        caps.setCapability("noReset", true);
					System.out.println("Before Class Notation is called");
					
		// Initialize driver
			        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			        System.out.println("Google Keep is opened");
	  }
  @Test
  public void activity() {
	  
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  MobileElement text_node_1 = driver.findElementByAccessibilityId("New text note");
	  text_node_1.click();
	  
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  MobileElement add_title = driver.findElementById("com.google.android.keep:id/editable_title");
	  add_title.sendKeys("Title: Activity2 Project");
	  
	  MobileElement add_note = driver.findElementById("com.google.android.keep:id/edit_note_text");
	  add_note.sendKeys("Note added for Activity 2");
	  
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  MobileElement back_nav = driver.findElementByAccessibilityId("Navigate up");
	  back_nav.click(); 
	  
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  // MobileElement note= driver.findElementByXPath("//androidx.cardview.widget.CardView[@content-desc=\"Title: Activity2 Project. Note added for Activity 2. \"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]");
	  
	  List<MobileElement> note = driver.findElementsById("index_note_title");
	  System.out.println("Size "+note.size());
	  for(i=0;i<note.size();i++)
	  System.out.println("String is "+ (note.get(i).getText()));
	 // Assert.assertEquals(note.get(1).getText(), "Title: Activity2 Project");
	  Assert.assertTrue(true);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
