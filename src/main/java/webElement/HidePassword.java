package webElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HidePassword {

	public static void main(String[] args) 
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui");
		String value = "password";
		driver.findElement(By.id("password")).sendKeys(value);
		driver.findElement(By.xpath("//input[@type='text']")).click();
		WebElement  element = driver.findElement(By.xpath("//input[@value='+value+']"));
		String actualValue = element.getAttribute("value");
		
		if(value.equals(actualValue))
			System.out.println("pass");
		else
			System.out.println("fail");
		

	}

}
