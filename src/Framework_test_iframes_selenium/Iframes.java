package Framework_test_iframes_selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

public class Iframes {
	
	WebDriver driver;
	String baseURL="https://www.madrid.es/portal/site/munimadrid";
	

	@Before
	public void InitTest() throws InterruptedException {
		
		driver = InstantiateDriver();	
		driver.get(baseURL);
		Thread.sleep(15000);
		} 
	
	@Test
	public void ValidarTextTitulo () {		
			
		String Titulo = driver.getTitle();
		System.out.println("El titulo de mi página es: "+Titulo);
						
	}
	
	@Test
	public void ValidarTextTweets () throws InterruptedException {		
		
		System.out.println("Test_Didier");
		WebElement iframeTweeter=driver.findElement(By.cssSelector("iframe#twitter-widget-0"));
		driver.switchTo().frame(iframeTweeter);
		Thread.sleep(15000);
		//System.out.println(iframeTweeter.isEnabled());
		WebElement TituloTweets = driver.findElement(By.cssSelector("div.timeline-Header.timeline-InformationCircle-widgetParent h1.timeline-Header-title.u-inlineBlock"));
		
		System.out.println("El tweets: "+TituloTweets.getText());
						
	}
		
	
	public WebDriver InstantiateDriver() {
		
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	@After
	public void EndTest() {
		
		driver.quit();
		} 
	
}
