package pommodule;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignPageModule {
	
	//WebElement Declaration
	
	@FindBy(xpath=("//input[@name='firstname']"))
	WebElement  firstName;	
	
	@FindBy(xpath=("//input[@name='lastname']"))
	WebElement  lastName;	
	
	@FindBy(xpath=("//input[@name='reg_email__']"))
	WebElement  mobNoEmail;
	
	@FindBy(xpath=("//input[@name='reg_passwd__']"))
	WebElement  userPassword;
	
	@FindBy(xpath=("//select[@id='day']"))
	WebElement  birthDate;
	
	@FindBy(xpath=("//select[@id='month']"))
    WebElement  birthMonth;
	
	@FindBy(xpath=("//select[@id='year']"))
    WebElement  birthYear;
	
	@FindBy(xpath=("//input[@value='1']"))
    WebElement  female;
	
	@FindBy(xpath=("//input[@value='2']"))
    WebElement  male;
	
	@FindBy(xpath=("//input[@value='-1']"))
    WebElement  custom;
	
    @FindBy(xpath=("(//button[@type='submit'])[1]"))
    WebElement  signUpButton;
    
  private  WebDriver driver;
  
  private WebDriverWait wait;
  
 // private Actions act;
 // <------------------------------------------------------------------->  
		
    //constructor// for webelement initialization
	public SignPageModule(WebDriver driver) {
			this.driver=driver;
	   PageFactory.initElements(driver, this);
	   wait=new WebDriverWait(driver,Duration.ofMillis(10000));
      //  act=new Actions(driver);
	}
	
// <------------------------------------------------------------------->  

	
	//methods to perform actions on webelement
    public void enterFirstName(String firstname){
  	  wait.until(ExpectedConditions.visibilityOf(firstName));
  	  firstName.sendKeys(firstname);  	  
    }
    
   public void enterLastName(String lastname){
  	  
  	 lastName.sendKeys(lastname);  	  
    } 
   
   public void enterMobNoEmail(String mobnoOrEmail){
  	  
	   mobNoEmail.sendKeys(mobnoOrEmail);  	  
    } 
   
   public void enterPassword(String Password) {
  	 
	   userPassword.sendKeys(Password);
   }

   public void enterBirthdate(int x) {
	   Select s=new Select(birthDate);
	       s.selectByIndex(x);
   }
   
   public void enterBirthMonth(int month) {
	   Select s=new Select(birthMonth);
	       s.selectByIndex(month);
   }
   
   public void enterBirthYear(String year) {
	   Select s=new Select(birthYear);
	       s.selectByVisibleText(year);
   }
   
   public void selectMaleGender() {
	   
	   male.click();
   }
	
   public void selectFemaleGender() {
	   
	   female.click();
   }
   public void selectCustomGender() {
	   
	   custom.click();
   }
   
   public void clickonSignUpButton() {
	   
	   signUpButton.click(); 
	 }
	
	
	
	
	
	
	
	
	

}
