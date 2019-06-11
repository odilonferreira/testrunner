package cenario1.testesComTestrunner;

import org.openqa.selenium.WebDriver;

import annotations.PreRequisito;
import core.TesteBase;
import pageobjects.CarrinhoPag;
import pageobjects.CriarAtualizaContaPag;
import verificador.Verificar;

@PreRequisito(CDT03.class)
public class CDT04 extends TesteBase{

	@Override
	public void passos(WebDriver webdriver) {
		CarrinhoPag.aumentarQuantidadeDoProduto(2);
		CarrinhoPag.botaoProceder().click();
		CarrinhoPag.botaoUpdateDeliveryAddress().click();
		CriarAtualizaContaPag.campoHomePhone().sendKeys("1234567890");
		CriarAtualizaContaPag.campoMobilePhone().clear();
		CriarAtualizaContaPag.campoMobilePhone().sendKeys("789654123");
		CriarAtualizaContaPag.botaoSave().click();
	}

	@Override
	public void asserts(WebDriver webdriver) {
		Verificar.seTelefoneFixoDoEnderecoDeEntregaFoiAtualizadoCom("1234567890");
		Verificar.seTelefoneMovelDoEnderecoDeEntregaFoiAtualizadoCom("789654123");
		
	}

}
