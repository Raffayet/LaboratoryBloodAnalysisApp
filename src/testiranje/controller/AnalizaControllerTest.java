package testiranje.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import controller.AnalizaController;
import model.Analiza;
import model.Zahtev;

public class AnalizaControllerTest {
	
	@Before
	void init() {
		
		System.out.println("Pokretanje testova");
	}
	
	@Test
	void testVracanjeUkupneCeneZahteva() {
		
		ArrayList<String> imenaAnaliza = new ArrayList<String>();
	
		assertNotNull(AnalizaController.vracanjeUkupneCeneZahteva(imenaAnaliza, false, false));
	}
	
	@Test
	void testVracanjeAnalize() {
		
		ArrayList<String> imenaAnaliza = new ArrayList<String>();
		
		imenaAnaliza.add("B2");
		imenaAnaliza.add("B6");
		imenaAnaliza.add("B12");
		
		assertNotNull(AnalizaController.vracanjeAnalize(imenaAnaliza));
	}
	
	@Test
	void testDobavljanjeImenaAnaliza() {
		
		assertNotNull(AnalizaController.dobavljanjeImenaAnaliza());
	}
	
	@Test
	void testVracanjeCeneNaOsnovuImenaAnalize() {
		
		String imeAnalize = "Kuvano mleko RF231";
		
		if (AnalizaController.vracanjeAnalizeNaOsnovuImena(imeAnalize) != null) {
		
		assertEquals(Analiza.class, AnalizaController.vracanjeCeneNaOsnovuImenaAnalize(imeAnalize).getClass());
	}
	}
	
	@Test
	void testVracanjeImenaAnalizaPoLaborantu() {
		
		String korisnickoImeLaboranta = "mika123";
		assertNotNull(AnalizaController.vracanjeImenaAnalizaPoLaborantu(korisnickoImeLaboranta));
	}
	
	@Test
	void testVracanjeAnalizeNaOsnovuImena() {
		
		String imeAnalize = "Vitamin B2";
		
		if (AnalizaController.vracanjeAnalizeNaOsnovuImena(imeAnalize) != null) {
		
		assertEquals(Analiza.class, AnalizaController.vracanjeAnalizeNaOsnovuImena(imeAnalize).getClass());
	}
	}
	
	@Test
	void testDobavljanjeRezultataAnaliza() {
		
		Zahtev selektovanZahtev = null;
		String imeAnalize = "B2";
		
		if (AnalizaController.vracanjeAnalizeNaOsnovuImena(imeAnalize) != null) {
			
			assertEquals(String.class, AnalizaController.dobavljanjeRezultataAnaliza(selektovanZahtev, imeAnalize).getClass());
		}
	}
}
