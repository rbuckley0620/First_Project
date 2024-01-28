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

public class HW_1 {
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
		WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("//button[@id='login_submit']"));
		
		USER_NAME_ELEMENT.sendKeys("demo@codefios.com");
		PASSWORD_ELEMENT.sendKeys("abc123");
		SIGNIN_BUTTON_ELEMENT.click();
		
		WebElement DASHBOARD_VALIDATION_PAGE = driver.findElement(By.xpath("//strong[text()='Dashboard']"));
		Assert.assertTrue("Dashboard not found", DASHBOARD_VALIDATION_PAGE.isDisplayed());
}	
	
	
	@Test
	public void testDeposit() {
		
		testLogin();
		
		driver.findElement(By.xpath("//span[contains(text(),'Transactions')]")).click();
		driver.findElement(By.xpath("//span[text()='Deposit']")).click(); 
		
		
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("James Bond");
		driver.findElement(By.xpath("//textarea[@name='notes']")).sendKeys("This should be enough.");
		driver.findElement(By.xpath("//input[@name='amount'] ")).sendKeys("500,000,000");
		driver.findElement(By.xpath("//button[@class='btn btn-sm btn-primary']")).click(); 
		
		By DEPOSIT_FIELD =By.xpath("//strong[contains(text(),'Add Deposit')]");
		
		Assert.assertTrue("Deposit page not found!!!", driver.findElement(DEPOSIT_FIELD).isDisplayed());
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(DEPOSIT_FIELD));
	}

}
