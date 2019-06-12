package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.ChromeDriverManager;

public class MinhaContaPag {
	
	public static WebElement botaoMyWishLists() {
		String className = "lnk_wishlist";
		return ChromeDriverManager.encontrarElemento(By.className(className));
	}
	
}
