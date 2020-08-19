package com.wbqa.TestCase;

//1. create test case and dataProvider method
//2. dataProvider method takes data from xlSheet and converts it into 2D array and returns the array to the actual test case

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wbqa.PageObjects.LoginPage;
import com.wbqa.Utilities.XLUtils;

import junit.framework.Assert;

public class TestLoginDDT extends BaseClass {

	
	@Test (dataProvider = "LoginData") // giving a name to the method 
	public void loginDDT(String user, String pwd) throws Exception {
		
		LoginPage lp = new LoginPage(driver);
		lp.typeUserName(user);
		logger.info("user name is provided");
		lp.typePassword(pwd);
		logger.info("password provided");
		lp.clickLogin();
		
		Thread.sleep(3000);
		
		if (isAlertPresent()==true) {
			driver.findElement(By.id("username")).clear();  
			driver.findElement(By.id("password")).clear();
		//  .switchTo().alert().accept();
		//	driver.switchTo().defaultContent();
		//	Assert.assertTrue(false);	
			logger.warn("Login failed");
		}
		else {
		//	Assert.assertTrue(true);
			logger.warn("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
		//	driver.switchTo().alert().accept(); // closes the logout alert
		//	driver.switchTo().defaultContent();
			
		}
		
		
	}
	
	public boolean isAlertPresent() {   //user defiened method created to check if alert is present or not
		
		try {
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/article/h6"));
		 
		//	driver.switchTo().alert();
		
			return true;
		}
		catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	
	
	@DataProvider(name="LoginData")
	
	String [][] getData() throws IOException {
		String path = System.getProperty("user.dir")+"/src/test/java/com/wbqa/TestData/LoginData.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String loginData[][] = new String [rownum][colcount] ;
		
		
		for (int i=1; i<=rownum; i++) {
			for(int j=0;j<colcount; j++) {
				loginData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
	return loginData; 
	}
	
}
