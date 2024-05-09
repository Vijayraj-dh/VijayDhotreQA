package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FriendsRequestPage {

	
	@FindBy(xpath=("//span[text()='All friends']"))
	private WebElement allFriends;

	@FindBy(xpath=("//span[text()='Friend requests']"))
	private WebElement friendRequests;

	@FindBy(xpath=("//span[text()='Birthdays']"))
	private WebElement birthDays;

		

	
	
//	(//span[@class='x1n2onr6'])[1]
	

	
	public FriendsRequestPage(WebDriver driver){

		PageFactory.initElements(driver, this);

	}
	//----Actions on WebElements	--------------------------------------------

	public void viewAllFriends(){
		allFriends.click();	  
	}

	public void viewFriendRequests(){
		friendRequests.click();  	  
	} 

	public void viewBirthDays(){
		birthDays.click();  	  
	} 

	
 
}
