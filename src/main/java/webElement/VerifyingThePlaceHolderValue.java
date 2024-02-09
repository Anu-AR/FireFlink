package webElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyingThePlaceHolderValue {

	public static void main(String[] args) 
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui");
		String expetcedValue = "Enter your email";
	WebElement ele=	driver.findElement(By.xpath("//input[@placeholder='Enter your email']"));
	String actualValue = ele.getAttribute("placeholder");
	if(expetcedValue.equals(actualValue))
	{
		System.out.println("pass");
		System.out.println(actualValue);
	}
	else
		System.err.println("fail");

	}

}
