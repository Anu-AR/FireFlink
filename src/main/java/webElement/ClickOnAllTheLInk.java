package webElement;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickOnAllTheLInk {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui");
		driver.findElement(By.xpath("//section[text()='Link']")).click();
		driver.findElement(By.xpath("//a[text()='Link in New Tab']")).click();
		List<WebElement> link = driver.findElements(By.xpath("//h1[text()='ABOUT']/../li/a]"));
		
		
		for(WebElement childLink : link )
		{
			System.out.println(childLink);
			
		}


	}

}
