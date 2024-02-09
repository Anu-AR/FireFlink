package webElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickOnTheElement {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui");
		driver.findElement( By.xpath("//section[text()='Button']")).click();
		driver.findElement(By.xpath("//a[text()='Double Click']")).click();
		WebElement element = driver.findElement(By.id("btn20"));
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
		String expectedValue="You selected";
		String actualValueYes = driver.findElement(By.xpath("//span[contains(text(),'You selected')]")).getText();
		System.out.println(actualValueYes);
		if(actualValueYes.contains(expectedValue))
			System.out.println("pass");
		else
			System.out.println("fail");
		driver.close();
	}

}
