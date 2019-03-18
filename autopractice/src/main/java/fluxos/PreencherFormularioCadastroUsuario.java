package fluxos;

import org.junit.Test;
import org.junit.runner.RunWith;
import core.Testrunner;
import pageobjects.CriarAtualizaContaPag;

@RunWith(Testrunner.class)
public class PreencherFormularioCadastroUsuario {

	@Test
	public static void run() {
		CriarAtualizaContaPag.campoFirstName().sendKeys("Bar");
		CriarAtualizaContaPag.campoLastName().sendKeys("Foo");
		CriarAtualizaContaPag.campoPassword().sendKeys("12345");
		CriarAtualizaContaPag.campoAddress().sendKeys("BarFoo");
		CriarAtualizaContaPag.selectCountry().selectByVisibleText("United States");
		CriarAtualizaContaPag.selectState().selectByVisibleText("Arizona");
		CriarAtualizaContaPag.campoCity().sendKeys("Phoenix");
		CriarAtualizaContaPag.campoZipPostalCode().sendKeys("85050");
		CriarAtualizaContaPag.campoMobilePhone().sendKeys("0987654321");
		CriarAtualizaContaPag.botaoRegister().click();
		
	}
	
}
