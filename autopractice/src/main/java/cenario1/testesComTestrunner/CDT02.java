package cenario1.testesComTestrunner;

import org.openqa.selenium.WebDriver;

import annotations.PreRequisito;
import constantes.Cores;
import core.TesteBase;
import funcoes.Delay;
import pageobjects.ConfirmacaoMenuPag;
import pageobjects.DetalhesDressesPag;
import pageobjects.DressesPag;
import verificador.Verificar;


@PreRequisito(CDT01.class)
public class CDT02 extends TesteBase{

	@Override
	public void passos(WebDriver webdriver) {
		DressesPag.botaoMore(3).click();
		DetalhesDressesPag.aumentarQuantidadeDoProduto(2);
		DetalhesDressesPag.selectTamanho().selectByVisibleText("M");
		DetalhesDressesPag.botaoCorProduto(Cores.VERDE).click();
		DetalhesDressesPag.botaoAdicionarAoCarrinho().click();
		Delay.de(1500);
		ConfirmacaoMenuPag.botaoProceder().click();
		
	}
	
	@Override
	public void asserts(WebDriver webdriver) {
		Verificar.seTotalDaCompraEhDe("51.20");
		
	}


}
