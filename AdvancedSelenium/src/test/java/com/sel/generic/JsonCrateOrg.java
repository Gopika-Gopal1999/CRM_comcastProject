package com.sel.generic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class JsonCrateOrg {
	@Test
	public void createOrg() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser=new JSONParser();
	     Object obj = parser.parse(new FileReader("C:\\Users\\LENOVO\\TekPyramid\\AdvancedSelenium\\data\\JsonData.JSON"));
	     JSONObject map=(JSONObject)obj;
	     String url=map.get("Url").toString();
		 String Browser=map.get("Browser").toString();
		 String username= map.get("Username").toString();
		 String password=map.get("Password").toString();
	   

		WebDriver driver= null;
		if(Browser.equals("Chrome"))
		{
			driver=new ChromeDriver();
			
		}
		else if(Browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(Browser.equals("Edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		 driver.get( url);
		 driver.findElement(By.name("user_name")).sendKeys(username);
		 driver.findElement(By.name("user_password")).sendKeys(password);
		 driver.findElement(By.id("submitButton")).click();
		 driver.findElement(By.linkText("Organizations")).click();	
		 driver.quit();
	}

}
