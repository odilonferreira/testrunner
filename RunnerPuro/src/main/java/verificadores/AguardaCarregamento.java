package verificadores;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ufsc.bridge.testtools.testrunner.Falha;
import br.ufsc.bridge.testtools.testrunner.Verificador;

import driver.DriverFactory;

public class AguardaCarregamento {

	private AguardaCarregamento() {

	}

	public static void daPagina(String url) {

		WebDriver wd = DriverFactory.getDriver().getWebDriver();

		try {
			WebDriverWait wait = new WebDriverWait(wd, 15);
			ExpectedCondition<Boolean> expected = w -> w.getCurrentUrl().startsWith(url);
			wait.until(expected);
		} catch (Throwable s) {
			Verificador.getColetor().addFalha(new Falha("A página " + url + " não foi carregada."));
		}

	}

}
