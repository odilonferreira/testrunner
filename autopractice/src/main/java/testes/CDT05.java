package testes;

import org.openqa.selenium.WebDriver;

import annotations.IsFinal;
import annotations.PreRequisito;
import core.TesteBase;
import fluxos.PreencherFormularioCadastroUsuario;
import funcoes.GerarEmailRandomico;
import pageobjects.AutomationPracticePag;
import pageobjects.CarrinhoPag;
import pageobjects.CriarAtualizaContaPag;
import pageobjects.LoginPag;
import pageobjects.MenuSuperior;
import verificador.Verificar;

@PreRequisito(CDT04.class)
public class CDT05 extends TesteBase{

	@Override
	public void passos(WebDriver webdriver) {
		CarrinhoPag.botaoProceder().click();
		CarrinhoPag.checkTermosDeServico().click();
		CarrinhoPag.botaoProceder().click();
		CarrinhoPag.botaoPagamentoComCartao().click();
		CarrinhoPag.botaoConfirmarPagamento().click();
		
	}

	@Override
	public void asserts(WebDriver webdriver) {
		Verificar.sePagamentoFoiCompletado();
		Verificar.seCarrinhoEstaVazio();
		
	}

}
