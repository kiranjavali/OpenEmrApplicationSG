package com.sg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private static By usernameLocator=By.id("authUser");
	private static By passwordLocator=By.id("clearPass");
	private WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void enterUsername(WebDriver driver,String Username)
	{
		driver.findElement(usernameLocator).sendKeys(Username);
	}
	public void enterPassword(WebDriver driver,String Password)
	{
		driver.findElement(passwordLocator).sendKeys(Password);
	}

}
