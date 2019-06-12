package core;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import funcoes.Delay;
import lombok.Getter;
import lombok.Setter;

public class ChromeDriverManager {
	
	@Getter
	@Setter
	private static WebDriver webdriver;
	
	public static WebElement encontrarElementoSemEspera(By by) {
		WebElement element = webdriver.findElement(by);
		return element;
	}
	
	public static WebElement encontrarElemento(By by) {
		WebDriverWait wait = new WebDriverWait(webdriver, 15);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public static List<WebElement> encontrarElementosSemEspera(By by) {
		List<WebElement> elements = webdriver.findElements(by);
		return elements;
	}
	
	public static void moverMouseAte(WebElement visibleElement) {
		Actions builder = new Actions(webdriver);
		builder.moveToElement(visibleElement).build().perform();
		Delay.de(1000);
	}
	
	public WebDriver createWebDriver() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "/chromedriver/chromedriver");

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
		webdriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		return webdriver;
	}

	public void closeWebDriver() {
		webdriver.close();
		webdriver.quit();
		webdriver = null;
	}
	

}
