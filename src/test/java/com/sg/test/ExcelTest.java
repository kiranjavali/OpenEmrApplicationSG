package com.sg.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream file = new FileInputStream("./src/test/resources/TestData/OpenEmrData.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet("InvalidCredentailsTest");
		
		int rowCount=sheet.getPhysicalNumberOfRows();
		int cellCount=sheet.getRow(0).getPhysicalNumberOfCells();
		Object [][] main= new Object[rowCount-1][cellCount];
		DataFormatter format = new DataFormatter();
		for (int i=1;i<rowCount;i++) 
		{
			for (int j=0;j<cellCount;j++)
			{
				
				XSSFRow row = sheet.getRow(i);
				XSSFCell cell = row.getCell(j);
				
				String cellValue = format.formatCellValue(cell);
				System.out.println(cellValue);
				main[i-1][j]=cellValue;
			}
		}

	}

}
