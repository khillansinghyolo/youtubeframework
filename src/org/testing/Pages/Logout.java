package org.testing.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logout {
public	WebDriver driver;
public	Properties pr;
public	Logout(WebDriver driver ,Properties pr)
	{
		this.driver=driver;
		this.pr=pr;
	}
public void doLogout()
{
	driver.findElement(By.xpath("//img[@id='img']")).click();
	driver.findElement(By.xpath("//*[text()='Sign out']")).click();	
}
}
