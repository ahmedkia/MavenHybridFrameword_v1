package Maoven.HybridFramework_v1_pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice_test1 {
 
	 WebDriver driver;
	 @BeforeMethod
	 public void  work1() {
		
		 WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 }
	 @Test
		 public void atwork() throws InterruptedException {
		 driver.get(("https://login.yahoo.com"));
		 String s = driver.getTitle();
		 System.out.println(s);
		 Thread.sleep(10);
		 Assert.assertEquals(s, "Yahoo");
		 driver.findElement(By.xpath("//input[@id=\"login-username\"]")).sendKeys("kazi222222003@yahoo.com");
         driver.findElement(By.id("login-signin")).click(); 	
         driver.findElement(By.xpath("//input[@id=\"login-passwd\"]")).sendKeys("1Q2W3E");
         driver.findElement(By.id("login-signin")).click();	 
	 }
		 
     @AfterMethod
     public void finalwork() {
     
     driver.quit();
     }
	 }
	 

	
	
	

