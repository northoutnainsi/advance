package library;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class utility {
	static WebDriver driver; 
	public static String screenshot(WebDriver driver,String ScreenshotName){
		
		 try {
			TakesScreenshot ts =(TakesScreenshot)driver;
			  File soure = ts.getScreenshotAs(OutputType.FILE);
			  String dest = "C:\\Users\\mjain\\Downloads\\XSLT Report\\"+ScreenshotName+".png";
			  File destination = new File(dest);
			  FileUtils.copyFile(soure, destination);
			  System.out.println("Screenshot taken successfully");
			  return dest;
			 } 
		 catch (Exception e) {
			System.out.println("Exception while taking Screenshots" +e.getMessage());
			return e.getMessage();
		}
	

}
}
