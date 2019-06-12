package cenario2.testesComTestrunner;

import org.openqa.selenium.WebDriver;

import annotations.PreRequisito;
import constantes.CategoriasMenu;
import core.ChromeDriverManager;
import core.TesteBase;
import pageobjects.MenuPrincipal;
import pageobjects.MenuSuperior;
import pageobjects.MinhaContaPag;
import pageobjects.TShirtsPag;
import verificador.Verificar;

@PreRequisito(CDT04.class)
public class CDT05 extends TesteBase{

	@Override
	public void passos(WebDriver webdriver) {
		ChromeDriverManager.moverMouseAte(MenuPrincipal.botaoCategoria(CategoriasMenu.WOMEN));
		MenuPrincipal.botaoSubcategoria(CategoriasMenu.TSHIRTS).click();
		ChromeDriverManager.moverMouseAte(TShirtsPag.cardProduto("Faded Short Sleeve T-shirts"));
		TShirtsPag.botaoAddToWishlist("Faded Short Sleeve T-shirts").click();
		TShirtsPag.botaoFecharNotifyWishList().click();
		MenuSuperior.botaoMenuUsuario().click();
		MinhaContaPag.botaoMyWishLists().click();
		
	}
	
	@Override
	public void asserts(WebDriver webdriver) {
		Verificar.seHaUmaListaDeDesejosCriada();
	}

}
