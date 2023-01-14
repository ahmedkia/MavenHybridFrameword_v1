package Maven_HybridFramework_v1_testCases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Maoven.HybridFramework_v1_pageObjects.LoginPage;
import Maven_HybridFramework_v1_utilities.XLUTils;

public class Tc_loginDDT_002 extends BaseClass 

{
@Test	(dataProvider = "LoginData")
public void loginDDT(String user, String pwdd) throws InterruptedException
{
	LoginPage sp = new LoginPage(driver);
	
	 sp.setusername(user);
	 sp.clicknext1();
	 sp.setPassword(pwdd);
	 sp.clicknext2();
	 Thread.sleep(3000);
	
	if(isalertPresent()==true)
	{
	sp.alertverification();
	driver.switchTo().defaultContent();
		
	Assert.assertTrue(false);
           } else {
	Assert.assertTrue(true);
	Thread.sleep(3000);
     sp.clickonlink();
     sp.switchout();
     sp.yahoomailclick();
     sp.yahoomailpage();
     driver.switchTo().defaultContent();
	 }
}




@DataProvider(name="LoginData")	
String[][] getData() throws IOException
{
	String  path = System.getProperty("user.dir")+"/src/test/java/Maven_HybridFramework_v1_testData/data2.xlsx";
	
	int rownum = XLUTils.getRowCount(path, "Sheet1");
	int colcount = XLUTils.getcellcount(path, "Sheet1", 1);
	
	String logindata[][]= new String[rownum][colcount];
	
	for(int i =1;i<=rownum; i++)
	{
		for (int P=0;P<colcount; P++)
		{
	logindata[i-1][P]= XLUTils.getcellData(path, "Sheet1", i,P);
	
			
		}
	}
	return logindata;
			
			
			                                   
			
			
			
			
			
			
			
			
			
		
	
		
	
		
	}
	
	

	
	
	
}
	
