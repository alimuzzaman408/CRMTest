package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement logo;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
		
	}
	public String validateLoginPagetitle(){
		return driver.getTitle();
		
		
	}
public boolean validateCRMImage(){
	
	 return logo.isDisplayed();
	
}

public HomePage login(String un,String pw){
	username.sendKeys(un);
	password.sendKeys(pw);
	
	 JavascriptExecutor js = (JavascriptExecutor)driver;
 	js.executeScript("arguments[0].click();", loginBtn) ; 
	//loginBtn.click();
	return new HomePage();
	
	
	
	
}






}
