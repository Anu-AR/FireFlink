package webElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextBoxWithToolTip {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui");
		driver.findElement(By.xpath("//li[text()='With ToolTip']")).click();
		driver.findElement(By.id("name")).sendKeys("anu",Keys.TAB,"anupama@gmail.com", Keys.TAB,"password$123");
		driver.findElement(By.xpath("//button[text()='Register']")).click();
		String expectedValue ="Login";
		WebElement ele = driver.findElement(By.xpath("//h1[text()='Login']"));
		String actualValue = ele.getText();
		if(expectedValue.equals(actualValue))
			System.out.println("pass");
		else
			System.err.println("fail");

	}

}
