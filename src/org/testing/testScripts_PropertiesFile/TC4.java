package org.testing.testScripts_PropertiesFile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testing.testBase.TestBase;
import org.testng.annotations.Test;

public class TC4 extends TestBase {

	@Test
	public void testLikeVideo() throws InterruptedException
	{
		driver.findElement(By.xpath(prop.getProperty("PlayVideo_button"))).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("LikeVideo")).click();
		System.out.println(prop.getProperty("TC4_message"));
	Thread.sleep(4000);
		WebElement element_signOut1=driver.findElement(By.xpath(prop.getProperty("sign_out")));
		wait.until(ExpectedConditions.elementToBeClickable(element_signOut1)).click();
		WebElement element_SignOut=driver.findElement(By.xpath(prop.getProperty("sign_out_button")));
		wait.until(ExpectedConditions.elementToBeClickable(element_SignOut)).click();;
		System.out.println(prop.getProperty("signOut_Message"));	
	}	
}
