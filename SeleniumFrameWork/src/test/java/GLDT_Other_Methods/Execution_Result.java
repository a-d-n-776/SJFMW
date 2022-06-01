
package GLDT_Other_Methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

import BIPS.BIPS_Login;
import GLDT_Methods.GLDT_TestCase_Steps;


public class Execution_Result {
	
	public static String xlfilepath = BIPS_Login.xlfilepath;
	
	public static void Fill_Execution_Result() throws Exception {
		
//File xlsxFile = new File("C:\\Users\\DC0121\\eclipse-workspace\\BIPS\\GLDT-TestCases-for-Automation.xlsx");
File xlsxFile = new File(xlfilepath);

        
        try {
            //Creating input stream
            FileInputStream inputStream = new FileInputStream(xlsxFile);
             
            //Creating workbook from input stream
            Workbook workbook = WorkbookFactory.create(inputStream);
 
            //Reading first sheet of excel file
            Sheet sheet = workbook.getSheetAt(1);
            
            sheet.getRow(GLDT_TestCase_Steps.row).getCell(GLDT_TestCase_Steps.cell_actual_result).setCellValue("As expected");

            sheet.getRow(GLDT_TestCase_Steps.row).getCell(GLDT_TestCase_Steps.cell_Status).setCellValue("Pass");
            
//          sheet.getRow(GLDT_TestCase_Steps.row).getCell(GLDT_TestCase_Steps.cell_Status).setCellValue("");
            //Close input stream
            inputStream.close();
 
            //Crating output stream and writing the updated workbook
            FileOutputStream os = new FileOutputStream(xlsxFile);
            workbook.write(os);
             
            //Close the workbook and output stream
            workbook.close();
            os.close();
             
            System.out.println("Excel file has been updated successfully.");
            System.out.println("Excel file has been updated successfully@Execution_Result.java@Fill_Execution_Result().");
        } catch (EncryptedDocumentException | IOException e) {
            System.err.println("Exception while updating an existing excel file.");
            e.printStackTrace();
        }
	} 
	public static void Fill_caseid_and_Result() throws Exception {
		
		//File xlsxFile = new File("C:\\Users\\DC0121\\eclipse-workspace\\BIPS\\GLDT-TestCases-for-Automation.xlsx");
		File xlsxFile = new File(xlfilepath);        
		        try {
		            //Creating input stream
		            FileInputStream inputStream = new FileInputStream(xlsxFile);
		             
		            //Creating workbook from input stream
		            Workbook workbook = WorkbookFactory.create(inputStream);
		 
		            //Reading first sheet of excel file
		            Sheet sheet = workbook.getSheetAt(1);
		            
//		            sheet.getRow(GLDT_TestCase_Steps.row).getCell(GLDT_TestCase_Steps.cell_actual_result).setCellValue("As expected");
//		          sheet.getRow(GLDT_TestCase_Steps.row).getCell(GLDT_TestCase_Steps.cell_Status).setCellValue("");
		            sheet.getRow(GLDT_TestCase_Steps.row).getCell(GLDT_TestCase_Steps.cell_Status).setCellValue("Pass");
		            //Close input stream
		            inputStream.close();
		 
		            //Crating output stream and writing the updated workbook
		            FileOutputStream os = new FileOutputStream(xlsxFile);
		            workbook.write(os);
		             
		            //Close the workbook and output stream
		            workbook.close();
		            os.close();
		             
		            System.out.println("Excel file has been updated successfully.");
		            System.out.println("Excel file has been updated successfully@Execution_Results.java@Fill_caseid_and_Result().");
		            
		        } catch (EncryptedDocumentException | IOException e) {
		            System.err.println("Exception while updating an existing excel file.");
		            e.printStackTrace();
		        }
			}
	public static void Fill_Fail_Result() throws Exception {
		
		//File xlsxFile = new File("C:\\Users\\DC0121\\eclipse-workspace\\BIPS\\GLDT-TestCases-for-Automation.xlsx");
		File xlsxFile = new File(xlfilepath);        
		        try {
		            //Creating input stream
		            FileInputStream inputStream = new FileInputStream(xlsxFile);
		             
		            //Creating workbook from input stream
		            Workbook workbook = WorkbookFactory.create(inputStream);
		 
		            //Reading first sheet of excel file
		            Sheet sheet = workbook.getSheetAt(1);
		            sheet.getRow(GLDT_TestCase_Steps.row).getCell(GLDT_TestCase_Steps.cell_actual_result).setCellValue(""); 
		            sheet.getRow(GLDT_TestCase_Steps.row).getCell(GLDT_TestCase_Steps.cell_actual_result).setCellValue(GLDT_TestCase_Steps.nameofCurrMethod);
		            sheet.getRow(GLDT_TestCase_Steps.row).getCell(GLDT_TestCase_Steps.cell_Status).setCellValue("Fail");
		            //Close input stream
		            inputStream.close();
		 
		            //Crating output stream and writing the updated workbook
		            FileOutputStream os = new FileOutputStream(xlsxFile);
		            workbook.write(os);
		             
		            //Close the workbook and output stream
		            workbook.close();
		            os.close();
		             
		            System.out.println("Excel file has been updated successfully.");
		             
		        } catch (EncryptedDocumentException | IOException e) {
		            System.err.println("Exception while updating an existing excel file.");
		            e.printStackTrace();
		        }
			} 
	public static void Dependency_TC_Failed() throws Exception {
		WebDriver driver = BIPS_Login.driver;
		//File xlsxFile = new File("C:\\Users\\DC0121\\eclipse-workspace\\BIPS\\GLDT-TestCases-for-Automation.xlsx");
		File xlsxFile = new File(xlfilepath);
        try {
            //Creating input stream
            FileInputStream inputStream = new FileInputStream(xlsxFile);
             
            //Creating workbook from input stream
            Workbook workbook = WorkbookFactory.create(inputStream);
 
            //Reading first sheet of excel file
            Sheet sheet = workbook.getSheetAt(1);
             
            for (int row = 5, cell = 11; row <= 41; row++) {
            	sheet.getRow(row).getCell(cell).setCellValue("Blocked");
            }            
            //Close input stream
            inputStream.close();
 
            //Crating output stream and writing the updated workbook
            FileOutputStream os = new FileOutputStream(xlsxFile);
            workbook.write(os);
             
            //Close the workbook and output stream
            workbook.close();
            os.close();
             
            System.out.println("Excel file has been updated successfully.");
            driver.manage().deleteAllCookies();    
        } catch (EncryptedDocumentException | IOException e) {
            System.err.println("Exception while updating an existing excel file.");
            e.printStackTrace();
        }
        driver.quit();
	}
	
