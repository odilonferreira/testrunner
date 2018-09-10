package funcoes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import core.ChromeDriverManager;
import lombok.SneakyThrows;

public class Delay {
	
	@SneakyThrows
	public static void de(long timeout) {
		//WebDriver wd = ChromeDriverManager.getWebdriver();
		TimeUnit.MILLISECONDS.sleep(timeout);
	}

}
