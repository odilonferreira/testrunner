package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import core.ChromeDriverManager;

public class CriarAtualizaContaPag {
	
	public static WebElement radioSexoMr() {
		//String xpath = "//*[contains(@id, 'uniform-id_gender') and ancestor::label[contains(text(), 'Mrs')]]";
		return ChromeDriverManager.encontrarElemento(By.id("id_gender1"));
	}
	
	public static WebElement radioSexoMrs() {
		return ChromeDriverManager.encontrarElemento(By.id("id_gender2"));
	}
	
	public static WebElement campoFirstName() {
		return ChromeDriverManager.encontrarElemento(By.name("customer_firstname"));
	}
	
	public static WebElement campoLastName() {
		return ChromeDriverManager.encontrarElemento(By.name("customer_lastname"));
	}
	
	public static WebElement campoEmail() {
		return ChromeDriverManager.encontrarElemento(By.name("email"));
	}
	
	public static WebElement campoPassword() {
		return ChromeDriverManager.encontrarElemento(By.name("passwd"));
	}
	
	public static Select selectDiaDataNascimento() {
		return new Select(ChromeDriverManager.encontrarElemento(By.name("days")));
	}
	
	public static Select selectMesDataNascimento() {
		return new Select(ChromeDriverManager.encontrarElemento(By.name("months")));
	}
	
	public static Select selectAnoDataNascimento() {
		return new Select(ChromeDriverManager.encontrarElemento(By.name("years")));
	}
	
	public static WebElement campoAddress() {
		return ChromeDriverManager.encontrarElemento(By.name("address1"));
	}
	
	public static WebElement campoCity() {
		return ChromeDriverManager.encontrarElemento(By.name("city"));
	}
	
	public static Select selectState() {
		return new Select(ChromeDriverManager.encontrarElemento(By.name("id_state")));
	}
	
	public static WebElement campoZipPostalCode() {
		return ChromeDriverManager.encontrarElemento(By.name("postcode"));
	}
	
	public static Select selectCountry() {
		return new Select(ChromeDriverManager.encontrarElemento(By.name("id_country")));
	}
	
	public static WebElement campoHomePhone() {
		return ChromeDriverManager.encontrarElemento(By.name("phone"));
	}
	
	public static WebElement campoMobilePhone() {
		return ChromeDriverManager.encontrarElemento(By.name("phone_mobile"));
	}
	
	public static WebElement botaoRegister() {
		return ChromeDriverManager.encontrarElemento(By.name("submitAccount"));
	}
	
	public static WebElement botaoSave() {
		return ChromeDriverManager.encontrarElemento(By.name("submitAddress"));
	}
}
