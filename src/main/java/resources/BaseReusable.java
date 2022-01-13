package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseReusable {

public WebDriver driver;
	
	public WebDriver intializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Sampa\\eclipse-workspace\\Selenium\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		String browserName= prop.getProperty("browser");
		System.out.println(browserName);
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Sampa\\Downloads\\chromedriver_win32\\chromedriver.exe");
			 driver = new ChromeDriver();
			 driver.manage().window().maximize();
			 
		}
		
		return driver;
	}

}
