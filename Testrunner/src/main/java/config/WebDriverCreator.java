package config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import br.ufsc.bridge.testtools.browser.WebDriverManager;

public class WebDriverCreator implements WebDriverManager {

	private static WebDriver webdriver;

	public static WebDriver getWebDriver() {
		if (webdriver == null) {
			throw new RuntimeException("WebDriver não iniciado.");
		}

		return webdriver;
	}

	@Override
	public WebDriver createWebDriver() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "/Documentos/ChromeDriver/chromedriver");

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--start-maximized");
		options.addArguments("--no-proxy-server");
		options.addArguments("--disable-breakpad");
		options.addArguments("--disable-gpu-watchdog");
		options.addArguments("-incognito");

		webdriver = new ChromeDriver(options);
		webdriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

		return webdriver;
	}

	@Override
	public void closeWebDriver() {
		webdriver.quit();
	}

}
