package day6May23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnteringTextDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		String actUrl = "https://www.letskodeit.com/practice";
		driver.get(actUrl);
		driver.manage().window().maximize();
		
		String expUrl = "https://www.letskodeit.com/practice";
		if (expUrl.equals(actUrl))
			System.out.println("We landed up at the right URL : test case passed !");
		else
			System.out.println("We landed up at the WRONG URL : test case failed !");
	
		WebElement txtElement = driver.findElement(By.id("autosuggest"));
		txtElement.sendKeys("Heetarth Jawade ","Shubham Parmar ","Mangesh Belure");
		
		Thread.sleep(5000l);
		
		txtElement.clear();
		txtElement.sendKeys("Anushka ", "Sunny ", "Katrina => ");
		
		
		driver.findElement(By.id("autosuggest")).sendKeys("Cyber Success Pune");
		
		
		driver.quit();
		
		
	}
	
	
	
}
