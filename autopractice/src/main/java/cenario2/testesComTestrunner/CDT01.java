package cenario2.testesComTestrunner;

import org.openqa.selenium.WebDriver;

import constantes.CategoriasMenu;
import core.ChromeDriverManager;
import core.TesteBase;
import pageobjects.AutomationPracticePag;
import pageobjects.DressesPag;
import pageobjects.MenuPrincipal;
import pageobjects.TopsPag;
import verificador.Verificar;

public class CDT01 extends TesteBase{

	@Override
	public void passos(WebDriver webdriver) {
		ChromeDriverManager.setWebdriver(webdriver);
		AutomationPracticePag.acessar(webdriver);
		ChromeDriverManager.moverMouseAte(MenuPrincipal.botaoCategoria(CategoriasMenu.WOMEN));
		MenuPrincipal.botaoSubcategoria(CategoriasMenu.TOPS).click();
		ChromeDriverManager.moverMouseAte(TopsPag.cardProduto("Faded Short Sleeve T-shirts"));
	}
	
	@Override
	public void asserts(WebDriver webdriver) {
		Verificar.seProdutoTemDescontoDe(2, "20");
	}

}
