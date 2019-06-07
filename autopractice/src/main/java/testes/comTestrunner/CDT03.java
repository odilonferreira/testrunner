package testes.comTestrunner;

import org.openqa.selenium.WebDriver;

import annotations.IsFinal;
import annotations.PreRequisito;
import core.TesteBase;
import fluxos.PreencherFormularioCadastroUsuario;
import funcoes.GerarEmailRandomico;
import pageobjects.LoginPag;
import pageobjects.MenuSuperior;
import verificador.Verificar;

@PreRequisito(CDT02.class)
public class CDT03 extends TesteBase{

	@Override
	public void passos(WebDriver webdriver) {
		MenuSuperior.botaoSignIn().click();
		LoginPag.campoEmailCriarConta().sendKeys(GerarEmailRandomico.doit() + "@gmail.com");
		LoginPag.botaoCreateAnAccount().click();
		PreencherFormularioCadastroUsuario.run();
		
	}

	@Override
	public void asserts(WebDriver webdriver) {
		Verificar.seExisteUsuarioLogado();
		Verificar.seUsuarioLogadoPossuiNome("Bar Foo");
		
	}

}
