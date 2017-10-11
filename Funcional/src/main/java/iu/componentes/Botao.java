package iu.componentes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Botao extends Componente {

	WebDriver wd;

	public Botao(By by) {
		super(by);
	}

	public void clicar() {
		this.wd.findElement(this.by).click();
	}

}