package cenario2.testesComTestrunner;

import org.openqa.selenium.WebDriver;

import constantes.CategoriasMenu;
import core.ChromeDriverManager;
import core.TesteBase;
import pageobjects.AutomationPracticePag;
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
		TopsPag.botaoAddToCompare("Faded Short Sleeve T-shirts").click();
		ChromeDriverManager.moverMouseAte(TopsPag.cardProduto("Blouse"));
		TopsPag.botaoAddToCompare("Blouse").click();
		
	}
	
	@Override
	public void asserts(WebDriver webdriver) {
		Verificar.quantosProdutosExistemNaListaDeComparacao(2);
	}

}
