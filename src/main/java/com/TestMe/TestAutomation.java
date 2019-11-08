package com.TestMe;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.utility.DriversUtility;

public class TestAutomation {

	WebDriver driver;
	
	@BeforeTest
	public void configureBrowser()
	{
		driver = DriversUtility.createDriver("chrome");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void user_login_logout() throws InterruptedException
	{
		System.out.println("Testing user login and logout scenario");
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		Thread.sleep(20000);
		Assert.assertEquals(driver.getTitle(), "Home");
		
		driver.findElement(By.linkText("SignIn")).click();
		Thread.sleep(10000);
		Assert.assertEquals(driver.getTitle(), "Login");
		
		driver.findElement(By.id("userName")).sendKeys("lalitha");
		driver.findElement(By.id("password")).sendKeys("password123");
		driver.findElement(By.name("Login")).click();
		Thread.sleep(20000);
		Assert.assertEquals(driver.getTitle(), "Home");
		
		driver.findElement(By.xpath("//a[@href='logout.htm']")).click();
		Thread.sleep(20000);
		Assert.assertEquals(driver.getTitle(), "Home");
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
}
