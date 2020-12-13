package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	WebDriver ldriver;

	@FindBy(name="username")
	WebElement username;

	@FindBy(name="password")
	WebElement password;


	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath="//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement logo;

	public LoginPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);		
	}

	public String validateLoginPagetitle(){
		String title=ldriver.getTitle();
		return title;		
	}
	public boolean validateCRMImage(){	
		return logo.isDisplayed();	
	}
	public void login(String un,String pw){
		username.sendKeys(un);
		password.sendKeys(pw);	
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", loginBtn) ; 
		//loginBtn.click();

	}


}
