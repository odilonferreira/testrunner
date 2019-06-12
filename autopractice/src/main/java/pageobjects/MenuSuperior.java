package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.ChromeDriverManager;

public class MenuSuperior {
	
	public static WebElement botaoContactUs() {
		String id = "contact-link";
		return ChromeDriverManager.encontrarElemento(By.id(id));
	}
	
	public static WebElement botaoSignIn() {
		String className = "login";
		return ChromeDriverManager.encontrarElemento(By.className(className));
	}
	
	public static WebElement botaoSignOut() {
		String className = "logout";
		return ChromeDriverManager.encontrarElemento(By.className(className));
	}
	
	public static WebElement botaoMenuUsuario() {
		String className = "account";
		return ChromeDriverManager.encontrarElemento(By.className(className));
	}
	
}
