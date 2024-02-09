package webElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextBoxWithOutAPlaceHolder {

	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/login?scenario=1");
		driver.findElement(By.xpath("//li[text()='Without placeholder']")).click();
		driver.findElement(By.id("email")).sendKeys("anupama@gmail.com",Keys.TAB,"password$123");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		String expectedValue = "Signin successful";
		WebElement ele = driver.findElement(By.xpath("(//div[text()='Signin successful'])[2]"));
		String actualValue = ele.getText();
		System.out.println(actualValue);
//		if(expectedValue.equals(actualValue))
//			System.out.println("pass");
//		else
//		System.err.println("fail");
		
		
		

	}

}
