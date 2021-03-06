package com.housingboard.test.junit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class LoginTest {
	WebDriver driver;
	@Before
	public void openLoginPage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/HousingBoard/login.jsp");
		Assert.assertEquals("HousingBoard Login", driver.getTitle());
	}
	@Test
	public void checkLogin() throws InterruptedException{
		WebElement radio = driver.findElement(By.id("type-member"));
		radio.click();
		Thread.sleep(2000);
		WebElement email = driver.findElement(By.id("email_id"));
		email.sendKeys("pra@gmail.com");
		Thread.sleep(2000);
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("12");
		Thread.sleep(2000);
		WebElement submit = driver.findElement(By.name("submit"));
		submit.click();
		Assert.assertEquals("Member - Home Page", driver.getTitle());
	}

	@After
	public void closePage(){
		driver.quit();
	}
}