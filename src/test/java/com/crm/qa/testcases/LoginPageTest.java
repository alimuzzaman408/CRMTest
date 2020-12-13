package com.crm.qa.testcases;

import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	@Test
	public void logintest() {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.validateLoginPagetitle();
		loginpage.validateCRMImage();
		loginpage.login(username, password);




	}

}









