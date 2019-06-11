package pageobjects;

import org.openqa.selenium.WebDriver;

import core.ChromeDriverManager;

public class AutomationPracticePag {
	
	public static final String url = "http://automationpractice.com/index.php";

	public static void acessar(WebDriver wd) {
		ChromeDriverManager.setWebdriver(wd);
		wd.get(url);
	}

}
