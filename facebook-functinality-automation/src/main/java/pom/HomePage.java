package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//-------------------WebElement Declaration-----------------------------
	@FindBy(xpath=("//div[@aria-label='Menu']"))
	private WebElement menu;
	
	@FindBy(xpath=("//div[@class='x1rg5ohu x1n2onr6 x3ajldb x1ja2u2z']"))
	private WebElement myProfile;
	
	@FindBy(xpath=("//a[@aria-label='Home']"))
	private WebElement homeIcon;
	
	@FindBy(xpath=("//span[text()='Friends']"))
	private WebElement friends;

	@FindBy(xpath=("//span[text()='Marketplace']"))
	private WebElement marketPlace;

	@FindBy(xpath=("//span[text()='Saved']"))
	private WebElement savedPages;

	@FindBy(xpath=("//span[text()='Groups']"))
	private WebElement groups;

	@FindBy(xpath=("//span[text()='See more']"))
	private WebElement moreDropDown;

	@FindBy(xpath=("//span[text()='Feeds']"))
	private WebElement feeds;

	@FindBy(xpath=("//span[text()='Climate Science Centre']"))
	private WebElement climateScienceCentrePage;

	@FindBy(xpath=("//span[text()='Messenger']"))
	private WebElement Messenger;

	@FindBy(xpath=("//span[text()='Messenger Kids']"))
	private WebElement MessengerKids;

	@FindBy(xpath=("//span[text()='Fundraisers']"))
	private WebElement fundRaisers;

	@FindBy(xpath=("//span[text()='Facebook Pay']"))
	private WebElement facbookPay;

	@FindBy(xpath=("//span[text()='Gaming video']"))
	private WebElement gamingVideos;

	@FindBy(xpath=("//span[text()='Play games']"))
	private WebElement playGames;

	@FindBy(xpath=("//span[text()='Pages']"))
	private WebElement allPages;

	@FindBy(xpath=("//span[text()='Recent ad activity']"))
	private WebElement recentAdActivity;

	@FindBy(xpath=("//span[text()='Events']"))
	private WebElement events;

	@FindBy(xpath=("//span[text()='Ads Manager']"))
	private WebElement AddsManagerPage;
	
	@FindBy(xpath=("//span[text()='All friends']"))
	private WebElement viewAllFriends;
	

	


	//--------WebElement Initialization-------------------------------------

	public HomePage(WebDriver driver){

		PageFactory.initElements(driver, this);

	}
	//----Actions on WebElements	--------------------------------------------

	
	
	public void clickOnHomeIcon(){
		homeIcon.click();  	  
	} 
	
	
	
	public void clickOnMenuIcon(){
		
		menu.click();	  
	}

	public void viewMarketPlace(){
		marketPlace.click();  	  
	} 

	public void viewSavedPages(){
		savedPages.click();  	  
	} 

	public void viewGroups() {
		groups.click();
	}
	
	public void clickOnMoreIcon(){
		moreDropDown.click();	    
	}
	public void viewFeeds(){
		feeds.click();  	  
	} 

	public void viewClimateScienceCentrePage(){
		climateScienceCentrePage.click();  	  
	} 

	public void openMessenger() {
		Messenger.click();
	}
	public void openMessengerKids(){
		MessengerKids.click();	  
	}

	public void openFundRaisersPage(){
		fundRaisers.click();  	  
	} 

	public void openFacbookPay(){
		facbookPay.click();  	  
	} 

	public void openGamingVideos() {
		gamingVideos.click();
	}
	public void openPlayGames(){
		playGames.click();	  
	}

	public void viewAllPages(){
		allPages.click();  	  
	} 

	public void viewRecentAdActivity(){
		recentAdActivity.click();  	  
	} 

	public void viewEvents() {
		events.click();
	}

	public void viewAddsManagerPage() {
		AddsManagerPage.click();
	}
	
	public void clickonFriends() {
		friends.click();
	}
	
	
	public void clickOnMyProfile() {

	myProfile.click();
	}
	public void clickTOviewAllFriends() {

		viewAllFriends.click();
		}
	public void homePage() {
		//menu.click();	  
		marketPlace.click();  	  
		savedPages.click();  	  
		groups.click();
		moreDropDown.click();	    
		feeds.click();  	  
		climateScienceCentrePage.click();  	  
		Messenger.click();
		MessengerKids.click();	  
		fundRaisers.click();  	  
		facbookPay.click();  	  
		gamingVideos.click();
		playGames.click();	  
		allPages.click();  	  
		recentAdActivity.click();  	  
		events.click();
		AddsManagerPage.click();

		
	}
}
