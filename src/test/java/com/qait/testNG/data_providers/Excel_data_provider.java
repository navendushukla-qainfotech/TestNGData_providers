package com.qait.testNG.data_providers;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_data_provider {

	public Object[][] excelreader() throws IOException {

		String Filepath = "/home/navendushukla/Downloads/MailingList.xlsx";
		File file = new File(Filepath);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(inputStream);
		Sheet excelsheet = wb.getSheet("Sheet1");
		int rowcount = excelsheet.getLastRowNum() - excelsheet.getFirstRowNum() + 1;
		//System.out.println(rowcount);
		
		String[][] arr=new String[rowcount][excelsheet.getRow(0).getLastCellNum()];
		
		
		for (int i = 0; i < rowcount; i++) {
			Row row = excelsheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++)
			{
				
				arr[i][j]=row.getCell(j).getStringCellValue();
//				System.out.println(arr[i][j]);
			}

			
		}

		
		//System.out.println(arr);
		return arr;

	}

	public static void main(String a[]) throws IOException {
		Excel_data_provider es = new Excel_data_provider();
		es.excelreader();
	}
}
