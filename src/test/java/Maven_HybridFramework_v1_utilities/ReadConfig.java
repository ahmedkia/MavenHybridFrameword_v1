package Maven_HybridFramework_v1_utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		
		File src = new File("./Configeration/config.properties");
	    
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
		
			System.out.println("Exception is " + e.getMessage());
		}
	
	}

	public String getApplicationURL() {
		String geturl = pro.getProperty("url");
		return geturl;
		
	}
	  
	public String getusername() {
		String username = pro.getProperty("username");
		return username;
		
	}
	
	public String getPassword() {
		String Password12 = pro.getProperty("password");
		return Password12;
		
	}
	
	public String getchromPath() {
		
		String chrompath = pro.getProperty("chromepath");
		return chrompath;
		
	}
	
    public String getfirefoxPath() {
		
		String firepath = pro.getProperty("firefoxpath");
		return firepath;
		
	}
	
    public String getedgedriverpath() {
    	
    	String getedgepath = pro.getProperty("edgepath");
    	return getedgepath;		
    }
}

