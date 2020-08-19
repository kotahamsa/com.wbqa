package com.wbqa.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	public Properties pro;
	
	public String url;
	public String username;
	public String password;
	
	
	public ReadConfig() {
		
		try {
		
		    File src = new File("/Users/Harini/Documents/Harini/Java_Work/com.wbqa/Configuration/config.properties");
	
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
			url = pro.getProperty("url");
			username = pro.getProperty("username");
			password = pro.getProperty("password");
			
		}	
		catch (Exception e) {
			System.out.println("Exception is: "+e.getMessage());
		}
		
		
		
		
	}
	
	
}
