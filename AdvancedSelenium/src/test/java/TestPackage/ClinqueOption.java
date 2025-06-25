package TestPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ClinqueOption {

	public static void main(String[] args) {
     WebDriver driver=new ChromeDriver();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.manage().window().maximize();
     driver.get("https://www.clinique.in/");
     WebElement ele = driver.findElement(By.partialLinkText("Skincare"));
     Actions a=new Actions(driver);
     a.moveToElement(ele).click().perform();
     //List<WebElement> allOptions = driver.findElements(By.xpath("//a[@title='Moisturizers & Face Creams']/../a"));
     List<WebElement> allOptions = driver.findElements(By.xpath("//a[@title='Moisturizers & Face Creams']/../a"));
     for(int i=0;i<allOptions.size();i++)
     {
    	 String texts = allOptions.get(i).getText();
    	 System.out.println(texts);
     }
     driver.quit();
	}

}
