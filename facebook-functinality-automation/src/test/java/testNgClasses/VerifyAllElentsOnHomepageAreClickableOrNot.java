package testNgClasses;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Base;
import pom.FriendsRequestPage;
import pom.HomePage;
import pom.LogInOrSignPage;
import pom.MyProfilePage;
import util.Utility;

public class VerifyAllElentsOnHomepageAreClickableOrNot extends Base {

	private	WebDriver driver;
	private LogInOrSignPage logInOrSignPage;
	private HomePage  homePage	;
	private FriendsRequestPage friendRequestsPage;
	private MyProfilePage myProfilePage;
	
	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {

		if(browserName.equals("chrome")) {
			ChromeOptions chrome=new ChromeOptions();
			chrome.addArguments("--disable-notifications");

			
			driver=new ChromeDriver(chrome);
		} 
		if(browserName.equals("edge")) {			
			EdgeOptions edge=new EdgeOptions();
			edge.addArguments("--disable-notifications");
			driver=new EdgeDriver(edge);
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


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));


	}
	@BeforeMethod 
	public void beforeMehtod() throws EncryptedDocumentException, IOException {
		driver.get("https://www.facebook.com/login/");
		logInOrSignPage.sendUserName(Utility.GetDataFromExcelSheet("Sheet1", 1, 0));
		logInOrSignPage.sendPassword(Utility.GetDataFromExcelSheet("Sheet1", 1, 1));
		logInOrSignPage.clickOnLoginButton();


	}
	@Test
	public void test1() {
		System.out.println("test1");
		homePage.clickonFriends();

		friendRequestsPage.viewAllFriends();
		homePage.clickOnHomeIcon();
		homePage.openMessenger();
		homePage.clickOnHomeIcon();
		String Expected="https://www.facebook.com/";
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual, Expected);
	}

	@Test
	public void test2() {
		System.out.println("test2");
		homePage.openMessenger();
	}

	@AfterMethod
	public void afterMehtod(ITestResult result) throws IOException {
		
		if(ITestResult.FAILURE==result.getStatus()) {
			Utility.takeScreenshotMethod(driver, "1234");
		}
		
		homePage.clickOnMyProfile();
		myProfilePage.clickOnLogOut();
	}

	@AfterClass
	public void afterClass() {
		System.out.println("afterClass");
		logInOrSignPage=null;
		homePage=null;
		friendRequestsPage=null;
		myProfilePage=null;
		}
	@AfterTest
	public void closeBrowser()
	{
		System.out.println("afterTest");
		driver.quit();
		driver=null;
		System.gc();

	}



}
