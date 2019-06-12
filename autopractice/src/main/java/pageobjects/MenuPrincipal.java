package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.ChromeDriverManager;

public class MenuPrincipal {
	
	public static WebElement botaoCategoria(int categoria) {
		String xpath = "(//div[@id='block_top_menu']/ul/li)[" + categoria + "]";
		WebElement we = ChromeDriverManager.encontrarElemento(By.xpath(xpath));
		return we;
	}
	
	public static WebElement botaoSubcategoria(int subcategoria) {
		String xpath = "//div[@id='block_top_menu']/descendant::a[contains(@href, 'id_category=" + subcategoria + "')]";
		WebElement we = ChromeDriverManager.encontrarElemento(By.xpath(xpath));
		return we;
	}
	
	public static WebElement botaoSubcategoriaSummer() {
		String xpath = "(//div[@id='block_top_menu']/descendant::a[@href='http://automationpractice.com/index.php?id_category=11&controller=category'])[2]";
		WebElement we = ChromeDriverManager.encontrarElemento(By.xpath(xpath));
		return we;
	}
	
}
