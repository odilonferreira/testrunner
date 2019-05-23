package core;

import org.openqa.selenium.WebDriver;

import lombok.Getter;
import lombok.Setter;

public class ExecutionController {

	@Getter
	private boolean suiteEmAndamento;
	
	@Getter
	@Setter
	private Class<?> ultimoTeste;
	
	@Getter
	private WebDriver wd;
	private WebDriverManager wdm = new WebDriverManager();
	
	private static ExecutionController instante;
	
	private ExecutionController() {
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

	public static ExecutionController getInstance() {
		if(instante == null) {
			instante = new ExecutionController();
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
