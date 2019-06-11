package cenario1.testesSemTestrunner;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import constantes.CategoriasMenu;
import constantes.Cores;
import core.ChromeDriverManager;
import core.TesteBase;
import fluxos.PreencherFormularioCadastroUsuario;
import funcoes.Delay;
import funcoes.GerarEmailRandomico;
import pageobjects.AutomationPracticePag;
import pageobjects.CarrinhoPag;
import pageobjects.ConfirmacaoMenuPag;
import pageobjects.CriarAtualizaContaPag;
import pageobjects.DetalhesDressesPag;
import pageobjects.DressesPag;
import pageobjects.LoginPag;
import pageobjects.MenuPrincipal;
import pageobjects.MenuSuperior;
import verificador.Verificar;

public class CDT09 {

	@Test
	public void teste09() {
		ChromeDriverManager cdm = new ChromeDriverManager();
		WebDriver wd = cdm.createWebDriver();
		cdm.setWebdriver(wd);
		//cdt06
		AutomationPracticePag.acessar(wd);
		ChromeDriverManager.moverMouseAte(MenuPrincipal.botaoCategoria(CategoriasMenu.DRESSES));
		MenuPrincipal.botaoSubcategoria(CategoriasMenu.SUMMER_DRESSES).click();
		DressesPag.botaoModoList().click();
		
		//cdt07
		DressesPag.botaoMore(3).click();
		DetalhesDressesPag.aumentarQuantidadeDoProduto(2);
		DetalhesDressesPag.selectTamanho().selectByVisibleText("M");
		DetalhesDressesPag.botaoCorProduto(Cores.VERDE).click();
		DetalhesDressesPag.botaoAdicionarAoCarrinho().click();
		Delay.de(1500);
		ConfirmacaoMenuPag.botaoProceder().click();
		
		//cdt08
		MenuSuperior.botaoSignIn().click();
		LoginPag.campoEmailCriarConta().sendKeys(GerarEmailRandomico.doit() + "@gmail.com");
		LoginPag.botaoCreateAnAccount().click();
		PreencherFormularioCadastroUsuario.run();
		
		CarrinhoPag.aumentarQuantidadeDoProduto(2);
		CarrinhoPag.botaoProceder().click();
		CarrinhoPag.botaoUpdateDeliveryAddress().click();
		CriarAtualizaContaPag.campoHomePhone().sendKeys("1234567890");
		CriarAtualizaContaPag.campoMobilePhone().clear();
		CriarAtualizaContaPag.campoMobilePhone().sendKeys("789654123");
		CriarAtualizaContaPag.botaoSave().click();
		Verificar.seTelefoneFixoDoEnderecoDeEntregaFoiAtualizadoCom("1234567890");
		Verificar.seTelefoneMovelDoEnderecoDeEntregaFoiAtualizadoCom("789654123");
		
		cdm.closeWebDriver();
	}
	
}
