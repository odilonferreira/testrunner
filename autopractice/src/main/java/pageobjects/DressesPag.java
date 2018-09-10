package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.ChromeDriverManager;

public class DressesPag {
	
	public static final String url = "http://automationpractice.com/index.php";

	public static void acessar() {
		ChromeDriverManager.getWebdriver().get(url);
	}
	
	public static By botaoModoGrid() {
		String xpath = "//li[@id='grid']";
		return By.xpath(xpath);
	}
	
	public static By botaoModoList() {
		String xpath = "//li[@id='list']";
		return By.xpath(xpath);
	}
	
	public static By botaoSubcategoria(int subcategoria) {
		//String xpath = "//div[@id='block_top_menu']//a[@title='Women']";
		String xpath = "(//div[@id='block_top_menu']/descendant::a[@href='http://automationpractice.com/index.php?id_category=" + subcategoria + "&controller=category'])[2]";
		return By.xpath(xpath);
	}
	
	public static By botaoSubcategoriaSummerDresses() {
		String xpath = "//div[@id='block_top_menu']//a[@title='T-shirts']";
		return By.xpath(xpath);
	}
	
}
