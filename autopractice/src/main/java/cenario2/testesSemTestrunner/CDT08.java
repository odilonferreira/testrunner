package cenario2.testesSemTestrunner;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import constantes.CamposMensagemDeErro;
import constantes.CategoriasMenu;
import core.ChromeDriverManager;
import core.TesteBase;
import funcoes.GerarEmailRandomico;
import pageobjects.AutomationPracticePag;
import pageobjects.ConfirmacaoMenuPag;
import pageobjects.CriarAtualizaContaPag;
import pageobjects.ListaComparacaoPag;
import pageobjects.LoginPag;
import pageobjects.MenuPrincipal;
import pageobjects.MenuSuperior;
import pageobjects.TopsPag;
import verificador.Verificar;

public class CDT08 {

	@Test
	public void teste08() {
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
		
		Verificar.seHaAlertaErroParaCampo(CamposMensagemDeErro.FIRST_NAME);
		Verificar.seHaAlertaErroParaCampo(CamposMensagemDeErro.LAST_NAME);
		Verificar.seHaAlertaErroParaCampo(CamposMensagemDeErro.PASSWORD);
	}

}
