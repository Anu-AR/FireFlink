
package webElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class VerifyTheButtonIsClickable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui");
		driver.findElement( By.xpath("//section[text()='Button']")).click();
		driver.findElement(By.xpath("//a[text()='Right Click']")).click();
		WebElement element = driver.findElement(By.id("btn30"));
		Actions act = new Actions(driver);
		
		if(element.isDisplayed() && element.isEnabled())
		{
			act.contextClick(element).perform();
			System.out.println("button enabled");
		}

		else
			System.err.println("Button is disabled");

		driver.findElement(By.xpath("//div[text()='Yes']")).click();
		driver.close();

	}

}
