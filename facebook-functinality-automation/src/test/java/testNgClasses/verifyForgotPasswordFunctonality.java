package testNgClasses;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
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
import pom.ForgotPasswordPage;
import pom.FriendsRequestPage;
import pom.HomePage;
import pom.LogInOrSignPage;
import pom.MyProfilePage;
import util.Utility;

public class verifyForgotPasswordFunctonality extends Base {
	
	private	WebDriver driver;
	private LogInOrSignPage logInOrSignPage;
	private HomePage  homePage	;
	private FriendsRequestPage friendRequestsPage;
	private MyProfilePage myProfilePage;
	private ForgotPasswordPage forgotPasswordPage;
	private String testId;
	
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
	public void launchForgotPasswordpage() throws EncryptedDocumentException, IOException {
		System.out.println("beforeMethod");
        driver.get("https://www.facebook.com/login/");
      //  HomePage  homepage=new HomePage(driver);
       logInOrSignPage=new LogInOrSignPage(driver);
       logInOrSignPage.sendUserName(Utility.GetDataFromExcelSheet("Sheet1", 1, 0));
       logInOrSignPage.sendPassword(Utility.GetDataFromExcelSheet("Sheet1", 1, 1));
       logInOrSignPage.clickOnForgetPasswordlink();

	}
	@Test(priority=1)
	public void verifyPasswordShouldBeChangedSucccessfully() throws EncryptedDocumentException, IOException {
		testId="1215";
   System.out.println("test1");
   forgotPasswordPage.sendDataToEmailOrMobNoField(Utility.GetDataFromExcelSheet("Sheet1", 1, 0));
   forgotPasswordPage.clickOnSearchButton();
   
	}
	@Test(priority=2)
	public void verifyErrorMessageWhenForgotFunctionalityIsUsed() {
		System.out.println("test2");
		testId="1216";

		forgotPasswordPage=new ForgotPasswordPage(driver);
		forgotPasswordPage.sendDataToEmailOrMobNoField("vij");
		forgotPasswordPage.clickOnCancelButton();
			}
	
	@AfterMethod
        public void takeScreenshotOfFailedTestCases(ITestResult result) throws IOException {
		System.out.println("aftermethod");
		if(ITestResult.SUCCESS==result.getStatus()) {
			Utility.takeScreenshotMethod(driver, testId);
		}	}
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
