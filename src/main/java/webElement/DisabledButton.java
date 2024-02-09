package webElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DisabledButton {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui");
		driver.findElement( By.xpath("//section[text()='Button']")).click();
		driver.findElement(By.xpath("//a[text()='Disabled']")).click();
		WebElement chceckBox = driver.findElement(By.xpath("//input[@value='false']"));
		if(chceckBox.isEnabled())
			System.out.println("is Enabled");
		else
			System.out.println("is disabled");
		WebElement submitButton = driver.findElement(By.id("chceckBox"));
		if(submitButton.isEnabled())
			System.out.println("Submit button is enabled");
		else
			System.out.println("Submit button is disabled");
		driver.close();
			

	}

}
