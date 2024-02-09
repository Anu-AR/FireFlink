package JDBC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PracticeMavenTest {

	
	@Test
	public void practiceMavenTest()
	{
		String BROWSER = System.getProperty("browser");
		String URL =System.getProperty("url");
		
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
//		String USERNAME =System.getProperty("username");
//		String PASSWORD =System.getProperty("password");
		
		System.out.println(BROWSER);
		System.out.println(URL);
	}
}
