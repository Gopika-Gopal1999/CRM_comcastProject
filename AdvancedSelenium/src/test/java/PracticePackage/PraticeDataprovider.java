package PracticePackage;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.FileUtility.ExcelUtility;

public class PraticeDataprovider {
	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brand,String product)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(brand,Keys.ENTER);
		//driver.findElement(By.id("nav-search-submit-button")).click();
	    String price = driver.findElement(By.xpath("//span[text()='"+product+"']/../../../..//span[@class='a-price-whole']")).getText();
		System.out.println(price);
		driver.quit();
		
		
		}
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		ExcelUtility e=new ExcelUtility();
		return e.getMultipledata("Test");
	}

}
