package organisation;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateCampaignsAndOpportunities {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver:8888/index.php?action=Login&module=Users");
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin");
		driver.findElement(By.id("submitButton")).click();
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[text()='More']"))).perform();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		Random random = new Random();
		int num = random.nextInt(30);
		String campaignName = "Banner"+num;
		
		driver.findElement(By.name("campaignname")).sendKeys(campaignName);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		String verifyCampaignName = driver.findElement(By.id("dtlview_Campaign Name")).getText();
		if(campaignName.equals(verifyCampaignName))
			System.out.println("Campaign created and verified successfully!!!");
		else
			System.out.println("Campaign not created!!!");
		
		driver.findElement(By.xpath("(//a[text()='Opportunities'])[1]")).click();
		
		driver.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click();
		String opportunityName = "sony"+num;
		driver.findElement(By.name("potentialname")).sendKeys(opportunityName);
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
	
		
		String parentId = driver.getWindowHandle();
		Set<String> allId = driver.getWindowHandles();
		
		for (String newId : allId) 
		{
			if(!parentId.equals(newId))
				driver.switchTo().window(newId);
			
		}
		driver.findElement(By.id("search_txt")).sendKeys("thomsonreuters");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='thomsonreuters']")).click();
		driver.switchTo().window(parentId);
		driver.findElement(By.xpath("(//img[@alt='Select'])[2]")).click();
		String campaignParentId = driver.getWindowHandle();
		Set<String> campaignChildId= driver.getWindowHandles();
		for(String campaignNewID :campaignChildId )
		{
			if(!campaignParentId.equals(campaignNewID))
				driver.switchTo().window(campaignNewID);
		}
		driver.findElement(By.id("search_txt")).sendKeys(campaignName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+campaignName+"']")).click();
		driver.switchTo().window(campaignParentId);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		String name = driver.findElement(By.id("dtlview_Opportunity Name")).getText();
		System.out.println(name);
		if(opportunityName.equals(name))
			System.out.println("pass");
		else
			System.out.println("fail");
		
		act.moveToElement(driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"))).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();

		
	}

}
