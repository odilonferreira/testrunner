package driver;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverDefaultCreator {

	private static WebDriver webdriver;

	public static WebDriver getWebDriver() {
		if (webdriver == null) {
			throw new RuntimeException("WebDriver não iniciado.");
		}

		return webdriver;
	}

	public WebDriver createWebDriver() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "/Documentos/ChromeDriver/chromedriver");

		ChromeOptions options = new ChromeOptions();

		if (StringUtils.equals(System.getProperty("headless"), "true")) {
			options.addArguments("headless");
			options.addArguments("window-size=1200x600");
			options.addArguments("disable-gpu");
		}

		options.addArguments("--start-maximized");
		options.addArguments("--no-proxy-server");
		options.addArguments("--disable-breakpad");
		options.addArguments("--disable-gpu-watchdog");
		options.addArguments("-incognito");

		webdriver = new ChromeDriver(options);
		webdriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

		return webdriver;
	}

}