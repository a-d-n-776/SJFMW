package AGLDT;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class BIPS_Login_a {
	

	public static String Case_Id;
	//public static String row = "MONIS";
	private static WebDriver driver = null;
	public static void main(String[] args) throws Exception {



		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://biphrm-biplah-stg1.pegacloud.io/prweb/app/default/c5mb0Z99oLKgPL-hk4L4rty7OLzbbezr*/!STANDARD"
				);

		driver.manage().window().maximize();
		driver.findElement(By.id("txtUserID")).sendKeys("DK_TAMAManager");
		driver.findElement(By.id("txtPassword")).sendKeys(" Rules#137");


		//driver.findElement(By.id("sub")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("sub")).click();
		

		WebElement FrameSRC=driver.findElement(By.xpath("//iframe[@src='about:blank']"));
		driver.switchTo().frame(FrameSRC);
		
		
		Thread.sleep(3000);
		WebElement initiate = driver.findElement(By.xpath("//*[@class=\'header']"));//Copied the xpath and replace with class as the id is changing dynamically
		initiate.click();
		
		//WebElement gldt = driver.findElement(By.xpath("//*[@id=\"RULE_KEY\"]/div/div/div/div/div/div/div[2]/div/div/div/div[2]/span/button/img"));
		WebElement gldt = driver.findElement(By.xpath("//*[@id=\"RULE_KEY\"]/div/div/div/div/div/div/div[1]/div/div/div/div[2]/span/button/img"));
		gldt.click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		
		WebElement aa = driver.findElement(By.xpath("//*[@id=\"414e17ce\"]"));
		
		aa.sendKeys("MONIS");
		aa.sendKeys(Keys.DOWN);
		aa.sendKeys(Keys.ENTER);
		//aa.equals("MONIS");
		//a.click();
		WebElement bb = driver.findElement(By.xpath("//input[@id='158b841d']"));
		bb.sendKeys("Test Reason");
		Thread.sleep(3000);
		bb.sendKeys(Keys.TAB);
		 WebElement checkbox = driver.findElement(By.xpath("//*[@id=\\\"e2457cfb\\\"]"));
		 bb.sendKeys(Keys.TAB);
		 checkbox.click();			
	        System.out.println("Radio Button Option 1 Selected");
		
		
	
		   } 
		
    	

		//driver.close();
		//driver.quit();
		

		

		// calling flush writes everything to the log file
		//extent.flush();
	}

