package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.ChromeDriverManager;

public class MenuSuperior {
	
	public static final String url = "http://automationpractice.com/index.php";

	public static void acessar() {
		ChromeDriverManager.getWebdriver().get(url);
	}
	
	public static By botaoContactUs() {
		String id = "contact-link";
		//WebElement we = By.id(id).
		return By.id(id);
	}
	
	public static By botaoSignIn() {
		String className = "login";
		return By.className(className);
	}
	
}