	public static void Dependency_TC_Passed() throws Exception {
		//File xlsxFile = new File("C:\\Users\\\DC0121\\eclipse-workspace\\BIPS\\GLDT-TestCases-for-Automation.xlsx");
		File xlsxFile = new File(xlfilepath);        
		        try {
		            //Creating input stream
		            FileInputStream inputStream = new FileInputStream(xlsxFile);
		             
		            //Creating workbook from input stream
		            Workbook workbook = WorkbookFactory.create(inputStream);
		 
		            //Reading first sheet of excel file
		            Sheet sheet = workbook.getSheetAt(1);
		             
//		            for (int row = 5, cell = 11; row <= 41; row++) {
//		            	sheet.getRow(row).getCell(cell).setCellValue("");
//		            }
		            
		            for (int row = 1, cell = 10; row <= 4; row++) {
		            	sheet.getRow(row).getCell(cell).setCellValue("As expected");
		            }
		            for (int row = 1, cell = 11; row <= 4; row++) {
		            	sheet.getRow(row).getCell(cell).setCellValue("Pass");
		            }
		            //Close input stream
		            inputStream.close();
		 
		            //Crating output stream and writing the updated workbook
		            FileOutputStream os = new FileOutputStream(xlsxFile);
		            workbook.write(os);
		             
		            //Close the workbook and output stream
		            workbook.close();
		            os.close();
		             
		            System.out.println("Excel file has been updated successfully.");
		            System.out.println("Excel file has been updated successfully@Execution_Results.java@Dependency_TC_Passed().");
		            
		             
		        } catch (EncryptedDocumentException | IOException e) {
		            System.err.println("Exception while updating an existing excel file.");
		            e.printStackTrace();
		        }
			}


