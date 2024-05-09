package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
	

	@FindBy(xpath=("//input[@placeholder='Email address or mobile number']"))
	private WebElement enterEmailorMobNo;

	@FindBy(xpath=("//button[@id='did_submit']"))
	private WebElement searchButton;
	
	@FindBy(xpath=("//a[text()='Cancel']"))
	private WebElement cancelButton;


	//--------WebElement Initialization-------------------------------------

	public ForgotPasswordPage(WebDriver driver){

		PageFactory.initElements(driver, this);

	}
	//----Actions on WebElements	--------------------------------------------

	public void sendDataToEmailOrMobNoField(String userid){
		
		enterEmailorMobNo.sendKeys(userid);	  
	}

	public void clickOnSearchButton(){
		searchButton.click();  	  
	} 

	public void clickOnCancelButton(){
		cancelButton.click();  	  
	}

}
