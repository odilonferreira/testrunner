package test;

import org.openqa.selenium.WebDriver;

import annotations.PreRequisito;
import core.TesteBase;

@PreRequisito(CDT001.class)
public class CDT003 extends TesteBase{

	@Override
	public void passos(WebDriver webdriver) {
		System.out.println("passos cdt003");
	}

	@Override
	public void asserts(WebDriver webdriver) {
		System.out.println("asserts cdt003");
	}

}
