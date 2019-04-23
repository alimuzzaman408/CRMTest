package com.crm.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'User: Md Alimuzzaman')]")
	
	WebElement userlabel;

	@FindBy(xpath="//a[@title='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontactsLink;

	@FindBy(xpath="//a[@title='Deals']")
	WebElement dealsLink;

	public HomePage(){
		PageFactory.initElements(driver, this);

	}
	public String validateHomePagetitle(){
		return driver.getTitle();


	}
	public boolean validateuserlabel(){

		return userlabel.isDisplayed();



	}
	public CotactsPage clickoncontacts(){
		contactsLink.click();
		return new CotactsPage();
	}
	
	public DealsPage clickDealslink(){

		dealsLink.click();
		return new DealsPage();

	}

public void clickOnNewContacts(){
	
	Actions action=new Actions(driver);
	action.moveToElement(contactsLink).build().perform();
	newcontactsLink.click();
	
}


}
