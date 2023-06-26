package day13Jun23.temp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadingDemoUtility {

	static Object[][] getData(String fileName, String sheetName) 
	{
	 
		Object[][] data = null;

		try {
			FileInputStream fis = new FileInputStream(fileName);

			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
			XSSFSheet sheet = workbook.getSheet(sheetName);

			int row = sheet.getLastRowNum();
			int col = sheet.getRow(0).getLastCellNum();
			System.out.println("row=" + row);
			System.out.println("col=" + col); // 4
			data = new Object[row][col];

			for (int i = 1; i <= row; i++) // accessing rows
			{
				for (int j = 0; j < col; j++) // accesing columns
					data[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	public static void main(String[] args) {

		Object[][] newData = getData(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx",
				"PlayerInfo");

		for (int r = 0; r < newData.length; r++) {
			for (int c = 0; c < newData[r].length; c++)
				System.out.print(newData[r][c] + "\t");
			System.out.println();
		}

	}
}