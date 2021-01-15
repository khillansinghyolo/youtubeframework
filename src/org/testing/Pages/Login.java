package org.testing.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
public	WebDriver driver;
public	Properties prop ;

public Login(WebDriver driver ,Properties prop)
	{
		this.driver=driver;
		this.prop=prop;
	}
public void doLogin(String username,String password)
{
	driver.findElement(By.xpath(prop.getProperty("sign_in"))).click();
	WebElement element=driver.findElement(By.xpath(prop.getProperty("email_text")));
	element.clear();
	element.sendKeys(username);
	driver.findElement(By.xpath(prop.getProperty("next_button"))).click();
	WebElement elementPassword=driver.findElement(By.xpath(prop.getProperty("password")));
	elementPassword.clear();
	elementPassword.sendKeys(password);
	driver.findElement(By.xpath(prop.getProperty("password_next_button"))).click();
	System.out.println(prop.getProperty("login_Message"));	



}

}
