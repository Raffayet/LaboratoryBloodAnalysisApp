package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import enumeracije.Entitet;
import enumeracije.Pol;
import model.Musterija;

public class MusterijaController {
	
	public static String putanja = "bazaPodataka/testniPrimeri.csv";
	public static ArrayList<Musterija> musterije = new ArrayList<Musterija>();
	
	public static void ucitavanje(String putanja) {
		
		musterije.clear();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(putanja));
			
			String linija;
			
			try {
				while((linija = reader.readLine()) != null) {
								
					linija = linija.trim();
					String [] reci = linija.split(",");
					
					if (reci[reci.length - 1].trim().equals(Entitet.MUSTERIJA.name())) {
						
						kreiranjeMusterije(linija);
						
					}			
					}
							
				
				} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		}

	private static void kreiranjeMusterije(String linija) {
		
		String [] reci = linija.split(",");
		Date krajnjiDatum = KorisniciController.vracanjeParsiranogDatuma(reci[5].trim());
		Musterija musterija = new Musterija(reci[0].trim(), reci[1].trim(), reci[2].trim(), reci[3].trim(), reci[4].trim(), krajnjiDatum, 
					Pol.valueOf(reci[6].trim()));
		musterije.add(musterija);
		KorisniciController.licniBrojeviOsiguranika.add(musterija.getLBO());
	}
	
	public static void registracijaMusterija(String ime, String prezime, String adresa, String LBO, String telefon, String pol, String datumRodjenja) {
		
		try {
			FileWriter fw = new FileWriter(putanja, true);
			
			String upis = String.join(",", ime, prezime, adresa, LBO, telefon, datumRodjenja.toString(), pol, Entitet.MUSTERIJA.name());
			fw.write(upis + "\n");
			fw.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		ucitavanje(putanja);
	}
	
	public static String vracanjePolaNaOsnovuLBO(String LBO) {
		
		ucitavanje(putanja);
		
		for (Musterija musterija : musterije) {
			
			if (musterija.getLBO().equals(LBO)) {
				
				return musterija.getPol().name();
			}
			
		}
		
		return null;
	}
	
}
			
