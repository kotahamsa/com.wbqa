package com.wbqa.TestCase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wbqa.PageObjects.LoginPage;
import com.wbqa.Utilities.ReadConfig;

import junit.framework.Assert;

public class TestLogin extends BaseClass{

	@Test
	public void verifyLogin() throws IOException {
		
		ReadConfig readconfig = new ReadConfig();
		
		driver.get(readconfig.url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.typeUserName(readconfig.username);
		logger.info("Entered username");
		
		lp.typePassword(readconfig.password);
		logger.info("Entered password");
		
		lp.clickLogin();
		logger.info("clicked the login button");
		
	
		if (driver.getTitle().equals("QA/QE/SDET Training.")) {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else {
			
			captureScreenMethod(driver, "TestLogin");
			
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
	}
	
}
