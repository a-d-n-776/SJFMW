
package GLDT_Methods;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import BIPS.BIPS_Login;
import GLDT_Other_Methods.Execution_Result;
import GLDT_Other_Methods.Jira_Ticket;
import GLDT_Other_Methods.ScreenCapture;
//import junit.framework.AssertionFailedError;

public class GLDT_TestCase_Steps {
   public static int row;
   public static int cell_case_id;
   public static int cell_actual_result;
   public static int cell_Status;
   public static int cell_Jira_Id;
   public static String Case_Id;
   public static String nameofCurrMethod;
   public static String summary;
   public static WebDriver driver;
	    
   public static void initiate_gldt() throws Exception {
	        String Product = null;
	        String Reason = null;
	        SoftAssert softAssert = new SoftAssert();
	    	WebDriver driver = BIPS_Login.driver;
			WebElement FrameSRC=driver.findElement(By.xpath("//iframe[@src='about:blank']"));
	        driver.switchTo().frame(FrameSRC);
			WebElement initiate = driver.findElement(By.xpath("//*[@class=\'header']"));//Copied the xpath and replace with class as the id is changing dynamically
			initiate.click();
			//WebElement gldt = driver.findElement(By.xpath("//*[@id=\"RULE_KEY\"]/div/div/div/div/div/div/div[2]/div/div/div/div[2]/span/button/img"));
			WebElement gldt = driver.findElement(By.xpath("//*[@id=\"RULE_KEY\"]/div/div/div/div/div/div/div[1]/div/div/div/div[2]/span/button/img"));
			gldt.click();
			row = 5;
			cell_case_id = 10;
			cell_actual_result = 10;
			cell_Status = 11;
			cell_Jira_Id = 12;
//			WebDriverWait wait5 = new WebDriverWait(driver, 30);
//	    	wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='414e17ce']")));
//			WebElement selectproduct1 = driver.findElement(By.xpath("//input[@id='414e17ce']"));
//			softAssert.assertTrue(selectproduct1.isDisplayed());
			Execution_Result.Fill_Execution_Result();
			driver.switchTo().defaultContent();
//			driver.switchTo().frame("PegaGadget1Ifr");
			driver.switchTo().frame(1);
	    	Case_Id = driver.findElement(By.xpath("//span[contains(text(),'(GLDT-')]")).getText();
	    	Thread.sleep(3000);
	    	Case_Id = Case_Id.substring(Case_Id.lastIndexOf("G")); //Removal of text from left side
	    	Thread.sleep(3000);
	    	StringBuffer sb= new StringBuffer(Case_Id);
	    	sb.deleteCharAt(sb.length()-1); //Removal of text from right side
	    	Case_Id = sb.toString();
			row++;
			Execution_Result.Update_GLDT_CaseId();
			Execution_Result.Fill_caseid_and_Result();
			try {
	            //FileInputStream fStream = new FileInputStream(new File(
	                    //"C:\\Users\\DC0121\\eclipse-workspace\\BIPS\\GLDT-TestCases-for-Automation.xlsx")); 
	            
	            FileInputStream fStream = new FileInputStream(new File(
	            		"G:\\My Drive\\app\\GLDT-TestCases-for-Automation.xlsx"));
	            
	            //Enter the path to your excel here

	            // Create workbook instance referencing the file created above
	            XSSFWorkbook workbook = new XSSFWorkbook(fStream);

	            // Get your first or desired sheet from the workbook
	            XSSFSheet sheet = workbook.getSheetAt(1); // getting second sheet

	            XSSFRow row = sheet.getRow(7);
	            XSSFCell cell1 = row.getCell(8);
	            XSSFRow row1 = sheet.getRow(8);
	            XSSFCell cell2 = row1.getCell(8);

	            Product = cell1.toString();
	            Reason = cell2.toString();

	            fStream.close();
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    	WebElement selectproduct = driver.findElement(By.xpath("//input[@id='414e17ce']"));
	    	selectproduct.clear();
	    	selectproduct.sendKeys(Product);
	    	selectproduct.sendKeys(Keys.DOWN);
	    	selectproduct.sendKeys(Keys.RETURN);
//			softAssert.assertTrue(selectproduct.isDisplayed());
			row++;
			Execution_Result.Fill_Execution_Result();
	    	WebElement reason = driver.findElement(By.xpath("//*[@id=\"158b841d\"]"));
	    	reason.clear();
	    	reason.sendKeys(Reason);
//			softAssert.assertTrue(reason.isDisplayed());
			row++;
			Execution_Result.Fill_Execution_Result();
//	    	WebElement region = driver.findElement(By.xpath("//*[@id=\"CT\"]/span/button"));
	    	WebElement region = driver.findElement(By.xpath("//button[contains(text(),'EM')]"));
	    	region.click();
//			softAssert.assertTrue(region.isDisplayed());
			row++;
			Execution_Result.Fill_Execution_Result();
	    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    	WebElement ropu = driver.findElement(By.xpath("//button[text()='ROPU IMETA']"));
	    	ropu.click();
//			softAssert.assertTrue(ropu.isDisplayed());
			row++;
			Execution_Result.Fill_Execution_Result();
	    	WebDriverWait wait = new WebDriverWait(driver, 10);
	    	WebElement country = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='PEGA_HARNESS']/form[1]/div[3]/div[1]/section[1]/div[1]/span[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[7]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[19]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]/i[1]/img[1]")));
	    	country.click();
//			softAssert.assertTrue(country.isDisplayed());
			row++;
			Execution_Result.Fill_Execution_Result();
			WebElement close = driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
			close.click();
//			WebElement home_page = driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
//			softAssert.assertTrue(home_page.isDisplayed());
			row++;
			Execution_Result.Fill_Execution_Result();
			driver.manage().deleteAllCookies();
			try {
			  Thread.sleep(15000); //wait 15 seconds to clear cookies.
			} catch (InterruptedException e) {
			  e.printStackTrace();
			}
			driver.quit();
	    }
	    public static void Initiate_And_Complete_RAprocess_GLDT() throws Exception {
	        String Product = null;
	        String Reason = null;
	        WebDriver driver = BIPS_Login.driver;
	    	WebElement FrameSRC=driver.findElement(By.xpath("//iframe[@src='about:blank']"));
	        driver.switchTo().frame(FrameSRC);
	    	WebElement initiate = driver.findElement(By.xpath("//*[@class=\'header']"));//Copied the xpath and replace with class as the id is changing dynamically
	    	initiate.click();
	    	//WebElement gldt = driver.findElement(By.xpath("//*[@id=\"RULE_KEY\"]/div/div/div/div/div/div/div[2]/div/div/div/div[2]/span/button/img"));
	    	WebElement gldt = driver.findElement(By.xpath("//*[@id=\"RULE_KEY\"]/div/div/div/div/div/div/div[1]/div/div/div/div[2]/span/button/img"));
	    	gldt.click();
			row = 13;
			cell_case_id = 10;
			cell_actual_result = 10;
			cell_Status = 11;
			cell_Jira_Id = 12;
			Execution_Result.Fill_Execution_Result();
	    	driver.switchTo().defaultContent();
//	    	driver.switchTo().frame("PegaGadget1Ifr");
	    	driver.switchTo().frame(1);
	    	Case_Id = driver.findElement(By.xpath("//span[contains(text(),'(GLDT-')]")).getText();
	    	Case_Id = Case_Id.substring(Case_Id.lastIndexOf("G")); //Removal of text from left side
	    	StringBuffer sb= new StringBuffer(Case_Id);
	    	sb.deleteCharAt(sb.length()-1); //Removal of text from right side
	    	Case_Id = sb.toString();
			row++;
			Execution_Result.Update_GLDT_CaseId();
			Execution_Result.Fill_caseid_and_Result();
	    	try {
	            //FileInputStream fStream = new FileInputStream(new File(
	                    //"C:\\Users\\DC0121\\eclipse-workspace\\BIPS\\GLDT-TestCases-for-Automation.xlsx")); 
	            
	            FileInputStream fStream = new FileInputStream(new File(
	            		"G:\\My Drive\\app\\GLDT-TestCases-for-Automation.xlsx")); 
	            
	            
	            //Enter the path to your excel here

	            // Create workbook instance referencing the file created above
	            XSSFWorkbook workbook = new XSSFWorkbook(fStream);

	            // Get your first or desired sheet from the workbook
	            XSSFSheet sheet = workbook.getSheetAt(1); // getting second sheet

	            XSSFRow row = sheet.getRow(15);
	            XSSFCell cell1 = row.getCell(8);
	            XSSFRow row1 = sheet.getRow(16);
	            XSSFCell cell2 = row1.getCell(8);

	            Product = cell1.toString();
	            Reason = cell2.toString();

	            fStream.close();
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    	WebElement selectproduct = driver.findElement(By.xpath("//input[@id='414e17ce']"));
	    	selectproduct.clear();
	    	selectproduct.sendKeys(Product);
	    	selectproduct.sendKeys(Keys.DOWN);
	    	selectproduct.sendKeys(Keys.RETURN);
			row++;
			Execution_Result.Fill_Execution_Result();
	    	WebElement reason = driver.findElement(By.xpath("//*[@id=\"158b841d\"]"));
	    	reason.clear();
	    	reason.sendKeys(Reason);
			row++;
			Execution_Result.Fill_Execution_Result();
//	    	WebElement region = driver.findElement(By.xpath("//*[@id=\"CT\"]/span/button"));
	    	WebElement region = driver.findElement(By.xpath("//button[contains(text(),'EM')]"));
	    	region.click();
			row++;
			Execution_Result.Fill_Execution_Result();
	    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    	WebElement ropu = driver.findElement(By.xpath("//button[text()='ROPU IMETA']"));
	    	ropu.click();
			row++;
			Execution_Result.Fill_Execution_Result();
	    	WebDriverWait wait = new WebDriverWait(driver, 10);
	    	WebElement country = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='PEGA_HARNESS']/form[1]/div[3]/div[1]/section[1]/div[1]/span[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[7]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]/i[1]/img[1]")));
	    	country.click();
			row++;
			Execution_Result.Fill_Execution_Result();
	    	WebElement InitiateRAProcess = driver.findElement(By.xpath("//*[@id=\"RULE_KEY\"]/div[2]/div[3]/span/button"));
	    	InitiateRAProcess.click();
			row++;
			Execution_Result.Fill_Execution_Result();
	    	WebElement continue1 = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
	    	continue1.click();
			row++;
			Execution_Result.Fill_Execution_Result();
	    	driver.manage().deleteAllCookies();
	    	try {
	    	  Thread.sleep(15000); //wait 15 seconds to clear cookies.
	    	} catch (InterruptedException e) {
	    	  e.printStackTrace();
	    	}
	    	driver.quit();
	    }
	    public static void CompleteRAprocess_For_Open_Case_GLDT() throws Exception {
	    	String CaseID = null;
	    	String Product = null;
	        String Reason = null;
	        WebDriver driver = BIPS_Login.driver;
//	    	driver.switchTo().frame("PegaGadget2Ifr");
//	    	driver.switchTo().frame("PegaGadget0Ifr");
//	        driver.switchTo().defaultContent();
	    	driver.switchTo().frame(0);
	    	try {
	            //FileInputStream fStream = new FileInputStream(new File(
	              //      "C:\\Users\\DC0121\\eclipse-workspace\\BIPS\\GLDT-TestCases-for-Automation.xlsx"));
	            
	            FileInputStream fStream = new FileInputStream(new File(
	            		"G:\\My Drive\\app\\GLDT-TestCases-for-Automation.xlsx")); 
	            
	            //Enter the path to your excel here

	            // Create workbook instance referencing the file created above
	            XSSFWorkbook workbook = new XSSFWorkbook(fStream);

	            // Get your first or desired sheet from the workbook
	            XSSFSheet sheet = workbook.getSheetAt(1); // getting second sheet

	            XSSFRow row = sheet.getRow(22);
	            XSSFCell cell1 = row.getCell(8);
	            XSSFRow row1 = sheet.getRow(23);
	            XSSFCell cell2 = row1.getCell(8);
	            XSSFRow row2 = sheet.getRow(24);
	            XSSFCell cell3 = row2.getCell(8);
	            
	            CaseID = cell1.toString();
	            Product = cell2.toString();
	            Reason = cell3.toString();

	            fStream.close();
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    	driver.findElement(By.linkText(CaseID)).click();
			row = 22;
			cell_case_id = 10;
			cell_actual_result = 10;
			cell_Status = 11;
			cell_Jira_Id = 12;
			Execution_Result.Fill_Execution_Result();
	    	driver.switchTo().defaultContent();
//	    	driver.switchTo().frame("PegaGadget1Ifr");
	    	driver.switchTo().frame(1);
	    	
	    	WebElement selectproduct = driver.findElement(By.xpath("//input[@id='414e17ce']"));
	    	selectproduct.clear();
	    	selectproduct.sendKeys(Product);
	    	selectproduct.sendKeys(Keys.DOWN);
	    	selectproduct.sendKeys(Keys.RETURN);
	    	row++;
	    	Execution_Result.Fill_Execution_Result();
	    	WebElement reason = driver.findElement(By.xpath("//*[@id=\"158b841d\"]"));
	    	reason.clear();
	    	reason.sendKeys(Reason);
	    	row++;
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
	    	WebElement country = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='PEGA_HARNESS']/form[1]/div[3]/div[1]/section[1]/div[1]/span[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[7]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[19]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]/i[1]/img[1]")));
	    	country.click();
	    	row++;
	    	Execution_Result.Fill_Execution_Result();
	    	WebElement InitiateRAProcess = driver.findElement(By.xpath("//*[@id=\"RULE_KEY\"]/div[2]/div[3]/span/button"));
	    	InitiateRAProcess.click();
	    	row++;
	    	Execution_Result.Fill_Execution_Result();
	    	WebElement continue1 = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
	    	continue1.click();
	    	row++;
	    	Execution_Result.Fill_Execution_Result();
	    	driver.manage().deleteAllCookies();
	    	Thread.sleep(15000); //wait 15 seconds to clear cookies.
	    	try {
	    	  Thread.sleep(15000); //wait 15 seconds to clear cookies.
	    	} catch (InterruptedException e) {
	    	  e.printStackTrace();
	    	}
	    	driver.quit();
	    }
	    
