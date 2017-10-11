package testes;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import config.WebDriverManager;
import config.WebDriverRunner;

@RunWith(WebDriverRunner.class)
public class cdt001 {

	@Test
	public void login() throws InterruptedException {
		WebDriver webdriver = WebDriverManager.getWebDriver();
		webdriver.get("localhost:8080");
		TimeUnit.MILLISECONDS.sleep(5000);

	}

}
