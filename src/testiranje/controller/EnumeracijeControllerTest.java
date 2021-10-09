package testiranje.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import javax.swing.JComboBox;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import controller.EnumeracijeController;
import enumeracije.GrupaAnalize;

 public class EnumeracijeControllerTest {
	 
	 @Before
		void init() {
			
			System.out.println("Pokretanje testova");
		}

	@Test
	void testDobavljanjeStrucnihSprema() {
		
		assertEquals(ArrayList.class, EnumeracijeController.dobavljanjeStrucnihSprema().getClass());
	}
	
	@Test
	void testPunjenjeComboboxova() {
		
		JComboBox<String> combobox = new JComboBox<String>();
		
		ArrayList<String> lista = new ArrayList<String>();
		
		assertEquals(JComboBox.class, EnumeracijeController.punjenjeComboBoxa(combobox, lista).getClass());
	}
	
	@Test
	void PunjenjeComboboxaObjekat() {
		
		JComboBox<GrupaAnalize> combobox = new JComboBox<GrupaAnalize>();
		
		ArrayList<GrupaAnalize> lista = new ArrayList<GrupaAnalize>();
		
		assertEquals(JComboBox.class, EnumeracijeController.punjenjeComboBoxaObjekat(combobox, lista).getClass());
	}
	
	@Test
	void testDobavljanjeSpecijalizacija() {
		
		assertEquals(ArrayList.class,  EnumeracijeController.dobavljanjeSpecijalizacija().getClass());
	}

}
