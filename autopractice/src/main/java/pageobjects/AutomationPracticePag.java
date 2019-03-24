package pageobjects;

import core.ChromeDriverManager;

public class AutomationPracticePag {
	
	public static final String url = "http://automationpractice.com/index.php";

	public static void acessar() {
		ChromeDriverManager.getWebdriver().get(url);
	}

}
