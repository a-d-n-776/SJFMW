package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import BIPS.BIPS_Login;

public class BIPS_Login_TC {
	private static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("BIPSLoginTCReport.html");
		
		 // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        
     // creates a toggle for the given test, adds all log events under it    
        ExtentTest test1 = extent.createTest("BIPSLoginTC","this is a test to validate BIPSLoginTC functionality");
	
        String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		test1.log(Status.INFO, "started Testing");
		driver.get("https://biphrm-biplah-stg1.pegacloud.io/prweb/app/default/c5mb0Z99oLKgPL-hk4L4rty7OLzbbezr*/!STANDARD"
);
		
		
		
		driver.manage().window().maximize();
		
		test1.pass("The URL is open.");
		
		driver.findElement(By.id("txtUserID")).sendKeys("DK_TAMAManager");
		test1.pass("User name entered successfully.");
		
		driver.findElement(By.id("txtPassword")).sendKeys(" Rules#137");
		test1.pass("Password entered successfully.");
		
		driver.findElement(By.id("sub")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("sub")).click();
		test1.pass("User successfully logged into the application.");

		

		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		//test1.pass("Pressed keyboard enter key");
		//driver.findElement(By.name("btnK")).click();
		
			
   
		//WebElement FrameSRC=driver.findElement(By.xpath("//iframe[@src='about:blank']"));
        //driver.switchTo().frame(FrameSRC);
        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='about:blank']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"RULE_KEY\"]/span/div/div")));
    
        
        Thread.sleep(3000);
        
		//WebElement initiate = driver.findElement(By.xpath("//*[@class=\'header']"));//Copied the xpath and replace with class as the id is changing dynamically
		//initiate.click();
		//driver.findElement(By.xpath("//*[@class=\'header']")).click();
		driver.findElement(By.xpath("//*[@id=\"headerlabel104\"]/h1")).click();
		
		
		//WebElement gldt = driver.findElement(By.xpath("//*[@id=\"RULE_KEY\"]/div/div/div/div/div/div/div[2]/div/div/div/div[2]/span/button/img"));
		//WebElement gldt = driver.findElement(By.xpath("//*[@id=\"RULE_KEY\"]/div/div/div/div/div/div/div[1]/div/div/div/div[2]/span/button/img"));
		//gldt.click();
		driver.findElement(By.xpath("//*[@id=\"RULE_KEY\"]/div/div/div/div/div/div/div[1]/div/div/div/div[2]/span/button/img")).click();
		
		
		Thread.sleep(3000);
		
		driver.close();
		//driver.quit();
		test1.pass("Closed the browser");
		
		test1.info("Test Completed");
		
		// calling flush writes everything to the log file
        extent.flush();
}
}
