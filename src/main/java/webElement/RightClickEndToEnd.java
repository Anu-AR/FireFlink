package webElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickEndToEnd {

	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui");
		driver.findElement( By.xpath("//section[text()='Button']")).click();
		driver.findElement(By.xpath("//a[text()='Right Click']")).click();
		WebElement element = driver.findElement(By.id("btn30"));
		Actions act = new Actions(driver);
		
		act.contextClick(element).perform();
		driver.findElement(By.xpath("//div[text()='Yes']")).click();
		String expectedValue="You selected";
		String actualValueYes = driver.findElement(By.xpath("//span[contains(text(),'You selected')]")).getText();
		System.out.println(actualValueYes);
		if(actualValueYes.contains(expectedValue))
			System.out.println("pass");
		else
			System.out.println("fail");
		WebElement element2 = driver.findElement(By.id("btn31"));
		act.contextClick(element2).perform();
		driver.findElement(By.xpath("//div[text()='No']")).click();
		String actualValueNo = driver.findElement(By.xpath("//span[contains(text(),'You selected')]")).getText();
		
		if(actualValueYes.contains(expectedValue))
			System.out.println("pass");
		else
			System.out.println("fail");
		driver.findElement(By.id("btn32")).click();
		WebElement element3 = driver.findElement(By.id("btn32"));
		act.contextClick(element3).perform();
		driver.findElement(By.xpath("//div[text()='5']")).click();
		


	}

}
