package TestPackage;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windows {

	public static void main(String[] args) throws InterruptedException {
     WebDriver driver=new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.get("https://demoqa.com/browser-windows");
     WebElement ele = driver.findElement(By.className("text-center"));
     JavascriptExecutor js=(JavascriptExecutor)driver; 
 	js.executeScript("arguments[0].scrollIntoView(true);", ele);
     driver.findElement(By.xpath("//button[text()='New Window Message']")).click();
     
     String mainWindow = driver.getWindowHandle();
      Set<String> allWindowHandles = driver.getWindowHandles();
      Iterator<String> it= allWindowHandles.iterator();
      String expectedTitle = "about:blank";
      
      while( it.hasNext())
      {
    	  String window = it.next();
    	  //if(!mainWindow.equalsIgnoreCase(window)) {
    	  String actualTitle = driver.getCurrentUrl();
    	  if (actualTitle.contains(expectedTitle)) {
    	  driver.switchTo().window(window);
    	  Thread.sleep(200);
    	  try {
    		  String text = driver.findElement(By.xpath("//body")).getText();
     		 System.out.print(text);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	  driver.close();
    	  }
      }
     driver.switchTo().window(mainWindow);
     driver.quit();
     /* for (String handle : allWindowHandles) {
    	  driver.switchTo().window(handle);
    	  String actualTitle = driver.getCurrentUrl();
    	  if (actualTitle.contains(expectedTitle)) {
    		  String text = driver.findElement(By.xpath("//body")).getText();
      		 System.out.print(text);
      		 
    	  }
    	  driver.close();
      }
      driver.quit();*/
	}
}



