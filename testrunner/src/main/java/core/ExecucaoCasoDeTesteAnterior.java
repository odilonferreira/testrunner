package core;

import org.openqa.selenium.WebDriver;

public class ExecucaoCasoDeTesteAnterior extends Execucao {

	public ExecucaoCasoDeTesteAnterior(TesteBase cdt) {
		super(cdt);
	}

	public void executar(WebDriver webdriver) {
		bt.passos(webdriver);
	}


}
