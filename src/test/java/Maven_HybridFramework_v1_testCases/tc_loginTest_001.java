package Maven_HybridFramework_v1_testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import Maoven.HybridFramework_v1_pageObjects.LoginPage;

public class tc_loginTest_001 extends BaseClass {
	
	
	@Test
	public void loginTest()  {
		
	
		
		logger.info("open");
		
		LoginPage lp = new LoginPage(driver);
		
		
		
	
		lp.setusername(username);
		logger.info("entered username");
		lp.clicknext1();
		lp.setPassword(password);
		logger.info("entered password");
		lp.clicknext2();
		
		if (driver.getTitle().equals("Yahoo")) {
			
			Assert.assertTrue(true);
			logger.info("login test pass");
		}else {
			
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
	}
	
	
	
	

}
