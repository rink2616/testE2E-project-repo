package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class ValidateNavbar extends Base {
	public WebDriver driver;

	public static Logger log=LogManager.getLogger(Base.class.getName());

	
	@BeforeTest
	public void initialize() throws IOException 
	{
		driver=initializeDriver();
		//driver.get("http://qaclickacademy.com");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

	@Test
	public void validatenavebar() throws IOException 
	{
	//	driver=initializeDriver();
	
	//	driver.get("http://qaclickacademy.com");
	//	driver.manage().window().maximize();
		
		//creating the object of the class to invoke that getlogin (landing page) method
		LandingPage l=new LandingPage(driver);
		Assert.assertTrue(l.getNavBar().isDisplayed());
		
		log.info("Navigation bar is displayed");

		
	
		
		
	}
	@AfterTest
	public void tearDowm()
	{
		driver.close();
	}
	
}
