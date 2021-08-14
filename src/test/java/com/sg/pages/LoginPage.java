package com.sg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	private static By usernameLocator = By.id("authUser");
	private static By passwordLocator = By.id("clearPass");
	private static By languageSelector = By.name("languageChoice");
	private static By loginButton = By.xpath("//button[@type='submit']");
	private static By appDesc = By.xpath("//div[contains(text(),'')]");
	private static By invalidLoginMsg=By.xpath("//div[contains (text(),'Invalid')]");
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsername(String Username) {
		this.driver.findElement(usernameLocator).sendKeys(Username);
	}

	public void enterPassword(String Password) {
		driver.findElement(passwordLocator).sendKeys(Password);
	}

	public void selectLanguage(String Language) {
		Select Ls = new Select(driver.findElement(languageSelector));
		Ls.selectByVisibleText(Language);
	}

	public void clickLogin() {
		driver.findElement(loginButton).click();
	}
	public String GetApplicationDescription()
	{
		return driver.findElement(languageSelector).getText();
	}
	public String InvalidLoginError()
	{
		return driver.findElement(invalidLoginMsg).getText().trim();
	}


}
