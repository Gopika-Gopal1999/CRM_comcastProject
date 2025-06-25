package TestPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class CandyMapper {

	public static void main(String[] args) throws InterruptedException {
		

		WebDriver driver1=new ChromeDriver();
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver1.get("https://candymapper.com/");
		//Thread.sleep(2000);
		driver1.findElement(By.id("popup-widget307423-close-icon")).click();
		WebElement element = driver1.findElement(By.xpath("//span[contains(text(),'Worcestershire')]"));
		//Actions a=new Actions(driver1);
		//a.scrollToElement(element).perform();
		JavascriptExecutor js=(JavascriptExecutor)driver1; 
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		WebElement ele1 = driver1.findElement(By.xpath("//iframe[contains(@id,'iframe-undefined12')]"));
		driver1.switchTo().frame(ele1);
		Thread.sleep(2000);
		WebElement listBox = driver1.findElement(By.name("tCounty"));
		listBox.click();
		Thread.sleep(2000);
		Select s=new Select(listBox);
		s.selectByVisibleText("Avon");
		Thread.sleep(2000);
		driver1.quit();
		
	}

}
