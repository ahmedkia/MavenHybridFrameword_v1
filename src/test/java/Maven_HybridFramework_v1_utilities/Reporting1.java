package Maven_HybridFramework_v1_utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Reporting1 {
	
	
	public WebDriver driver;
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeTest
	public void setExtent() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output1/myReport.html");
        htmlReporter.config().setDocumentTitle("Automation Report");//Title of the report
        htmlReporter.config().setReportName("Functional Report");// Name of the report
      
        htmlReporter.config().setTheme(Theme.DARK);
        
        extent = new ExtentReports();
        
        extent.attachReporter(htmlReporter);
        
        extent.setSystemInfo("HostName", "LocalHost");
        extent.setSystemInfo("OS", "Windows 11");
        extent.setSystemInfo("Tester Name", "Kazi");
        extent.setSystemInfo("Browser", "Chrome");
        
        
        
       }
	
	@AfterTest
	public void endReport() {
		
		extent.flush();
	}
	
	@BeforeMethod
	public void setup1() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://login.yahoo.com");
		
	}
	
	@Test
	public void titleverification() {
		
		test = extent.createTest("titleverification");
		
		String s = driver.getTitle();
		System.out.println(s);
		Assert.assertEquals(s, "Yahoo");
	}
	
	@Test
	public void logotest() {
		
		test = extent.createTest("logotest");
		
		boolean st = driver.findElement(By.xpath("//img[@class=\"logo \"]")).isDisplayed();
		Assert.assertTrue(st);
		
		
	}
	@Test
	public void logintest() {
		
		test = extent.createTest("logintest");
		
		Assert.assertTrue(true);
		
	}
	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		
		if(result.getStatus() == ITestResult.FAILURE) 
		{
			test.log(Status.FAIL, "TEST CASE FAILED IS" + result.getName());// to add name in extent report
			test.log(Status.FAIL, "TEST CASE FAILED IS" + result.getThrowable());//to get error/exception in report 
			
			
			String screenshotPath = Reporting1.getScreenshot(driver, result.getName());
			
			test.addScreenCaptureFromPath(screenshotPath);//adding screenshots
			
		}else if (result.getStatus() == ITestResult.SKIP) {
			
			test.log(Status.SKIP, "TEST CASE SKIPPED IS " + result.getName());
		}
			
        else if (result.getStatus() == ITestResult.SUCCESS) {
			
			test.log(Status.SKIP, "TEST CASE PASSED IS " + result.getName());
			
			
		}
		driver.quit();
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException
	{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		// after execution , you could see  a folder 'FailedTestScreenshots' under src file
		
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		
		
		
	}
	
	
}
