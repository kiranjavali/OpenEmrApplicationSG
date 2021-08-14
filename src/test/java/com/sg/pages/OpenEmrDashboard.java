package com.sg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenEmrDashboard {
	
	private static By flowBoard=By.xpath("//div[text()='Flow Board']");
	private WebDriver driver;
	public OpenEmrDashboard(WebDriver driver) {
		this.driver = driver;
	}
	public void waitForPresenceofFlowBoard()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(flowBoard));
		//Assert.assertEquals(driver.getTitle(), "OpenEMR");

	}
	public String getCurrentTitle()
	{
		return driver.getTitle();
	}
}
