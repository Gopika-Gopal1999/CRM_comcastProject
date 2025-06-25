package com.sel.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ReadPropertyFile {

	public static void main(String[] args) throws  InterruptedException, IOException {
			
		
			 FileInputStream fis=new FileInputStream("C:\\Users\\LENOVO\\Desktop\\DatasComman.properties");
			 Properties pObj=new Properties();
			 pObj.load(fis);
			 String Browser = pObj.getProperty("browser");
			 String Url = pObj.getProperty("url");
			 String Username= pObj.getProperty("username");
			 String Password=pObj.getProperty("password");
				System.out.println(Browser);
				System.out.println(Url);
				System.out.println(Username);
				System.out.println(Password);
				//Generate random number
				Random random=new Random();
				int randomInt = random.nextInt();
				
				//Read testScript data from excel
				
				FileInputStream fos=new FileInputStream("C:\\Users\\LENOVO\\TekPyramid\\AdvancedSelenium\\data\\TestData.xlsx");
				Workbook wb =WorkbookFactory.create(fos);
				Sheet sh = wb.getSheet("Org");
				Row row = sh.getRow(1);
				String orgName = row.getCell(2).toString()+randomInt;
				wb.close();
				
				
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
				 driver.get(Url);
				 driver.findElement(By.name("user_name")).sendKeys(Username);
				 driver.findElement(By.name("user_password")).sendKeys(Password);
				 driver.findElement(By.id("submitButton")).click();
				 driver.findElement(By.linkText("Organizations")).click();	
				 
				 driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				 driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
				 driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
				 
				 Thread.sleep(2000);
				 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
				 //Actions act=new Actions(driver);
				 //act.moveToElement(logout);
				 Thread.sleep(2000);
				 driver.findElement(By.linkText("Sign Out")).click();
				 driver.quit();
				 
				 
	}

}

