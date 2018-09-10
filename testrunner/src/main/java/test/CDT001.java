package test;

import org.openqa.selenium.WebDriver;

import annotations.IsFinal;
import annotations.PreRequisito;
import core.TesteBase;

@PreRequisito(CDT000.class)
//@IsFinal
public class CDT001 extends TesteBase{

	@Override
	public void passos(WebDriver webdriver) {
		System.out.println("passos cdt001");
		
	}

	@Override
	public void asserts(WebDriver webdriver) {
		System.out.println("asserts cdt001");
		
	}
	

}
