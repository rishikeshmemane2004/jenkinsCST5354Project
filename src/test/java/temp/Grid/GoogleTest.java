package temp.Grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GoogleTest {
	
@Test
public void GTest() throws MalformedURLException
{
	 DesiredCapabilities dc = new DesiredCapabilities();
	 dc.setBrowserName("firefox");
	 WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.35:4444"),dc);
	 driver.get("https://www.google.com");
	 System.out.println("Google title : "+ driver.getTitle());
	 driver.quit();
 }
}
