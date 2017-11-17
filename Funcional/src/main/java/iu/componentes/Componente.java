package iu.componentes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driver.DriverFactory;

public abstract class Componente {

	protected By by;
	public WebDriver wd;

	public Componente(By by) {
		WebDriver wd = DriverFactory.getDriver().getWebDriver();
		this.by = by;
	}

	// public boolean estaVisivel() {
	//
	// WebElement[] elementos = this.driver.getElementoSemEspera(this.by);
	//
	// if (elementos.length > 0) {
	// return elementos[0].isDisplayed();
	// } else {
	// return false;
	// }
	//
	// }
	//
	// public boolean esperarPorVisibilidade() {
	//
	// WebElement[] elementos = this.driver.getElementosComEspera(this.by);
	//
	// if (elementos.length > 0) {
	// return elementos[0].isDisplayed();
	// } else {
	// return false;
	// }
	//
	// }
	//
	// public void trocarFoco() {
	// Actions actions = new Actions(this.driver.getWebDriver());
	// this.driver.getElementoSemEspera(this.by).click();
	// actions.sendKeys(Keys.TAB);
	// actions.build().perform();
	// }
	//
	// public void setFocus() {
	// WebElement we = this.driver.getElementoComEspera(this.by);
	// new Actions(this.driver.getWebDriver()).moveToElement(we).click().perform();
	// }

}
