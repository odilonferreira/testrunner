package config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import br.ufsc.bridge.testtools.testrunner.TestRunnerController;

public class DriverFactory {

	private DriverFactory() {

	}

	public static Driver getDriver() {

		Driver driver = new Driver();
		TestRunnerController controle = TestRunnerController.getCDTSControl();
		WebDriver webdriver = controle.getDriver();
		driver.wd = webdriver;
		driver.wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		driver.idHandleAtual = driver.wd.getWindowHandle();
		driver.idHandleMaster = driver.wd.getWindowHandle();

		return driver;
	}

}
