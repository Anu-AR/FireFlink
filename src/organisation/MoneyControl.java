package organisation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoneyControl {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/stocksmarketsindia/");
		driver.findElement(By.id("wzrk-cancel")).click();
		driver.switchTo().frame("sen_load_graph");
		driver.findElement(By.xpath("//a[@href='https://www.moneycontrol.com/indian-indices/s&p-bse-sensex-4.html']")).click();
		

	}

}
