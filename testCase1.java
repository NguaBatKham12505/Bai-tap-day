package test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testCase1 {
	WebDriver driver;
	String Chuoi;

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");

		Thread.sleep(10000);

		Chuoi = driver.findElement(By.xpath("//h3[text()='Basic Auth']//following-sibling::p")).getText();
	}

	@Test(enabled = true)
	public void Testcase1() throws InterruptedException {
		System.out.println("Verify Congratulations! You must have the proper credentials:");
		assertEquals(Chuoi, "Congratulations! You must have the proper credentials.");
		Thread.sleep(10000);
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		driver.quit();
	}

}
