package com.sg.test;

import org.openqa.selenium.By;	
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sg.base.WebDriverWrapper;
import com.sg.pages.LoginPage;
import com.sg.pages.OpenEmrDashboard;
import com.sg.utils.DataProviderUtils;

public class LoginTest extends WebDriverWrapper{


	@Test(dataProvider="validCredentailsData",dataProviderClass = DataProviderUtils.class)
	
	public void validCredentailsTest(String username,String password,String language,String pageTitle)
	{
		LoginPage lp= new LoginPage(driver);
		lp.enterUsername(username);
		lp.enterPassword(password);
		lp.selectLanguage(language);
		//Select lang = new Select(driver.findElement(By.name("languageChoice")));
		//lang.selectByVisibleText("English (Indian)");
		lp.clickLogin();
		OpenEmrDashboard oed=new OpenEmrDashboard(driver);
		oed.waitForPresenceofFlowBoard();
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Flow Board']")));
		Assert.assertEquals(oed.getCurrentTitle(), pageTitle);
		
	}
	@Test(dataProvider="invalidCredentailsData",dataProviderClass = DataProviderUtils.class)
	public void InvalidCredentailsTest(String username,String password,String langauage,String invalidMessage)
	{
		LoginPage lp= new LoginPage(driver);
		lp.enterUsername(username);
		lp.enterPassword(password);
		lp.selectLanguage(langauage);
		lp.clickLogin();
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Flow Board']")));
		//Assert.assertEquals(driver.getTitle(), "OpenEMR");
		
		//String error = driver.findElement(By.xpath("//div[contains (text(),'Invalid')]")).getText();
		Assert.assertEquals(lp.InvalidLoginError(), invalidMessage);
		
	}
	
	
}
