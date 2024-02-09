package organisation;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateContact {

	public static void main(String[] args) 
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver:8888/index.php?action=Login&module=Users");
		driver.findElement(By.name("user_name")).sendKeys("admin", Keys.TAB, "admin", Keys.TAB);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		Random random = new Random();
		int number = random.nextInt(50);
		String lastName = "anu"+number;
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		String parentId = driver.getWindowHandle();
		Set<String> allId = driver.getWindowHandles();
		for (String newId : allId) 
		{
			if(!parentId.equals(newId))
				driver.switchTo().window(newId);
				
		}
		
		driver.findElement(By.id("search_txt"));
		driver.findElement(By.xpath("//a[text()='abcde']")).click();
		driver.switchTo().window(parentId);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.name("search_text")).sendKeys(lastName);
		Select opt = new Select(driver.findElement(By.id("bas_searchfield")));
		opt.selectByIndex(2);
		driver.findElement(By.name("submit")).click();
		String value =driver.findElement(By.xpath("//span[@id='dtlview_Opportunity Name']")).getText();
		System.out.println(value);
		if(value.equals(lastName))
		System.out.println("Test script pass!");
		else
			System.out.println ("Test script fail!");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"))).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		
	}
}
