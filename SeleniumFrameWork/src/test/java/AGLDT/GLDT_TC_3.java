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




public class GLDT_TC_3 {



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

		//String Product = "MONIS";
		WebElement selectproduct = driver.findElement(By.xpath("//input[@id='414e17ce']"));
		selectproduct.clear();
		//selectproduct.sendKeys(Product);
		selectproduct.sendKeys("MONIS");
		selectproduct.sendKeys(Keys.DOWN);
		selectproduct.sendKeys(Keys.RETURN);

		String Reason = "Test Reason";
		WebElement reason = driver.findElement(By.xpath("//*[@id=\"158b841d\"]"));
		reason.clear();
		reason.sendKeys(Reason);
		
		//for check mark//
		WebElement Productisundefined = driver.findElement(By.xpath("//label[@for='e2457cfb']"));
		Productisundefined.click();
		
		Thread.sleep(5000);
		


		WebElement TemporaryProductName = driver.findElement(By.xpath("//input[@id='7515729c']"));
		TemporaryProductName.click();
		
		Thread.sleep(5000);
		
		WebElement Search = driver.findElement(By.xpath("//input[@id='anypicker-input']"));
		Search.sendKeys("Temp_Proj_1");
		Search.sendKeys(Keys.DOWN);
		Search.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
	
		
		
		WebElement region = driver.findElement(By.xpath("//button[contains(text(),'EM')]"));
		region.click();

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement ropu = driver.findElement(By.xpath("//button[text()='ROPU IMETA']"));
		ropu.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		//Nigeria
		WebElement country = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='PEGA_HARNESS']/form[1]/div[3]/div[1]/section[1]/div[1]/span[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[7]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[19]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]/i[1]/img[1]")));
		//India
		//WebElement country = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='PEGA_HARNESS']/form[1]/div[3]/div[1]/section[1]/div[1]/span[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[7]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]/i[1]/img[1]")));
		country.click();
		
		//WebElement close = driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
		//close.click();

		WebElement InitiateRAProcess = driver.findElement(By.xpath("//*[@id=\"RULE_KEY\"]/div[2]/div[3]/span/button"));
    	InitiateRAProcess.click();
    	Thread.sleep(3000);
    	WebElement continue1 = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
    	continue1.click();

		driver.manage().deleteAllCookies();

		Thread.sleep(15000);//wait 15 seconds to clear cookies.

		driver.quit();







	} 



	//driver.close();
	//driver.quit();




	// calling flush writes everything to the log file
	//extent.flush();
}

