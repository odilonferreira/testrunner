package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import funcoes.Delay;

public class ChromeDriverManager extends WebDriverManager{
	
	public static WebDriverWait getWebDriverWait() {
		WebDriver webdriver = getWebdriver();
		return new WebDriverWait(webdriver, 10);
	}
	
	public static WebElement encontrarElemento(By by) {
		WebDriver wd = getWebdriver();
		WebElement we = wd.findElement(by);
		return we;
	}
	
	public static void waitVisibleElement(By locator) {
		WebDriver wd = getWebdriver();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(wd).withTimeout(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static void moverMouseAte(By by) {
		WebDriver wd = getWebdriver();
		Actions builder = new Actions(wd);
		//waitVisibleElement(by);
		WebElement visibleElement = encontrarElemento(by);
		builder.moveToElement(visibleElement).build().perform();
		Delay.de(1000);
	}
	

}
