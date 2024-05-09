package testNgClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Base;
import pom.ForgotPasswordPage;
import pom.FriendsRequestPage;
import pom.HomePage;
import pom.LogInOrSignPage;
import pom.MyProfilePage;

public class verifyForgotPasswordFunctonality extends Base {
	
	private	WebDriver driver;
	private LogInOrSignPage logInOrSignPage;
	private HomePage  homePage	;
	private FriendsRequestPage friendRequestsPage;
	private MyProfilePage myProfilePage;
	private ForgotPasswordPage forgotPasswordPage;
	
	
	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		
		if(browserName.equals("chrome")) {			
			driver=new ChromeDriver();
		}
		if(browserName.equals("edge")) {			
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();

	}
	
	
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass");
		logInOrSignPage=new LogInOrSignPage(driver);
		homePage=new HomePage(driver);
		friendRequestsPage=new FriendsRequestPage(driver);
		myProfilePage=new MyProfilePage(driver);
		forgotPasswordPage=new ForgotPasswordPage(driver);

	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

	}
	@BeforeMethod
	public void launchForgotPasswordpage() {
		System.out.println("beforeMethod");
        driver.get("https://www.facebook.com/login/");
      //  HomePage  homepage=new HomePage(driver);
       logInOrSignPage=new LogInOrSignPage(driver);
       logInOrSignPage.sendUserName("9604419850");
       logInOrSignPage.sendPassword("Vijay@0708");
       logInOrSignPage.clickOnForgetPasswordlink();

	}
	@Test(priority=1)
	public void verifyPasswordShouldBeChangedSucccessfully() {
   System.out.println("test1");
   forgotPasswordPage.sendDataToEmailOrMobNoField("vijaydhotre10@gmail.com");
   forgotPasswordPage.clickOnSearchButton();
   
	}
	@Test(priority=2)
	public void verifyErrorMessageWhenForgotFunctionalityIsUsed() {
		System.out.println("test2");
		forgotPasswordPage=new ForgotPasswordPage(driver);
		forgotPasswordPage.sendDataToEmailOrMobNoField("vij");
		forgotPasswordPage.clickOnCancelButton();
			}
	
	@AfterMethod
        public void takeScreenshotOfFailedTestCases() {
		System.out.println("aftermethod");
		System.out.println("take screenshot of failed testcases");
	}
	@AfterClass
    public void closeBrowser() {
	System.out.println("afterClass");
	logInOrSignPage=null;
	homePage=null;
	friendRequestsPage=null;
	myProfilePage=null;
	
}

	@AfterTest
	public void afterTest() {
		System.out.println("aftertest");
		driver.quit();
		driver=null;
		System.gc();
	}

	

}
