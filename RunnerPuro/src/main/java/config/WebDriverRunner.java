package config;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import driver.DriverDefaultCreator;

public class WebDriverRunner extends BlockJUnit4ClassRunner {

	public WebDriverRunner(Class<?> klass) throws InitializationError {
		super(klass);
	}

	@Override
	protected void runChild(final FrameworkMethod method, RunNotifier notifier) {

		this.beforeTest();

		try {
			super.runChild(method, notifier);
		} finally {
			this.afterTest();
		}

	}

	private void beforeTest() {

		DriverDefaultCreator ddc = new DriverDefaultCreator();
		ddc.createWebDriver();

	}

	private void afterTest() {

		DriverDefaultCreator ddc = new DriverDefaultCreator();
		ddc.closeWebDriver();

	}

}
