package config;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ufsc.bridge.testtools.browser.DriverListener;
import br.ufsc.bridge.testtools.config.TesttoolsLogger;
import br.ufsc.bridge.testtools.testrunner.exceptions.LoadPageException;

public class Driver {

	protected WebDriver wd;
	protected String idHandleMaster;
	protected String idHandleAtual;
	private LinkedList<DriverListener> startListeners;
	private LinkedList<DriverListener> quitListeners;
	private boolean isClosed;
	private static final int TIMEOUT_DEFAULT = 10;

	public Driver() {
		this.startListeners = new LinkedList<>();
		this.quitListeners = new LinkedList<>();
	}

	public void addStartListeners(DriverListener listener) {
		this.startListeners.addLast(listener);
	}

	public void addQuitListeners(DriverListener listener) {
		this.quitListeners.addLast(listener);
	}

	protected void executeStartListeners() {

		for (DriverListener listener : this.startListeners) {
			listener.doit();
		}
	}

	public WebDriver getWebDriver() {
		return this.wd;
	}

	public String getUrlAtual() {
		return this.wd.getCurrentUrl();
	}

	public void acessar(String pag) {
		try {
			this.wd.get(pag);
		} catch (Exception e) {
			throw new LoadPageException(e);
		}
	}

	public boolean isClosed() {
		return this.isClosed;
	}

	public WebElement getElementoSemEspera(By by) {
		return this.wd.findElement(by);
	}

	public WebElement getElementoComEspera(By by, int tempoMaximo) {
		WebDriverWait wait = new WebDriverWait(this.wd, tempoMaximo);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return this.wd.findElement(by);
	}

	public WebElement getElementoComEspera(By by) {
		return this.getElementoComEspera(by, Driver.TIMEOUT_DEFAULT);
	}

	public WebElement getElementoComEspera(WebElement we, By by) {
		WebDriverWait wait = new WebDriverWait(this.wd, Driver.TIMEOUT_DEFAULT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return we.findElement(by);
	}

	public WebElement getElementoSemEspera(WebElement we, By by) {
		return we.findElement(by);
	}

	public String getCssValue(By by, String propertyName) {
		return this.wd.findElement(by).getCssValue(propertyName);
	}

	public void esperarPorPagina(final String url, int tempoMax) {
		WebDriverWait wait = new WebDriverWait(this.wd, tempoMax);
		ExpectedCondition<Boolean> condicao = w -> w.getCurrentUrl().startsWith(url);
		wait.until(condicao);
	}

	public void delay(int milissegundos) {
		try {
			TimeUnit.MILLISECONDS.sleep(milissegundos);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			TesttoolsLogger.log(e);
		}
	}

	public boolean existeElemento(By by) {
		return this.existeElemento(by, Driver.TIMEOUT_DEFAULT);
	}

	public boolean existeElemento(By by, int tempoMaximo) {
		try {
			this.getElementoComEspera(by, tempoMaximo);
		} catch (Exception e) {
			TesttoolsLogger.logVazio(e);
			return false;
		}
		return true;
	}

	public WebElement[] getElementosSemEspera(By by) {
		List<WebElement> listaWebElements = this.wd.findElements(by);
		WebElement[] elementos = new WebElement[listaWebElements.size()];
		int i = 0;
		for (WebElement we : listaWebElements) {
			elementos[i] = we;
			i++;
		}
		return elementos;
	}

	public WebElement[] getElementosComEspera(By by) {
		WebDriverWait wait = new WebDriverWait(this.wd, Driver.TIMEOUT_DEFAULT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		List<WebElement> listaWebElements = this.wd.findElements(by);
		WebElement[] elementos = new WebElement[listaWebElements.size()];
		int i = 0;
		for (WebElement we : listaWebElements) {
			elementos[i] = we;
			i++;
		}
		return elementos;
	}

	public void esperarPorPagina(final String url) {
		this.esperarPorPagina(url, Driver.TIMEOUT_DEFAULT);
	}

	public void esperaPorPagina(final String url, int tempoMaximo) {
		WebDriverWait wait = new WebDriverWait(this.wd, tempoMaximo);
		ExpectedCondition<Boolean> expected = w -> w.getCurrentUrl().startsWith(url);
		wait.until(expected);
	}

	public void moveMouseToElement(WebElement we, By by) {
		Actions builder = new Actions(this.wd);
		WebElement weRel = we.findElement(by);
		builder.moveToElement(weRel).build().perform();

	}

	public void moveMouseToElement(By by) {
		Actions builder = new Actions(this.wd);
		WebElement weRel = this.wd.findElement(by);
		builder.moveToElement(weRel).build().perform();

	}

}
