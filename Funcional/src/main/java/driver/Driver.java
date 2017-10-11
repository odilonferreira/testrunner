package driver;

import java.util.LinkedList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.ufsc.bridge.testtools.browser.DriverListener;
import br.ufsc.bridge.testtools.testrunner.exceptions.LoadPageException;

public class Driver {

	protected WebDriver wd;
	protected String idHandleMaster;
	protected String idHandleAtual;
	private LinkedList<DriverListener> startListeners;
	private LinkedList<DriverListener> quitListeners;
	private static final int TIMEOUT_DEFAULT = 10;

	public Driver() {
		this.startListeners = new LinkedList();
		this.quitListeners = new LinkedList();
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

	public WebElement getElementoSemEspera(By by) {
		return this.wd.findElement(by);
	}

}
