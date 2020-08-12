package SDET.GoogleChrome;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class activity1 {
	
	AppiumDriver<MobileElement> driver;
	WebDriverWait wait;
	
	@BeforeClass
	  public void beforeClass() throws MalformedURLException {
		
		// setting up DesiredCapabilities	
		DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "emulator-5554");
        caps.setCapability("deviceName", "Vijay_One");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("chromedriverExecutable","C:\\Vijay\\Automation\\chromedriver_win32\\chromedriver.exe");
        caps.setCapability("noReset", true);
		System.out.println("Before Class Notation is called");
		
		// Initialize driver
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        System.out.println("Chorme Browser is opened");
	  }
	
	
	@Test
	  public void chrome_activity1() throws InterruptedException {
		
		  driver.get("https://www.training-support.net/selenium");
		
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  driver.findElement(MobileBy.xpath("//android.widget.Button[@text=\"Get Started!\"]")).click();
		  
		  driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true).instance(0)).scrollForward(2).scrollIntoView(textStartsWith(\"To-Do List\"))")).click();
		  ArrayList<String> tasklist = new ArrayList<String>();
		  tasklist.add("Complete Activity with Google Tasks");
		  tasklist.add("Complete Activity with Google Keep");
		  tasklist.add("Complete the second Activity Google Keep");
		  
		  for (String task : tasklist) 
		  { 
		  driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
		  MobileElement button = driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
		  button.sendKeys(task);
		  driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  }
		  
		  List<MobileElement> todoList = driver.findElementsById("com.google.android.apps.tasks:id/task_name");
		  for (MobileElement task: todoList) 
		  {
			  System.out.println(task.getText());
		  }
		  assertEquals(todoList.get(2).getText(),"Complete Activity with Google Tasks");
		  assertEquals(todoList.get(1).getText(),"Complete Activity with Google Keep");
		  assertEquals(todoList.get(0).getText(),"Complete the second Activity Google Keep");
	  }
	  
	
	@AfterClass
	  public void afterClass() {
		driver.close();
	  }

}
