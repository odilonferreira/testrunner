package verificador;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.ChromeDriverManager;

public class Verificar {
	
	private static String descontoProduto(int linhaProduto) {
		String xpath = "(//*[@class='price-percent-reduction' and ancestor::div[contains(@class, 'right-block')]])[" + linhaProduto + "]";
		String desconto = ChromeDriverManager.encontrarElemento(By.xpath(xpath)).getText();
		System.out.println(desconto);
		return desconto;
	}
	
	public static void seProdutoTemDescontoDe(int linhaProduto, String desconto) {
		Assert.assertTrue(descontoProduto(linhaProduto).contains(desconto));
	}
	
	public static void seExisteAlgumProdutoComDesconto() {
		String xpath = "span[@class='discount']";
		Assert.assertTrue(ChromeDriverManager.encontrarElemento(By.xpath(xpath)).isDisplayed());
	}
	
	public static void seElementoContemTexto(WebElement we, String texto) {
		Assert.assertTrue(we.getText().contains(texto));
	}
	
	public static void seElementoTemTexto(WebElement we, String texto) {
		Assert.assertTrue(we.getText().equals(texto));
	}
	
	public static void seElementoEstaVisivel(WebElement we) {
		Assert.assertTrue(we.isDisplayed());
	}
	
	public static void seElementoEstaHabilitado(WebElement we) {
		Assert.assertTrue(we.isEnabled());
	}
	
	public static void seElementoEstaSelecionado(WebElement we) {
		Assert.assertTrue(we.isSelected());
	}

}
