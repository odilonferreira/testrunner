package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.ChromeDriverManager;

public class LoginPag {
	
	public static WebElement campoEmailCriarConta() {
		return ChromeDriverManager.encontrarElemento(By.name("email_create"));
	}
	
	public static WebElement botaoCreateAnAccount() {
		return ChromeDriverManager.encontrarElemento(By.name("SubmitCreate"));
	}
	
	public static WebElement campoEmailLogar() {
		return ChromeDriverManager.encontrarElemento(By.name("email"));
	}
	
	public static WebElement campoSenhaLogar() {
		return ChromeDriverManager.encontrarElemento(By.name("passwd"));
	}
	
	public static WebElement botaoSignIn() {
		return ChromeDriverManager.encontrarElemento(By.name("SubmitLogin"));
	}
	
}
