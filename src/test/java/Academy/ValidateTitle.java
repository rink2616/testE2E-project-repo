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

public class ValidateTitle extends Base {
	
	public WebDriver driver;

	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException 
	{
		driver=initializeDriver();
		log.info("Driver is initialize");
		
		driver.get("http://qaclickacademy.com");
		log.info("navigated to home page");
		driver.manage().window().maximize();
	}

	@Test
	public void validatetitle() throws IOException 
	{
		
		
		//creating the object of the class to invoke that getlogin (landing page) method
		LandingPage l=new LandingPage(driver);
		Assert.assertEquals(l.gettitle().getText(),"FEATURED COURSES123");
		log.info("successfully validated text message");
		
	
		}
	
	@AfterTest
	public void tearDowm()
	{
		driver.close();
	}
	
	
}
