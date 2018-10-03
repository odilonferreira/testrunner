package core;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
public class SuiteBase {
	
	@BeforeClass
	public static void before() {
		ExecutionController.getInstance().setSuiteEmAndamento(true);
	}
	
	@AfterClass
	public static void after() {
		ExecutionController.getInstance().setSuiteEmAndamento(false);
	}

}
