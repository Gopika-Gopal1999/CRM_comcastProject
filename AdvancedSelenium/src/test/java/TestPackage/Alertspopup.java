package TestPackage;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alertspopup {

	public static void main(String[] args) {
     WebDriver driver=new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.get("https://demoqa.com/alerts");
     WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'prompt box will appear')]"));
 	JavascriptExecutor js=(JavascriptExecutor)driver; 
	js.executeScript("arguments[0].scrollIntoView(true);", ele);
     driver.findElement(By.id("promtButton")).click();
     
     Alert a = driver.switchTo().alert();
     a.sendKeys("Hello hii");
     a.accept();
     //driver.quit();
     
	}

}
