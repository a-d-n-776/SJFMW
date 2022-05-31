package AGLDT;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import GLDT_Other_Methods.Execution_Result;




public class GLDT_TC_4 {



	private static WebDriver driver = null;
	public static void main(String[] args) throws Exception {


		//Select Temporary products check box.Initiate GLDT case and Complete RA process.
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://biphrm-biplah-stg1.pegacloud.io/prweb/app/default/c5mb0Z99oLKgPL-hk4L4rty7OLzbbezr*/!STANDARD"
				);
		driver.manage().window().maximize();
		driver.findElement(By.id("txtUserID")).sendKeys("DK_TAMAManager");
		driver.findElement(By.id("txtPassword")).sendKeys(" Rules#138");
		//driver.findElement(By.id("sub")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("sub")).click();

		
		
		
		driver.switchTo().frame(0);
		
		String CaseID = "GLDT-3628";
		driver.findElement(By.linkText(CaseID)).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);

		WebElement reason = driver.findElement(By.xpath("//*[@id=\"158b841d\"]"));
    	reason.clear();
    	Thread.sleep(10000);
    	reason.sendKeys("Test Reason");
    	Thread.sleep(10000);
		
		
		WebElement region = driver.findElement(By.xpath("//button[contains(text(),'EM')]"));
		region.click();

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement ropu = driver.findElement(By.xpath("//button[text()='ROPU IMETA']"));
		ropu.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		//Nigeria
		WebElement countryN = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='PEGA_HARNESS']/form[1]/div[3]/div[1]/section[1]/div[1]/span[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[7]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[19]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]/i[1]/img[1]")));
		countryN.click();
		Thread.sleep(5000);
		//India
		WebElement country = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='PEGA_HARNESS']/form[1]/div[3]/div[1]/section[1]/div[1]/span[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[7]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]/i[1]/img[1]")));
		country.click();
		
		Thread.sleep(5000);
		
		
		WebElement comment = driver.findElement(By.xpath("//*[@id=\"5e1978c7\"]"));
		comment.click();
		comment.sendKeys("Testing");
		
		
		Thread.sleep(5000);
		//WebElement close = driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
		//close.click();

		WebElement InitiateRAProcess = driver.findElement(By.xpath("//*[@id=\"RULE_KEY\"]/div[2]/div[3]/span/button"));
    	InitiateRAProcess.click();
    	Thread.sleep(3000);
    	
    	//WebElement continue1 = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
    	//continue1.click();

		driver.manage().deleteAllCookies();

		Thread.sleep(15000);//wait 15 seconds to clear cookies.

		driver.quit();







	} 



	//driver.close();
	//driver.quit();




	// calling flush writes everything to the log file
	//extent.flush();
}