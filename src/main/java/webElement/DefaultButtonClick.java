package webElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DefaultButtonClick {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui");
		driver.findElement( By.xpath("//section[text()='Button']")).click();
		driver.findElement(By.id("btn")).click();
		String expectedValue="You selected";
		String actualValueYes = driver.findElement(By.xpath("//span[contains(text(),'You selected')]")).getText();
		System.out.println(actualValueYes);
		if(actualValueYes.contains(expectedValue))
			System.out.println("pass");
		else
			System.out.println("fail");
		
		driver.findElement(By.xpath("//button[text()='No']")).click();
		String actualValueNo = driver.findElement(By.xpath("//span[contains(text(),'You selected')]")).getText();
		if(actualValueNo.contains(expectedValue))
			System.out.println("pass");
		else
			System.out.println("fail");
	}

}
