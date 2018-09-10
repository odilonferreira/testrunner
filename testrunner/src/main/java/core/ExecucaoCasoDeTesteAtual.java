package core;

import org.openqa.selenium.WebDriver;

public class ExecucaoCasoDeTesteAtual extends Execucao {

	public ExecucaoCasoDeTesteAtual(TesteBase cdt) {
		super(cdt);
	}

	public void executar(WebDriver webdriver) {
		bt.passos(webdriver);
		bt.asserts(webdriver);
	}

}
