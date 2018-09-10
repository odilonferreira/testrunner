package core;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

public class OdilonRunner extends Runner{
	
	private Class<?> testClass;
	private Description desc;

	public OdilonRunner(Class<?> testClass) throws InitializationError {
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
		
		if(!desc.getTestClass().getSimpleName().startsWith("CDT")) {
			rn.fireTestFailure(new Failure(desc, new Exception("O teste não começa com CDT")));
		}
		
		rn.fireTestStarted(this.desc);
		rn.fireTestFinished(this.desc);
		
	}

}
