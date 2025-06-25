package TestPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollingAndDrop {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     driver.get("https://testautomationpractice.blogspot.com/");
	     WebElement ele = driver.findElement(By.xpath("//h2[text()='Scrolling DropDown']"));
	     JavascriptExecutor js=(JavascriptExecutor)driver; 
	 	js.executeScript("arguments[0].scrollIntoView(true);", ele);
	 	driver.findElement(By.xpath("//input[@id='comboBox']")).click();
	 	WebElement ele2 = driver.findElement(By.xpath("//div[text()='Item 10']"));
	 	Actions a=new Actions(driver);
	 	a.moveToElement(ele2).click().perform();
	}

}
