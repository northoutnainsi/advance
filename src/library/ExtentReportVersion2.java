package library;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportVersion2 {
	// firstly we will create three global variables in which two are from extentReport jar
	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;
	static String Path =  "C:\\Users\\mjain\\eclipse\\eclipse\\workplace1\\ChalkBracket\\src\\chromedriver.exe";
	
	
	@Test
	public void verifyBlogTitle(){
		
		report = new ExtentReports("C:\\Users\\mjain\\Downloads\\XSLT Report\\AdvanceReport.html");
		 logger = report.startTest("verifyBlogTitle");
		// Launching Chrome Driver
		System.setProperty("webdriver.chrome.driver",Path);
	    driver = new ChromeDriver();
   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    
    logger.log(LogStatus.INFO, "Browser Started");
    driver.get("http://www.google.com");
    
    logger.log(LogStatus.INFO, "Application is up and running");
    String title = driver.getTitle();
    Assert.assertTrue(title.contains("Selenium"));
    
    logger.log(LogStatus.PASS, "Title Verified Successfully");
    logger.log(LogStatus.INFO,"Title Verified Successfully");
		
	}
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception
	{
		if(result.getStatus()==ITestResult.FAILURE){
			String screenshot_path = utility.screenshot(driver, result.getName());
			Thread.sleep(3000);
			String image = logger.addScreenCapture(screenshot_path);
			Thread.sleep(5000);
			
			logger.log(LogStatus.FAIL,"title verification",image);
			logger.log(LogStatus.INFO, "title is not verified");
			Thread.sleep(3000);
		}
		report.endTest(logger);
		report.flush();
		driver.get("C:\\Users\\mjain\\Downloads\\XSLT Report\\AdvanceReport.html");
		
	}

}
