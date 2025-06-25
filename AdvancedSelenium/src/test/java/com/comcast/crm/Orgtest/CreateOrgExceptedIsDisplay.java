package com.comcast.crm.Orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrgExceptedIsDisplay {

	public static void main(String[] args) throws IOException, InterruptedException {


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
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 driver.get(Url);
			 driver.findElement(By.name("user_name")).sendKeys(Username);
			 driver.findElement(By.name("user_password")).sendKeys(Password);
			 driver.findElement(By.id("submitButton")).click();
			 driver.findElement(By.linkText("Organizations")).click();	
			 
			 driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			 driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
			 driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			 Thread.sleep(2000);
			String headerInfo =driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			 if(headerInfo.contains(orgName))
			 {
				 System.out.println(orgName+"is created===Pass");
			 }
			 else {
				 System.out.println(orgName+"is not created===Pass");
			 }
			 
			String actualOrgName = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
			
			if(actualOrgName.equals(orgName))
			{
				System.out.println(orgName+"Actual orgname is displayed===Pass");
			}
			else
			{
				System.out.println(orgName+"Actual orgname is not displayed===Pass");
			}
			
			
			 
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			 //Actions act=new Actions(driver);
			 //act.moveToElement(logout);
			 Thread.sleep(2000);
			 driver.findElement(By.linkText("Sign Out")).click();
			 driver.quit();
	}

}
