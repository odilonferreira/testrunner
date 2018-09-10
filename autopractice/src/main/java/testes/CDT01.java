package testes;

import org.openqa.selenium.WebDriver;

import constantes.CategoriasMenu;
import core.ChromeDriverManager;
import core.TesteBase;
import funcoes.Delay;
import pageobjects.AutomationPracticePag;
import pageobjects.MenuPrincipal;
import pageobjects.MenuSuperior;

public class CDT01 extends TesteBase{


	public void passos(WebDriver webdriver) {
		AutomationPracticePag.acessar();
		ChromeDriverManager.moverMouseAte(MenuPrincipal.botaoCategoria(CategoriasMenu.DRESSES));
		ChromeDriverManager.encontrarElemento(MenuPrincipal.botaoSubcategoria(CategoriasMenu.SUMMER_DRESSES)).click();
		

	}
	
	@Override
	public void asserts(WebDriver webdriver) {
		// TODO Auto-generated method stub
		
	}

}
