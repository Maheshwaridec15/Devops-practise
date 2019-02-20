package co.edureka.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import org.apache.log4j.BasicConfigurator;

import co.edureka.qa.base.TestBase;
import co.edureka.qa.pages.HomePage;
import co.edureka.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	/*Global Declarations*/
	LoginPage loginPage;
	HomePage homePage;
	
	/*constructor of this class is defined here to inherit the super class- TestBase class*/
	public LoginPageTest(){
		super();
	}
	
	
	/* Functional Test Cases
	 * Author: Maheshwari Thiyagarajan
	 * Dated: 26/01/2019
	 */
	

	Logger log = Logger.getLogger(LoginPageTest.class);
	
	/*Method to invoke the browser properties*/
	@BeforeMethod
	public void setUp(){
		log.info("****************************** Starting test cases execution  *****************************************");
		initialization();
		loginPage = new LoginPage();	
	}
	
	/*Test case to validate the login page title:*/
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Instructor-Led Online Training with 24X7 Lifetime Support | Edureka");
	}
	
	/*Test case to validate the login user:*/
	@Test(priority=2)
	public void loginIconTest(){
		loginPage.loginClickIcon();
	}
	
	/*Test case to validate the login functionality*/
	@Test(priority=3)
	public void loginTest() throws InterruptedException{
		loginPage.loginClickIcon();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	/*Method to close the respective browser*/
	@AfterMethod
	public void tearDown(){
		driver.quit();
		log.info("****************************** Browser is closed *****************************************");
	}
}
