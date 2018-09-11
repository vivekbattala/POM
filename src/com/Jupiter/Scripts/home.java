package com.Jupiter.Scripts;

import org.testng.annotations.Test;

import com.oracle.tools.packager.Log;

import org.testng.annotations.BeforeTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class home {
	WebDriver driver;
	String title;

	@BeforeTest
	public void beforeTest() {
		ChromeOptions options=new ChromeOptions();
		Map<String, Object> prefs=new HashMap<String,Object>();
		prefs.put("profile.default_content_setting_values.notifications", 1);
		//******1-Allow, 2-Block, 0-default*****
		options.setExperimentalOption("prefs",prefs);
		// Handle Browser Notifications
		
		System.setProperty("webdriver.chrome.driver", "D:\\$elenium_Work$pace\\Credit-TestNG\\chromedriver.exe");

		driver = new ChromeDriver(options);
		driver.get("http://jupiter.cloud.planittesting.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
  @Test()
  public void Validate() {
	  driver.findElement(By.xpath("//a[contains(text(),'Contact')]")).click();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.findElement(By.id("forename")).sendKeys("xyz");
	  driver.findElement(By.id("message")).sendKeys("Test123");
	  driver.findElement(By.id("email")).sendKeys("y.b@sd.c");
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//a[@class='btn-contact btn btn-primary']")).click();
	  //driver.findElement(By.id("forename")).sendKeys("abc");
	 
	String loc_name_err=driver.findElement(By.xpath("//span[@id='forename-err']")).getText().toString();
	  String loc_email_err=driver.findElement(By.xpath("//span[@id='email-err']")).getText().toString();
	  String loc_msg_err=driver.findElement(By.xpath("//span[@id='message-err']")).getText().toString();
	  
	  System.out.println(loc_email_err+loc_msg_err+loc_name_err);
	  	 //Email is required 
	  String error_msg=loc_name_err+loc_email_err+loc_msg_err;
	  if (error_msg.length()>0) {
		  System.out.println("please Enter Values");
		  driver.close();
	  }
	  else {
		  main();
	  }
  }
@Test
public void main()
{
System.out.println("enter the main Block");
	}

  @AfterTest
  public void afterTest() {
  }

}
