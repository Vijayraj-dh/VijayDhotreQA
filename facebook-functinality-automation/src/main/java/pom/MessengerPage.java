package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessengerPage {

	@FindBy(xpath=("//div[@aria-label='Message']"))
	private WebElement chatBox;


	@FindBy(xpath=("//div[@aria-label='Press Enter to send']"))
	private WebElement sendButton;



	//--------WebElement Initialization-------------------------------------

	public MessengerPage(WebDriver driver){

		PageFactory.initElements(driver, this);

	}
	//----Actions on WebElements	--------------------------------------------

	public void sendDataIntoChatBox(String message){

		chatBox.sendKeys(message);	  
	}
	public void clickOnSendButton(){

		sendButton.click();
	}





}
