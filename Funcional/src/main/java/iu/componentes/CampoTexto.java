package iu.componentes;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class CampoTexto extends Componente {

	private By byInput;

	public CampoTexto(String name) {
		super(By.xpath("//div[contains(@data-name, '" + name + "')]"));
		this.byInput = By.xpath("//input[contains(@name, '" + name + "')]");
	}

	public void preencher(String texto) {
		Actions actions = new Actions(this.driver.getWebDriver());
		actions.moveToElement(this.driver.getElementoSemEspera(this.byInput));
		actions.click();
		actions.sendKeys(texto);
		actions.build().perform();

	}

}