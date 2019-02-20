package co.edureka.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import co.edureka.qa.base.TestBase;

public class LoginPage extends TestBase {

	/*Page Factory (object repository) of the LoginPage*/
	/* ************************************ */
	
		@FindBy(linkText = "Log In")
		WebElement loginIcon;
		
		@FindBy(id ="si_popup_email")
		WebElement username;
		
		@FindBy(id ="si_popup_passwd")
		WebElement password;
		
		@FindBy(xpath="//button[contains(text(),'Login')]")
		WebElement loginBtn;
		
		@FindBy(xpath="//*[@id=\"new_sign_up_mode\"]/div/div/div[2]/div[3]/p/span")
		WebElement signUpBtn;
		
		/*Initializing the Page Objects by defining a constructor for this class:*/
		
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
	
/*Actions to be performed on LoginPage*/
/* ************************************ */
		
		/*Method to validate the LOGIN page title of the AUT*/
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		/*Method to click on the loginPage Login Icon:*/
		public void loginClickIcon() {
			loginIcon.click();
		}
		
		/*Method to login to AUT*/
		public HomePage login(String un, String pwd) throws InterruptedException{
			username.clear();
			Thread.sleep(1000);
			username.sendKeys(un);
			Thread.sleep(1000);
			password.sendKeys(pwd);
			loginBtn.click();
			return new HomePage();
		}
}
