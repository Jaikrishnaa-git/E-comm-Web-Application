package com.Ecomm.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;

public class ExcelUtilities {
<<<<<<< HEAD
	public static Object[][] getdata(String excelpath, String sheetname) throws IOException {
		  
		  String projectpath=System.getProperty("user.dir")  ;
		  File file1=new File(excelpath);
		  FileInputStream fs=new FileInputStream(file1);
		  XSSFWorkbook workbook=new XSSFWorkbook(fs);
		  XSSFSheet worksheet=workbook.getSheet(sheetname);
		  int rowcount=worksheet.getPhysicalNumberOfRows();
		  System.out.println("rows:"+rowcount);
		  String[][] data=new String[rowcount][2];
		  
		  for(int i=0;i<rowcount;i++)
		  {
			  data[i][0]=worksheet.getRow(i).getCell(0).getStringCellValue();
			  data[i][1]=worksheet.getRow(i).getCell(1).getStringCellValue();
		  }
		  
		  return data;
		  
		 	    }

=======

    public static Object[][] getdata(String excelPath, String sheetName) throws IOException {

        FileInputStream fis = new FileInputStream(excelPath);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        int totalRows = sheet.getPhysicalNumberOfRows();
        int totalCols = sheet.getRow(0).getLastCellNum();

        System.out.println("Total rows: " + totalRows);
        System.out.println("Total columns: " + totalCols);

        Object[][] data = new Object[totalRows - 1][totalCols];

        for (int i = 1; i < totalRows; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < totalCols; j++) {
                Cell cell = row.getCell(j);

                if (cell == null) {
                    data[i - 1][j] = "";
                } else {
                    cell.setCellType(CellType.STRING);
                    data[i - 1][j] = cell.getStringCellValue();
                }
            }
        }

        workbook.close();
        fis.close();
        return data;
    }
>>>>>>> 77bb121 (2025sep8 project)
}