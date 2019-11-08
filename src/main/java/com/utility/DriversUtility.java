package com.utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
public class DriversUtility {

	static WebDriver driver;
	
	public static WebDriver createDriver(String browserName)
	{
		String chromepath = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe";
		String firefoxpath = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\geokodriver.exe";
		String iepath = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\IEDriverServer.exe";
	
		if (browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", chromepath);
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", firefoxpath);
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", iepath);
			driver = new InternetExplorerDriver();
		}
		else
		{
			System.out.println ("Browser not configured");
		}
		return driver;

}
	}
