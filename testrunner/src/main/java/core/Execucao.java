package core;

import org.openqa.selenium.WebDriver;

import lombok.Getter;

public abstract class Execucao {
	
	@Getter
	protected TesteBase bt; 
	
	public Execucao (TesteBase bt) {
		this.bt = bt;
	}
	
	public abstract void executar(WebDriver driver);
	
}
