package GLDT_Other_Methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Make_Cell_Empty {
//	public static int Clear_row;
//	public static int Clear_cell = 8;
	
	public static void Delete_Cell_Contents() throws Exception {
	
		//File xlsxFile = new File("C:\\Users\\DC0121\\eclipse-workspace\\BIPS\\GLDT-TestCases-for-Automation.xlsx");
		File xlsxFile = new File("G:\\My Drive\\app\\GLDT-TestCases-for-Automation.xlsx");        
		        try {
		            //Creating input stream
		            FileInputStream inputStream = new FileInputStream(xlsxFile);
		             
		            //Creating workbook from input stream
		            Workbook workbook = WorkbookFactory.create(inputStream);
		 
		            //Reading first sheet of excel file
		            Sheet sheet = workbook.getSheetAt(1);// Based on index ..0,1,2...
		          //Sheet sheet = workbook.getSheet("GLDT_Test_Cases"); //Based on sheet name
		           
		            
		            for (int Clear_row = 1, Clear_cell = 10; Clear_cell <= 12; Clear_row++ ) {		         
		            	sheet.getRow(Clear_row).getCell(Clear_cell).setCellValue("");
		            	if (Clear_row == 41) {
		            		Clear_row = 0;
		            		Clear_cell++;
		            	}		            		
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
		            System.out.println("Excel file has been updated successfully@ Make_Cell_Empty.java@Delete_Cell_Contents().");
		             
		        } catch (EncryptedDocumentException | IOException e) {
		            System.err.println("Exception while updating an existing excel file.");
		            e.printStackTrace();
		        }
			} 
	
	public static void main(String[] args) throws Exception {
						Make_Cell_Empty.Delete_Cell_Contents();
	}
}
