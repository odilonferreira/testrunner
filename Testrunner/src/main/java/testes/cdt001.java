package testes;

import org.openqa.selenium.WebDriver;

import br.ufsc.bridge.testtools.testrunner.CasoDeTeste;

import iu.pageobjects.LoginPag;

public class cdt001 extends CasoDeTeste {

	@Override
	public void passos(WebDriver webdriver) {
		LoginPag.campoLogin().preencher("medico1");
		LoginPag.campoSenha().preencher("123456");
		LoginPag.botaoEntrar().clicar();
	}

	@Override
	public void asserts(org.openqa.selenium.WebDriver webdriver) {
		// TODO Auto-generated method stub

	}

}
