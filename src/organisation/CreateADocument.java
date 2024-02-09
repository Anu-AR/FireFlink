package organisation;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateADocument {

	public static void main(String[] args) throws Exception 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver:8888/index.php?action=Login&module=Users");
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Documents']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Document...']")).click();
		driver.findElement(By.name("notes_title")).sendKeys("campaign");
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//html[@dir='ltr']")).sendKeys("java java java");
		driver.switchTo().parentFrame();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//a[text()='Documents']")).getText());
		

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement fileUpload = driver.findElement(By.xpath("//input[@type='file']"));
		
		jse.executeScript("arguments[0].click()", fileUpload);

		StringSelection s = new StringSelection("C:\\Users\\User\\Desktop\\Dataprovider.xlsx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_ENTER);
	}

}
