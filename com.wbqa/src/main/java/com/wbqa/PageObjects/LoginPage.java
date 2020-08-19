package com.wbqa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	WebDriver driver;
	
	public LoginPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "uname") WebElement username;
	@FindBy (id = "password") WebElement password;
	@FindBy (id = "login") WebElement login;
	@FindBy (id = "logout") WebElement logout;
	
	public void typeUserName (String uname) {
		
		username.sendKeys(uname);
		return;
	} 
	
	public void typePassword (String pwd) {
		password.sendKeys(pwd);
		return;
	}
	
	public void clickLogin () {
		login.click();
		
	}
	
	public void clickLogout() {
		logout.click();
	}
	
	
}
