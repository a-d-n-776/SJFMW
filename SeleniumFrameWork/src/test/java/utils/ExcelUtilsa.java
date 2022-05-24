package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilsa {
	public static void main(String[] args) {
		getRowCount();
		getColCount();
	}
	
	
	public static void getRowCount() {
		try {
			String projectpath = System.getProperty("user.dir");
			//XSSFWorkbook workbook = new XSSFWorkbook("C:\\Users\\cnbna\\git\\SJFMW\\SeleniumFrameWork\\excel\\data.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(projectpath+"\\excel\\data.xlsx");
			//XSSFSheet sheet = workbook.getSheet("Sheet1");
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rowCount = sheet.getPhysicalNumberOfRows();
			
			System.out.println("No of rows : "+rowCount);
			
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		
		
	}
	
	
	public static void getColCount() {
		try {
			String projectpath = System.getProperty("user.dir");
			//XSSFWorkbook workbook = new XSSFWorkbook("C:\\Users\\cnbna\\git\\SJFMW\\SeleniumFrameWork\\excel\\data.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(projectpath+"\\excel\\data.xlsx");
			//XSSFSheet sheet = workbook.getSheet("Sheet1");
			XSSFSheet sheet = workbook.getSheetAt(0);
			int colCount = sheet.getRow(7).getPhysicalNumberOfCells();
			
			System.out.println("No of colCount : "+colCount);
			
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		
		
	}





}