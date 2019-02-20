package co.edureka.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class Day1 {

	WebDriver driver;

	
	
	
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver","F:\\SeleniumInstallationFiles\\ExeFiles\\chromedriver.exe");
			driver =new ChromeDriver();
			
			/*//System.setProperty("webdriver.gecko.driver","F:\\SeleniumInstallationFiles\\ExeFiles\\geckodriver.exe");
			//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			//capabilities.setCapability("marionette", true);
			//driver =new FirefoxDriver();
*/			
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("https://www.edureka.co");
			Thread.sleep(1000);
			searchCourse();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}	
	public void searchCourse() {
		try {
		
			driver.findElement(By.id("homeSearchBar")).sendKeys("selenium");
			Thread.sleep(2000);
			
			driver.findElement(By.id("homeSearchBarIcon")).click();
			Thread.sleep(1000);
			driver.navigate().back();
			Thread.sleep(1000);
			
			driver.findElement(By.linkText("Programming & Frameworks")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.cssSelector("a#dropdownMenu1")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.className("icon-Lms_Ver_List")).click();
		    Thread.sleep(1000);
			
			driver.findElement(By.name("user_v1[query]")).sendKeys("Mobile Development");
			Thread.sleep(2000);
			
			driver.navigate().to("https://www.edureka.co");
			Thread.sleep(2000);	
			driver.findElement(By.xpath("/html/body/div[2]/div[7]/div[1]/section/ul/div/div/li[5]/a")).click();
			Thread.sleep(5000);
			
	
			driver.findElement(By.linkText("Log In")).click();
			Thread.sleep(1000);
			
			//driver.findElement(By.partialLinkText("Log")).click();
			//Thread.sleep(1000);
			driver.close();
						
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Day1 myObj = new Day1();
		myObj.invokeBrowser();
	}

}
