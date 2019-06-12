package cenario2.testesSemTestrunner;

import org.openqa.selenium.WebDriver;

import annotations.PreRequisito;
import core.TesteBase;
import pageobjects.CarrinhoPag;
import pageobjects.CriarAtualizaContaPag;
import verificador.Verificar;

@PreRequisito(CDT08.class)
public class CDT09 extends TesteBase{

	@Override
	public void passos(WebDriver webdriver) {
		CriarAtualizaContaPag.campoFirstName().sendKeys("Bar");
		CriarAtualizaContaPag.campoLastName().sendKeys("Foo");
		CriarAtualizaContaPag.campoPassword().sendKeys("12345");
		CriarAtualizaContaPag.botaoRegister().click();
		CarrinhoPag.botaoRemoverProdutoCarrinho("Faded Short Sleeve T-shirts").click();
		CarrinhoPag.botaoRemoverProdutoCarrinho("Blouse").click();
	}
	
	@Override
	public void asserts(WebDriver webdriver) {
		Verificar.seCarrinhoEstaVazio();
	}

}
