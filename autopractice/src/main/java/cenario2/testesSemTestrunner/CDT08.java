package cenario2.testesSemTestrunner;

import org.openqa.selenium.WebDriver;

import constantes.CamposMensagemDeErro;
import core.TesteBase;
import funcoes.GerarEmailRandomico;
import pageobjects.CriarAtualizaContaPag;
import pageobjects.LoginPag;
import pageobjects.MenuSuperior;
import verificador.Verificar;

public class CDT08 extends TesteBase{

	@Override
	public void passos(WebDriver webdriver) {
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
		
	}
	
	@Override
	public void asserts(WebDriver webdriver) {
		Verificar.seHaAlertaErroParaCampo(CamposMensagemDeErro.FIRST_NAME);
		Verificar.seHaAlertaErroParaCampo(CamposMensagemDeErro.LAST_NAME);
		Verificar.seHaAlertaErroParaCampo(CamposMensagemDeErro.PASSWORD);
	}

}
