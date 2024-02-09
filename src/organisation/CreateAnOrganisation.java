package organisation;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAnOrganisation {

	static Select select;
	static String orgName="thomson" ;
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver:8888/index.php?action=Login&module=Users");
		driver.findElement(By.name("user_name")).sendKeys("admin", Keys.TAB, "admin", Keys.TAB);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		Random random = new Random();
		 int number= random.nextInt(1000);
		 orgName ="thomson"+number;
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		 select = new Select(driver.findElement(By.name("industry")));
		select.selectByIndex(2);
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[2]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Organization Information')]")).getText();
		
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.name("search_text")).sendKeys(orgName,Keys.TAB);
		select = new Select(driver.findElement(By.xpath("(//select[@id='bas_searchfield'])[1]")));
		select.selectByIndex(1);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
		List<WebElement> list= driver.findElements(By.xpath("//a[@title='Organizations']"));
		int count = 0;
		for (WebElement webElement : list)
		{
			if(orgName.equals(webElement.getText()))
					{
						count=1;
					}
			
		}
		
		if(count==1)
		{
			
		}
		else
			System.out.println("fail");
	}

}
