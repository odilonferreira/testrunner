package cenario1.testesSemTestrunner;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import constantes.CategoriasMenu;
import core.ChromeDriverManager;
import pageobjects.AutomationPracticePag;
import pageobjects.DressesPag;
import pageobjects.MenuPrincipal;
import verificador.Verificar;

public class CDT06 {

	@Test
	public void teste06() {
		ChromeDriverManager cdm = new ChromeDriverManager();
		WebDriver wd = cdm.createWebDriver();
		cdm.setWebdriver(wd);
		AutomationPracticePag.acessar(wd);
		ChromeDriverManager.moverMouseAte(MenuPrincipal.botaoCategoria(CategoriasMenu.DRESSES));
		MenuPrincipal.botaoSubcategoria(CategoriasMenu.SUMMER_DRESSES).click();
		DressesPag.botaoModoList().click();
		Verificar.seProdutoTemDescontoDe(2, "20");
		cdm.closeWebDriver();
	}
	
}
