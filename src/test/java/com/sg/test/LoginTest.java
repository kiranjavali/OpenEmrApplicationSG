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
		lp.clickLogin();
		OpenEmrDashboard oed=new OpenEmrDashboard(driver);
		oed.waitForPresenceofFlowBoard();
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Flow Board']")));
		Assert.assertEquals(oed.getCurrentTitle(), "OpenEMR");
		
	}
	@Test
	public void InvalidCredentailsTest()
	{
		LoginPage lp= new LoginPage(driver);
		lp.enterUsername("admin11");
		lp.enterPassword("pass");
		lp.selectLanguage("English (Indian)");
		lp.clickLogin();
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Flow Board']")));
		//Assert.assertEquals(driver.getTitle(), "OpenEMR");
		
		//String error = driver.findElement(By.xpath("//div[contains (text(),'Invalid')]")).getText();
		Assert.assertEquals(lp.InvalidLoginError(), "Invalid username or password");
		
	}
	
	
}
