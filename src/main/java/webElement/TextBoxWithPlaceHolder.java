package webElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;

public class TextBoxWithPlaceHolder {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui");
		driver.findElement(By.name("name")).sendKeys("anu",Keys.TAB, "anupama@gmail.com", Keys.TAB,"password$123");
		driver.findElement(By.xpath("//button[text()='Register']")).click();
		String verifyLoginExpectedValue ="Login";
		WebElement ele = driver.findElement(By.xpath("//h1[text()='Login']"));
		String actualValue =ele.getText();
		if(verifyLoginExpectedValue.equals(actualValue))
		
			System.out.println("Test Script pass");
		else
			System.err.println("Test Script fail");
		
		
	}

}
