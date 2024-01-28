package test3;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Learn_Mouse_Hover_Over {

	
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
	public void testLogin()   {
		WebElement USER_NAME_ELEMENT = driver.findElement(By.xpath("//input[@id='user_name']"));
		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("//button[@id='login_submit']"));
		USER_NAME_ELEMENT.sendKeys("demo@codefios.com");
		PASSWORD_ELEMENT.sendKeys("abc123");
		SIGNIN_BUTTON_ELEMENT.click();
		
		mouseHover();
	}
	
	
	public void mouseHover()  {
		
		
		WebElement DASHBOARD_ELEMENT=  driver.findElement(By.xpath("//strong[text()='Dashboard']"));
		Actions act = new Actions(driver);
		act.moveToElement(DASHBOARD_ELEMENT).build().perform();
		
	} 
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	
}
