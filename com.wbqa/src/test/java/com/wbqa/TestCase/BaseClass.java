package com.wbqa.TestCase;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;



public class BaseClass {

	public static WebDriver driver;
	
	public static Logger logger;
	
	
		@BeforeTest
		public void setup() {
			
			
			
		//	System.setProperty("webdriver.chrome.driver","/Users/Harini/Downloads/chromedriver");
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Driver/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://whiteboxqa.com/login.php");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			logger = Logger.getLogger("TestLoginPage");
			PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/main/resource/log4j.properties");
			
		}
	
	
		@AfterTest
		public void tearDown() {
			
			driver.quit();
		}
		
		
		public void captureScreenMethod(WebDriver driver, String tname) throws IOException{
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File (System.getProperty("user.dir")+"/ScreenShots/"+tname+".png");
			
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
		}
		
}



