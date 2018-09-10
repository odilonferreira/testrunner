package testes;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import br.ufsc.bridge.testtools.testrunner.CasoDeTeste;

import driver.DriverFactory;
import iu.constantes.UrlPaginas;
import iu.pageobjects.LoginPag;

public class Cdt001 extends CasoDeTeste {

	@Override
	public void passos(WebDriver webdriver) {
		LoginPag.acessar();
		LoginPag.campoLogin().preencher("medico1");
		LoginPag.campoSenha().preencher("123456");
		LoginPag.botaoEntrar().clicar();
	}

	@Override
	public void asserts(WebDriver webdriver) {
		assertEquals(DriverFactory.getDriver().getUrlAtual(), UrlPaginas.HOME);
	}

}
