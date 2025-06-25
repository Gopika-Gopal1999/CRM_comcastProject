package TestPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadPopup {

	public static void main(String[] args) throws FileNotFoundException {
		WebDriver driver=new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     driver.get("https://testautomationpractice.blogspot.com/");
	     WebElement ele = driver.findElement(By.xpath("//h2[text()='Upload Files']"));
	     JavascriptExecutor js=(JavascriptExecutor)driver; 
	 	js.executeScript("arguments[0].scrollIntoView(true);", ele);
	 	 File file = new File("./configAppData/Gopika_Gopal_resume (1).docx");
	        String absolutePath = file.getAbsolutePath();
	        WebElement uploadElement = driver.findElement(By.id("singleFileInput"));
	        uploadElement.sendKeys(absolutePath);
	        WebElement submitBtn = driver.findElement(By.xpath("//button[text()='Upload Single File']"));
	        submitBtn.click();
	       driver.quit();
	}

}
