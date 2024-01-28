package test3;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Youknowit {
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

		// Element List- WebElement Type
//		WebElement USER_NAME_ELEMENT = driver.findElement(By.xpath("//input[@id='user_name']"));
//		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//input[@id='password']"));
//		WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("//button[@id='login_submit']"));
//		
		//Element List- By Type
//		By USER_NAME_FIELD =By.xpath("//input[@id='user_name']");
//		By PASSWORD_FIELD = By.xpath("//input[@id='password']");
//		By SIGNIN_BUTTON_FIELD = By.xpath("//button[@id='login_submit']");
	
		
		WebElement USER_NAME_ELEMENT = driver.findElement(By.xpath("//input[@id='user_name']"));
		USER_NAME_ELEMENT.sendKeys("demo@123");
		
		By USER_NAME_FIELD = By.xpath("//input[@id='user_name']");
		
		driver.findElement(USER_NAME_FIELD);
		
		
		
//		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("demo@codefios.com");
//		driver.findElement(USER_NAME_FIELD).sendKeys("demo@codefios.com");
//		USER_NAME_ELEMENT.sendKeys("demo@co");
//		USER_NAME_ELEMENT.clear(); 
//		USER_NAME_ELEMENT.sendKeys("demo@codefios.com");
//		PASSWORD_ELEMENT.sendKeys("abc123");
//		SIGNIN_BUTTON_ELEMENT.click();
		
		
//		boolean pageTitleDisplayStatus;
		
//		try {
//			WebElement DASHBOARD_VALIDATION_ELEMENT = driver.findElement(By.xpath("/html/body/div[1]/section/div/div[2]/div/div/header/div/strong"));
//			boolean pageTitleDisplayStatus = true;
//		}catch(Exception e) {
//			 pageTitleDisplayStatus = false;
//			e.getStackTrace();
		}
		
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_VALIDATION_ELEMENT));
		
		
		
//		Assert.assertTrue("Dashboard page not found!!!",(pageTitleDisplayStatus);
		
		
}

