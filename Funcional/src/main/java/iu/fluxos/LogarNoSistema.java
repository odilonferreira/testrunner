package iu.fluxos;

import org.openqa.selenium.TimeoutException;

import br.ufsc.bridge.testtools.docextractor.ArtefatoEnum;
import br.ufsc.bridge.testtools.docextractor.annot.Artefato;
import br.ufsc.bridge.testtools.testrunner.Fluxo;
import br.ufsc.bridge.testtools.testrunner.exceptions.LoadPageException;

import driver.Driver;
import driver.DriverFactory;
import iu.constantes.UrlPaginas;
import iu.constantes.UsuarioDto;
import iu.pageobjects.LoginPag;

/**
 * @titulo Logar no sistema
 *
 * @passo Acessar a URL do sistema
 * @passo Preencher o login do usuário
 * @passo Preencher a senha do usuário
 * @passo Clicar em 'Entrar'
 */

@Artefato(ArtefatoEnum.FLUXO)
public class LogarNoSistema extends Fluxo {

	public static void com(UsuarioDto user) {
		Driver driver = DriverFactory.getDriver();
		String username = user.getLogin();
		String senha = user.getSenha();
		LogarNoSistema.com(driver, username, senha);
	}

	public static void com(Driver driver, String username, String senha) {
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
