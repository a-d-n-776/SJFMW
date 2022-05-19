package utils;


public class ExcelUtilsaba {
	
	
	public static void main(String[] args) {
		// Parameterized  data passing to ExcelUtilsab.java in that construct will pick  ..
		String projectpath = System.getProperty("user.dir");
		ExcelUtilsab excel = new ExcelUtilsab(projectpath+"\\excel\\data.xlsx", "Sheet1");
		
		excel.getRowCount();
		excel.getCellDataString(0, 0);
		excel.getCellDataDouble(5, 0);
		
		
		
	}
	
}
