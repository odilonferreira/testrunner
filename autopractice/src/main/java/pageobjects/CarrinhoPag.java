package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.ChromeDriverManager;

public class CarrinhoPag {
	
	public static WebElement botaoProceder() {
		String xpath = "//a[@title='Proceed to checkout']";
		return ChromeDriverManager.encontrarElemento(By.xpath(xpath));
	}
	
	public static WebElement checkTermosDeServico() {
		String xpath = "//a[@title='Proceed to checkout']";
		return ChromeDriverManager.encontrarElemento(By.xpath(xpath));
	}
	
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
	
	public static WebElement botaoUpdateDeliveryAddress() {
		String xpath = "//a[ancestor::ul[@id='address_delivery']]";
		return ChromeDriverManager.encontrarElemento(By.xpath(xpath));
	}
	
	public static WebElement botaoPagamentoComCartao() {
		return ChromeDriverManager.encontrarElemento(By.className("bankwire"));
	}
	
	public static WebElement botaoPagamentoComCheque() {
		return ChromeDriverManager.encontrarElemento(By.className("cheque"));
	}
	
	public static WebElement botaoConfirmarPagamento() {
		String xpath = "//button[descendant::span[text()='I confirm my order']]";
		return ChromeDriverManager.encontrarElemento(By.xpath(xpath));
	}
	
}
