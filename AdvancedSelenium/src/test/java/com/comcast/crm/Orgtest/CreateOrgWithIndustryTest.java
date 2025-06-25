package com.comcast.crm.Orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
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
import org.openqa.selenium.support.ui.Select;

public class CreateOrgWithIndustryTest {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {

		
	


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
	Row row = sh.getRow(4);
	String orgName = row.getCell(2).toString()+randomInt;
	String industry = row.getCell(3).toString();
	String type = row.getCell(4).toString();
	
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
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	 driver.get(Url);
	 driver.findElement(By.name("user_name")).sendKeys(Username);
	 driver.findElement(By.name("user_password")).sendKeys(Password);
	 driver.findElement(By.id("submitButton")).click();
	 driver.findElement(By.linkText("Organizations")).click();	
	 
	 driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	 driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
	 Thread.sleep(2000);
	 
	 WebElement sele = driver.findElement(By.xpath("//select[@name='industry']"));
	 Select sNew=new Select(sele);
	 sNew.selectByVisibleText(industry);
	 Thread.sleep(2000);
	 
	 WebElement sele2 = driver.findElement(By.xpath("//select[@name='accounttype']"));
	 Select sNew1=new Select(sele2);
	 sNew1.selectByVisibleText(type);
	 
	 driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	 
	 
	 Thread.sleep(2000);
	String actualIndustry =driver.findElement(By.id("mouseArea_Industry")).getText();
	 if(actualIndustry.equals(industry))
	 {
		 System.out.println(industry+"is displayed===Pass");
	 }
	 else {
		 System.out.println(industry+"is not displayed===Pass");
	 }
	 
	  String actualTYpe = driver.findElement(By.id("mouseArea_Type")).getText();
	
	if(actualTYpe.equals(type))
	{
		System.out.println(type+"is displayed===Pass");
	}
	else
	{
		System.out.println(type+"is not displayed===Pass");
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
