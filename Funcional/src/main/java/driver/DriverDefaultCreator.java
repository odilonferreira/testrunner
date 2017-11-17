package driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import br.ufsc.bridge.testtools.browser.WebDriverManager;

public class DriverDefaultCreator implements WebDriverManager {

	private WebDriver wd;

	@Override
	public WebDriver createWebDriver() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "/Documentos/ChromeDriver/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--no-proxy-server");
		options.addArguments("--disable-breakpad");
		options.addArguments("--disable-gpu-watchdog");
		options.addArguments("-incognito");

		WebDriver webdriver = new ChromeDriver(options);
		webdriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		this.wd = webdriver;

		return webdriver;
	}

	@Override
	public void closeWebDriver() {
		this.wd.close();
		this.wd.quit();
		this.wd = null;
	}

}
