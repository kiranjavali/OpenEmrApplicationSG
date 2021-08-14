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

public class LoginTest extends WebDriverWrapper{


	@DataProvider
	public Object[][] validCredentailsData()
	{
		Object[][] data= new Object[3][4];
		data[0][0]= "admin";
		data[0][1]="pass";
		data[0][2] = "English (Indian)";
		data[0][3] = "OpenEMR";
		
		data[1][0]= "physician";
		data[1][1]="physician";
		data[1][2] = "English (Indian)";
		data[1][3] = "OpenEMR";
		
		data[2][0]= "accountant";
		data[2][1]="accountant";
		data[2][2] = "English (Indian)";
		data[2][3] = "OpenEMR";
		
		return data;
		
		//admin,pass,English (Indian),OpenEMR
	    //physician,physician,English (Indian),OpenEMR
	    //accountant,accountant,English (Indian),OpenEMR
	}
	
	@Test(dataProvider="validCredentailsData")
	
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
