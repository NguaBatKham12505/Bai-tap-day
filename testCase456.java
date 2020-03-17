package test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testCase456 {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@Test(enabled = true)
	public void Testcase4() throws InterruptedException {
		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");

		Thread.sleep(5000);
		// Xac dinh cac nut click
		WebElement o1 = driver.findElement(By.xpath("//li[text()='1']"));
		WebElement o2 = driver.findElement(By.xpath("//li[text()='2']"));
		WebElement o3 = driver.findElement(By.xpath("//li[text()='3']"));

		// Thao tac click cac nut
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).click(o1).click(o2).click(o3).build().perform();

		// Verify cac nut da duoc chon hay chua & tim ra nut chua chon duoc

		String chuoi = "ui-state-default ui-selectee ui-selected";// gia tri class cac o duoc chon
		boolean a = o1.getAttribute("class").equals(chuoi);
		boolean b = o2.getAttribute("class").equals(chuoi);
		boolean c = o3.getAttribute("class").equals(chuoi);

		if (a == true && b == true && c == true) {
			System.out.println("Cac o da duoc chon");
		} else {
			System.out.println("Co o chưa duoc chon");
		}

		Thread.sleep(10000);
	}

	@Test(enabled = false)
	public void TestCase5() throws InterruptedException {
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

		Thread.sleep(5000);

		WebElement chuotphai = driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions action = new Actions(driver);
		action.contextClick(chuotphai).build().perform();

		// Verify menu hien thi
		WebElement menu = driver.findElement(By.xpath("//ul[@class='context-menu-list context-menu-root']"));
		boolean b = menu.isDisplayed();
		System.out.println("menu da duoc hien thi:" + b);

		// Verify linked: copy
		driver.findElement(By.xpath("//span[text()='Copy']")).click();
		Alert alert = driver.switchTo().alert();
		String altContent = alert.getText();
		System.out.println("Ket qua verify:");
		assertEquals(altContent, "Clicked: copy", " So sanh chua dung");

		Thread.sleep(10000);
	}

	@Test(enabled = false)
	public void TestCase6() throws InterruptedException {
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/angular");

		Thread.sleep(5000);

		// scroll den 1 element cu the
		WebElement phantuscroll = driver.findElement(By.xpath("//div[@class='demo-section k-content']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", phantuscroll);

		Thread.sleep(10000);

		// Thuc hien thao tac keo tha
		WebElement tronnho = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement tronlon = driver.findElement(By.xpath("//div[@id='droptarget']"));
		Actions action = new Actions(driver);
		action.clickAndHold(tronnho).build().perform(); // Click and hold vong nho
		action.moveToElement(tronlon).release().perform();// keo den vong lon

		Thread.sleep(10000);

		// Verify
		String ms = tronlon.getText();
		assertEquals(ms, "you did great!", "thong bao chua dung");
		System.out.println("Text la:" + ms);

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
