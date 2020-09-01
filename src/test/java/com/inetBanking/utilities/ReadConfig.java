package com.inetBanking.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	
	public ReadConfig() {
		
		try {
			FileInputStream file = new FileInputStream("./Configurations/config.properties");
			prop = new Properties();
			prop.load(file);
		}catch(Exception e)
		{
			System.out.println("Exception is "+e.getMessage());
		}
		
	}
	
	public String getApplicationUrl() {
		return prop.getProperty("baseUrl");
	}
	public String getUserName() {
		return prop.getProperty("userName");
	}
	public String getPassword() {
		return prop.getProperty("password");
	}
	public String getChromePath() {
		return prop.getProperty("chromepath");
	}
	public String getFirefoxPath() {
		return prop.getProperty("firefoxpath");
	}
	public String getIEPath() {
		return prop.getProperty("iepath");
	}
	
	
}
