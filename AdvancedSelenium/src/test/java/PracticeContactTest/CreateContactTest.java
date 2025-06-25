package PracticeContactTest;

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

public class CreateContactTest {

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
			Sheet sh = wb.getSheet("Contact");
			Row row = sh.getRow(1);
			String contactName = row.getCell(2).toString()+randomInt;
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
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 driver.findElement(By.name("user_name")).sendKeys(Username);
			 driver.findElement(By.name("user_password")).sendKeys(Password);
			 driver.findElement(By.id("submitButton")).click();
			 driver.findElement(By.linkText("Contacts")).click();	
			 
			 driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			 driver.findElement(By.xpath("//input[@name='lastname'] ")).sendKeys(contactName);
			 driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			 
		  String actualLast = driver.findElement(By.id("dtlview_Last Name")).getText();
			 if(actualLast.equals(contactName))
			 {
				 System.out.println(contactName+" is displayed===Pass");
			 }
			 else
			 {
				 System.out.println(contactName+" is not  displayed===Fail");
				 
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
