package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void LoginTest() throws InterruptedException, IOException {
		
		logger.info("Url is opend");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(userName);
		logger.info("Entered Username");
		loginPage.setPassword(password);
		logger.info("Entered password");
		loginPage.clickLogin();
		logger.info("Clicked on login button");
		Thread.sleep(2000);
		
		if(driver.getTitle().equals("Guru99 Bank Manager Home")) {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}else {
			captureScreen(driver, "LoginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
	}
}
