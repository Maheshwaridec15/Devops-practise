package co.edureka.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import co.edureka.qa.base.TestBase;

public class BlogPage extends TestBase {
	
	/*Page Factory or object repository for BlogPage on the AUT:*/
	/* ******************************************************* */
	
	@FindBy(id ="search-inp")
	WebElement searchBlog;
	
	@FindBy(xpath ="//*[@id=\"remote\"]/div[1]/span[2]/i[1]")
	WebElement searchIcon;
	
	@FindBy(linkText ="Interview Questions")
	WebElement interviewQuestionLink;
	

	/* Initializing the Page Objects on HomePage:*/
	public BlogPage() {
		PageFactory.initElements(driver, this);
	}
	
	/* Actions to be performed on BlogPage of the AUT */
	/*Method to search for selenium blogs*/
	public void searchSeleniumBlog() throws InterruptedException {
		searchBlog.sendKeys("Selenium");
		//searchBlog.click();
		searchIcon.click();
		Thread.sleep(3000);
		interviewQuestionLink.click();
		
	}
}
