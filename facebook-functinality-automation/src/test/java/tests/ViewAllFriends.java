package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import pom.HomePage;
import pom.LogInOrSignPage;
import pom.MyProfilePage;

public class ViewAllFriends {
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
        
        String actual=driver.getCurrentUrl();
        
        HomePage homepage=new HomePage(driver);
        homepage.clickonFriends();
        homepage.clickTOviewAllFriends();
        homepage.clickOnHomeIcon();
        homepage.clickOnMyProfile();
        
        
        
         String expected=driver.getCurrentUrl();
         
        Assert.assertEquals(actual, expected);
        
        
        MyProfilePage myProfilePage=new MyProfilePage(driver);
        myProfilePage.clickOnLogOut();
		
	}
}
