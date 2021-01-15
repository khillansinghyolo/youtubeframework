package org.testing.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectValueInDropDown {
	
	public static void selectValueInDropDown(WebElement element ,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
   public static void selectValueInDropDown(WebElement element ,String value) {
	   Select select=new Select(element);
		select.selectByValue(value);;
	}
   public static void selectValueInDropDown(String visibleText,WebElement element) {
	
	   Select select=new Select(element);
	   select.selectByVisibleText(visibleText);
}
}
