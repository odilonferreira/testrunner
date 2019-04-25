package core;

import java.util.LinkedList;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import annotations.IsFinal;
import annotations.PreRequisito;
import lombok.SneakyThrows;

public abstract class TesteBase {
	
	private boolean necessarioIniciarDriver;
	
	@Test
	public void teste() {
		LinkedList<Execucao> pilhaDeExecucao = this.getPilhaDeExecucao();
		this.executarPilhaExecucao(pilhaDeExecucao);
	}
	
	private void executarPilhaExecucao(LinkedList<Execucao> pilhaDeExecucao) {
		
		ExecutionController c = ExecutionController.getInstance();
		WebDriver wb = c.getWd();
		
		if (wb == null || necessarioIniciarDriver) {
			c.iniciaDriver();
			wb = c.getWd();
		}
		for (Execucao execucao : pilhaDeExecucao) {
			execucao.executar(wb);
			if (!isFinal(execucao.getBt())) {
				c.setUltimoTeste(execucao.getBt().getClass());
			}
		}
		if(!c.isSuiteEmAndamento()) {
			c.finalizarWebDriver();
		}
		
	}

	private LinkedList<Execucao> getPilhaDeExecucao() {
		
		LinkedList<Execucao> pilha = new LinkedList<Execucao>();
		pilha.push(new ExecucaoCasoDeTesteAtual(this));
		
		Class<?> ultimoTeste = ExecutionController.getInstance().getUltimoTeste();
		TesteBase cdt = this;
		this.necessarioIniciarDriver = true;
		
		while(cdt != null) {
			
			TesteBase pre = this.extrairPreRequisito(cdt);
			if(pre != null && pre.getClass() != ultimoTeste) {
				pilha.push(new ExecucaoCasoDeTesteAnterior(pre));
			}
			
			cdt = pre;
			
			if(pre != null && pre.getClass() == ultimoTeste) {
				necessarioIniciarDriver = false;
				break;
			}
			
			
		}

		return pilha;
	}
	
	@SneakyThrows
	private TesteBase extrairPreRequisito(TesteBase cdt) {
		PreRequisito prerequisito = cdt.getClass().getAnnotation(PreRequisito.class);
		if(prerequisito == null) {
			return null;
		}
		Class<? extends TesteBase> cdtclass = prerequisito.value();
		return cdtclass.newInstance();
		
	}
	
	private boolean isFinal(TesteBase bt) {
		IsFinal isFinal = bt.getClass().getAnnotation(IsFinal.class);
		return isFinal != null;
	}

	public abstract void passos(WebDriver webdriver); 
	
	public abstract void asserts(WebDriver webdriver); 
	

}
