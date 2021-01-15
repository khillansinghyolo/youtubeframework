package org.testing.testScripts_PropertiesFile;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testing.Pages.Login;
import org.testing.Pages.Logout;
import org.testing.testBase.TestBase;
import org.testing.utilities.TakeScreenShot;
import org.testng.annotations.Test;

public class TC1 extends TestBase {

	@Test
	public void testTrending() throws IOException
	{
		new Login(driver,prop).doLogin(prop.getProperty("emailValue"),prop.getProperty("passwordValue"));
		TakeScreenShot.takeScreenshot(driver, "../YTFramework/src/Screeshot/login.png");
		driver.findElement(By.xpath(prop.getProperty("trending_button"))).click();
		TakeScreenShot.takeScreenshot(driver, "../YTFramework/src/Screeshot/login.png");
		System.out.println(prop.getProperty("TC1_message"));
		new Logout(driver,prop).doLogout();
		TakeScreenShot.takeScreenshot(driver, "../YTFramework/src/Screeshot/logout.png");
			
		System.out.println(prop.getProperty("signOut_Message"));

	}
	
	
}
