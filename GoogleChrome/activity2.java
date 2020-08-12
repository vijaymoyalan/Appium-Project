package SDET.GoogleChrome;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class activity2 {
	
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
	System.out.println("Google Task is opened");
  }
  
  
  @Test
  public void loginPage() {
	  
	  driver.get("https://www.training-support.net/selenium");
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
  //    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@text='Get Started!']")));
	  driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Get Started!']")).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	  driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true).instance(0)).scrollForward(2).scrollIntoView(textStartsWith(\"Login Form\"))")).click();
		
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   	
	  driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).sendKeys("admin");
  	  driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("password");

  	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	       
	  driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Log in']")).click();
	      	        
	  String correctLogin = driver.findElement(MobileBy.xpath("//android.view.View[@text='Welcome Back, admin']")).getText();
	  Assert.assertEquals(correctLogin, "Welcome Back, admin");
	        
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
	  driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).clear();
	  driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).sendKeys("Admin");
	     
	  driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).clear();
	  driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("Password");
	        
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Log in']")).click();
	        
	  String incorrectLogin = driver.findElement(MobileBy.xpath("//android.view.View[@text='Invalid Credentials']")).getText();
	  Assert.assertEquals(incorrectLogin, "Invalid Credentials");	
  }

  @AfterClass
  public void afterClass() {
  }

}
