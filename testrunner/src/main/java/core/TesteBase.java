package core;

import java.util.LinkedList;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import annotations.PreRequisito;
import lombok.SneakyThrows;

public abstract class TesteBase {

	private boolean necessarioIniciarDriver;

	@Test
	public void run() {
		LinkedList<Execucao> pilhaDeExecucao = this.getPilhaDeExecucao();
		this.executarPilhaExecucao(pilhaDeExecucao);
	}

	private void executarPilhaExecucao(LinkedList<Execucao> pilhaDeExecucao) {

		ControleDeExecucao c = ControleDeExecucao.getInstance();
		WebDriver wb = c.getWd();

		if (wb == null || necessarioIniciarDriver) {
			c.iniciaDriver();
			wb = c.getWd();
		}
		for (Execucao execucao : pilhaDeExecucao) {
			c.setUltimoTeste(execucao.getBt().getClass());
			execucao.executar(wb);
		}
		if (!c.isSuiteEmAndamento()) {
			c.finalizarWebDriver();
		}

	}

	private LinkedList<Execucao> getPilhaDeExecucao() {

		LinkedList<Execucao> pilha = new LinkedList<Execucao>();
		pilha.push(new ExecucaoCasoDeTesteAtual(this));

		Class<?> ultimoTeste = ControleDeExecucao.getInstance().getUltimoTeste();
		TesteBase testeAtual = this;
		this.necessarioIniciarDriver = true;

		while (testeAtual != null) {

			TesteBase preRequisito = this.extrairPreRequisito(testeAtual);
			if (preRequisito != null && preRequisito.getClass() != ultimoTeste) {
				pilha.push(new ExecucaoCasoDeTesteAnterior(preRequisito));
			}

			testeAtual = preRequisito;

			if (preRequisito != null && preRequisito.getClass() == ultimoTeste) {
				necessarioIniciarDriver = false;
				break;
			}

		}

		return pilha;
	}

	@SneakyThrows
	private TesteBase extrairPreRequisito(TesteBase cdt) {
		PreRequisito prerequisito = cdt.getClass().getAnnotation(PreRequisito.class);
		if (prerequisito == null) {
			return null;
		}
		Class<? extends TesteBase> cdtclass = prerequisito.value();
		return cdtclass.newInstance();

	}

	public abstract void passos(WebDriver webdriver);

	public abstract void asserts(WebDriver webdriver);

}
