package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException 
	{
		//datadriven property file and its class is properties
		 prop=new Properties();
		//to go to any file path FileinputStream where exactly the file is located
		FileInputStream fis= new FileInputStream("C:\\Users\\RINK\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		//load file in prop class
		prop.load(fis);
		
	     String browserName=prop.getProperty("browser");
	     System.out.println(browserName);
	
		if (browserName.equalsIgnoreCase("chrome")) 
		{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\RINK\\OneDrive\\Desktop\\selenium\\jars\\chromejar\\chromedriver.exe");
		driver=new ChromeDriver();
		
		} 
		else if (browserName.equalsIgnoreCase("firefox ")) 
		{
			System.setProperty("webdriver.gecko.driver","c:\\Users\\RINK\\OneDrive\\Desktop\\selenium\\jars\\firefoxjar\\geckodriver.exe");
            driver=new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	
//	public  String getScreenshotPath(String testCaseName,WebDriver driver) throws IOException 
//	{
//		TakesScreenshot ts=(TakesScreenshot) driver;
//		File source=ts.getScreenshotAs(OutputType.FILE);
//		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
//		org.apache.commons.io.FileUtils.copyFile(source,new File(destinationFile));
//			
//		return destinationFile;
//		
//		
//		
//	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
		//String png= System.currentTimeMillis()+ ".png";
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+formater.format(calendar.getTime())+".png";
		org.openqa.selenium.io.FileHandler.copy(source,new File(destinationFile));
		
		return destinationFile;
	}
	
	

}
