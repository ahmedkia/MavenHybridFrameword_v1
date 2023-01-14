package Maoven.HybridFramework_v1_pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver Ldriver;
	
	public LoginPage (WebDriver rdriver){
	Ldriver = rdriver;
	PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath = "//input[@id=\"login-username\"]")	
	@CacheLookup
	WebElement txtuserName;
	
	@FindBy(id="login-signin")
	@CacheLookup
	WebElement nxtBton;
	
	@FindBy(xpath="//input[@id=\"login-passwd\"]")
	@CacheLookup
	WebElement txtPassword;
	
	
	@FindBy(id="login-signin")
	@CacheLookup
	WebElement nxtbton2;
	
	
	@FindBy(xpath ="//img[@class=\"_yb_pyb4d\"]")
	@CacheLookup
	WebElement logoutlink;
	
	
	@FindBy(xpath= "//a[@id=\"profile-signout-link\"]")
	@CacheLookup
	WebElement logout;
	
	
	@FindBy(xpath = "//*[@class=\"_yb_2wmq1\"]")
	@CacheLookup
	WebElement yahoomaillink;
	
	
	@FindBy(xpath ="//a[@class=\"pure-button puree-button-link add-account page-button-link\"]") 
	@CacheLookup
	WebElement useotheremailaddress;
	
	
	@FindBy(xpath = "//p[@class=\"error-msg\"]")
	@CacheLookup
	WebElement sc;
	
	
	
	public void setusername(String uname) {
		txtuserName.sendKeys(uname);
		
		}
	
	public void clicknext1() {
		nxtBton.click();
		
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
		
		}
	
	public void clicknext2() {
		nxtbton2.click();
		
		
	}
	
	public void clickonlink() {
		logoutlink.click();
		
	}
	
	public void switchout() {
		logout.click();
	}
	
	public void yahoomailclick() {
		
		yahoomaillink.click();
	}
	
	public void yahoomailpage() {
		useotheremailaddress.click();
		
	}
	
	public void alertverification() {
		sc.isDisplayed();
	}
}
