package day6May23;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {
	
	public static void main(String[] args) throws InterruptedException {
		 
		WebDriver driver = new ChromeDriver();  
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		String url = "https://www.selenium.dev/";
//		driver.get(url); 
		
		driver.navigate().to(url);  // allows you to utilize browser's back and forward button 
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		System.out.println("title : " + title);

		String cUrl = driver.getCurrentUrl();
		System.out.println("CURL : " + cUrl);
		
		System.out.println(driver.getPageSource());
		
		Thread.sleep(5000l);
		driver.quit();
	}
}
