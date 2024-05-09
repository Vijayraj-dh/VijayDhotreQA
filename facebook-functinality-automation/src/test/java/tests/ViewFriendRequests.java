package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pom.FriendsRequestPage;
import pom.HomePage;
import pom.LogInOrSignPage;

public class ViewFriendRequests {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions chrome=new ChromeOptions();
		chrome.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(chrome);
		driver.manage().window().maximize();
        driver.get("https://www.facebook.com/login/");
      
        
        LogInOrSignPage logInOrSignPage=  new LogInOrSignPage(driver);
        logInOrSignPage.sendUserName("9604419850");
        logInOrSignPage.sendPassword("Vijay@0708");
        logInOrSignPage.clickOnLoginButton();
        
        HomePage homepage=new HomePage(driver);
        homepage.clickonFriends();
        
        Thread.sleep(5000);
        
        FriendsRequestPage friendsRequestPage=new FriendsRequestPage(driver);
        friendsRequestPage.viewFriendRequests();
        friendsRequestPage.viewAllFriends();
	}
}
