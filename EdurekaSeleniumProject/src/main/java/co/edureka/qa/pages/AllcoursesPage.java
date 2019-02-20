package co.edureka.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import co.edureka.qa.base.TestBase;

public class AllcoursesPage extends TestBase {
	
	/*Page Factory or object repository for Course Page on the AUT:*/
	/* ******************************************************* */
	@FindBy(id ="d_wishlist-icon-224")
	WebElement wishIcon;
	
	@FindBy(xpath ="//*[@id=\"add-training-courses\"]/a/div[1]/div[2]/div[2]/div[3]/span[2]")
	WebElement viewDetailsbutton;
	
	/* Initializing the Page Objects on  course Page:*/
	public AllcoursesPage() {
		PageFactory.initElements(driver, this);
	}
	
	/* Actions to be performed on the courses Page of the AUT */
	
	
	/*Method to add a course to wishlist */
	public void addToWishlist() throws InterruptedException {
		wishIcon.click();
		Thread.sleep(3000);
		viewDetailsbutton.click();
	}
}
