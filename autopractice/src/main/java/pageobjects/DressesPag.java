package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.ChromeDriverManager;

public class DressesPag {
	
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
	
}
