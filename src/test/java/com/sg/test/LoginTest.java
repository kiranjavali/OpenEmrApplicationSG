package com.sg.test;

import org.openqa.selenium.By;	
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sg.base.WebDriverWrapper;
import com.sg.pages.LoginPage;
import com.sg.pages.OpenEmrDashboard;

public class LoginTest extends WebDriverWrapper{


	@Test
	public void validCredentailsTest()
	{
		LoginPage lp= new LoginPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("pass");
		lp.selectLanguage("English (Indian)");
		//Select lang = new Select(driver.findElement(By.name("languageChoice")));
		//lang.selectByVisibleText("English (Indian)");
		OpenEmrDashboard oed=new OpenEmrDashboard(driver);
		oed.waitForPresenceofFlowBoard();
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Flow Board']")));
		Assert.assertEquals(oed.getCurrentTitle(), "OpenEMR");
		
	}
	@Test
	public void InvalidCredentailsTest()
	{
		driver.findElement(By.id("authUser")).sendKeys("admin");
		driver.findElement(By.id("clearPass")).sendKeys("pass11");
		Select lang = new Select(driver.findElement(By.name("languageChoice")));
		lang.selectByVisibleText("English (Indian)");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Flow Board']")));
		//Assert.assertEquals(driver.getTitle(), "OpenEMR");
		String error = driver.findElement(By.xpath("//div[contains (text(),'Invalid')]")).getText();
		Assert.assertEquals(error, "Invalid username or password");
		
	}
	
	
}
