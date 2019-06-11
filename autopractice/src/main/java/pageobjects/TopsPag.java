package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.ChromeDriverManager;

public class TopsPag {
	
	public static WebElement botaoModoGrid() {
		String xpath = "//li[@id='grid']";
		WebElement we = ChromeDriverManager.encontrarElemento(By.xpath(xpath));
		return we;
	}
	
	public static WebElement botaoModoList() {
		String xpath = "//li[@id='list']";
		WebElement we = ChromeDriverManager.encontrarElemento(By.xpath(xpath));
		return we;
		}
	
	public static WebElement botaoMore(int linhaProduto) {
		String xpath = "(//span[text()='More' and ancestor::div[@class='product-container']])[" + linhaProduto + "]";
		WebElement we = ChromeDriverManager.encontrarElemento(By.xpath(xpath));
		return we;
	}
	
	public static By botaoSubcategoriaSummerDresses() {
		String xpath = "//div[@id='block_top_menu']//a[@title='T-shirts']";
		return By.xpath(xpath);
	}
	
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
}
