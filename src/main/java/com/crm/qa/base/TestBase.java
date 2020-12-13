package com.crm.qa.base;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.crm.qa.util.Readconfig;
public class TestBase {
	Readconfig rc=new Readconfig();
	public String url=rc.seturl();
	public String username=rc.setusername();
	public String password=rc.setpassword();
	public String browser="chrome";
	public static WebDriver driver;
	public static  Properties prop;


	@BeforeClass
	public static void setup(){

		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:/Driverr/chromedriver.exe");
			driver=new ChromeDriver();

		}
		else if(browsername.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "C:/Driver/geckodriver.exe");
			driver=new FirefoxDriver();

		}
		driver.get(prop.getProperty("url"));

	}
	@AfterClass
	public void teardown() {

		driver.close();
	}









}
