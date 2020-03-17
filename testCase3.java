package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testCase3 {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

	}

	@Test(enabled = true)
	public void Testcase3() throws InterruptedException {
		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");

		Actions action = new Actions(driver);
		WebElement so1 = driver.findElement(By.xpath("//li[text()='1']"));
		action.clickAndHold(so1).build().perform();

		Thread.sleep(5000);

		WebElement so4 = driver.findElement(By.xpath("//li[text()='4']"));
		action.moveToElement(so4).release().perform();

		Thread.sleep(5000);

		String Chuoiss = "ui-state-default ui-selectee ui-selected";
		boolean a = so1.getAttribute("class").equals(Chuoiss);
		boolean b = so1.getAttribute("class").equals(Chuoiss);

		if (a == true && b == true) {
			System.out.println("Tu 1 den 4 da duoc chon");
		} else {
			System.out.println("tu 1 den 4 khong duoc chon");
		}

	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		driver.quit();
	}

}
