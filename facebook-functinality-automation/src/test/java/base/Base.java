package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Base {

	public static WebDriver OpenChromeBrowser() {
				WebDriver driver=new ChromeDriver();
		return driver;
	}

	public static WebDriver OpenEdgeBrowser() {
		
		WebDriver driver=new EdgeDriver();
		return driver;
	}
	
	
	
}
