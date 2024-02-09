package webElement;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkTextOpenInNewTab {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui");
		driver.findElement(By.xpath("//section[text()='Link']")).click();
		driver.findElement(By.xpath("//a[text()='Link in New Tab']")).click();
		driver.findElement(By.linkText("Contact Us")).click();
		String parentId=driver.getWindowHandle();
		driver.switchTo().window(parentId);
		Set<String> childId= driver.getWindowHandles();
		String parentTitle = "DemoApps | Qspiders | Links";
		String childTilte="Demoapps | Qspider";
		for (String newId : childId) 
		{
			if(!parentId.equals(newId))
			{
				driver.switchTo().window(newId);
				String actualTitle = driver.getTitle();
				if(childTilte.equals(actualTitle))
				System.out.println("Title fetched");
				else
					System.out.println("Title not Fetched");
				
			}
				
			
		}
		


	}

}
