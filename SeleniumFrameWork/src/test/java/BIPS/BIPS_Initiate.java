package BIPS;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;



import GLDT_Other_Methods.Execution_Result;
import GLDT_Other_Methods.Execution_Result_Initiate;
public class BIPS_Initiate {
	
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
		//BIPS_Login.TAMA_User_Login();
		//BIPS_Initiate.GLDT_Initiate();
		//BIPS_Initiate.GLDT_Initiate_ProductsCheckBoxSelect();
		
		//BIPS_Initiate.PSF_Initiate();
		
		
	}
	


public static void GLDT_Initiate() throws Exception {


}
//////////////////////////////////////////////////////////
public static void GLDT_Initiate_ProductsCheckBoxSelect() throws Exception {

    String Product = null;
    String Reason = null;
    String TemporaryProductNameValue = null;
   
	SoftAssert softAssert = new SoftAssert();
	WebDriver driver = BIPS_Login.driver;
   
	
				// Click on Initiate tab & initiate GLDT Case //
	WebElement FrameSRC=driver.findElement(By.xpath("//iframe[@src='about:blank']"));
    driver.switchTo().frame(FrameSRC);
    
 
    						//click on initiate tab
	WebElement initiate = driver.findElement(By.xpath("//*[@class=\'header']"));//Copied the xpath and replace with class as the id is changing dynamically
	initiate.click();
	
	/////////////////////////////////////////////////////////
	
	
	//initiate GLDT Case 
	WebElement gldt = driver.findElement(By.xpath("//*[@id=\"RULE_KEY\"]/div/div/div/div/div/div/div[1]/div/div/div/div[2]/span/button/img"));
	gldt.click();
	
	 row = 42; // Variable for Case_Id row
	 cell_case_id = 10;// Variable for Case_Id column
	cell_actual_result = 10;
	 cell_Status = 11;
	 cell_Jira_Id = 12;

	Execution_Result_Initiate.Fill_Execution_Result();
	


	driver.switchTo().defaultContent();
	driver.switchTo().frame(1);
	Case_Id = driver.findElement(By.xpath("//span[contains(text(),'(GLDT-')]")).getText();
	Thread.sleep(3000);
	Case_Id = Case_Id.substring(Case_Id.lastIndexOf("G")); //Removal of text from left side
	Thread.sleep(3000);
	StringBuffer sb= new StringBuffer(Case_Id);
	sb.deleteCharAt(sb.length()-1); //Removal of text from right side
	Case_Id = sb.toString();
	row++;
	Execution_Result_Initiate.Update_GLDT_CaseId();
	Execution_Result_Initiate.Fill_caseid_and_Result();

	
	try {
		FileInputStream fStream = new FileInputStream(new File(xlfilepath));
        
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
//	softAssert.assertTrue(selectproduct.isDisplayed());
	row++;
	Execution_Result_Initiate.Fill_Execution_Result();
	WebElement reason = driver.findElement(By.xpath("//*[@id=\"158b841d\"]"));
	reason.clear();
	reason.sendKeys(Reason);
//	softAssert.assertTrue(reason.isDisplayed());
	row++;
	Execution_Result_Initiate.Fill_Execution_Result();
	
	//////////////////////////////////////
	// Check Mark selection 
	WebElement Productisundefined = driver.findElement(By.xpath("//label[@for='e2457cfb']"));
	Productisundefined.click();
	Thread.sleep(5000);
	//Selecting search box
	WebElement TemporaryProductName = driver.findElement(By.xpath("//input[@id='7515729c']"));
	Thread.sleep(5000);
	TemporaryProductName.click();
	Thread.sleep(5000);
	//Selecting TemporaryProduct Value under drop-down
	WebElement Search = driver.findElement(By.xpath("//input[@id='anypicker-input']"));
	Search.sendKeys(TemporaryProductNameValue);
	Search.sendKeys(Keys.DOWN);
	Search.sendKeys(Keys.ENTER);
	row++;
	Execution_Result_Initiate.Fill_Execution_Result();
	
	
	//////////////////////////////////////////////////////////////
//	WebElement region = driver.findElement(By.xpath("//*[@id=\"CT\"]/span/button"));
	WebElement region = driver.findElement(By.xpath("//button[contains(text(),'EM')]"));
	region.click();
//	softAssert.assertTrue(region.isDisplayed());
	row++;
	Execution_Result_Initiate.Fill_Execution_Result();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	WebElement ropu = driver.findElement(By.xpath("//button[text()='ROPU IMETA']"));
	ropu.click();
//	softAssert.assertTrue(ropu.isDisplayed());
	row++;
	Execution_Result_Initiate.Fill_Execution_Result();
	
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement country = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='PEGA_HARNESS']/form[1]/div[3]/div[1]/section[1]/div[1]/span[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[7]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[19]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]/i[1]/img[1]")));
	country.click();
//	softAssert.assertTrue(country.isDisplayed());
	row++;
	Execution_Result_Initiate.Fill_Execution_Result();
	WebElement close = driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
	close.click();
//	WebElement home_page = driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
//	softAssert.assertTrue(home_page.isDisplayed());
	row++;
	Execution_Result_Initiate.Fill_Execution_Result();
	//Press "Close" button. row update Actual data & Status/Pass or Fail 
	row++;
	Execution_Result_Initiate.Fill_Execution_Result();
	
	
	driver.manage().deleteAllCookies();
	try {
	  Thread.sleep(15000); //wait 15 seconds to clear cookies.
	} catch (InterruptedException e) {
	  e.printStackTrace();
	}
	driver.quit();
	
   


}
	
	


