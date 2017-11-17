package iu.fluxos;

import org.openqa.selenium.TimeoutException;

import br.ufsc.bridge.testtools.testrunner.Fluxo;
import br.ufsc.bridge.testtools.testrunner.exceptions.LoadPageException;

import driver.DriverFactory;
import iu.constantes.UrlPaginas;
import iu.constantes.UsuarioDto;
import iu.pageobjects.LoginPag;

public class LogarNoSistema extends Fluxo {

	public static void com(UsuarioDto user) {
		String username = user.getLogin();
		String senha = user.getSenha();
		LogarNoSistema.com(username, senha);
	}

	public static void com(String username, String senha) {
		try {
			acessarPaginaLogin();
		} catch (TimeoutException t) {
			throw new LoadPageException(t);
		}

		LoginPag.campoLogin().preencher(username);
		LoginPag.campoSenha().preencher(senha);
		LoginPag.botaoEntrar().clicar();

	}

	private static void acessarPaginaLogin() {
		if (!DriverFactory.getDriver().getUrlAtual().startsWith(UrlPaginas.LOGIN)) {
			LoginPag.acessar();
		}
	}
}
