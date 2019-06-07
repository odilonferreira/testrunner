package core;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
public class SuiteBase {
	
	@BeforeClass
	public static void before() {
		ControleDeExecucao.getInstance().setSuiteEmAndamento(true);
	}
	
	@AfterClass
	public static void after() {
		ControleDeExecucao.getInstance().setSuiteEmAndamento(false);
	}

}
