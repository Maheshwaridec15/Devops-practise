package co.edureka.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import co.edureka.qa.base.TestBase;

public class HomePage extends TestBase {
	
	/*Page Factory or object repository for HomePage on the AUT:*/
	/* ******************************************************* */
	
	@FindBy(xpath = "//*[@id=\"header-II\"]/section/nav/div/ul[2]/li[1]/a/span")
	WebElement userNameLabel;
	
	@FindBy(linkText = "My Profile")
	WebElement myProfile;

	@FindBy(linkText ="Courses")
	WebElement coursesLink;
	
	@FindBy(id ="dropdownMenu3")
	WebElement courses;
	
	@FindBy(linkText ="My Classroom")
	WebElement myenrolledCourses;
	
	@FindBy(linkText ="All Courses")
	WebElement allCourses;
	
	@FindBy(name ="user_v1[query]")
	WebElement searchCourse;
	
	@FindBy(xpath ="//*[@id=\"remote\"]/span[2]")
	WebElement searchbutton;
	
	@FindBy(id ="dropdownMenu4")
	WebElement communityLink;
	
	@FindBy(linkText ="Blog")
	WebElement blogLink;
	
	@FindBy(linkText ="Log Out")
	WebElement logoutLink;

	/* Initializing the Page Objects on HomePage:*/
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	/* Actions to be performed on Home Page of the AUT */
	/*************************************************** */
	
	/*Method to validate the HOME page title of the AUT*/
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	/*Method to validate the signed in User of the AUT*/
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	/*Method to update the user Profile in the AUT */
	public MyProfilePage myProfileUpdate() {
		userNameLabel.click();
		myProfile.click();
		return new MyProfilePage();
	}
	
	/*Method to view All courses from Home page of AUT */
	public AllcoursesPage viewAllCourses() throws InterruptedException {
		courses.click();
		allCourses.click();
		Thread.sleep(5000);
		return new AllcoursesPage();
	}
	
	/*Method to search a particular course in Edureka portal: */
	public void searchCourse() throws InterruptedException {
		searchCourse.sendKeys("Cucumber");
		Thread.sleep(1000);
		searchbutton.click();
		Thread.sleep(3000);
	}
	
	/*Method to verify the user enrolled courses from the Home Page of AUT */
	public myCoursesPage clickOnCoursesLink() throws InterruptedException {
		coursesLink.click();
		myenrolledCourses.click();
		Thread.sleep(2000);
		return new myCoursesPage();
	}
	
	/* Method to verify the blogs in edureka */
	public BlogPage clickOnCommunityLink() throws InterruptedException {
		communityLink.click();
		Thread.sleep(500);
		blogLink.click();
		//Thread.sleep(2000);
		return new BlogPage();
	}
	
	/*Method to validate log out feature of the AUT */
	public void logout() throws InterruptedException {
		userNameLabel.click();
		logoutLink.click();
		Thread.sleep(1000);
	}
	
	
}
