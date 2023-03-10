package Maven_HybridFramework_v1_utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testContext) 
	{
	
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //time stamp
		String repName = "Test-Report- " + timeStamp + ".html";
		
		htmlReporter = new ExtentHtmlReporter("C:\\Users\\pavel\\eclipse-workspace\\Maven_HybridFramework_v1\\test-output"+ repName);//specific location
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml/");
		
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Kazi");
		
		htmlReporter.config().setDocumentTitle("Maven_HybridFrameWork_v1 ");
		htmlReporter.config().setReportName("Functional test report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		
	}
	
	public void onTestSuccess(ITestResult tr) {
		
		logger = extent.createTest(tr.getName()); //create new entry in the report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
		
	}
	
public void onTestFailure(ITestResult tr) {
		
		logger = extent.createTest(tr.getName()); //create new entry in the report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String screenshotPath = "C:\\Users\\pavel\\eclipse-workspace\\Maven_HybridFramework_v1\\Screenshots" + tr.getName()+".png";
		
		File f = new File(screenshotPath);
		
		if(f.exists()) 
		{
		try {
			logger.fail("Screenshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
		    }
		catch (IOException e)
	     	{
			e.printStackTrace();
		    }
		    }	
	}
	public void onTestSkipped(ITestResult tr)
	
	{
		logger = extent.createTest(tr.getName());// create new entry in  the report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		
	}
	
	public void onFinish(ITestContext testContext) 
	{
		
		extent.flush();
		
	}
		
		
	}
	


