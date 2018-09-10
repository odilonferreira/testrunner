package iu.componentes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driver.DriverFactory;

public class Botao extends Componente {

	WebDriver wd = DriverFactory.getDriver().getWebDriver();

	public Botao(By by) {
		super(by);
	}

	public void clicar() {
		this.wd.findElement(this.by).click();
	}

}