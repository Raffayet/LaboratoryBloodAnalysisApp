package controller;

import java.util.ArrayList;

import javax.swing.JComboBox;

import enumeracije.GrupaAnalize;
import enumeracije.StrucnaSprema;

public class EnumeracijeController {
	
	public static ArrayList<String> dobavljanjeStrucnihSprema() {
		
		ArrayList<String> strucneSpreme = new ArrayList<String>();
		
		for (StrucnaSprema strucnaSprema : StrucnaSprema.values()) {
			
			strucneSpreme.add(strucnaSprema.name());
		}
		return strucneSpreme;
	
	}
	
	public static JComboBox<String> punjenjeComboBoxa(JComboBox<String> combobox, ArrayList<String> lista){
		
		for (String element : lista) {
			
			combobox.addItem(element);
		}
		
		return combobox;
	}
	
	public static JComboBox<GrupaAnalize> punjenjeComboBoxaObjekat(JComboBox<GrupaAnalize> combobox, ArrayList<GrupaAnalize> lista){
		
		for (GrupaAnalize element : lista) {
			
			combobox.addItem(element);
		}
		
		return combobox;
	}
	
	public static ArrayList<GrupaAnalize> dobavljanjeSpecijalizacija() {
		
		ArrayList<GrupaAnalize> specijalizacije = new ArrayList<GrupaAnalize>();
		
		for (GrupaAnalize specijalizacija : GrupaAnalize.values()) {
			
			specijalizacije.add(specijalizacija);
		}
		return specijalizacije;
	
	}
	
}
