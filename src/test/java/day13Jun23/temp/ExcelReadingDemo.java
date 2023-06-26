package day13Jun23.temp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 

public class ExcelReadingDemo {

	public static void main(String[] args) {

		try
		{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +
				"/src/test/resources/testdata/testdata.xlsx");
		String  sheetName= "PlayerInfo";
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		int row = sheet.getLastRowNum();                //total rows present in Sheet1
		int col = sheet.getRow(0).getLastCellNum();
		System.out.println("row="+ row);
		System.out.println("col="+ col);  //4
 		Object[][] data = new Object[row][col];
	
		for(int i=1;i<=row;i++)   // accessing rows
		{
			for(int j=0;j<col;j++)  // accessing columns
			{	data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
	//			System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() + "\t");
			}
	//		System.out.println();
		}
		System.out.println("==========================");
		for(int r=0;r<data.length;r++)
		{
			for(int c=0;c<data[r].length;c++)
				System.out.print(data[r][c] + "\t");
			System.out.println();
		}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
}
}