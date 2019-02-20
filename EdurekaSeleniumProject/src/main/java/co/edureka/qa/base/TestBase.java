package co.edureka.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	/*driver and prop are declared as global variables here, so that they can be used anywhere in this project*/
	public static WebDriver driver;
	public static Properties prop;
	
	/*TestBase class constructor is defined here to  read the global configuration properties*/
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("F:\\maheshjava\\EdurekaSeleniumProject\\src\\main\\java\\co\\edureka\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*A method to invoke the respective browser properties*/
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "F:\\\\SeleniumInstallationFiles\\\\ExeFiles\\\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "F:\\\\SeleniumInstallationFiles\\\\ExeFiles\\\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
	
	/*Page synchronization of the AUT is taken care here*/
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	}
	
	/* Handling on Alerts and pop ups*/
	public static void handleAlerts() {
	Alert sAlert = driver.switchTo().alert();
	System.out.println("The alert message is:" +sAlert.getText());
	sAlert.dismiss();
	}
	
}

