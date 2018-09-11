package com.Jupiter.Helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Utility {
	WebDriver driver;

/*	public void browser(String browser) {

		if (browser == "chrome") {
			System.setProperty("webdriver.chrome.driver", "D:\\$elenium_Work$pace\\Credit-TestNG\\chromedriver.exe");

			driver = new ChromeDriver();
			driver.get("http://jupiter.cloud.planittesting.com");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		} else if (browser == "firefox") {
			System.setProperty("webdriver.geckodriver.driver",
					"D:\\$elenium_Work$pace\\Credit-TestNG\\geckodriver.exe");
			driver.get("http://jupiter.cloud.planittesting.com");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
	}*/
	public void browser(String url) {
		System.setProperty("webdriver.chrome.driver", "D:\\$elenium_Work$pace\\JupiterToysTest\\chromedriver.exe");
		System.out.println(url);
		driver = new ChromeDriver();
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public Properties readProperties() throws IOException {
		FileInputStream io = new FileInputStream("D:\\$elenium_Work$pace\\JupiterToysTest\\src\\util.properties");
		Properties prop = new Properties();
		prop.load(io);
		return prop;

	}
	public String getTextbyXpath(String id) {
		return driver.findElement(By.xpath(id)).getText();
	}
	public void type(String id, String value) {
		driver.findElement(By.id(id)).sendKeys(value);
	}

	public void click(String id) {
		driver.findElement(By.xpath(id)).click();
	}
	public void wait_implicit() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void selectDropdown(String id, String opt) {
		Select dropdown = new Select(driver.findElement(By.xpath(id)));
		dropdown.selectByVisibleText(opt);
	}

	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
