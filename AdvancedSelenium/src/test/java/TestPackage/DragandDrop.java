package TestPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     driver.get("https://testautomationpractice.blogspot.com/");
	     WebElement ele = driver.findElement(By.xpath("//h2[text()='Drag and Drop']"));
	     JavascriptExecutor js=(JavascriptExecutor)driver; 
	 	js.executeScript("arguments[0].scrollIntoView(true);", ele);
	 	WebElement src = driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
	 	WebElement target = driver.findElement(By.xpath("//p[text()='Drop here']"));
	 	Actions a=new Actions(driver);
	 	a.dragAndDrop(src, target).perform();
	 	driver.quit();
	 	
	}

}
