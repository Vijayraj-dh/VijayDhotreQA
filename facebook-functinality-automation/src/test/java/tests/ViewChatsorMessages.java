package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pom.HomePage;
import pom.LogInOrSignPage;

public class ViewChatsorMessages {
	public static void main(String[] args) {
		ChromeOptions chrome=new ChromeOptions();
		chrome.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(chrome);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
        driver.get("https://www.facebook.com/login/");
      
        
        LogInOrSignPage logInOrSignPage=  new LogInOrSignPage(driver);
        logInOrSignPage.sendUserName("9604419850");
        logInOrSignPage.sendPassword("Vijay@0708");
        logInOrSignPage.clickOnLoginButton();
        
        HomePage homepage=new HomePage(driver);
        homepage.clickOnMoreIcon();
        homepage.openMessenger();
       
		
		
		
	}

}
