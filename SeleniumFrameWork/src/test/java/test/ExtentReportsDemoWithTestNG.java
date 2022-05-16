package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemoWithTestNG {
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver;

	@BeforeSuite
	public void setup() {

		// start reporters
		 htmlReporter = new ExtentSparkReporter("extent.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}


	@Test
	public void test1() {
		// creates a toggle for the given test, adds all log events under it    
        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
        
     // log(Status, details)
        test.log(Status.INFO, "This step shows usage of log(status, details)");

        // info(details)
        test.info("This step shows usage of info(details)");
        
        // log with snapshot
        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");
		
	}
	
	@Test
	public void test2() {
		  
        ExtentTest test = extent.createTest("My2ndTest", "Sample description");
        test.log(Status.INFO, "This step shows usage of log(status, details)");
        test.info("This step shows usage of info(details)");
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        test.addScreenCaptureFromPath("screenshot.png");
        
	}
	
	//@Test
	public void test3() {
		  
        ExtentTest test = extent.createTest("Google Search Test", "Sample description");
        test.log(Status.INFO, "This step shows usage of log(status, details)");
        driver.get("https://google.com");
        test.pass("This step shows Navigated to google.com");
		driver.findElement(By.name("q")).sendKeys("Automationaerhgjjkkk");
		test.pass("This step shows Enterd text in Searchbox");
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		//driver.findElement(By.name("btnK")).click();
		//test.info("This step shows Pressed keyboard enter key");
		driver.close();
		test.pass("This step shows Closed the browser");
		//driver.quit();
		test.addScreenCaptureFromPath("screenshot.png");
		test.info("This step shows Test Completed");
		
        
	}
	
	@Test
	public void test4() {
		  
        ExtentTest test = extent.createTest("BIPSLoginTC","this is a test to validate BIPSLoginTC functionality");
        //test.log(Status.INFO, "This step shows usage of log(status, details)");
        test.log(Status.INFO, "This step shows the Test started)");
        
        driver.get("https://biphrm-biplah-stg1.pegacloud.io/prweb/app/default/c5mb0Z99oLKgPL-hk4L4rty7OLzbbezr*/!STANDARD");
        test.pass("This step shows The URL is open");
		
        
		driver.findElement(By.id("txtUserID")).sendKeys("DK_TAMAManager");
		test.pass("This step shows The User name entered successfully.");
		
		driver.findElement(By.id("txtPassword")).sendKeys(" Rules#137");
		test.pass("This step shows The Password entered successfully.");
		
		driver.findElement(By.id("sub")).sendKeys(Keys.RETURN);
		//driver.findElement(By.id("sub")).click();
		test.pass("This step shows The User successfully logged into the application.");
		
		driver.close();
		test.pass("This step shows Closed the browser");
		//driver.quit();
		//test.addScreenCaptureFromPath("screenshot.png");
		test.info("This step shows Test Completed");
		
        
	}
	
	
	
	
	
	
	
	
	

	@AfterSuite
	public void tearDown() {
		// calling flush writes everything to the log file
        extent.flush();
	}
}
