package day14Jun23.temp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FlashElementDemo {

	@Test
	public void Test01() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//div[@id='app']//li[2]/a/span")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//		Thread.sleep(10000l);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("firstName")));
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
			
		driver.findElement(By.name("firstName")).sendKeys("AAAA");
		driver.findElement(By.name("middleName")).sendKeys("BBBB");
		driver.findElement(By.name("lastName")).sendKeys("CCCC");
		
		driver.findElement(By.xpath("//div[@id='app']//button[2]")).click();
		
		String flashMsg = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='oxd-toaster_1']//p[2]"))).getText();
		System.out.println("flashMsg : " + flashMsg );
		
	}
}