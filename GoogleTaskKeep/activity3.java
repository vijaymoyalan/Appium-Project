package SDET.GoogleTaskKeep;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class activity3 {
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
	  add_title.sendKeys("Title: Activity3 Project");
	  
	  MobileElement add_note = driver.findElementById("com.google.android.keep:id/edit_note_text");
	  add_note.sendKeys("Note added for Activity 3 along with reminder set");
	  
	  // clicking on reminder ICON
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  driver.findElementById("com.google.android.keep:id/menu_switch_to_list_view").click();
	  
	  // selection of time as per requirement
	  driver.manage().timeouts().implicitlyWait(3,  TimeUnit.SECONDS);
	  driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Reminder\"]").click();
  	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.keep:id/save")));
  	  driver.findElement(MobileBy.id("com.google.android.keep:id/time_spinner")).click();
  	  driver.findElementById("com.google.android.keep:id/reminder_time_afternoon").click();
  	  driver.findElementById("com.google.android.keep:id/save").click();
  	  driver.manage().timeouts().implicitlyWait(3,  TimeUnit.SECONDS);
  	  driver.findElementByAccessibilityId("Open navigation drawer").click();
  }

  @AfterClass
  public void afterClass() {
	 driver.quit();
  }

}
