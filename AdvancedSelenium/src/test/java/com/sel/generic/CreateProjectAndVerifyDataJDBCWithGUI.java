package com.sel.generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;


public class CreateProjectAndVerifyDataJDBCWithGUI {

	public static void main(String[] args) throws InterruptedException, SQLException 
	{
		String projectName="Sagomi_02";
		WebDriver driver=new FirefoxDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
     driver.get("http://49.249.28.218:8091/");
     driver.findElement(By.id("username")).sendKeys("rmgyantra");
     driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
    driver.findElement(By.xpath("//button[text()='Sign in']")).click();
     
		 driver.findElement(By.linkText("Projects")).click();
		 driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		 driver.findElement(By.name("projectName")).sendKeys(projectName);
		 //driver.findElement(By.name("teamSize")).sendKeys("20");
		 driver.findElement(By.name("createdBy")).sendKeys("Gopu");
		 WebElement sele = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		 Select  s1=new Select(sele);
		 s1.selectByVisibleText("Created");
		 driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		 driver.quit();
		 //verify the project in dataBase
		 boolean flag = false;
		 
		    Driver driverReg=new Driver();
		    DriverManager.registerDriver(driverReg);
		    Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
		    Statement stat = conn.createStatement();
		    ResultSet result = stat.executeQuery("Select * from project");
		    
		    while(result.next())
		    {
		    String actualProject = result.getString(4);
		    if(projectName.equals(actualProject))
		    {  
		    	flag=true;
		    	System.out.println(projectName+"is available==Pass");
		    }
		    }
		    if(flag==false)
		    {
		    	System.out.println(projectName+"is not available==Fail");
		    }
		    
		    conn.close();
		     
			}
	
}
	 
		
		 

		 
	

