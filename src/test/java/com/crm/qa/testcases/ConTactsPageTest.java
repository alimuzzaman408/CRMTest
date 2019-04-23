package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CotactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

import junit.framework.Assert;

public class ConTactsPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	CotactsPage contactspage;

	public ConTactsPageTest(){

		super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil=new TestUtil();
		loginpage=new LoginPage();
		contactspage=new CotactsPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToframe();
		contactspage= homepage.clickoncontacts();
	}

	@Test(priority=1)
	public void verifyContactsLabelTest(){
		boolean b=contactspage.validateContactslabel();
		Assert.assertTrue(b);
	}
	@Test(priority=2)
	public void checkbosTest(){
		contactspage.selectContactsByName("Abul Hossan");

	}

	@Test(priority=3)
	public void multiplecheckbosTest(){
		contactspage.selectContactsByName("Abul Hossan");
		contactspage.selectContactsByName("Akbul Mossan");
		contactspage.selectContactsByName("Ayesh Jesmin");
		contactspage.selectContactsByName("David Dsouza");

	}
	@DataProvider
	public Object[][] getCrmTestData(){
		Object data[][]=TestUtil.getTestData("contacts");
		return data;
	}





	@Test(priority=4,dataProvider="getCrmTestData")
	public void  validateCreateNewContactsTest(String title,String firstname,String lastname,String company){
		homepage.clickOnNewContacts();
		//contactspage.selectContactsByName("Mr","Tom","Peter","Ebay");
		contactspage.selectContactsByName(title, firstname, lastname, company);

	}



	@AfterMethod
	public void tearDown(){
		driver.quit();

	}





}
