package org.testing.testScripts;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Registration {
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
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.get("https://www.youtube.com/");
	}
	@Test
	public void createNewAccount() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[text()='Sign in']")).click();
		driver.findElement(By.xpath("//span[text()='Create account']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='For myself']")).click();
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("khillanSinghSmall");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Singh");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//span[text()='Use my current email address instead']")).click();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("khillanSinghSmall");
		driver.findElement(By.xpath("//input[@name='Passwd']")).sendKeys("Aioss@01234");
		driver.findElement(By.xpath("//input[@name='ConfirmPasswd']")).sendKeys("Aioss@01234");
		driver.findElement(By.xpath("//div[@id='accountDetailsNext']")).click();
		
		driver.get("https://accounts.google.com/");
		driver.findElement(By.xpath("//*[text()='Sign in']")).click();
		WebElement email =driver.findElement(By.xpath("//input[@name='identifier']"));
		email.clear();
		email.sendKeys("asdffafdf@gmail.com");
		driver.findElement(By.xpath("//div[@id='identifierNext']")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Aioss@01234");
		driver.findElement(By.xpath("//div[@id='passwordNext']")).click();
		
		System.out.println("Registration successfully ");
	}
	@BeforeMethod
	public void closeBrowser()
	{
		//driver.close();
	}

}
