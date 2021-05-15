package abcpack;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserSlider {
	WebDriver d;
	@Test
	public void testBrowserSlider() throws Exception
	{
		//Load web page
		d.get("https://www.selenium.dev/");
		assertEquals(d.getTitle(),"SeleniumHQ Browser Automation");
		for(int i=0;i<5;i++)
		{
			((RemoteWebDriver) d).executeScript("window.scrollBy(0,400)");
			Thread.sleep(1000);
		}
		((RemoteWebDriver) d).executeScript("window.scrollTo(0,0)");
		Thread.sleep(3000);
				
	}
	// while(isElementPresent(d, By.linkText("History"))
	public boolean isElementPresent(WebDriver driver, By b)
	{
		try
		{
			driver.findElement(b);
			return false;
		}
		catch(NoSuchElementException e)
		{
			return true;
		}
			    
	}
	@BeforeMethod
	public void setUp()
	{
		//Launch browser
		d=new FirefoxDriver();
		//d =new ChromeDriver();
		//Maximize browser
		//d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}
	@AfterMethod
	public void tearDown()
	{
		//Close browser
		d.quit();
	}


}
