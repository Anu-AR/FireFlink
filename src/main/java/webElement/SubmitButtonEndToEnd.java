package webElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SubmitButtonEndToEnd {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui");
		driver.findElement( By.xpath("//section[text()='Button']")).click();
		driver.findElement(By.xpath("//a[text()='Submit Click']")).click();
		driver.findElement(By.id("sat1")).click();
		driver.findElement(By.id("btn40")).click();
		String expetedValue ="You Selected";
		String actualValueForSatisfiedYes= driver.findElement(By.xpath("//span[contains(text(),'You Selected')]")).getText();
		
		if(actualValueForSatisfiedYes.contains(expetedValue))
			System.out.println("Satisfied radio button Pass");
		else
			System.out.println("Satisfied radio button Fail");
		driver.findElement(By.xpath("//input[@value='No']")).click();
		driver.findElement(By.name("problem")).click();
		driver.findElement(By.id("btn41")).click();
		String actualValueForConcernNo= driver.findElement(By.xpath("//span[contains(text(),'You Selected')]")).getText();
		if(actualValueForConcernNo.contains(expetedValue))
			System.out.println("Concern radio button Pass");
		else
			System.out.println("Concern radio button Fail");
		
		driver.findElement(By.id("r5")).click();
		driver.findElement(By.xpath("//a[text()='Submit Click']")).click();
		
		String actualValueForRating= driver.findElement(By.xpath("//span[contains(text(),'You Selected')]")).getText();
		if(actualValueForRating.contains(expetedValue))
			System.out.println("Rating update Pass");
		else
			System.out.println("Rating not updated");
 
	}

}
