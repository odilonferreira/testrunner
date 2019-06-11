package cenario1.testesSemTestrunner;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import constantes.CategoriasMenu;
import constantes.Cores;
import core.ChromeDriverManager;
import core.TesteBase;
import funcoes.Delay;
import pageobjects.AutomationPracticePag;
import pageobjects.ConfirmacaoMenuPag;
import pageobjects.DetalhesDressesPag;
import pageobjects.DressesPag;
import pageobjects.MenuPrincipal;
import verificador.Verificar;

public class CDT07 {

	@Test
	public void teste07() {
		ChromeDriverManager cdm = new ChromeDriverManager();
		WebDriver wd = cdm.createWebDriver();
		cdm.setWebdriver(wd);
		//cdt06
		AutomationPracticePag.acessar(wd);
		ChromeDriverManager.moverMouseAte(MenuPrincipal.botaoCategoria(CategoriasMenu.DRESSES));
		MenuPrincipal.botaoSubcategoria(CategoriasMenu.SUMMER_DRESSES).click();
		DressesPag.botaoModoList().click();
		
		
		DressesPag.botaoMore(3).click();
		DetalhesDressesPag.aumentarQuantidadeDoProduto(2);
		DetalhesDressesPag.selectTamanho().selectByVisibleText("M");
		DetalhesDressesPag.botaoCorProduto(Cores.VERDE).click();
		DetalhesDressesPag.botaoAdicionarAoCarrinho().click();
		Delay.de(1500);
		ConfirmacaoMenuPag.botaoProceder().click();
		Verificar.seTotalDaCompraEhDe("51.20");
		cdm.closeWebDriver();
	}
	
}
