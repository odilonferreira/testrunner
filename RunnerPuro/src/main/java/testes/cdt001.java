package testes;

import org.junit.Test;
import org.junit.runner.RunWith;

import config.WebDriverRunner;
import iu.pageobjects.LoginPag;

@RunWith(WebDriverRunner.class)
public class cdt001 {

	@Test
	public void login() throws InterruptedException {
		LoginPag.acessar();
		LoginPag.campoLogin().preencher("medico1");
		LoginPag.campoSenha().preencher("123456");
		LoginPag.botaoEntrar().clicar();
	}

}
