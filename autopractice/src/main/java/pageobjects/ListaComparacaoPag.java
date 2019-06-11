package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.ChromeDriverManager;

public class ListaComparacaoPag {
	
	private static String xpathCardProduto(String nomeProduto) {
		String xpath = "//div[@class='comparison_infos' and descendant::img[@title='" + nomeProduto + "']]";
		return xpath;
	}
	
	public static WebElement cardProduto(String nomeProduto) {
		WebElement we = ChromeDriverManager.encontrarElemento(By.xpath(xpathCardProduto(nomeProduto)));
		return we;
	}
	
	public static WebElement botaoRemover(String nomeProduto) {
		String xpathCompleto = xpathCardProduto(nomeProduto) + "//a[@class= 'cmp_remove')]"; 
		WebElement we = ChromeDriverManager.encontrarElemento(By.xpath(xpathCardProduto(xpathCompleto)));
		return we;
	}
	
	public static WebElement botaoAddToCart(String nomeProduto) {
		String xpathCompleto = xpathCardProduto(nomeProduto) + "//a[contains(@class, 'ajax_add_to_cart_button')]"; 
		WebElement we = ChromeDriverManager.encontrarElemento(By.xpath(xpathCardProduto(xpathCompleto)));
		return we;
	}
	
	public static WebElement botaoCompare() {
		String xpath = "(//button[contains(@class, 'bt_compare')])[1]"; 
		WebElement we = ChromeDriverManager.encontrarElemento(By.xpath(xpath));
		return we;
	}
}
