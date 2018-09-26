package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.ChromeDriverManager;

public class MenuPrincipal {
	
	public static final String url = "http://automationpractice.com/index.php";

	public static void acessar() {
		ChromeDriverManager.getWebdriver().get(url);
	}
	
	public static WebElement botaoCategoria(int categoria) {
		String xpath = "(//div[@id='block_top_menu']/ul/li)[" + categoria + "]";
		WebElement we = ChromeDriverManager.encontrarElemento(By.xpath(xpath));
		return we;
	}
	
	public static WebElement botaoSubcategoria(int subcategoria) {
		//String xpath = "//div[@id='block_top_menu']//a[@title='Women']";
		String xpath = "(//div[@id='block_top_menu']/descendant::a[@href='http://automationpractice.com/index.php?id_category=" + subcategoria + "&controller=category'])[2]";
		WebElement we = ChromeDriverManager.encontrarElemento(By.xpath(xpath));
		return we;
	}
	
	public static WebElement botaoSubcategoriaSummerDresses() {
		String xpath = "//div[@id='block_top_menu']//a[@title='T-shirts']";
		WebElement we = ChromeDriverManager.encontrarElemento(By.xpath(xpath));
		return we;
	}
	
}
