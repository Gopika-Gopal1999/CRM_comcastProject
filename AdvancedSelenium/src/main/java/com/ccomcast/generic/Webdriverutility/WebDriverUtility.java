package com.ccomcast.generic.Webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
   public void waitforPageload(WebDriver driver)
   {
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
   }
   public void waitForElementPresent(WebDriver driver,WebElement elements)
   {
	   WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	   wait.until(ExpectedConditions.visibilityOf(elements));
   }
   
   public void switchToTabOnUrl(WebDriver driver,String PartilUrl)
   {
	   Set<String> set = driver.getWindowHandles();
	   Iterator<String> it=set.iterator();
	   while(it.hasNext())
	   {
		   String wh = it.next();
		   driver.switchTo().window(wh);
		String actUrl = driver.getCurrentUrl();
		if(actUrl.contains(PartilUrl))
		{
			break;
		}
	   }
   }
   public void switchToTabOnTittle(WebDriver driver,String PartilTitle)
   {
	   Set<String> set = driver.getWindowHandles();
	   Iterator<String> it = set.iterator();
	   while(it.hasNext())
	   {
		   String wh = it.next();
		   driver.switchTo().window(wh);
		   String actTitle=driver.getTitle();
		   if(actTitle.contains(PartilTitle));
		   {
			   break;
		   }
	   }
	   
   }
   public void select(WebElement element,String text)
   {
	   Select sel=new Select(element);
	   sel.selectByVisibleText(text);
	   
   }
   public void select1(WebElement element,int index)
   {
	   Select sel=new Select(element);
	   sel.selectByIndex(index);
   }
}
