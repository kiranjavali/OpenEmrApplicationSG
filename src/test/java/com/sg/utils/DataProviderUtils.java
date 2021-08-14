package com.sg.utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

	@DataProvider
	public Object[][] invalidCredentailsData() throws IOException
	{
		Object[][] main= ExcelUtils.getSheetObjectArray("src/test/resources/TestData/OpenEmrData.xlsx" , "InvalidCredentailsTest");
		return main;
	}
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
}
