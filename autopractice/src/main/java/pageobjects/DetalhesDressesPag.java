package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import core.ChromeDriverManager;

public class DetalhesDressesPag {
	
	public static WebElement botaoAumentarQuantidadeProduto() {
		String xpath = "//a[descendant::i[@class='icon-plus']]";
		return ChromeDriverManager.encontrarElemento(By.xpath(xpath));
	}
	
	public static WebElement botaoDiminuirQuantidadeProduto() {
		String xpath = "//a[descendant::i[@class='icon-minus']]";
		return ChromeDriverManager.encontrarElemento(By.xpath(xpath));
	}
	
	public static void aumentarQuantidadeDoProduto(int qnt) {
		for(int c = 0; c < qnt; c++) {
			botaoAumentarQuantidadeProduto().click();
		}
	}
	
	public static WebElement botaoMore(int linhaProduto) {
		String xpath = "(//span[text()='More' and ancestor::div[@class='product-container']])[" + linhaProduto + "]";
		return ChromeDriverManager.encontrarElemento(By.xpath(xpath));
	}
	
	public static WebElement campoQuantidade() {
		return ChromeDriverManager.encontrarElemento(By.name("qty"));
	}
	
	public static Select selectTamanho() {
		return new Select(ChromeDriverManager.encontrarElemento(By.name("group_1")));
	}
	
	public static WebElement botaoCorProduto(String cor) {
		return ChromeDriverManager.encontrarElemento(By.name(cor));
	}
	
	public static WebElement botaoAdicionarAoCarrinho() {
		return ChromeDriverManager.encontrarElemento(By.name("Submit"));
	}
	
}
