package test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import core.ExecutionController;

@RunWith(Suite.class)
@SuiteClasses({ CDT000.class, CDT001.class, CDT002.class })
public class SuiteTest {

	@BeforeClass
	public static void before() {
		ExecutionController.getInstance().setSuiteEmAndamento(true);
	}
	
	@AfterClass
	public static void after() {
		ExecutionController.getInstance().setSuiteEmAndamento(false);
	}
	
}
