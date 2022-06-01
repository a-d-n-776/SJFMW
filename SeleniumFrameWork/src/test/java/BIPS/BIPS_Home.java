package BIPS;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import GLDT_Other_Methods.Execution_Result;

public class BIPS_Home {
	
	
	public static int row;
	   public static int cell_case_id;
	   public static int cell_actual_result;
	   public static int cell_Status;
	   public static int cell_Jira_Id;
	   public static String Case_Id;
	   public static String nameofCurrMethod;
	   public static String summary;

	
	
	public static WebDriver driver;
	
	  
	public static String xlfilepath = BIPS_Login.xlfilepath;
	
	
	public static void main(String[] args) throws Exception {
		//BIPS_Home.GLDT_Home();
	}
		
		public static void GLDT_Home() throws Exception {

		}
		
		
		public static void CompleteRAprocess_For_Open_Case_GLDT_ProductsCheckBox() throws Exception {

			
			String CaseID = null;
			String Product = null;
		    String Reason = null;
		    String TemporaryProductNameValue = null;
		    String Comments = null;
		    
		    
		    WebDriver driver = BIPS_Login.driver;
//			driver.switchTo().frame("PegaGadget2Ifr");
//			driver.switchTo().frame("PegaGadget0Ifr");
//		    driver.switchTo().defaultContent();
			driver.switchTo().frame(0);
			try {
		        //FileInputStream fStream = new FileInputStream(new File(
		          //      "C:\\Users\\DC0121\\eclipse-workspace\\BIPS\\GLDT-TestCases-for-Automation.xlsx"));
		        
		        FileInputStream fStream = new FileInputStream(new File(xlfilepath)); 
		        
		        //Enter the path to your excel here

		        // Create workbook instance referencing the file created above
		        XSSFWorkbook workbook = new XSSFWorkbook(fStream);

		        // Get your first or desired sheet from the workbook
		        XSSFSheet sheet = workbook.getSheetAt(1); // getting second sheet

		        XSSFRow row = sheet.getRow(63);
		        XSSFCell cell1 = row.getCell(8);
		        
		        XSSFRow row1 = sheet.getRow(64);
		        XSSFCell cell2 = row1.getCell(8);
		        
		        XSSFRow row2 = sheet.getRow(65);
		        XSSFCell cell3 = row2.getCell(8);
		        
		        //XSSFRow row3 = sheet.getRow(67);
		        //XSSFCell cell4 = row3.getCell(8);
		        
		        XSSFRow row4 = sheet.getRow(67);
		        XSSFCell cell5 = row4.getCell(8);
		        
		        
		        
		        CaseID = cell1.toString();
		        Product = cell2.toString();
		        Reason = cell3.toString();
		       // TemporaryProductNameValue = cell4.toString();
		        Comments = cell5.toString();
		        
		        fStream.close();
		    } catch (Exception e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
			driver.findElement(By.linkText(CaseID)).click();
			row = 63; // case id row for data in//
			cell_case_id = 10;
			cell_actual_result = 10;
			cell_Status = 11;
			cell_Jira_Id = 12;
			Execution_Result.Fill_Execution_Result();
			driver.switchTo().defaultContent();
//			driver.switchTo().frame("PegaGadget1Ifr");
			driver.switchTo().frame(1);
			
			//WebElement selectproduct = driver.findElement(By.xpath("//input[@id='414e17ce']"));
			//selectproduct.clear();
			//selectproduct.sendKeys(Product);
			//selectproduct.sendKeys(Keys.DOWN);
			//selectproduct.sendKeys(Keys.RETURN);
			//row++;
			//Execution_Result.Fill_Execution_Result();
			
			WebElement Reasonforcaseinitiation = driver.findElement(By.xpath("//*[@id=\"158b841d\"]")); 

			Reasonforcaseinitiation.clear();
			Reasonforcaseinitiation.sendKeys("Test Reasonforcaseinitiation");
			//row++;
			
			
			
		// Check Mark selection 
			//WebElement Productisundefined = driver.findElement(By.xpath("//label[@for='e2457cfb']"));
			//Productisundefined.click();
			
			//Thread.sleep(5000);
			
			//Check box selection
			//WebElement Productisundefined = driver.findElement(By.xpath("//label[@for='e2457cfb']"));
			//Productisundefined.click();
			Thread.sleep(5000);
		//Selecting search box
			//WebElement TemporaryProductName = driver.findElement(By.xpath("//input[@id='7515729c']"));
			//TemporaryProductName.click();
			//Thread.sleep(5000);
			
		//Selecting TemporaryProduct Value under drop-down
			//WebElement Search = driver.findElement(By.xpath("//input[@id='anypicker-input']"));
			//Search.sendKeys(TemporaryProductNameValue);
			//Search.sendKeys(Keys.DOWN);
			//Search.sendKeys(Keys.DOWN);
			//Search.sendKeys(Keys.ENTER);
			//row++;
			//Execution_Result.Fill_Execution_Result();
			
			
			//////////////////////////////////////////////////////////////
			
			
			
			
			
			
			Execution_Result.Fill_Execution_Result();
			WebElement region = driver.findElement(By.xpath("//*[@id=\"CT\"]/span/button"));
			region.click();
			row++;
			Execution_Result.Fill_Execution_Result();
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			WebElement ropu = driver.findElement(By.xpath("//button[text()='ROPU IMETA']"));
			ropu.click();
			row++;
			Execution_Result.Fill_Execution_Result();
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			

			//India
			WebElement countryI = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='PEGA_HARNESS']/form[1]/div[3]/div[1]/section[1]/div[1]/span[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[7]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]/i[1]/img[1]")));
			countryI.click();
			
			//Nigeria
			WebElement countryN = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='PEGA_HARNESS']/form[1]/div[3]/div[1]/section[1]/div[1]/span[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[7]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[19]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]/i[1]/img[1]")));
			countryN.click();
			Thread.sleep(5000);

			row++;
			Execution_Result.Fill_Execution_Result();
			
			Thread.sleep(5000);
			
			
			WebElement comment = driver.findElement(By.xpath("//*[@id=\"5e1978c7\"]"));
			comment.click();
			comment.sendKeys(Comments);

			
			row++;
			Execution_Result.Fill_Execution_Result();
			
			
			//if(countryNigeria.isSelected()) {
				//System.out.println("Country is alredy selected");
			//}
			
			//else {
				//countryNigeria.click();	
				//System.out.println("Country is not selected ,Now selected ");
			//}
			
			           //India
			//WebElement country = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='PEGA_HARNESS']/form[1]/div[3]/div[1]/section[1]/div[1]/span[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[7]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]/i[1]/img[1]")));
			//country.click();

			
			
			
			
			WebElement InitiateRAProcess = driver.findElement(By.xpath("//*[@id=\"RULE_KEY\"]/div[2]/div[3]/span/button"));
			InitiateRAProcess.click();
			row++;
			Execution_Result.Fill_Execution_Result();
			
			
			//WebElement continue1 = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
			//continue1.click();
			
			//row++;
			//Execution_Result.Fill_Execution_Result();
			
			driver.manage().deleteAllCookies();
			Thread.sleep(15000); //wait 15 seconds to clear cookies.
			try {
			  Thread.sleep(15000); //wait 15 seconds to clear cookies.
			} catch (InterruptedException e) {
			  e.printStackTrace();
			}
			driver.quit();
		}


		public static void Open_And_Close_PendingChildCaseProcessing_gldt_ProductsCheckBox() throws Exception {
			
		}

		
		
		
	}