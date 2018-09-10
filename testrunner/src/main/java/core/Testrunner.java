package core;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

public class Testrunner extends Runner{
	
	private Class<?> testClass;
	private Description desc;
	
	public Testrunner(Class<?> testClass) throws InitializationError {
		this.testClass = testClass;
	}

	@Override
	public Description getDescription() {
		desc = Description.createTestDescription(testClass, testClass.getSimpleName());
		return desc;
	}

	@Override
	public void run(RunNotifier rn) {
		rn.fireTestRunStarted(this.desc);
		rn.fireTestStarted(this.desc);
		rn.fireTestFinished(this.desc);
		
	}
	
	

}
