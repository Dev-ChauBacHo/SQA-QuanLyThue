package testSelenium;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogin extends TestDriver{
	ChromeDriver driver = getDriver();
	
	@Test
	public void login_test() {
		driver.get("http://localhost:8080/ThueSQA/login.jsp");
		WebElement username = driver.findElement(By.name("mst"));
		username.sendKeys("12345678");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("1");
		driver.findElement(By.name("login_btn")).click();
		
		String title = driver.getTitle();
		String expect = "Trang chủ khai báo thuế";
		driver.close();
		assertEquals(expect, title);
	}
	


}
