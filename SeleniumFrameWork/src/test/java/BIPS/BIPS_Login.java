package BIPS;

import java.io.File;
import java.io.FileInputStream;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import GLDT_Methods.GLDT_TestCase_Steps;
import GLDT_Other_Methods.Execution_Result;
import GLDT_Other_Methods.Jira_Ticket;
import GLDT_Other_Methods.ScreenCapture;


public class BIPS_Login {
	static SoftAssert softAssert = new SoftAssert();
	public static WebDriver driver;
	public static void TAMA_User_Login() throws Exception {
		String userid = null;
	    String password = null;
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		driver = new ChromeDriver();    
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        String baseUrl = "https://biphrm-biplah-stg1.pegacloud.io/prweb/app/default/c5mb0Z99oLKgPL-hk4L4rty7OLzbbezr*/!STANDARD";
        driver.get(baseUrl);
        driver.manage().window().maximize();
        try { 
            //FileInputStream fStream = new FileInputStream(new File("C:\\Users\\DC0121\\eclipse-workspace\\BIPS\\GLDT-TestCases-for-Automation.xlsx"));
            
            FileInputStream fStream = new FileInputStream(new File(
                    "C:\\Users\\cnbna\\Desktop\\BIPS Application\\reinvitationnosubjecttuemay1020224pm5pmi\\GLDT-TestCases-for-Automation.xlsx"));
            //Enter the path to your excel here

            // Create workbook instance referencing the file created above
            XSSFWorkbook workbook = new XSSFWorkbook(fStream);

            // Get your first or desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0); // getting first sheet

            XSSFRow row1 = sheet.getRow(1);
            XSSFCell cell1 = row1.getCell(2);
            XSSFRow row2 = sheet.getRow(2);
            XSSFCell cell2 = row2.getCell(2);

            userid = cell1.toString();
            password = cell2.toString();

            fStream.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        driver.findElement(By.name("UserIdentifier")).sendKeys(userid);
        driver.findElement(By.name("Password")).sendKeys(password);
        driver.findElement(By.id("sub")).click();
        try {
        	WebElement error = driver.findElement(By.xpath("//*[@id=\"error\"]"));
        	softAssert.assertFalse(error.isDisplayed());
        	System.out.println("Login failed");
			GLDT_TestCase_Steps.nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
			GLDT_TestCase_Steps.summary = "User name or Password is not correct";
			GLDT_TestCase_Steps.row = 4;
			GLDT_TestCase_Steps.cell_actual_result = 10;
			GLDT_TestCase_Steps.cell_Status = 11;
			GLDT_TestCase_Steps.cell_Jira_Id = 12;
			Execution_Result.Dependency_TC_Passed();
			ScreenCapture.main(null);
			Jira_Ticket.CreateJiraTicket();
			Execution_Result.Fill_Fail_Result();
			Execution_Result.Dependency_TC_Failed();
//			softAssert.assertAll();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Execution_Result.Dependency_TC_Passed();
//			System.out.println(e);
			System.out.println("Login passed");
		}   
    }
	public static void main(String[] args) throws Exception {
		BIPS_Login.TAMA_User_Login();
	}	
}
