package GLDT_Other_Methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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

import BIPS.BIPS_Login;
import GLDT_Methods.GLDT_TestCase_Steps;

public class Jira_Ticket {
	//Method to create a Jira ticket and update the Jira_Id in excel sheet
	public static void CreateJiraTicket() throws Exception {
//		System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");
//		driver = new EdgeDriver();
		String userid = null;
	    String password = null;
		WebDriver driver = BIPS_Login.driver;
		//System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\cnbna\\git\\SJFMW\\SeleniumFrameWork\\drivers\\chromedriver\\chromedriver.exe");
//		driver = new ChromeDriver();
		String baseUrl = "https://id.atlassian.com/login?continue=https%3A%2F%2F1abc12345.atlassian.net%2Flogin%3FredirectCount%3D1%26dest-url%3D%252Fjira%252Fsoftware%252Fc%252Fprojects%252FP1%252Fissues%26application%3Djira&application=jira";
		driver.get(baseUrl);
		driver.manage().window().maximize(); //Maximise browser window
		try { 
           // FileInputStream fStream = new FileInputStream(new File(
                   // "C:\\Users\\DC0121\\eclipse-workspace\\BIPS\\GLDT-TestCases-for-Automation.xlsx"));
            
            FileInputStream fStream = new FileInputStream(new File(
            		"G:\\My Drive\\app\\GLDT-TestCases-for-Automation.xlsx"));
            
            //Enter the path to your excel here

            // Create workbook instance referencing the file created above
            XSSFWorkbook workbook = new XSSFWorkbook(fStream);

            // Get your first or desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0); // getting first sheet

            XSSFRow row1 = sheet.getRow(3);
            XSSFCell cell1 = row1.getCell(2);
            XSSFRow row2 = sheet.getRow(4);
            XSSFCell cell2 = row2.getCell(2);

            userid = cell1.toString();
            password = cell2.toString();

            fStream.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='username']")));
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys(userid);
		driver.findElement(By.xpath("//*[@id=\'login-submit\']/span/span")).click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.name("password")));
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("login-submit")).click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\'createGlobalItem\']/span")));
		String ParentWindow = driver.getWindowHandle(); //switching from parent to pop up window
		driver.findElement(By.xpath("//*[@id=\'createGlobalItem\']/span")).click();
		for (String Child_Window : driver.getWindowHandles()) { 
		driver.switchTo().window(Child_Window);
		WebDriverWait wait = new WebDriverWait(driver, 30);// Wait 30 seconds
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Create issue')]")));
		driver.findElement(By.xpath("//input[@id='summary-field']")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
		Thread.sleep(5000);
		WebElement summary = driver.findElement(By.xpath("//input[@id='summary-field']"));
		summary.sendKeys(GLDT_TestCase_Steps.summary);
		WebDriverWait wait1 = new WebDriverWait(driver, 20);// Wait 20 seconds
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebDriverWait wait2 = new WebDriverWait(driver, 20);// Wait 20 seconds
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'View issue')]")));
		driver.findElement(By.xpath("//span[contains(text(),'View issue')]")).click();
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"jira-issue-header\"]/div/div/div/nav/ol/div[2]/li/a/span")));
		WebElement Jira_Text = driver.findElement(By.xpath("//*[@id=\"jira-issue-header\"]/div/div/div/nav/ol/div[2]/li/a/span"));
		String Jira_Id = Jira_Text.getText();
		System.out.println(Jira_Id);
		
		//File xlsxFile = new File("C:\\Users\\DC0121\\eclipse-workspace\\BIPS\\GLDT-TestCases-for-Automation.xlsx");
		File xlsxFile = new File("G:\\My Drive\\app\\GLDT-TestCases-for-Automation.xlsx");
		
        try {
            //Creating input stream
            FileInputStream inputStream = new FileInputStream(xlsxFile);
             
            //Creating workbook from input stream
            Workbook workbook = WorkbookFactory.create(inputStream);
 
            //Reading first sheet of excel file
            Sheet sheet = workbook.getSheetAt(1);
             
            sheet.getRow(GLDT_TestCase_Steps.row).getCell(GLDT_TestCase_Steps.cell_Jira_Id).setCellValue(Jira_Id);
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
//		driver.findElement(By.xpath("//button[contains(text(),'EM')]"));
		}
			driver.manage().deleteAllCookies();
				try {
				  Thread.sleep(15000); //wait 15 seconds to clear cookies.
				} catch (InterruptedException e) {
				  e.printStackTrace();
				}
				driver.quit();
	}
}
