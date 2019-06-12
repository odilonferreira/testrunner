package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.ChromeDriverManager;

public class ConfirmacaoMenuPag {
	
	public static WebElement botaoProceder() {
		String xpath = "//a[@title='Proceed to checkout']";
		return ChromeDriverManager.encontrarElemento(By.xpath(xpath));
	}
	
	public static WebElement botaoVoltarParaShopping() {
		String xpath = "//span[@title='Continue shopping']";
		return ChromeDriverManager.encontrarElemento(By.xpath(xpath));
	}
	
}
