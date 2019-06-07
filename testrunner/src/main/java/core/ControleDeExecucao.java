package core;

import org.openqa.selenium.WebDriver;

import lombok.Getter;
import lombok.Setter;

public class ControleDeExecucao {

	@Getter
	private boolean suiteEmAndamento;
	
	@Getter
	@Setter
	private Class<?> ultimoTeste;
	
	@Getter
	private WebDriver wd;
	private WebDriverManager wdm = new WebDriverManager();
	
	private static ControleDeExecucao instante;
	
	private ControleDeExecucao() {
		this.suiteEmAndamento = false;
		
	}
	
	public void iniciaDriver() {
		if(wd != null) {
			this.finalizarWebDriver();
		}
		wd = wdm.createWebDriver();
	}
	
	public void finalizarWebDriver() {
		if(wd != null) {
			wdm.closeWebDriver();
		}
		
	}

	public static ControleDeExecucao getInstance() {
		if(instante == null) {
			instante = new ControleDeExecucao();
		}
		return instante;
	}
	
	public void setSuiteEmAndamento(boolean b) {
		suiteEmAndamento = b;
		if (!b) {
			finalizarWebDriver();
		}
	}
	
}
