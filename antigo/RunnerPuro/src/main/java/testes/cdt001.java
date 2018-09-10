package testes;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;

import config.WebDriverRunner;
import driver.DriverFactory;
import iu.constantes.UrlPaginas;
import iu.pageobjects.LoginPag;

@RunWith(WebDriverRunner.class)
public class cdt001 {

	@Test
	public void login() throws InterruptedException {

		LoginPag.acessar();
		LoginPag.campoLogin().preencher("medico1");
		LoginPag.campoSenha().preencher("123456");
		LoginPag.botaoEntrar().clicar();
		TimeUnit.MILLISECONDS.sleep(500);
		assertEquals(DriverFactory.getDriver().getUrlAtual(), UrlPaginas.HOME);
		// fail("hey");
	}

}
