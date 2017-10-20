package iu.componentes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import driver.DriverDefaultCreator;

public class CampoTexto extends Componente {

	WebDriver wd = DriverDefaultCreator.getWebDriver();
	private By byInput;

	public CampoTexto(String name) {
		super(By.xpath("//div[contains(@data-name, '" + name + "')]"));
		this.byInput = By.xpath("//input[contains(@name, '" + name + "')]");
	}

	public void preencher(String texto) {
		Actions actions = new Actions(this.wd);
		actions.moveToElement(this.wd.findElement(this.byInput));
		actions.click();
		actions.sendKeys(texto);
		actions.build().perform();

	}

}