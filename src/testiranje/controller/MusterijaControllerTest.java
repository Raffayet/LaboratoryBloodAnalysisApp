package testiranje.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import controller.MusterijaController;

public class MusterijaControllerTest {
	
	
	@Before
	void init() {
		
		System.out.println("Pokretanje testova");
	}

	@Test
	void testVrcanjePolaNaOsnovuLBO() {
		
		String LBO = "21452133322";
		
		if (MusterijaController.vracanjePolaNaOsnovuLBO(LBO) != null) {
			
			assertEquals(String.class, MusterijaController.vracanjePolaNaOsnovuLBO(LBO).getClass());
		}
	}

}
