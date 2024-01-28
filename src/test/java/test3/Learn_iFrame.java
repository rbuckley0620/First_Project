package test3;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class Learn_iFrame {

	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://docs.oracle.com/javase/8/docs/api/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void iFrame() {

		driver.switchTo().frame("classFrame");
		driver.findElement(By.linkText("compact1")).click();
		driver.findElement(By.linkText("Closeable")).click();

		driver.switchTo().parentFrame();

	}

// Example for web-site with different frame structure. 	
	
	@Test
	public void iFrame2() {
		By USER_NAME_FIELD = By.xpath("//input[@id='user_name']");
		By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
		By SINGIN_BUTTON_FIELD = By.xpath("//*[@id=\"login_submit\"]");
		By DASHBOARD_VALIDATION_FIELD = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/header/div/strong");

		driver.findElement(USER_NAME_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(SINGIN_BUTTON_FIELD).click();

		Assert.assertTrue("Dashboard page not found!!", driver.findElement(DASHBOARD_VALIDATION_FIELD).isDisplayed());

		driver.switchTo().frame("advertisement");

		driver.findElement(By.xpath("//div[@id='ad_three']")).click();

		driver.switchTo().frame("portals");
		driver.findElement(By.xpath("//*[@id=\"portal_two\"]")).click();

		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//*[@id=\"ad_four\"]")).click();
	}

}
