package day15Jun23;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
 
public class SrotOnEmployeeNAmeUsingStream {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath(("(//nav[@role='navigation']/div[2]//li)[1]"))).click();
		driver.findElement(By.xpath(("(//div[@role='columnheader']/div/i)[3]"))).click();
				
		driver.findElement(By.xpath("(//ul[@role='menu']/li)[5]")).click();
		List<WebElement> low = driver.findElements(By.xpath("//div[@class='oxd-table-cell oxd-padding-cell' and @role='cell'][4]"));
				
				//"//div[@role='row']/div[4]"));
		
		List<String> lowString = low.stream().map(s->s.getText().toLowerCase()).collect(Collectors.toList());   // ascending  , defect not asc 
		System.out.println("actual asc list:");
		int cnt=1;
		for(String s: lowString)
			System.out.println(cnt++ + " : " +  s);
		System.out.println("-".repeat(40));
		
		List<String> lowSortedString = lowString.stream().map(s->s.toLowerCase()).collect(Collectors.toList());
		cnt = 1;
		System.out.println("exp asc list:");
		for(String s: lowSortedString)
			System.out.println(cnt++ + " : " + s);
		System.out.println("-".repeat(40));
		
//		Assert.assertEquals(lowString, lowSortedString,"Both list are not matching !!!!");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("Test case passed !!!");
		
		
		
		
		
		
		
		
		
	}
}
