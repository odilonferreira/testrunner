package core;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import lombok.Getter;

public class WebDriverManager {
	
	@Getter
	private static WebDriver webdriver;

	public WebDriver createWebDriver() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--no-proxy-server");
		options.addArguments("--disable-breakpad");
		options.addArguments("--disable-gpu");
		options.addArguments("--incognito");

		Map<String, Object> preferences = new Hashtable<String, Object>();
		options.setExperimentalOption("prefs", preferences);
		preferences.put("plugins.always_open_pdf_externally", Boolean.TRUE);

		webdriver = new ChromeDriver(options);
		webdriver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		return webdriver;
	}

	public void closeWebDriver() {
		webdriver.close();
		webdriver.quit();
		webdriver = null;
	}

}
