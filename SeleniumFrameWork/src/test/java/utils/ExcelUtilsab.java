package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilsab {

	static String projectpath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	// Create constructor
	public  ExcelUtilsab (String excelPath, String sheetName ) {
		try {
		projectpath = System.getProperty("user.dir");
		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetName);
	}catch(Exception e) {
		e.printStackTrace();
	}
		
		}
	

	public static void main(String[] args) {
		getRowCount();
		//getCellData();
		//getCellDataNumber();
		//getCellDataStringa();
		getCellDataString(0,0);
		getCellDataDouble(5,1);
	}


	public static void getRowCount() {
		try {
		//projectpath = System.getProperty("user.dir");
			//XSSFWorkbook workbook = new XSSFWorkbook("C:\\Users\\cnbna\\git\\SJFMW\\SeleniumFrameWork\\excel\\data.xlsx");
		//workbook = new XSSFWorkbook(projectpath+"\\excel\\data.xlsx");
		//sheet = workbook.getSheet("Sheet1");
			//XSSFSheet sheet = workbook.getSheetAt(0);
			int rowCount = sheet.getPhysicalNumberOfRows();

			System.out.println("No of rows : "+rowCount);

		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

	}
	
	
	public static void getCellData() {
		try {
			//projectpath = System.getProperty("user.dir");
			//workbook = new XSSFWorkbook(projectpath+"\\excel\\data.xlsx");
			//sheet = workbook.getSheet("Sheet1");
			String celldata = sheet.getRow(4).getCell(0).getStringCellValue();
			System.out.println(celldata);

		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

	}
	
	public static void getCellDataStringa() {
		try {
			//projectpath = System.getProperty("user.dir");
			//workbook = new XSSFWorkbook(projectpath+"\\excel\\data.xlsx");
			//sheet = workbook.getSheet("Sheet1");
			String celldata = sheet.getRow(4).getCell(0).getStringCellValue();
			System.out.println(celldata);

		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

	}
	
	
	
	public static void getCellDataString(int rowNum, int colNum) {
		try {
			//projectpath = System.getProperty("user.dir");
			//workbook = new XSSFWorkbook(projectpath+"\\excel\\data.xlsx");
			//sheet = workbook.getSheet("Sheet1");
			
			// getStringCellValue
			String celldata = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			System.out.println(celldata);

		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

	}
	
	public static void getCellDataDouble(int rowNum, int colNum) {
		try {
			//projectpath = System.getProperty("user.dir");
			//workbook = new XSSFWorkbook(projectpath+"\\excel\\data.xlsx");
			//sheet = workbook.getSheet("Sheet1");
			
			//getNumericCellValue
			double celldata = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println(celldata);

		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

	}
	
	
}