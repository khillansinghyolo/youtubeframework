package org.testing.testScripts;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC6 {
	WebDriver driver;
	@BeforeMethod
	public void lunchBrowser()
	{
		System.setProperty("webdriver.chrome.driver","../YTFramework/chromedriver.exe");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		driver =new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.youtube.com/");
	}
	@Test
	public void testComment() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[text()='Sign in']")).click();
		WebElement email =driver.findElement(By.xpath("//input[@name='identifier']"));
		email.clear();
		email.sendKeys("khillansinghgcube@gmail.com");
		driver.findElement(By.xpath("//div[@id='identifierNext']")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Aioss@01234");
		driver.findElement(By.xpath("//div[@id='passwordNext']")).click();
		System.out.println("Successfully login you tube");
		
		driver.findElement(By.xpath("//*[@id='video-title']")).click();
		Actions ac=new Actions(driver);
		Thread.sleep(7000);
		ac.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(10000);
		WebElement element=	driver.findElement(By.xpath("//*[@id='contenteditable-root' or @class='style-scope yt-formatted-string' or @aria-label='Add a public comment...']"));
		
		element.click();
		element.sendKeys("this is good things by khillan");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='submit-button']")).click();
		System.out.println("successfully comment");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//img[@id='img']")).click();
		driver.findElement(By.xpath("//*[text()='Sign out']")).click();
	
	}
	@AfterMethod
	public void closeBrowser()
	{
		//driver.close();
	}
	
}
