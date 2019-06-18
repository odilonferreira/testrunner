package cenario2.testesSemTestrunner;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import constantes.CategoriasMenu;
import core.ChromeDriverManager;
import funcoes.GerarEmailRandomico;
import pageobjects.AutomationPracticePag;
import pageobjects.CarrinhoPag;
import pageobjects.ConfirmacaoMenuPag;
import pageobjects.CriarAtualizaContaPag;
import pageobjects.ListaComparacaoPag;
import pageobjects.LoginPag;
import pageobjects.MenuPrincipal;
import pageobjects.MenuSuperior;
import pageobjects.MinhaContaPag;
import pageobjects.TShirtsPag;
import pageobjects.TopsPag;
import verificador.Verificar;

public class CDT10 {

	@Test
	public void teste10() {
		ChromeDriverManager cdm = new ChromeDriverManager();
		WebDriver wd = cdm.createWebDriver();
		cdm.setWebdriver(wd);
		AutomationPracticePag.acessar(wd);
		ChromeDriverManager.moverMouseAte(MenuPrincipal.botaoCategoria(CategoriasMenu.WOMEN));
		MenuPrincipal.botaoSubcategoria(CategoriasMenu.TOPS).click();
		ChromeDriverManager.moverMouseAte(TopsPag.cardProduto("Faded Short Sleeve T-shirts"));
		TopsPag.botaoAddToCompare("Faded Short Sleeve T-shirts").click();
		ChromeDriverManager.moverMouseAte(TopsPag.cardProduto("Blouse"));
		TopsPag.botaoAddToCompare("Blouse").click();
		
		TopsPag.botaoCompare().click();
		ListaComparacaoPag.botaoAddToCart("Faded Short Sleeve T-shirts").click();
		ConfirmacaoMenuPag.botaoVoltarParaShopping().click();
		ListaComparacaoPag.botaoAddToCart("Blouse").click();
		ConfirmacaoMenuPag.botaoVoltarParaShopping().click();
		ListaComparacaoPag.botaoRemover("Faded Short Sleeve T-shirts").click();
		ListaComparacaoPag.botaoRemover("Blouse").click();
		
		MenuSuperior.botaoSignIn().click();
		LoginPag.campoEmailCriarConta().sendKeys(GerarEmailRandomico.doit() + "@gmail.com");
		LoginPag.botaoCreateAnAccount().click();
		CriarAtualizaContaPag.campoAddress().sendKeys("BarFoo");
		CriarAtualizaContaPag.selectCountry().selectByVisibleText("United States");
		CriarAtualizaContaPag.campoCity().sendKeys("Phoenix");
		CriarAtualizaContaPag.selectState().selectByVisibleText("Arizona");
		CriarAtualizaContaPag.campoZipPostalCode().sendKeys("85050");
		CriarAtualizaContaPag.campoMobilePhone().sendKeys("0987654321");
		CriarAtualizaContaPag.botaoRegister().click();
		
		CriarAtualizaContaPag.campoFirstName().sendKeys("Bar");
		CriarAtualizaContaPag.campoLastName().sendKeys("Foo");
		CriarAtualizaContaPag.campoPassword().sendKeys("12345");
		CriarAtualizaContaPag.botaoRegister().click();
		CarrinhoPag.botaoRemoverProdutoCarrinho("Faded Short Sleeve T-shirts").click();
		CarrinhoPag.botaoRemoverProdutoCarrinho("Blouse").click();
		
		ChromeDriverManager.moverMouseAte(MenuPrincipal.botaoCategoria(CategoriasMenu.WOMEN));
		MenuPrincipal.botaoSubcategoria(CategoriasMenu.TSHIRTS).click();
		ChromeDriverManager.moverMouseAte(TShirtsPag.cardProduto("Faded Short Sleeve T-shirts"));
		TShirtsPag.botaoAddToWishlist("Faded Short Sleeve T-shirts").click();
		TShirtsPag.botaoFecharNotifyWishList().click();
		MenuSuperior.botaoMenuUsuario().click();
		MinhaContaPag.botaoMyWishLists().click();
		
		Verificar.seHaUmaListaDeDesejosCriada();
	}
	
}
