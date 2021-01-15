package org.testing.testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testing.Pages.Login;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
	public WebDriver driver;
	public Properties prop;
	public WebDriverWait wait;
	
	@BeforeMethod
	public void launchBrowser()throws NumberFormatException, IOException 
	{
	File file=new File("../YTFramework/dataFile.properties");
	FileReader fr=new FileReader(file);
	prop=new Properties();
	prop.load(fr);
	
	System.setProperty(prop.getProperty("propertiesValue"),prop.getProperty("propertiesPath"));
	Map<String, Object> prefs = new HashMap<String, Object>();
	prefs.put("profile.default_content_setting_values.notifications", 2);
	ChromeOptions options = new ChromeOptions();
	options.setExperimentalOption("prefs", prefs);
	driver =new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(TimeUtil.implicitlyWaitValue,TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(TimeUtil.pageLoadTimeoutValue, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	driver.get(prop.getProperty("testUrl"));
	wait =new WebDriverWait(driver,TimeUtil.webdriverwaitValue);
	

	}
	@AfterMethod
	public void closeBrowser()
	{	
		driver.close();
	}
}
