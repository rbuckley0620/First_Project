package test3;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Learn_Alerts {

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
	
		WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("//button[@id='login_submit']"));
		
		SIGNIN_BUTTON_ELEMENT.click(); 
		driver.switchTo().alert().getText();
		
//to get the alert text and print it on the console. 		
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
	}
	

}
