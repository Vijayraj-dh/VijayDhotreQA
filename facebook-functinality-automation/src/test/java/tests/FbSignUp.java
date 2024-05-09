package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pom.LogInOrSignPage;
import pommodule.SignPageModule;

public class FbSignUp {
public static void main(String[] args) {
	ChromeOptions chrome=new ChromeOptions();
	chrome.addArguments("--disable-notifications");
	WebDriver driver=new ChromeDriver(chrome);
	driver.manage().window().maximize();
    driver.get("https://www.facebook.com/login/");
    
    LogInOrSignPage logInOrSignPage=  new LogInOrSignPage(driver);
    logInOrSignPage.createNewAccount();

    
    SignPageModule signPageModule= new SignPageModule(driver);
    signPageModule.enterFirstName("vijay");
    signPageModule.enterLastName("Dhotre");
    signPageModule.enterMobNoEmail("9604419850");
    signPageModule.enterPassword("4888777");
    signPageModule.enterBirthdate(9);
    signPageModule.enterBirthMonth(5);
    signPageModule.enterBirthYear("1996");
    signPageModule.selectMaleGender();
    signPageModule.clickonSignUpButton();
}
}