public static void GLDT_Initiate_ProductsCheckBoxSelect_And_RAprocess() throws Exception {
	
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
//	WebDriverWait wait5 = new WebDriverWait(driver, 30);
//	wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='414e17ce']")));
//	WebElement selectproduct1 = driver.findElement(By.xpath("//input[@id='414e17ce']"));
//	softAssert.assertTrue(selectproduct1.isDisplayed());
	Execution_Result_Initiate.Fill_Execution_Result();
	driver.switchTo().defaultContent();
//	driver.switchTo().frame("PegaGadget1Ifr");
	driver.switchTo().frame(1);
	Case_Id = driver.findElement(By.xpath("//span[contains(text(),'(GLDT-')]")).getText();
	Thread.sleep(3000);
	Case_Id = Case_Id.substring(Case_Id.lastIndexOf("G")); //Removal of text from left side
	Thread.sleep(3000);
	StringBuffer sb= new StringBuffer(Case_Id);
	sb.deleteCharAt(sb.length()-1); //Removal of text from right side
	Case_Id = sb.toString();
	row++;
	Execution_Result_Initiate.Update_GLDT_CaseId();
	Execution_Result_Initiate.Fill_caseid_and_Result();
	try {
        //FileInputStream fStream = new FileInputStream(new File(
                //"C:\\Users\\DC0121\\eclipse-workspace\\BIPS\\GLDT-TestCases-for-Automation.xlsx")); 
        
        FileInputStream fStream = new FileInputStream(new File(xlfilepath));
        
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
//	softAssert.assertTrue(selectproduct.isDisplayed());
	row++;
	Execution_Result_Initiate.Fill_Execution_Result();
	WebElement reason = driver.findElement(By.xpath("//*[@id=\"158b841d\"]"));
	reason.clear();
	reason.sendKeys(Reason);
//	softAssert.assertTrue(reason.isDisplayed());
	row++;
	Execution_Result_Initiate.Fill_Execution_Result();
	
	/////////////////////////////////////
	// Check Mark selection 
	WebElement Productisundefined = driver.findElement(By.xpath("//label[@for='e2457cfb']"));
	Productisundefined.click();
	row++;
	Execution_Result_Initiate.Fill_Execution_Result();
	
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
	Execution_Result_Initiate.Fill_Execution_Result();
	
	
	///////////////////////////////////////////////////////////////
//	WebElement region = driver.findElement(By.xpath("//*[@id=\"CT\"]/span/button"));
	WebElement region = driver.findElement(By.xpath("//button[contains(text(),'EM')]"));
	region.click();
//	softAssert.assertTrue(region.isDisplayed());
	row++;
	Execution_Result_Initiate.Fill_Execution_Result();
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	WebElement ropu = driver.findElement(By.xpath("//button[text()='ROPU IMETA']"));
	ropu.click();
//	softAssert.assertTrue(ropu.isDisplayed());
	row++;
	Execution_Result_Initiate.Fill_Execution_Result();
	
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement country = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='PEGA_HARNESS']/form[1]/div[3]/div[1]/section[1]/div[1]/span[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[7]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[19]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]/i[1]/img[1]")));
	country.click();
//	softAssert.assertTrue(country.isDisplayed());
	row++;
	Execution_Result_Initiate.Fill_Execution_Result();
	
	///// close  ////
	//WebElement close = driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
	//close.click();
//	WebElement home_page = driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
//	softAssert.assertTrue(home_page.isDisplayed());
	//row++;
	//Execution_Result_Initiate.Fill_Execution_Result();
	
	//Press "Close" button. row update Actual data & Status/Pass or Fail 
	//row++;
	//Execution_Result_Initiate.Fill_Execution_Result();
	
	//Initiate RA Process" button & Press Continue. row update Actual data & Status/Pass or Fail 

	WebElement InitiateRAProcess = driver.findElement(By.xpath("//*[@id=\"RULE_KEY\"]/div[2]/div[3]/span/button"));
	InitiateRAProcess.click();
	row++;
	Execution_Result_Initiate.Fill_Execution_Result();
	


	
	Thread.sleep(3000);
	
	//Popup window///
	//WebElement continue1 = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
	//continue1.click();
	//row++;
	//Execution_Result_Initiate.Fill_Execution_Result();
	
	
	driver.manage().deleteAllCookies();
	try {
	  Thread.sleep(15000); //wait 15 seconds to clear cookies.
	} catch (InterruptedException e) {
	  e.printStackTrace();
	}
	driver.quit();
	
}

public static void CompleteRAprocess_For_Open_Case_GLDT_ProductsCheckBox() throws Exception {

	
}


public static void Open_And_Close_PendingChildCaseProcessing_gldt_ProductsCheckBox() throws Exception {
	
}



public static void PSF_Initiate() throws Exception {

}




}