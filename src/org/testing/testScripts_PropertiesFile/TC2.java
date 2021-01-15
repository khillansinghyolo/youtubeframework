package org.testing.testScripts_PropertiesFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testing.testBase.TestBase;
import org.testng.annotations.Test;

public class TC2 extends TestBase{
	
	@Test
	public void testHistory()
	{
		driver.findElement(By.xpath(prop.getProperty("Hisoty_button"))).click();
		System.out.println(prop.getProperty("TC2_message"));
	
		WebElement element_signOut1=driver.findElement(By.xpath(prop.getProperty("sign_out")));
		wait.until(ExpectedConditions.elementToBeClickable(element_signOut1)).click();
		WebElement element_SignOut=driver.findElement(By.xpath(prop.getProperty("sign_out_button")));
		wait.until(ExpectedConditions.elementToBeClickable(element_SignOut)).click();;
		System.out.println(prop.getProperty("signOut_Message"));
	
	}
	

}
