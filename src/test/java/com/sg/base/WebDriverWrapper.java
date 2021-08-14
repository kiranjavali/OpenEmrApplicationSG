package com.sg.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class WebDriverWrapper {

	protected WebDriver driver;
	@BeforeMethod
	@Parameters({"browser"})
	public void setup(String browser)
	{
		//String browser="ch";
				
		if (browser.equalsIgnoreCase("ff"))
		{
		System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver.exe");
		driver= new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "src/test/resources/driver/chromedriver.exe");
			driver= new ChromeDriver();
			
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
			driver= new ChromeDriver();
		}
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get("http://demo.openemr.io/b/openemr");
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
