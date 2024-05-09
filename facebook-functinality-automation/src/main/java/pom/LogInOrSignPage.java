package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInOrSignPage {
	//variable-private->WebElement declaration---------------------------
	
	@FindBy(xpath=("//input[@placeholder='Email address or phone number']"))
	 private WebElement userName;
	
	@FindBy(xpath=("//input[@placeholder='Password']"))
	 private WebElement password;
	
	@FindBy(xpath=("//button[@name='login']"))
	 private WebElement loginButton;
	
	@FindBy(xpath=("//a[text()='Sign up for Facebook']"))
	private WebElement createNewAccount;
	
	
	@FindBy(xpath=("//a[text()='Forgotten account?']"))
	private WebElement forgetPassword;
	
	
	
	
	
	//constructor-public->WebElement Initilization------------------
	
      public LogInOrSignPage(WebDriver driver){
    	  
    	  PageFactory.initElements(driver, this);
    	  
      }
      
//------methods-public-performing actions onwebElements-----------------
      public void sendUserName(String userid){
    	  
    	  userName.sendKeys(userid);  	  
      }
      
     public void sendPassword(String userpassword){
    	  
    	 password.sendKeys(userpassword);  	  
      } 
     
     public void clickOnLoginButton(){
    	  
    	 loginButton.click();  	  
      } 
     
     public void createNewAccount() {
    	 
    	 createNewAccount.click();
     }
     public void clickOnForgetPasswordlink() {
    	 
    	 forgetPassword.click();
     }
     
     
     
     
     //or
     public void logIn() {
    	 
   	  userName.sendKeys("9604419850");  	  
 	 password.sendKeys("Vijay@0708");  	  
	 loginButton.click();  	  
	 createNewAccount.click();

     }
      
      
      
      
      
      
      
      
      
      
      
      
}
