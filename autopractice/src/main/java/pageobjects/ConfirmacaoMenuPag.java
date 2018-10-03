package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import constantes.Cores;
import core.ChromeDriverManager;

public class ConfirmacaoMenuPag {
	
	public static WebElement botaoProceder() {
		String xpath = "(//span[@title='Proceed to checkout']";
		return ChromeDriverManager.encontrarElemento(By.xpath(xpath));
	}
	
	public static WebElement botaoVoltarParaShopping() {
		String xpath = "(//span[@title='Continue shopping']";
		return ChromeDriverManager.encontrarElemento(By.xpath(xpath));
	}
	
}
