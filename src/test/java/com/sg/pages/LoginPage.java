package com.sg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private static By usernameLocator=By.id("authUser");
	private static By passwordLocator=By.id("clearPass");

	public static void enterUsername(WebDriver driver,String Username)
	{
		driver.findElement(usernameLocator).sendKeys(Username);
	}
	public static void enterPassword(WebDriver driver,String Password)
	{
		driver.findElement(passwordLocator).sendKeys(Password);
	}

}
