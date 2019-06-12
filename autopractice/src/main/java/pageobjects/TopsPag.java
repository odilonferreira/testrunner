package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.ChromeDriverManager;

public class TopsPag {
	
	private static String xpathCardProduto(String nomeProduto) {
		String xpath = "//div[@class='product-container' and descendant::img[@title='" + nomeProduto + "']]";
		return xpath;
	}
	
	public static WebElement cardProduto(String nomeProduto) {
		WebElement we = ChromeDriverManager.encontrarElemento(By.xpath(xpathCardProduto(nomeProduto)));
		return we;
	}
	
	public static WebElement botaoAddToWishlist(String nomeProduto) {
		String xpathCompleto = xpathCardProduto(nomeProduto) + "//a[contains(@class, 'addToWishlist')]"; 
		WebElement we = ChromeDriverManager.encontrarElemento(By.xpath(xpathCardProduto(xpathCompleto)));
		return we;
	}
	
	public static WebElement botaoAddToCompare(String nomeProduto) {
		String xpathCompleto = xpathCardProduto(nomeProduto) + "//a[contains(@class, 'add_to_compare')]"; 
		WebElement we = ChromeDriverManager.encontrarElemento(By.xpath(xpathCompleto));
		return we;
	}
	
	public static WebElement botaoCompare() {
		String xpath = "(//button[contains(@class, 'bt_compare')])[1]"; 
		WebElement we = ChromeDriverManager.encontrarElemento(By.xpath(xpath));
		return we;
	}
}
