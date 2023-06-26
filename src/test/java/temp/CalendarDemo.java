package temp;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarDemo {

	static WebDriver driver;
	static WebElement getWebElement(By by)
	{
		return driver.findElement(by);
	}
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1/login.do");
		
		By txtUserName = By.name("username");
		By txtPassword = By.name("pwd");
		By btnLogin    = By.id("loginButton");
		By prevMonth   = By.xpath("((//table[@class='mainSidesPadding'])[1]//tr[1]/td/table/tbody/tr/td)[13]/a");
		By nextMonth   = By.xpath("((//table[@class='mainSidesPadding'])[1]//tr/td[3])[2]/a");
		
		
		getWebElement(txtUserName).sendKeys("admin");
		getWebElement(txtPassword).sendKeys("manager");
		getWebElement(btnLogin).click();
 		
		LocalDate todaysDate   = LocalDate.now();
		LocalDate selectedDate = LocalDate.of(2023, 5, 22); 
											// y m d 23 1 4
											// 4 dec 2023
		Period dateDiff = Period.between(selectedDate, todaysDate); 
		
		
		int monthsDiff = dateDiff.getMonths();
		int daysDiff = dateDiff.getDays();
		
		System.out.println("monthsDiff : " + monthsDiff);
		boolean goNextMonths;
		if(selectedDate.isAfter(todaysDate))
		{		
			goNextMonths = true;
			monthsDiff= Math.abs(monthsDiff);
		}
		else
		{	goNextMonths = false;
			if (daysDiff > 30)
				monthsDiff++;
		}
		System.out.println("goNextMonths: "+ goNextMonths);
		while(monthsDiff>0)
		{
			if(goNextMonths)
			{
				System.out.println("going in next month");
				getWebElement(nextMonth).click();
			}
			else
			{
				System.out.println("going in previous month");		getWebElement(prevMonth).click();
			}
			monthsDiff--;	
		}
 
		int day = selectedDate.getDayOfMonth();
		System.out.println("day: " + day);
		
		String part1 = "//table[@id='calendar_table']//tr//td//span[text()='";
		String part2= "']";
		WebElement element = getWebElement(By.xpath(part1+day+part2));
		element.click();
 		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
