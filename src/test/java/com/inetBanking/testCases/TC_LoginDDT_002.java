package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{

	@Test(dataProvider="LoginData")
	public void LoginDDT(String user, String pass) throws InterruptedException {
		LoginPage page = new LoginPage(driver);
		page.setUsername(user);
		page.setPassword(pass);
		page.clickLogin();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			page.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			
		}
		
		
	}
	
	public boolean isAlertPresent() //user defined method created to check alert is presetn or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		String data = System.getProperty("user.dir")+"\\src\\test\\java\\com\\inetBanking\\testData\\LoginData.xlsx";
		int rowCount = XLUtils.getRowCount(data, "Sheet1");
		int colCount = XLUtils.getCellCount(data, "Sheet1", 1);
		
		String loginData[][] = new String[rowCount][colCount];
		
		for(int i=1; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				loginData[i-1][j] = XLUtils.getCellData(data, "Sheet1", i, j);
			}
		}
		return loginData;
	}
}
