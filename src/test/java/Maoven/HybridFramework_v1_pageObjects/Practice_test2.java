package Maoven.HybridFramework_v1_pageObjects;

import java.time.Duration;

import org.apache.commons.math3.ode.SecondaryEquations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Practice_test2 {
	

WebDriver driver;


@BeforeMethod
public void starting() {
driver = new ChromeDriver();
WebDriverManager.chromedriver().setup();
driver.get("https://www.google.com");
driver.manage().window().maximize();
driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

}
@Test

public void middle() {

String s = driver.getTitle();
Assert.assertEquals("Google"
		+ "", s);
	System.out.println("Test case has passed");


System.out.println("Test case has passed");

}


@AfterMethod
public void finalmethod() {
	driver.quit();
}
}
	










