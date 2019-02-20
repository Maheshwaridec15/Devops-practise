package co.edureka.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import co.edureka.qa.base.TestBase;

public class MyProfilePage extends TestBase {
	
	/*Page Factory or object repository for MyProfile Page on the AUT:*/
	/* ******************************************************* */
	
	@FindBy(xpath = "//*[@id=\"personal_details\"]/i")
	WebElement editPersonalDetails;
	
	@FindBy(name = "fullname")
	WebElement myProfileName;
	
	@FindBy(xpath="//button[contains(text(),'Continue')]")
	WebElement continueBtn;
	
	
	/* Initializing the Page Objects of MyProfile Page:*/
	public MyProfilePage() {
		PageFactory.initElements(driver, this);
	}

	
	/* Actions to be performed on MyProfile Page of the AUT */
	
	
	/*Method to update /validate personal details of the user on the AUT*/
	public void personalDetails() throws InterruptedException {
		editPersonalDetails.click();
		Thread.sleep(2000);
		myProfileName.clear();
		Thread.sleep(2000);
		myProfileName.sendKeys("Maheshwari");
		continueBtn.click();
		Thread.sleep(3000);
		
	}
	
}
