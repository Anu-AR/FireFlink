package webElement;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureThePassedDataFromTextBox {

	public static void main(String[] args) throws Exception 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui");
		String expectedValue = "Anu";
		WebElement ele = driver.findElement(By.name("name"));
		ele.sendKeys(expectedValue);
		String actualValue = ele.getAttribute("value");
		if(expectedValue.equals(actualValue))
		{
			System.out.println("pass");
			System.out.println(actualValue);
			
		}
			
		else
			System.out.println("fail");
	
	
		
		
		
		

	}

}
