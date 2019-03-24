package testes;

import org.openqa.selenium.WebDriver;

import constantes.CategoriasMenu;
import core.ChromeDriverManager;
import core.TesteBase;
import pageobjects.AutomationPracticePag;
import pageobjects.DressesPag;
import pageobjects.MenuPrincipal;
import verificador.Verificar;

public class CDT01 extends TesteBase{

	public void passos(WebDriver webdriver) {
		AutomationPracticePag.acessar();
		ChromeDriverManager.moverMouseAte(MenuPrincipal.botaoCategoria(CategoriasMenu.DRESSES));
		MenuPrincipal.botaoSubcategoria(CategoriasMenu.SUMMER_DRESSES).click();
		DressesPag.botaoModoList().click();
	}
	
	@Override
	public void asserts(WebDriver webdriver) {
		Verificar.seProdutoTemDescontoDe(2, "20");
	}

}