	    public static void Verify_error_message() throws Exception {
	    	String CaseID = null;
			String Product = null;
		    String Reason = null;
		    SoftAssert softAssert = new SoftAssert();
		    WebDriver driver = BIPS_Login.driver;
//	    	driver.switchTo().frame("PegaGadget2Ifr");
//	    	driver.switchTo().frame("PegaGadget0Ifr");
//	        driver.switchTo().defaultContent();
	    	driver.switchTo().frame(0);
			try {
		        //FileInputStream fStream = new FileInputStream(new File(
		                //"C:\\Users\\DC0121\\eclipse-workspace\\BIPS\\GLDT-TestCases-for-Automation.xlsx")); //Enter the path to your excel here
		        
				FileInputStream fStream = new FileInputStream(new File(
	            		"G:\\My Drive\\app\\GLDT-TestCases-for-Automation.xlsx")); 
		        // Create workbook instance referencing the file created above
		        XSSFWorkbook workbook = new XSSFWorkbook(fStream);

		        // Get your first or desired sheet from the workbook
		        XSSFSheet sheet = workbook.getSheetAt(1); // getting second sheet

		        XSSFRow row = sheet.getRow(30);
		        XSSFCell cell1 = row.getCell(8);
		        XSSFRow row1 = sheet.getRow(31);
		        XSSFCell cell2 = row1.getCell(8);
		        XSSFRow row2 = sheet.getRow(32);
		        XSSFCell cell3 = row2.getCell(8);
		        
		        CaseID = cell1.toString();
		        Product = cell2.toString();
		        Reason = cell3.toString();

		        fStream.close();
		    } catch (Exception e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
			row = 30;
			cell_actual_result = 10;
			cell_Status = 11;
			cell_Jira_Id = 12;	
			driver.findElement(By.linkText(CaseID)).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget1Ifr");
			WebElement close1 = driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
//			softAssert.assertEquals(true, close1.isDisplayed());
			softAssert.assertTrue(close1.isDisplayed());
			Execution_Result.Fill_Execution_Result();
			WebElement selectproduct = driver.findElement(By.xpath("//input[@id='414e17ce']"));
			selectproduct.clear();
			selectproduct.sendKeys(Product);
			selectproduct.sendKeys(Keys.DOWN);
			selectproduct.sendKeys(Keys.RETURN);
			softAssert.assertTrue(selectproduct.isDisplayed());
			row++;
			Execution_Result.Fill_Execution_Result();
			WebElement reason = driver.findElement(By.xpath("//*[@id=\"158b841d\"]"));
			reason.clear();
			reason.sendKeys(Reason);
			softAssert.assertTrue(reason.isDisplayed());
			row++;
			Execution_Result.Fill_Execution_Result();
//			WebElement region = driver.findElement(By.xpath("//*[@id=\"CT\"]/span/button"));
			WebElement region = driver.findElement(By.xpath("//button[contains(text(),'EM')]"));
			region.click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			softAssert.assertTrue(region.isDisplayed());
			row++;
			Execution_Result.Fill_Execution_Result();
			WebElement ropu = driver.findElement(By.xpath("//button[text()='ROPU IMETA']"));
			ropu.click();
			softAssert.assertTrue(ropu.isDisplayed());
			row++;
			Execution_Result.Fill_Execution_Result();
			WebElement InitiateRAProcess = driver.findElement(By.xpath("//*[@id=\"RULE_KEY\"]/div[2]/div[3]/span/button"));
			InitiateRAProcess.click();
		    String ExpectedError = "Please select at least one country1";
		    String ActualError = driver.findElement(By.xpath("//div[contains(text(),'Please select at least one country')]")).getText();
		    try {
		    softAssert.assertTrue(ActualError.equalsIgnoreCase(ExpectedError));
		    if (ExpectedError.equalsIgnoreCase(ActualError)) {
				System.out.println("The expected error is same as actual error --- " + ActualError);
				row++;
				WebElement close = driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
				close.click();
				Execution_Result.Fill_Execution_Result();
				driver.manage().deleteAllCookies();
				throw new Exception("Assertion passed");
		    }
			else {
				System.out.println("The expected error doesn't match the actual error --- " + ActualError);
				summary = "The expected error doesn't match the actual error";
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Please select at least one country')]")));
				takeSnapShot(driver, "C:\\Users\\DC0121\\eclipse-workspace\\BIPS\\screenshot\\Error_message_to_select_at_least_one_country.png");
				ScreenCapture.main(null);
				row++;
				nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
				Execution_Result.Fill_Fail_Result();
				WebElement close = driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
				close.click();
				Jira_Ticket.CreateJiraTicket();
				driver.manage().deleteAllCookies();
				throw new Exception("Assertion failed");
			}			
		}
				catch (Exception e) 
		    	{
				Thread.sleep(15000); //wait 15 seconds to clear cookies.
				driver.quit();
		    	}
//				finally {
//				Thread.sleep(15000); //wait 15 seconds to clear cookies.
//				driver.quit();
//				}
		    softAssert.assertAll();
}
	   
 		public static void Open_And_Close_Open_case_gldt() throws Exception {
	    	String CaseID = null;
	    	String Product = null;
	        String Reason = null; 
	        WebDriver driver = BIPS_Login.driver;
//	    	driver.switchTo().frame("PegaGadget2Ifr");
//	    	driver.switchTo().frame("PegaGadget0Ifr");
//	        driver.switchTo().defaultContent();
	    	driver.switchTo().frame(0);
	    	try {
	            //FileInputStream fStream = new FileInputStream(new File(
	                    //"C:\\Users\\DC0121\\eclipse-workspace\\BIPS\\GLDT-TestCases-for-Automation.xlsx"));
	            
	            FileInputStream fStream = new FileInputStream(new File(
	            		"G:\\My Drive\\app\\GLDT-TestCases-for-Automation.xlsx")); 
	            
	            //Enter the path to your excel here

	            
	            // Create workbook instance referencing the file created above
	            XSSFWorkbook workbook = new XSSFWorkbook(fStream);

	            // Get your first or desired sheet from the workbook
	            XSSFSheet sheet = workbook.getSheetAt(1); // getting second sheet

		        XSSFRow row = sheet.getRow(36);
		        XSSFCell cell1 = row.getCell(8);
		        XSSFRow row1 = sheet.getRow(37);
		        XSSFCell cell2 = row1.getCell(8);
		        XSSFRow row2 = sheet.getRow(38);
		        XSSFCell cell3 = row2.getCell(8);
	            
	            CaseID = cell1.toString();
	            Product = cell2.toString();
	            Reason = cell3.toString();

	            fStream.close();
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    	driver.findElement(By.linkText(CaseID)).click();
			row = 36;
			cell_actual_result = 10;
			cell_Status = 11;
			cell_Jira_Id = 12;
	    	driver.switchTo().defaultContent();
//	    	driver.switchTo().frame("PegaGadget1Ifr");
	    	driver.switchTo().frame(1);
			Execution_Result.Fill_Execution_Result();
//			Execution_Result t1 = new Execution_Result();
//			t1.Fill_Execution_Result();
	    	WebElement selectproduct = driver.findElement(By.xpath("//input[@id='414e17ce']"));
	    	selectproduct.clear();
	    	selectproduct.sendKeys(Product);
	    	selectproduct.sendKeys(Keys.DOWN);
	    	selectproduct.sendKeys(Keys.RETURN);
	    	row++;
			Execution_Result.Fill_Execution_Result();
	    	WebElement reason = driver.findElement(By.xpath("//*[@id=\"158b841d\"]"));
	    	reason.clear();
	    	reason.sendKeys(Reason);
	    	row++;
			Execution_Result.Fill_Execution_Result();
	    	WebElement close = driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
	    	close.click();
	    	row++;
			Execution_Result.Fill_Execution_Result();
	    	driver.manage().deleteAllCookies();
	    	try {
	    	  Thread.sleep(15000); //wait 15 seconds to clear cookies.
	    	} catch (InterruptedException e) {
	    	  e.printStackTrace();
	    	}
	    	driver.quit();
	    }
	    public static void Open_And_Close_PendingChildCaseProcessing_gldt() throws Exception {
	    	String CaseID = null;
	    	WebDriver driver = BIPS_Login.driver;
//	    	driver.switchTo().frame("PegaGadget2Ifr");
//	    	driver.switchTo().frame("PegaGadget0Ifr");
//	        driver.switchTo().defaultContent();
	    	driver.switchTo().frame(0);
	    	try {
	            //FileInputStream fStream = new FileInputStream(new File(
	              //      "C:\\Users\\DC0121\\eclipse-workspace\\BIPS\\GLDT-TestCases-for-Automation.xlsx")); 
	            
	            FileInputStream fStream = new FileInputStream(new File(
	            		"G:\\My Drive\\app\\GLDT-TestCases-for-Automation.xlsx")); 
	            
	            //Enter the path to your excel here

	            // Create workbook instance referencing the file created above
	            XSSFWorkbook workbook = new XSSFWorkbook(fStream);

	            // Get your first or desired sheet from the workbook
	            XSSFSheet sheet = workbook.getSheetAt(1); // getting second sheet

	            XSSFRow row = sheet.getRow(40);
	            XSSFCell cell1 = row.getCell(8);
	            
	            CaseID = cell1.toString();

	            fStream.close();
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    	driver.findElement(By.linkText(CaseID)).click();
			row = 40;
			cell_actual_result = 10;
			cell_Status = 11;
			cell_Jira_Id = 12;
	    	driver.switchTo().defaultContent();
	    	driver.switchTo().frame("PegaGadget1Ifr");
			Execution_Result.Fill_Execution_Result();
	    	WebElement close = driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
	    	close.click();
	    	row++;
			Execution_Result.Fill_Execution_Result();
	    	driver.manage().deleteAllCookies();
	    	try {
	    	  Thread.sleep(15000); //wait 15 seconds to clear cookies.
	    	} catch (InterruptedException e) {
	    	  e.printStackTrace();
	    	}
	    	driver.quit();
	    }

	    //////////////////////gldtProductsCheckBox////////
	    
		public static void initiate_gldtProductsCheckBox() throws Exception {
		    String Product = null;
		    String Reason = null;
		    
		   String TemporaryProductNameValue = null;
		   
		    SoftAssert softAssert = new SoftAssert();
			WebDriver driver = BIPS_Login.driver;
			WebElement FrameSRC=driver.findElement(By.xpath("//iframe[@src='about:blank']"));
		    driver.switchTo().frame(FrameSRC);
			WebElement initiate = driver.findElement(By.xpath("//*[@class=\'header']"));//Copied the xpath and replace with class as the id is changing dynamically
			initiate.click();
			//WebElement gldt = driver.findElement(By.xpath("//*[@id=\"RULE_KEY\"]/div/div/div/div/div/div/div[2]/div/div/div/div[2]/span/button/img"));
			WebElement gldt = driver.findElement(By.xpath("//*[@id=\"RULE_KEY\"]/div/div/div/div/div/div/div[1]/div/div/div/div[2]/span/button/img"));
			gldt.click();
			row = 42; // Variable for Case_Id row
			cell_case_id = 10;// Variable for Case_Id column
			cell_actual_result = 10;
			cell_Status = 11;
			cell_Jira_Id = 12;
//			WebDriverWait wait5 = new WebDriverWait(driver, 30);
//			wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='414e17ce']")));
//			WebElement selectproduct1 = driver.findElement(By.xpath("//input[@id='414e17ce']"));
//			softAssert.assertTrue(selectproduct1.isDisplayed());
			Execution_Result.Fill_Execution_Result();
			driver.switchTo().defaultContent();
//			driver.switchTo().frame("PegaGadget1Ifr");
			driver.switchTo().frame(1);
			Case_Id = driver.findElement(By.xpath("//span[contains(text(),'(GLDT-')]")).getText();
			Thread.sleep(3000);
			Case_Id = Case_Id.substring(Case_Id.lastIndexOf("G")); //Removal of text from left side
			Thread.sleep(3000);
			StringBuffer sb= new StringBuffer(Case_Id);
			sb.deleteCharAt(sb.length()-1); //Removal of text from right side
			Case_Id = sb.toString();
			row++;
			Execution_Result.Update_GLDT_CaseId();
			Execution_Result.Fill_caseid_and_Result();
			try {
		        //FileInputStream fStream = new FileInputStream(new File(
		                //"C:\\Users\\DC0121\\eclipse-workspace\\BIPS\\GLDT-TestCases-for-Automation.xlsx")); 
		        
		        FileInputStream fStream = new FileInputStream(new File(
		        		"G:\\My Drive\\app\\GLDT-TestCases-for-Automation.xlsx"));
		        
		        //Enter the path to your excel here

		        // Create workbook instance referencing the file created above
		        XSSFWorkbook workbook = new XSSFWorkbook(fStream);

		        // Get your first or desired sheet from the workbook
		        XSSFSheet sheet = workbook.getSheetAt(1); // getting second sheet

		        XSSFRow row = sheet.getRow(44);
		        XSSFCell cell1 = row.getCell(8);
		        XSSFRow row1 = sheet.getRow(45);
		        XSSFCell cell2 = row1.getCell(8);
		        
		        XSSFRow row2 = sheet.getRow(47);
		        XSSFCell cell3 = row2.getCell(8);

		        Product = cell1.toString();
		        Reason = cell2.toString();
		        
		        TemporaryProductNameValue= cell3.toString();
		        
		        fStream.close();
		    } catch (Exception e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
			WebElement selectproduct = driver.findElement(By.xpath("//input[@id='414e17ce']"));
			selectproduct.clear();
			selectproduct.sendKeys(Product);
			selectproduct.sendKeys(Keys.DOWN);
			selectproduct.sendKeys(Keys.RETURN);
//			softAssert.assertTrue(selectproduct.isDisplayed());
			row++;
			Execution_Result.Fill_Execution_Result();
			WebElement reason = driver.findElement(By.xpath("//*[@id=\"158b841d\"]"));
			reason.clear();
			reason.sendKeys(Reason);
//			softAssert.assertTrue(reason.isDisplayed());
			row++;
			Execution_Result.Fill_Execution_Result();
			
			/////////////////////////////////////
			// Check Mark selection 
			WebElement Productisundefined = driver.findElement(By.xpath("//label[@for='e2457cfb']"));
			Productisundefined.click();
			Thread.sleep(5000);
			//Selecting search box
			WebElement TemporaryProductName = driver.findElement(By.xpath("//input[@id='7515729c']"));
			TemporaryProductName.click();
			Thread.sleep(5000);
			//Selecting TemporaryProduct Value under drop-down
			WebElement Search = driver.findElement(By.xpath("//input[@id='anypicker-input']"));
			Search.sendKeys(TemporaryProductNameValue);
			Search.sendKeys(Keys.DOWN);
			Search.sendKeys(Keys.ENTER);
			row++;
			Execution_Result.Fill_Execution_Result();
			
			
			//////////////////////////////////////////////////////////////
//			WebElement region = driver.findElement(By.xpath("//*[@id=\"CT\"]/span/button"));
			WebElement region = driver.findElement(By.xpath("//button[contains(text(),'EM')]"));
			region.click();
//			softAssert.assertTrue(region.isDisplayed());
			row++;
			Execution_Result.Fill_Execution_Result();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			WebElement ropu = driver.findElement(By.xpath("//button[text()='ROPU IMETA']"));
			ropu.click();
//			softAssert.assertTrue(ropu.isDisplayed());
			row++;
			Execution_Result.Fill_Execution_Result();
			
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement country = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='PEGA_HARNESS']/form[1]/div[3]/div[1]/section[1]/div[1]/span[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[7]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[19]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]/i[1]/img[1]")));
			country.click();
//			softAssert.assertTrue(country.isDisplayed());
			row++;
			Execution_Result.Fill_Execution_Result();
			WebElement close = driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
			close.click();
//			WebElement home_page = driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
//			softAssert.assertTrue(home_page.isDisplayed());
			row++;
			Execution_Result.Fill_Execution_Result();
			//Press "Close" button. row update Actual data & Status/Pass or Fail 
			row++;
			Execution_Result.Fill_Execution_Result();
			
			
			driver.manage().deleteAllCookies();
			try {
			  Thread.sleep(15000); //wait 15 seconds to clear cookies.
			} catch (InterruptedException e) {
			  e.printStackTrace();
			}
			driver.quit();
		}

		public static void initiate_gldtProductsCheckBox_And_RAprocess() throws Exception {
		    String Product = null;
		    String Reason = null;
		    String TemporaryProductNameValue = null;
		   
		    
		    SoftAssert softAssert = new SoftAssert();
			WebDriver driver = BIPS_Login.driver;
			WebElement FrameSRC=driver.findElement(By.xpath("//iframe[@src='about:blank']"));
		    driver.switchTo().frame(FrameSRC);
			WebElement initiate = driver.findElement(By.xpath("//*[@class=\'header']"));//Copied the xpath and replace with class as the id is changing dynamically
			initiate.click();
			//WebElement gldt = driver.findElement(By.xpath("//*[@id=\"RULE_KEY\"]/div/div/div/div/div/div/div[2]/div/div/div/div[2]/span/button/img"));
			WebElement gldt = driver.findElement(By.xpath("//*[@id=\"RULE_KEY\"]/div/div/div/div/div/div/div[1]/div/div/div/div[2]/span/button/img"));
			gldt.click();
			row = 52; // Variable for Case_Id row
			cell_case_id = 10;// Variable for Case_Id column
			cell_actual_result = 10;
			cell_Status = 11;
			cell_Jira_Id = 12;
//			WebDriverWait wait5 = new WebDriverWait(driver, 30);
//			wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='414e17ce']")));
//			WebElement selectproduct1 = driver.findElement(By.xpath("//input[@id='414e17ce']"));
//			softAssert.assertTrue(selectproduct1.isDisplayed());
			Execution_Result.Fill_Execution_Result();
			driver.switchTo().defaultContent();
//			driver.switchTo().frame("PegaGadget1Ifr");
			driver.switchTo().frame(1);
			Case_Id = driver.findElement(By.xpath("//span[contains(text(),'(GLDT-')]")).getText();
			Thread.sleep(3000);
			Case_Id = Case_Id.substring(Case_Id.lastIndexOf("G")); //Removal of text from left side
			Thread.sleep(3000);
			StringBuffer sb= new StringBuffer(Case_Id);
			sb.deleteCharAt(sb.length()-1); //Removal of text from right side
			Case_Id = sb.toString();
			row++;
			Execution_Result.Update_GLDT_CaseId();
			Execution_Result.Fill_caseid_and_Result();
			try {
		        //FileInputStream fStream = new FileInputStream(new File(
		                //"C:\\Users\\DC0121\\eclipse-workspace\\BIPS\\GLDT-TestCases-for-Automation.xlsx")); 
		        
		        FileInputStream fStream = new FileInputStream(new File(
		        		"G:\\My Drive\\app\\GLDT-TestCases-for-Automation.xlsx"));
		        
		        //Enter the path to your excel here

		        // Create workbook instance referencing the file created above
		        XSSFWorkbook workbook = new XSSFWorkbook(fStream);

		        // Get your first or desired sheet from the workbook
		        XSSFSheet sheet = workbook.getSheetAt(1); // getting second sheet

		        XSSFRow row = sheet.getRow(54);
		        XSSFCell cell1 = row.getCell(8);
		        
		        XSSFRow row1 = sheet.getRow(55);
		        XSSFCell cell2 = row1.getCell(8);
		        
		        XSSFRow row2 = sheet.getRow(57);
		        XSSFCell cell3 = row2.getCell(8);

		        Product = cell1.toString();
		        Reason = cell2.toString();
		        TemporaryProductNameValue= cell3.toString();
		        
		        fStream.close();
		    } catch (Exception e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
			WebElement selectproduct = driver.findElement(By.xpath("//input[@id='414e17ce']"));
			selectproduct.clear();
			selectproduct.sendKeys(Product);
			selectproduct.sendKeys(Keys.DOWN);
			selectproduct.sendKeys(Keys.RETURN);
//			softAssert.assertTrue(selectproduct.isDisplayed());
			row++;
			Execution_Result.Fill_Execution_Result();
			WebElement reason = driver.findElement(By.xpath("//*[@id=\"158b841d\"]"));
			reason.clear();
			reason.sendKeys(Reason);
//			softAssert.assertTrue(reason.isDisplayed());
			row++;
			Execution_Result.Fill_Execution_Result();
			
			/////////////////////////////////////
			// Check Mark selection 
			WebElement Productisundefined = driver.findElement(By.xpath("//label[@for='e2457cfb']"));
			Productisundefined.click();
			row++;
			Execution_Result.Fill_Execution_Result();
			
			Thread.sleep(5000);
			//Selecting search box
			WebElement TemporaryProductName = driver.findElement(By.xpath("//input[@id='7515729c']"));
			TemporaryProductName.click();
			Thread.sleep(5000);
			//Selecting TemporaryProduct Value under drop-down
			WebElement Search = driver.findElement(By.xpath("//input[@id='anypicker-input']"));
			Search.sendKeys(TemporaryProductNameValue);
			Search.sendKeys(Keys.DOWN);
			Search.sendKeys(Keys.ENTER);
			row++;
			Execution_Result.Fill_Execution_Result();
			
			
			//////////////////////////////////////////////////////////////
//			WebElement region = driver.findElement(By.xpath("//*[@id=\"CT\"]/span/button"));
			WebElement region = driver.findElement(By.xpath("//button[contains(text(),'EM')]"));
			region.click();
//			softAssert.assertTrue(region.isDisplayed());
			row++;
			Execution_Result.Fill_Execution_Result();
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			WebElement ropu = driver.findElement(By.xpath("//button[text()='ROPU IMETA']"));
			ropu.click();
//			softAssert.assertTrue(ropu.isDisplayed());
			row++;
			Execution_Result.Fill_Execution_Result();
			
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement country = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='PEGA_HARNESS']/form[1]/div[3]/div[1]/section[1]/div[1]/span[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[7]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[19]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]/i[1]/img[1]")));
			country.click();
//			softAssert.assertTrue(country.isDisplayed());
			row++;
			Execution_Result.Fill_Execution_Result();
			
			///// close  ////
			//WebElement close = driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
			//close.click();
//			WebElement home_page = driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
//			softAssert.assertTrue(home_page.isDisplayed());
			//row++;
			//Execution_Result.Fill_Execution_Result();
			
			//Press "Close" button. row update Actual data & Status/Pass or Fail 
			//row++;
			//Execution_Result.Fill_Execution_Result();
			
			//Initiate RA Process" button & Press Continue. row update Actual data & Status/Pass or Fail 

			WebElement InitiateRAProcess = driver.findElement(By.xpath("//*[@id=\"RULE_KEY\"]/div[2]/div[3]/span/button"));
			InitiateRAProcess.click();
			row++;
			Execution_Result.Fill_Execution_Result();
			

		
			
			Thread.sleep(3000);
			
			//Popup window///
			//WebElement continue1 = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
			//continue1.click();
			//row++;
			//Execution_Result.Fill_Execution_Result();
			
			
			driver.manage().deleteAllCookies();
			try {
			  Thread.sleep(15000); //wait 15 seconds to clear cookies.
			} catch (InterruptedException e) {
			  e.printStackTrace();
			}
			driver.quit();
		}

		public static void CompleteRAprocess_For_Open_Case_GLDT_ProductsCheckBox() throws Exception {
			
			String CaseID = null;
	    	String Product = null;
	        String Reason = null;
	        String TemporaryProductNameValue = null;
	        String Comments = null;
	        
	        
	        WebDriver driver = BIPS_Login.driver;
//	    	driver.switchTo().frame("PegaGadget2Ifr");
//	    	driver.switchTo().frame("PegaGadget0Ifr");
//	        driver.switchTo().defaultContent();
	    	driver.switchTo().frame(0);
	    	try {
	            //FileInputStream fStream = new FileInputStream(new File(
	              //      "C:\\Users\\DC0121\\eclipse-workspace\\BIPS\\GLDT-TestCases-for-Automation.xlsx"));
	            
	            FileInputStream fStream = new FileInputStream(new File(
	            		"G:\\My Drive\\app\\GLDT-TestCases-for-Automation.xlsx")); 
	            
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
//	    	driver.switchTo().frame("PegaGadget1Ifr");
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
	    	
	    	
	    	WebElement continue1 = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
	    	continue1.click();
	    	
	    	row++;
	    	Execution_Result.Fill_Execution_Result();
	    	
	    	driver.manage().deleteAllCookies();
	    	Thread.sleep(15000); //wait 15 seconds to clear cookies.
	    	try {
	    	  Thread.sleep(15000); //wait 15 seconds to clear cookies.
	    	} catch (InterruptedException e) {
	    	  e.printStackTrace();
	    	}
	    	driver.quit();
			
		}
	    
		public static void Open_And_Close_PendingChildCaseProcessing_gldt_ProductsCheckBox() throws Exception{
			
			
			
		}
		
		
		
		
		
	    
	    
	    
	    
public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

    //Convert web driver object to TakeScreenshot

    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    
    //Call getScreenshotAs method to create image file
    
            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
            
        //Move image file to new destination

            File DestFile=new File(fileWithPath);

            //Copy file at destination

//          FileUtils.copyFile(SrcFile, DestFile);
            FileHandler.copy(SrcFile, DestFile);
}








public static void main(String[] args) throws Exception {
	BIPS_Login.TAMA_User_Login();
//	GLDT_TestCase_Steps.Open_And_Close_Open_case_gldt();
	GLDT_TestCase_Steps.Verify_error_message();
}




}
//public static void CreateJiraTicket() throws Exception {
////	System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");
////	driver = new EdgeDriver();
//	WebDriver driver = BIPS_Login.driver;
//	String str = null;
//	System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
////	driver = new ChromeDriver();
//	String baseUrl = "https://id.atlassian.com/login?continue=https%3A%2F%2F1abc12345.atlassian.net%2Flogin%3FredirectCount%3D1%26dest-url%3D%252Fjira%252Fsoftware%252Fc%252Fprojects%252FP1%252Fissues%26application%3Djira&application=jira";
//	driver.get(baseUrl);
//	driver.manage().window().maximize(); //Maximise browser window
//	new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='username']")));
//	WebElement username = driver.findElement(By.xpath("//*[@id='username']"));
//	username.sendKeys("chainiadya@gmail.com");
//	driver.findElement(By.xpath("//*[@id=\'login-submit\']/span/span")).click();
////	driver.findElement(By.xpath("//button[@id='login-submit']")).click();
//	new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.name("password")));
//	WebElement password = driver.findElement(By.name("password"));
//	password.sendKeys("Testing@123");
//	driver.findElement(By.id("login-submit")).click();
////	driver.findElement(By.xpath("//button[@id='login-submit']")).click();
//	new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\'createGlobalItem\']/span")));
//	String ParentWindow = driver.getWindowHandle(); //switching from parent to pop up window
//	driver.findElement(By.xpath("//*[@id=\'createGlobalItem\']/span")).click();
//	for (String Child_Window : driver.getWindowHandles()) { 
//	driver.switchTo().window(Child_Window);
//	WebDriverWait wait = new WebDriverWait(driver, 30);// Wait 30 seconds
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Create issue')]")));
//	driver.findElement(By.xpath("//input[@id='summary-field']")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
//	Thread.sleep(5000);
//	WebElement summary = driver.findElement(By.xpath("//input[@id='summary-field']"));
//	summary.sendKeys("The expected error doesn't match the actual error");
//	WebDriverWait wait1 = new WebDriverWait(driver, 20);// Wait 20 seconds
//	wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
//	driver.findElement(By.xpath("//button[@type='submit']")).click();
//	WebDriverWait wait2 = new WebDriverWait(driver, 20);// Wait 20 seconds
//	wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'View issue')]")));
//	driver.findElement(By.xpath("//span[contains(text(),'View issue')]")).click();
//	wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"jira-issue-header\"]/div/div/div/nav/ol/div[2]/li/a/span")));
//	WebElement Jira_Text = driver.findElement(By.xpath("//*[@id=\"jira-issue-header\"]/div/div/div/nav/ol/div[2]/li/a/span"));
//	String Jira_Id = Jira_Text.getText();
//	System.out.println(Jira_Id);
//	
//	File xlsxFile = new File("C:\\Users\\DC0121\\eclipse-workspace\\BIPS\\GLDT-TestCases-for-Automation.xlsx");
//    
//    try {
//        //Creating input stream
//        FileInputStream inputStream = new FileInputStream(xlsxFile);
//         
//        //Creating workbook from input stream
//        Workbook workbook = WorkbookFactory.create(inputStream);
//
//        //Reading first sheet of excel file
//        Sheet sheet = workbook.getSheetAt(1);
//         
//        //Getting age cell of first row from the sheet
////        Cell cell = sheet.getRow(1).getCell(3);
//        Verify_error_message
//    	int row = ver
//    	int cell = test.cell;
//        sheet.getRow(row).getCell(cell).setCellValue(Jira_Id);
//        
//      //Updating the cell value with new data
////        cell.setCellValue(30);
//
//        //Close input stream
//        inputStream.close();
//
//        //Crating output stream and writing the updated workbook
//        FileOutputStream os = new FileOutputStream(xlsxFile);
//        workbook.write(os);
//         
//        //Close the workbook and output stream
//        workbook.close();
//        os.close();
//         
//        System.out.println("Excel file has been updated successfully.");
//         
//    } catch (EncryptedDocumentException | IOException e) {
//        System.err.println("Exception while updating an existing excel file.");
//        e.printStackTrace();
//    }
////	driver.findElement(By.xpath("//button[contains(text(),'EM')]"));
//	} 
//	
//	driver.manage().deleteAllCookies();
//			try {
//			  Thread.sleep(15000); //wait 15 seconds to clear cookies.
//			} catch (InterruptedException e) {
//			  e.printStackTrace();
//			}
//			driver.quit();
//}
/*
 * public static void Verify_page_title() throws Exception { String CaseID =
 * null; String Product = null; String Reason = null; SoftAssert softAssert =
 * new SoftAssert(); WebDriver driver = BIPS_Login.driver; //
 * driver.switchTo().frame("PegaGadget2Ifr");
 * driver.switchTo().frame("PegaGadget0Ifr"); try { FileInputStream fStream =
 * new FileInputStream(new File(
 * "C:\\Users\\DC0121\\eclipse-workspace\\BIPS\\GLDT-TestCases-for-Automation.xlsx"
 * )); //Enter the path to your excel here
 * 
 * // Create workbook instance referencing the file created above XSSFWorkbook
 * workbook = new XSSFWorkbook(fStream);
 * 
 * // Get your first or desired sheet from the workbook XSSFSheet sheet =
 * workbook.getSheetAt(2); // getting second sheet
 * 
 * XSSFRow row = sheet.getRow(30); XSSFCell cell1 = row.getCell(5); XSSFRow row1
 * = sheet.getRow(31); XSSFCell cell2 = row1.getCell(5); XSSFRow row2 =
 * sheet.getRow(32); XSSFCell cell3 = row2.getCell(5);
 * 
 * CaseID = cell1.toString(); Product = cell2.toString(); Reason =
 * cell3.toString();
 * 
 * fStream.close(); } catch (Exception e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } driver.findElement(By.linkText(CaseID)).click();
 * driver.switchTo().defaultContent();
 * driver.switchTo().frame("PegaGadget1Ifr"); WebElement selectproduct =
 * driver.findElement(By.xpath("//input[@id='414e17ce']"));
 * selectproduct.clear(); selectproduct.sendKeys(Product);
 * selectproduct.sendKeys(Keys.DOWN); selectproduct.sendKeys(Keys.RETURN);
 * WebElement reason = driver.findElement(By.xpath("//*[@id=\"158b841d\"]"));
 * reason.clear(); reason.sendKeys(Reason); // WebElement region =
 * driver.findElement(By.xpath("//*[@id=\"CT\"]/span/button")); WebElement
 * region = driver.findElement(By.xpath("//button[contains(text(),'EM')]"));
 * region.click();
 * driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); WebElement
 * ropu = driver.findElement(By.xpath("//button[text()='ROPU IMETA']"));
 * ropu.click(); WebElement InitiateRAProcess =
 * driver.findElement(By.xpath("//*[@id=\"RULE_KEY\"]/div[2]/div[3]/span/button"
 * )); InitiateRAProcess.click(); WebDriverWait wait = new WebDriverWait(driver,
 * 10); wait.until(ExpectedConditions.presenceOfElementLocated(By.
 * xpath("//div[contains(text(),'Please select at least one country')]")));
 * takeSnapShot(driver,
 * "C:\\Users\\DC0121\\eclipse-workspace\\BIPS\\screenshot\\Country not selected.png"
 * ); WebElement close =
 * driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
 * close.click(); String ExpectedTitle = "Pega Case Manager Portal"; String
 * ActualTitle = driver.getTitle(); if
 * (ExpectedTitle.equalsIgnoreCase(ActualTitle))
 * System.out.println("The expected title is same as actual title --- " +
 * ActualTitle); else
 * System.out.println("The expected title doesn't match the actual title --- " +
 * ActualTitle); // GLDT_TestCase_Steps.CreateJiraTicket(); Boolean verifyTitle
 * = ActualTitle.equalsIgnoreCase(ExpectedTitle); // assertTrue(verifyTitle);
 * System.out.println(verifyTitle); softAssert.assertTrue(verifyTitle);
 * driver.manage().deleteAllCookies(); try { Thread.sleep(15000); //wait 15
 * seconds to clear cookies. } catch (InterruptedException e) {
 * e.printStackTrace(); } driver.quit(); softAssert.assertAll(); } public static
 * void CompleteRAprocess_Without_selecting_Country() throws Exception { String
 * CaseID = null; String Product = null; String Reason = null; WebDriver driver
 * = BIPS_Login.driver; driver.switchTo().frame("PegaGadget2Ifr"); try {
 * FileInputStream fStream = new FileInputStream(new File(
 * "C:\\Users\\DC0121\\eclipse-workspace\\BIPS\\GLDT-TestCases-for-Automation.xlsx"
 * )); //Enter the path to your excel here
 * 
 * // Create workbook instance referencing the file created above XSSFWorkbook
 * workbook = new XSSFWorkbook(fStream);
 * 
 * // Get your first or desired sheet from the workbook XSSFSheet sheet =
 * workbook.getSheetAt(2); // getting second sheet
 * 
 * XSSFRow row = sheet.getRow(30); XSSFCell cell1 = row.getCell(5); XSSFRow row1
 * = sheet.getRow(31); XSSFCell cell2 = row1.getCell(5); XSSFRow row2 =
 * sheet.getRow(32); XSSFCell cell3 = row2.getCell(5);
 * 
 * CaseID = cell1.toString(); Product = cell2.toString(); Reason =
 * cell3.toString();
 * 
 * fStream.close(); } catch (Exception e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } driver.findElement(By.linkText(CaseID)).click();
 * driver.switchTo().defaultContent();
 * driver.switchTo().frame("PegaGadget1Ifr"); WebElement selectproduct =
 * driver.findElement(By.xpath("//input[@id='414e17ce']"));
 * selectproduct.clear(); selectproduct.sendKeys(Product);
 * selectproduct.sendKeys(Keys.DOWN); selectproduct.sendKeys(Keys.RETURN);
 * WebElement reason = driver.findElement(By.xpath("//*[@id=\"158b841d\"]"));
 * reason.clear(); reason.sendKeys(Reason); // WebElement region =
 * driver.findElement(By.xpath("//*[@id=\"CT\"]/span/button")); WebElement
 * region = driver.findElement(By.xpath("//button[contains(text(),'EM')]"));
 * region.click();
 * driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); WebElement
 * ropu = driver.findElement(By.xpath("//button[text()='ROPU IMETA']"));
 * ropu.click(); WebElement InitiateRAProcess =
 * driver.findElement(By.xpath("//*[@id=\"RULE_KEY\"]/div[2]/div[3]/span/button"
 * )); InitiateRAProcess.click(); WebDriverWait wait = new WebDriverWait(driver,
 * 10); wait.until(ExpectedConditions.presenceOfElementLocated(By.
 * xpath("//div[contains(text(),'Please select at least one country')]")));
 * takeSnapShot(driver,
 * "C:\\Users\\DC0121\\eclipse-workspace\\BIPS\\screenshot\\Country not selected.png"
 * ); WebElement close =
 * driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
 * close.click(); String ExpectedTitle = "Pega Case Manager Portal"; String
 * ActualTitle = driver.getTitle(); if
 * (ExpectedTitle.equalsIgnoreCase(ActualTitle))
 * System.out.println("The expected title is same as actual title --- " +
 * ActualTitle); else //
 * System.out.println("The expected title doesn't match the actual title --- " +
 * ActualTitle); // System.out.println(ActualTitle);
 * GLDT_TestCase_Steps.CreateJiraTicket(); // System.out.println("Print this");
 * Assert.assertEquals(ExpectedTitle, ActualTitle); Boolean verifyTitle =
 * driver.getTitle().equalsIgnoreCase("Pega Case Manager Portal");
 * assertTrue(verifyTitle); driver.manage().deleteAllCookies(); try {
 * Thread.sleep(15000); //wait 15 seconds to clear cookies. } catch
 * (InterruptedException e) { e.printStackTrace(); } driver.quit(); } public
 * static void failed_initiate_gldt() throws Exception { String Product = null;
 * String Reason = null; WebDriver driver = BIPS_Login.driver; WebElement
 * FrameSRC=driver.findElement(By.xpath("//iframe[@src='about:blank']"));
 * driver.switchTo().frame(FrameSRC); WebElement initiate =
 * driver.findElement(By.xpath("//*[@class=\'header']"));//Copied the xpath and
 * replace with class as the id is changing dynamically initiate.click();
 * WebElement gldt = driver.findElement(By.xpath(
 * "//*[@id=\"RULE_KEY\"]/div/div/div/div/div/div/div[1]/div/div/div/div[2]/span/button/img"
 * )); gldt.click(); driver.switchTo().defaultContent();
 * driver.switchTo().frame("PegaGadget1Ifr"); try { FileInputStream fStream =
 * new FileInputStream(new File(
 * "C:\\Users\\DC0121\\eclipse-workspace\\BIPS\\Input_Data_GLDT.xlsx")); //Enter
 * the path to your excel here
 * 
 * // Create workbook instance referencing the file created above XSSFWorkbook
 * workbook = new XSSFWorkbook(fStream);
 * 
 * // Get your first or desired sheet from the workbook XSSFSheet sheet =
 * workbook.getSheetAt(2); // getting second sheet
 * 
 * XSSFRow row = sheet.getRow(1); XSSFCell cell1 = row.getCell(0); XSSFCell
 * cell2 = row.getCell(1);
 * 
 * Product = cell1.toString(); Reason = cell2.toString();
 * 
 * fStream.close(); } catch (Exception e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } WebElement selectproduct =
 * driver.findElement(By.xpath("//input[@id='414e17ce']"));
 * selectproduct.clear(); selectproduct.sendKeys(Product);
 * selectproduct.sendKeys(Keys.DOWN); selectproduct.sendKeys(Keys.RETURN);
 * WebElement reason = driver.findElement(By.xpath("//*[@id=\"158b841d\"]"));
 * reason.clear(); reason.sendKeys(Reason); WebElement region =
 * driver.findElement(By.xpath("//*[@id=\"CT\"]/span/button")); region.click();
 * driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); WebElement
 * ropu = driver.findElement(By.xpath("//button[text()='ROPU IMETA']"));
 * ropu.click(); // WebDriverWait wait = new WebDriverWait(driver, 10); //
 * WebElement country =
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "//body/div[@id='PEGA_HARNESS']/form[1]/div[3]/div[1]/section[1]/div[1]/span[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[7]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[19]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]/i[1]/img[1]"
 * ))); // country.click(); WebElement InitiateRAProcess =
 * driver.findElement(By.xpath("//*[@id=\"RULE_KEY\"]/div[2]/div[3]/span/button"
 * )); InitiateRAProcess.click(); WebDriverWait wait = new WebDriverWait(driver,
 * 10); wait.until(ExpectedConditions.presenceOfElementLocated(By.
 * xpath("//div[contains(text(),'Please select at least one country')]")));
 * takeSnapShot(driver,
 * "C:\\Users\\DC0121\\eclipse-workspace\\BIPS\\screenshot\\Country not selected.png"
 * ); // WebElement continue1 =
 * driver.findElement(By.xpath("//button[contains(text(),'Continue')]")); //
 * continue1.click(); // driver.manage().deleteAllCookies(); WebElement close =
 * driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
 * close.click(); // WebElement heading = driver.findElement(By.xpath(
 * "//*[@id=\"Error_.CountOfCountriesSelected\"]/div[2]/div[2]"); //
 * System.out.println(heading); String ExpectedTitle =
 * "Pega Case Manager Portal1"; String ActualTitle = driver.getTitle(); if
 * (ExpectedTitle.equalsIgnoreCase(ActualTitle))
 * System.out.println("The expected title is same as actual title --- " +
 * ActualTitle); else //
 * System.out.println("The expected title doesn't match the actual title --- " +
 * ActualTitle); // System.out.println(ActualTitle);
 * GLDT_TestCase_Steps.CreateJiraTicket(); // System.out.println("Print this");
 * Assert.assertEquals(ExpectedTitle, ActualTitle); Boolean verifyTitle =
 * driver.getTitle().equalsIgnoreCase("Pega Case Manager Portal");
 * assertTrue(verifyTitle); driver.manage().deleteAllCookies(); try {
 * Thread.sleep(15000); //wait 15 seconds to clear cookies. } catch
 * (InterruptedException e) { e.printStackTrace(); } driver.quit(); }
 */
