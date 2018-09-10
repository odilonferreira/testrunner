package driver;

import java.util.LinkedList;

import org.openqa.selenium.WebDriver;

import br.ufsc.bridge.testtools.browser.DriverListener;
import br.ufsc.bridge.testtools.testrunner.exceptions.LoadPageException;

public class Driver {

	protected WebDriver wd;
	protected String idHandleMaster;
	protected String idHandleAtual;
	private LinkedList<DriverListener> startListeners;
	private LinkedList<DriverListener> quitListeners;

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

	public void acessar(String pag) {
		try {
			this.wd.get(pag);
		} catch (Exception e) {
			throw new LoadPageException(e);
		}
	}

	public String getUrlAtual() {
		return this.wd.getCurrentUrl();
	}

}
