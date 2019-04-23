package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.CotactsPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	CotactsPage contactspage;
	public HomePageTest(){

		super();

	}

	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil=new TestUtil();
		loginpage=new LoginPage();
		contactspage=new CotactsPage();
		
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}


	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String title=homepage.validateHomePagetitle();
		Assert.assertEquals(title, "CRMPRO","HomePage title not matched");
	}


	@Test(priority=3)
	public void contactsLinkClickTest(){
		testUtil.switchToframe();
		contactspage=homepage.clickoncontacts();
		
		
	}
	
	@Test(priority=2)
	public void verifyUserLabel(){
		testUtil.switchToframe();
		boolean flag=homepage.validateuserlabel();
		Assert.assertTrue(flag);
		
		
		
	}
	

	@AfterMethod
	public void tearDown(){
		driver.quit();

	}



}
