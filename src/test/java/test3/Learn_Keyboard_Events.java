package test3;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class Learn_Keyboard_Events {

	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://codefios.com/ebilling/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void testLogin() {
		WebElement USER_NAME_ELEMENT = driver.findElement(By.xpath("//input[@id='user_name']"));
		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//input[@id='password']"));
//		WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("//button[@id='login_submit']"));
		USER_NAME_ELEMENT.sendKeys("demo@codefios.com");
		PASSWORD_ELEMENT.sendKeys("abc123");

//keyboard events (replace sign-in button element click with keyboard enter.)
		Actions act = new Actions(driver); 
		act.sendKeys(Keys.ENTER).build().perform();
		
		WebElement DASHBOARD_VALIDATION_ELEMENT = driver.findElement(By.xpath("//strong[text()='Dashboard']"));
		Assert.assertTrue("Dashboard not found", (DASHBOARD_VALIDATION_ELEMENT).isDisplayed());


	} 
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
		
	}

}
