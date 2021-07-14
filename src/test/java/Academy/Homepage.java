package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class Homepage extends Base {
	
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws IOException 
	{
		driver=initializeDriver();
		
	}
	
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password,String text) throws IOException 
	{
		//driver=initializeDriver();
	//	driver.get("http://qaclickacademy.com");
		//driver.manage().window().maximize();
		driver.get("http://qaclickacademy.com");
		driver.manage().window().maximize();
		
		//creating the object of the class to invoke that getlogin (landing page) method
		LandingPage l=new LandingPage(driver);
		l.getLogin().click();
		
		//creating the object of the class to invoke that getemail,getpwd (login page) method
		LoginPage lp=new LoginPage(driver);
		lp.getemail().sendKeys(Username);
		lp.getpassword().sendKeys(Password);
		//System.out.println(text);
		log.info(text);
		lp.loginbtn().click();
		
	}
	
	@DataProvider
	public Object[][] getData() 
	{
		//Row stands for howmany diff data types test should run
		//column stands for how many values for each test 
		
		//here we gave [2] [2] in the array size because of we have two types of data and two types of values(username,password)
		//array size is [2] [2] but data index always start every thing from 0 
		//so here is two set of data with size of 2 array 
		Object [][] data=new Object[2][3];
		//0th row
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="123456";
		data[0][2]="nonrestricted user";
		
		//1th row
		data[1][0]="restricteduser@qw.com";
		data[1][1]="123456";
		data[1][2]="restricted user";
		return data;
	}
	
	
	  @AfterTest
	  public void tearDowm() 
	  {
		  driver.close(); 
	  }
	 
}
