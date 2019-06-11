package cenario2.testesComTestrunner;

import org.openqa.selenium.WebDriver;

import annotations.PreRequisito;
import core.TesteBase;
import pageobjects.ConfirmacaoMenuPag;
import pageobjects.ListaComparacaoPag;
import pageobjects.TopsPag;
import verificador.Verificar;

@PreRequisito(CDT01.class)
public class CDT02 extends TesteBase{

	@Override
	public void passos(WebDriver webdriver) {
		TopsPag.botaoCompare().click();
		ListaComparacaoPag.botaoAddToCart("Faded Short Sleeve T-shirts").click();
		ConfirmacaoMenuPag.botaoVoltarParaShopping().click();
		ListaComparacaoPag.botaoAddToCart("Blouse").click();
		ConfirmacaoMenuPag.botaoVoltarParaShopping().click();
		ListaComparacaoPag.botaoRemover("Faded Short Sleeve T-shirts").click();
		ListaComparacaoPag.botaoRemover("Blouse").click();
		
	}
	
	@Override
	public void asserts(WebDriver webdriver) {
		Verificar.seNaoHaProdutosListaComparacao();
	}

}
