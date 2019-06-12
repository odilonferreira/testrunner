package cenario1.testesComTestrunner;

import org.openqa.selenium.WebDriver;

import constantes.CategoriasMenu;
import core.ChromeDriverManager;
import core.TesteBase;
import pageobjects.AutomationPracticePag;
import pageobjects.DressesPag;
import pageobjects.MenuPrincipal;
import verificador.Verificar;

public class CDT01 extends TesteBase{

	@Override
	public void passos(WebDriver webdriver) {
		AutomationPracticePag.acessar(webdriver);
		ChromeDriverManager.moverMouseAte(MenuPrincipal.botaoCategoria(CategoriasMenu.DRESSES));
		MenuPrincipal.botaoSubcategoriaSummer().click();
		DressesPag.botaoModoList().click();
	}
	
	@Override
	public void asserts(WebDriver webdriver) {
		Verificar.seProdutoTemDescontoDe(2, "20");
	}

}
