package testSelenium;

import org.openqa.selenium.chrome.ChromeDriver;

public class TestDriver {
	private String driverUrl = "D:\\Downloads\\Programs\\chromedriver.exe";
	
	public TestDriver() {
		
	}
	public ChromeDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", driverUrl);
		return new ChromeDriver();
	}
}
