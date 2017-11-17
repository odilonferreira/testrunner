package iu.pageobjects;

import org.openqa.selenium.By;

import driver.DriverFactory;
import iu.componentes.Botao;
import iu.componentes.CampoTexto;
import iu.constantes.UrlPaginas;

public class LoginPag {

	private LoginPag() {

	}

	public static void acessar() {
		DriverFactory.getDriver().acessar(UrlPaginas.LOGIN);
	}

	public static CampoTexto campoLogin() {
		return new CampoTexto("username");
	}

	public static CampoTexto campoSenha() {
		return new CampoTexto("password");
	}

	public static Botao botaoEntrar() {
		return new Botao(By.xpath("//button[contains(text(), 'Entrar')]"));
	}

	public static Botao botaoCadastreSeAqui() {
		return new Botao(By.xpath("//a[contains(text(), 'Cadastre-se aqui')]"));
	}

}
