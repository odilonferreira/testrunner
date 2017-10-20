package iu.componentes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driver.DriverDefaultCreator;

public class Botao extends Componente {

	WebDriver wd = DriverDefaultCreator.getWebDriver();

	public Botao(By by) {
		super(by);
	}

	public void clicar() {
		this.wd.findElement(this.by).click();
	}

}