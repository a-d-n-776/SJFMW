

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilities_Demo {

	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("ignoreProtectedModeSettings", true);
		
		//System.setProperty("webdriver.ie.driver", projectPath+"/drivers/iedriver/IEDriverServer.exe");
		//WebDriver driver = new InternetExplorerDriver(caps);
		
		System.setProperty("webdriver.edge.driver", projectPath+"\\drivers\\edgedriver\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("ABCD");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		//driver.findElement(By.id("btnK")).click();
		
		
			//Thread.sleep(7000);
		
		//driver.close();
		//driver.quit();
		

	}

}