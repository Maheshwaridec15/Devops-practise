package co.edureka.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import co.edureka.qa.base.TestBase;
import co.edureka.qa.pages.AllcoursesPage;
import co.edureka.qa.pages.HomePage;
import co.edureka.qa.pages.LoginPage;
import co.edureka.qa.pages.MyProfilePage;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	MyProfilePage myprofile;
	
	 /*constructor of this class is defined here to inherit the super class- TestBase class*/
	public HomePageTest() {
		super();
	}
	
/*
	//test cases are separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	*/
	
	
	/* Functional Test Cases
	 * Author: Maheshwari Thiyagarajan
	 * Dated: 26/01/2019
	 */
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		loginPage.loginClickIcon();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	/* Test case to validate the home page title */
	@Test(priority=0)
	public void verifyHomePageTitleTest() throws InterruptedException{
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Instructor-Led Online Training with 24X7 Lifetime Support | Edureka","Home page title matched");
	}
	
	/* Test case to validate the signed -in user */
	@Test(priority=1)
	public void verifyUserNameTest(){
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
		
	/* Test case to view all the available courses in Edureka and add one to wishlist */
	@Test(priority = 2)
	//@Test(retryAnalyzer = Analyzer.RetryAnalyzer.class )
	public void viewAllCoursesAvailable() throws InterruptedException {
		homePage.viewAllCourses();
		homePage.searchCourse();
		AllcoursesPage allcoursepage = new AllcoursesPage();
		allcoursepage.addToWishlist();
		Thread.sleep(800);
	}
	
	/* Test case to validate the courses enrolled by the signed-in user */
	@Test(priority =3)
	public void verifyMyEnrolledCourses() throws InterruptedException {
		Thread.sleep(4000);
		homePage.clickOnCoursesLink();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	
	}
	
	/*Test case to validate the user profile updations */
	@Test(priority =4)
	public void myProfileUpdate() throws InterruptedException {
		homePage.myProfileUpdate();
		MyProfilePage myprofile = new MyProfilePage();
		myprofile.personalDetails();
	}
	
	/* Test case to validate log out functionality */
	@Test(priority =5)
	public void logout() throws InterruptedException {
		homePage.logout();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
