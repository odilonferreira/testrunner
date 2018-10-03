package testes;

import org.openqa.selenium.WebDriver;

import constantes.CategoriasMenu;
import core.ChromeDriverManager;
import core.TesteBase;
import funcoes.Delay;
import pageobjects.AutomationPracticePag;
import pageobjects.DetalhesDressesPag;
import pageobjects.DressesPag;
import pageobjects.MenuPrincipal;
import pageobjects.MenuSuperior;
import verificador.Verificar;

public class CDT01 extends TesteBase{


	public void passos(WebDriver webdriver) {
		AutomationPracticePag.acessar();
		ChromeDriverManager.moverMouseAte(MenuPrincipal.botaoCategoria(CategoriasMenu.DRESSES));
		MenuPrincipal.botaoSubcategoria(CategoriasMenu.SUMMER_DRESSES).click();
		DressesPag.botaoModoList().click();
		//DressesPag.botaoMore(1).click();
		//DetalhesDressesPag.aumentarQuantidadeDoProduto(2);
		//DetalhesDressesPag.selectTamanho().selectByVisibleText("M");

	}
	
	@Override
	public void asserts(WebDriver webdriver) {
		Verificar.seProdutoTemDescontoDe(2, "20");
		//Verificar.seElementoContemTexto(DressesPag.botaoMore(1), "More");
		//Verificar.seElementoEstaVisivel(we);
		
	}

}
