package co.edureka.qa.testcases;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import co.edureka.qa.base.TestBase;
import co.edureka.qa.pages.BlogPage;
import co.edureka.qa.pages.HomePage;
import co.edureka.qa.pages.LoginPage;

public class BlogPageTest extends TestBase {

	
	LoginPage loginPage;
	HomePage homePage;
	BlogPage blogPage;
	
	 /*constructor of this class is defined here to inherit the super class- TestBase class*/
	public BlogPageTest() {
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
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	/* Test case to validate the blog page title */
	@Test(priority=1)
	public void verifyBlogPageTitleTest() throws InterruptedException{
		homePage.clickOnCommunityLink();
		Thread.sleep(5000);
		//change focus to new tab - blogs page
		ArrayList tabs = new ArrayList (driver.getWindowHandles());
		System.out.println("Printing the no: of active tabs:"+tabs.size());
		driver.switchTo().window((String) tabs.get(1));
		System.out.println("The title of the current blog page is:"+driver.getTitle());
		String blogPageTitle = driver.getTitle();
		Assert.assertEquals(blogPageTitle, "Edureka - Edurekaam - Discover Learning","Blog page title matched");
		Thread.sleep(1000);
	}
	
	/* Test case to validate the search functionality in the Blog page:
	 * Select a blog of choice: say for ex: selenium blog
	 * Navigate to Interview Questions from the blog:
	 */
	@Test (priority =2)
	public void searchblog() throws InterruptedException {
		homePage.clickOnCommunityLink();
		Thread.sleep(500);
		//change focus to new tab - blogs page
		ArrayList tabs = new ArrayList (driver.getWindowHandles());
		System.out.println("Printing the no: of active tabs:"+tabs.size());
		driver.switchTo().window((String) tabs.get(1));
		BlogPage blogPage = new BlogPage();
		blogPage.searchSeleniumBlog();
		Thread.sleep(1000);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
		driver.quit();
	}
	
}
