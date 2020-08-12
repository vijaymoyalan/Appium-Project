package SDET.GoogleChrome;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class activity3 {
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
	
  @Test(dataProvider = "Credentials")
  public void activity3(String UserName,String password,String Confirmation) {
	  	      
	        driver.get("https://www.training-support.net/selenium");
	        wait = new WebDriverWait(driver, 10);
	        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]")));
	        
	        String pageTitle = driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]").getText();
	        System.out.println("Title on Homepage: " + pageTitle);
	       
	        driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Get Started!']")).click();
	        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollForward(3).scrollIntoView(textStartsWith(\"Popups\"))"));
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        driver.findElement(MobileBy.xpath("//android.webkit.WebView/android.view.View[2]/android.view.View[3]/android.view.View[19]/android.view.View")).click();
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.webkit.WebView/android.view.View[1]/android.view.View[4]/android.widget.Button")));
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        driver.findElementByXPath("//android.webkit.WebView/android.view.View[1]/android.view.View[4]/android.widget.Button").click();
	        
	        // passing the userid and password
			driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id='username']")).sendKeys(UserName);
			driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id='password']")).sendKeys(password);
	        
			//clicking on the button
	        driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        String actualText = driver.findElement(MobileBy.xpath("//android.view.View[@resource-id='action-confirmation']")).getText();

			System.out.println(actualText);
			Assert.assertEquals(actualText, Confirmation);
	    }
	    
	    @DataProvider(name = "Credentials")
	    public String[][] authenticationMethod(){

			String[][] data=new String[2][3];

			data[0][0]="admin";
			data[0][1]="password";
			data[0][2]="Welcome Back, admin";

			data[1][0]="admin";
			data[1][1]="admin123";
			data[1][2]="Invalid Credentials";

			return data;	
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
