package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static String GetDataFromExcelSheet(String sheetname ,int rowNo ,int CellNo) throws EncryptedDocumentException, IOException {
		String data;

		String path="C:\\Users\\Vijay Dhotre\\OneDrive\\Desktop\\seleniumtoexcel.xlsx";

		FileInputStream file=new FileInputStream(path);
		
		Cell cell=WorkbookFactory.create(file).getSheet(sheetname).getRow(rowNo).getCell(CellNo);
		
		try {
			data=cell.getStringCellValue();
		}
		catch(IllegalStateException e) {
			double d=cell.getNumericCellValue();
			System.out.println(d);
			 data=Double.toString(d);
				System.out.println(data);

		}
		 
		file.close();
		
		return data;
		
		
		
		
	}

	
	
	public static void takeScreenshotMethod( WebDriver driver, String testid) throws IOException {
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-dd-mm hh-mm-ss");
		LocalDateTime now=LocalDateTime.now();
		 
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\AutomationLibraries\\automationscreenshots\\test"+testid+dtf.format(now)+".png") ;
		FileHandler.copy(source,dest);
	}

}
