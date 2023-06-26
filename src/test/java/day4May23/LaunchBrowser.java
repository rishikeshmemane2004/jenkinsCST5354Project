package day4May23;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	
	public static void main(String[] args) throws InterruptedException {
		
		// top casting
		WebDriver driver = new ChromeDriver();  // launched Chrome browser
		driver.get("https://www.selenium.dev/"); // navigate to https://www.selenium.dev/
		driver.manage().window().maximize(); // method chaining 
		
		String title = driver.getTitle();
		System.out.println("title : " + title);
	
		Thread.sleep(5000l);
		driver.quit();
		System.out.println("New title: " + driver.getTitle());  // session id null
// 		driver.close();
// 		System.out.println("New title: " + driver.getTitle()); // invalid session id - expired 
	}
}
