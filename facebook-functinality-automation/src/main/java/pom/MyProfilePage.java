package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {
	
	
	
	
	@FindBy(xpath=("//span[text()='Log out']"))
	private WebElement logOut;


	//--------WebElement Initialization-------------------------------------

	public MyProfilePage(WebDriver driver){

		PageFactory.initElements(driver, this);

	}
	//----Actions on WebElements	--------------------------------------------

	public void clickOnLogOut(){
		
		logOut.click();	  
	}


}
