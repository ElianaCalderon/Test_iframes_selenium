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
	String baseURL="https://www.atm.cat/web/index.php";
	

	@Before
	public void InitTest() {
		
		driver = InstantiateDriver();	
		driver.get(baseURL);
	} 
	
	@Test
	public void ValidarEnvironment () {		
			
		String Titulo = driver.getTitle();
		System.out.println("El titulo de mi pagina es: "+Titulo);
		String expectetResult="ATM | web oficial de l'Autoritat del Transport Metropolità";
		assertEquals("El titulo no corresponde al esperado", expectetResult, Titulo);
				
	}
	
	@Test
	public void ValidarMenu () {
						
		WebElement botonCerrar = driver.findElement(By.cssSelector("div.modal-header button.close"));
		System.out.println("boton cerrar Displayed: "+botonCerrar.isDisplayed());
		botonCerrar.click();
		WebElement menuAtm = driver.findElement(By.xpath("//a[contains(text(), 'ATM')]"));		
		System.out.println("Menu Displayed: "+menuAtm.isDisplayed());
		System.out.println("Menu Enabled: "+menuAtm.isEnabled());
		System.out.println("Texto del menú: "+menuAtm.getText());
		assertTrue(menuAtm.isDisplayed());
		WebElement menuObservatori = driver.findElement(By.xpath("//a[contains(text(), 'Observatori')]"));		
		System.out.println("Menu Displayed: "+menuObservatori.isDisplayed());
		System.out.println("Menu Enabled: "+menuObservatori.isEnabled());
		System.out.println("Texto del menú: "+menuObservatori.getText());
		assertTrue(menuObservatori.isDisplayed());
				
	}
	
	@Test
	public void Busqueda () throws InterruptedException {
		
		WebElement botonCerrar = driver.findElement(By.cssSelector("div.modal-header button.close"));
		System.out.println("boton cerrar Displayed: "+botonCerrar.isDisplayed());
		botonCerrar.click();
		
		Thread.sleep(5000);
		
		
		WebElement inputBuscar = driver.findElement(By.cssSelector("input.gsc-input"));
		inputBuscar.click();
		inputBuscar.sendKeys("Test");
		WebElement inputSearch = driver.findElement(By.cssSelector("button.gsc-search-button"));
		inputSearch.click();
		
		WebElement Resultats = driver.findElement(By.cssSelector("div.headline h1"));
		System.out.println("Menu Enabled: "+Resultats.isEnabled());
		System.out.println("Texto del menú: "+Resultats.getText());		
		String UrlResultados = driver.getCurrentUrl();
		System.out.println("La URL actual es: "+UrlResultados);
		String expectetResult="Resultats";
		assertEquals("Busqueda no realizada", expectetResult, Resultats.getText());
		
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