	public static void Dependency_TC2_Passed() throws Exception {
		
		
		
		
		
		//File xlsxFile = new File("C:\\Users\\\DC0121\\eclipse-workspace\\BIPS\\GLDT-TestCases-for-Automation.xlsx");
				File xlsxFile = new File(xlfilepath);        
				        try {
				            //Creating input stream
				            FileInputStream inputStream = new FileInputStream(xlsxFile);
				             
				            //Creating workbook from input stream
				            Workbook workbook = WorkbookFactory.create(inputStream);
				 
				            //Reading first sheet of excel file
				            Sheet sheet = workbook.getSheetAt(1);
				             
//				            for (int row = 5, cell = 11; row <= 41; row++) {
//				            	sheet.getRow(row).getCell(cell).setCellValue("");
//				            }
				            
				            for (int row = 1, cell = 10; row <= 4; row++) {
				            	sheet.getRow(row).getCell(cell).setCellValue("As expected");
				            }
				            for (int row = 1, cell = 11; row <= 4; row++) {
				            	sheet.getRow(row).getCell(cell).setCellValue("Pass");
				            }
				            //Close input stream
				            inputStream.close();
				 
				            //Crating output stream and writing the updated workbook
				            FileOutputStream os = new FileOutputStream(xlsxFile);
				            workbook.write(os);
				             
				            //Close the workbook and output stream
				            workbook.close();
				            os.close();
				             
				            System.out.println("Excel file has been updated successfully.");
				            System.out.println("Excel file has been updated successfully@Execution_Results.java@Dependency_TC_Passed().");
				            
				             
				        } catch (EncryptedDocumentException | IOException e) {
				            System.err.println("Exception while updating an existing excel file.");
				            e.printStackTrace();
				        }
		
	}
	
	
	
	
	
	public static void Update_GLDT_CaseId() throws Exception {
		//File xlsxFile = new File("C:\\Users\\DC0121\\eclipse-workspace\\BIPS\\GLDT-TestCases-for-Automation.xlsx");
		File xlsxFile = new File(xlfilepath);        
		        try {
		            //Creating input stream
		            FileInputStream inputStream = new FileInputStream(xlsxFile);
		             
		            //Creating workbook from input stream
		            Workbook workbook = WorkbookFactory.create(inputStream);
		 
		            //Reading first sheet of excel file
		            Sheet sheet = workbook.getSheetAt(1);
		             
		            sheet.getRow(GLDT_TestCase_Steps.row).getCell(GLDT_TestCase_Steps.cell_case_id).setCellValue(GLDT_TestCase_Steps.Case_Id);           
		            //Close input stream
		            inputStream.close();
		 
		            //Crating output stream and writing the updated workbook
		            FileOutputStream os = new FileOutputStream(xlsxFile);
		            workbook.write(os);
		             
		            //Close the workbook and output stream
		            workbook.close();
		            os.close();
		             
		            System.out.println("Excel file has been updated successfully.");
		            System.out.println("Excel file has been updated successfully@Execution_Result.java@Update_GLDT_CaseId().");
		             
		        } catch (EncryptedDocumentException | IOException e) {
		            System.err.println("Exception while updating an existing excel file.");
		            e.printStackTrace();
		        }

		}
}
	
