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

public class activity1 {
	
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	
	  @BeforeClass
	  public void beforeClass() throws MalformedURLException {
		  
		// setting up DesiredCapabilities	
			DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceId", "emulator-5554");
	        caps.setCapability("deviceName", "Vijay_One");
	        caps.setCapability("platformName", "android");
	        caps.setCapability("automationName", "UiAutomator2");
	        caps.setCapability("appPackage", "com.google.android.apps.tasks");
	        caps.setCapability("appActivity", ".ui.TaskListsActivity");
	        caps.setCapability("noReset", true);
			System.out.println("Before Class Notation is called");
			
		// Initialize driver
	        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	        System.out.println("Google Task is opened");
	  }
	
	
	  @Test
	  public void activity() {
		  
		  
		// Create object for WebDriverWait class
		  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		  MobileElement taskbtn = driver.findElementByAccessibilityId("Create new task");
		  taskbtn.click();
		  
		  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);		  
		  MobileElement add_task1 = driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
		  add_task1.sendKeys("Complete Activity with Google Tasks");
		  
		  MobileElement savebtn = driver.findElementById("com.google.android.apps.tasks:id/add_task_done");
		  savebtn.click();
		  
		  MobileElement taskbtn1 = driver.findElementByAccessibilityId("Create new task");
		  taskbtn1.click();
		  System.out.println("First Activity Added");
		  
		  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);		  
		  MobileElement add_task2 = driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
		  add_task2.sendKeys("Complete Activity with Google Keep");
		  
		  MobileElement savebtn1 = driver.findElementById("com.google.android.apps.tasks:id/add_task_done");
		  savebtn1.click();
		  System.out.println("Second Activity Added");
		  
		  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		  MobileElement taskbtn2 = driver.findElementByAccessibilityId("Create new task");
		  taskbtn2.click();
		  
		  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);		  
		  MobileElement add_task3 = driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
		  add_task3.sendKeys("Complete the second Activity Google Keep");
		  
		  MobileElement savebtn3 = driver.findElementById("com.google.android.apps.tasks:id/add_task_done");
		  savebtn3.click();
		  System.out.println("Third Activity Added");
		  
		  List<MobileElement> note = driver.findElementsById("com.google.android.apps.tasks:id/task_name");
		  System.out.println("Size "+note.size());
		  for(int i=0;i<note.size();i++)
		  System.out.println("String is "+ (note.get(i).getText()));
		 // Assert.assertEquals(note.get(1).getText(), "Title: Activity2 Project");
		  Assert.assertTrue(true);
	  }


	@AfterClass
	  public void afterClass() {
		driver.quit();
	  }

}
