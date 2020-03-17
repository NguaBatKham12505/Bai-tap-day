package test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testCase2 {
	WebDriver driver;
	WebElement discover;
	WebElement submenu;
	String Url;

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.myntra.com/");

		Thread.sleep(5000);

		Actions action = new Actions(driver);

		discover = driver.findElement(By.xpath("//a[@href=\"/shop/discover\" and @data-reactid=\"604\"]"));
		action.moveToElement(discover).build().perform();

		Thread.sleep(5000);

		submenu = driver.findElement(By.xpath("//a[contains(text(),'American Eagle')]"));
		action.moveToElement(submenu).click().perform();
		Thread.sleep(10000);

		Url = driver.getCurrentUrl();
		System.out.println(Url);

	}

	@Test(enabled = true)
	public void Testcase2() {
		System.out.println("Da chuyen trang chua:sa");
		assertEquals(Url, "https://www.myntra.com/american-eagle");
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		driver.quit();
	}

}
