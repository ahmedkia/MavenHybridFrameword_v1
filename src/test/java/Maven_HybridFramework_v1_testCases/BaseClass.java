package Maven_HybridFramework_v1_testCases;

//Lestener class used to generate report

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Maven_HybridFramework_v1_utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	public static WebDriver driver;
	public String  username = readconfig.getusername();
	public String password = readconfig.getPassword();
	public String url = readconfig.getApplicationURL();
	public static Logger logger;
	
	 
	@BeforeMethod
	@Parameters({"browser"})
	public void setup(String browser) {
		
		
		
		
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.proerties");
		
		if (browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
		
			WebDriverManager.firefoxdriver().setup();
			driver  = new FirefoxDriver();
			
		}else if (browser.equals("edge")) {
			
	System.setProperty("webdriver.edge.driver","C:\\Users\\pavel\\eclipse\\IEDriver or edge\\msedgedriver.exe");
			driver = new EdgeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.get(url);  
	}
	


	
    public boolean isalertPresent() {
	 try {
		
		driver.switchTo().alert().accept();
		return true;
	}catch(NoAlertPresentException e)
	{ 
	return false;
	}
	
	
	
	
	}                 
	
	   @AfterMethod
		public void teardown() {
		driver.quit();
	}
	}
	
	

