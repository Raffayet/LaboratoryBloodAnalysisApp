package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import enumeracije.Entitet;
import enumeracije.GrupaAnalize;
import model.Analiza;
import model.Laborant;
import model.Zahtev;

public class AnalizaController {
	
	public static String putanja = "bazaPodataka/testniPrimeri.csv";
	public static ArrayList<Analiza> analize = new ArrayList<Analiza>();
	public static ArrayList<String> imenaAnaliza = new ArrayList<String>();
	public static ArrayList<String> zahteviSaNasumicnomVrednoscu = new ArrayList<String>();
	
	public static void ucitavanje(String putanja) {
		
		analize.clear();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(putanja));
			
			String linija;
			
			try {
				while((linija = reader.readLine()) != null) {
								
					linija = linija.trim();
					String [] reci = linija.split(",");
					
					if (reci[reci.length - 1].trim().equals(Entitet.ANALIZA.name())) {
						
						kreiranjeAnalize(linija);
						
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

	private static void kreiranjeAnalize(String linija) {
		
		String [] reci = linija.split(",");
		Analiza analiza = new Analiza(GrupaAnalize.valueOf(reci[0].trim()), reci[1].trim(), reci[2].trim(), Double.parseDouble(reci[3].trim()), 
				Double.parseDouble(reci[4].trim()), Double.parseDouble(reci[5].trim()), Double.parseDouble(reci[6].trim()), Double.parseDouble(reci[7].trim()), reci[8].trim(), 
				Integer.parseInt(reci[9].trim())); 
		analize.add(analiza);
		
	}

	public static String vracanjeUkupneCeneZahteva(ArrayList<String> izabraneAnalize, boolean odredjenoVreme, boolean kucnaPoseta) {
		
		double ukupnaCena = 0;
		
		for (Analiza analiza : analize) {
			
			for (String imeAnalize : izabraneAnalize) {
				
				if (analiza.getImeAnalize().equals(imeAnalize)) {
					
					ukupnaCena += analiza.getCena();
				}
			}
		}
		
		
		if (odredjenoVreme == false && kucnaPoseta == false) {
			
			return String.valueOf(Math.round(ukupnaCena));
		}
		
		else if (odredjenoVreme == true && kucnaPoseta == false){
		
			return String.valueOf(Math.round(ukupnaCena));
		}
		
		else if (odredjenoVreme == false && kucnaPoseta == true) {
			
			return String.valueOf(Math.round(ukupnaCena) + 300);
		}
		
		else if (odredjenoVreme == true && kucnaPoseta == true) {
			
			return String.valueOf(Math.round(ukupnaCena) + 500);
		}
		
		return String.valueOf(Math.round(ukupnaCena));
	}
	
	public static ArrayList<Analiza> vracanjeAnalize(ArrayList<String> imenaAnaliza) {
		
		ArrayList<Analiza> analizeZaPrikaz = new ArrayList<Analiza>();
		
		for (String imeAnalize : imenaAnaliza) {
			
			for (Analiza analiza : analize) {
				
				if (analiza.getImeAnalize().equals(imeAnalize)) {
					
					analizeZaPrikaz.add(analiza);
				}
			}
		}
		
		return analizeZaPrikaz;
	}
	
//	private static double kreiranjeNasumicneVrednosti(double izvorniMinimum, double IzvorniMaksimum) {
//		
//		double krajnjiMinimum = izvorniMinimum - 2;
//		double krajnjiMaksimum = IzvorniMaksimum + 2;
//		double random = new Random().nextDouble();
//		double rezultat = Math.round(krajnjiMinimum + (random * (krajnjiMaksimum - krajnjiMinimum)));
//		return rezultat;
//	}
	
	public static ArrayList<String> dobavljanjeImenaAnaliza() {
		
		for (Analiza analiza : analize) {
			
			imenaAnaliza.add(analiza.getImeAnalize());
		}
		
		return imenaAnaliza;
	}
	
	public static String vracanjeCeneNaOsnovuImenaAnalize(String imeAnalize) {
		
		for (Analiza analiza : analize) {
			
			if (analiza.getImeAnalize().equals(imeAnalize)) {
				
				return String.valueOf(Math.round(analiza.getCena()));
			}
		}
		
		return null;
	}
	
	public static void azuriranjeCeneAnaliza(String imeAnalize, String novaCena) {
		
		AnalizaController.ucitavanje(putanja);
		
		String recZaPromenu = "";
		
		BufferedReader br = null;
		
		File fajl = new File(putanja);
		String stariSadrzaj = "";
		String noviSadrzaj = "";
		String novaLinija = "";
		
		try {
			br = new BufferedReader(new FileReader(fajl));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String linija;

		try {
			while ((linija = br.readLine()) != null)
			{
				linija = linija.trim();
				
				stariSadrzaj = stariSadrzaj + linija + System.lineSeparator();
				
				String [] reci = linija.split(",");
				
				if (reci[reci.length - 1].equals(Entitet.ANALIZA.name())) {
					
				
				if (reci[1].trim().equals(imeAnalize)) {
					
					recZaPromenu = reci[3].trim();
					novaLinija = linija.replace(recZaPromenu, novaCena);
					noviSadrzaj = noviSadrzaj + novaLinija + System.lineSeparator();
				}
				
				else {
					noviSadrzaj = noviSadrzaj + linija + System.lineSeparator();
				}
				
				}
				
				else {
					
					noviSadrzaj = noviSadrzaj + linija + System.lineSeparator();

				}
				
			}
			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(fajl);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			
			fw.write(noviSadrzaj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void dodavanjeNoveAnalize(Object grupaAnalize, String imeAnalize, String jedinicaMere, String cena,
			String referentnaVrednostOdMuski, String referentnaVrednostDoMuski,
			String referentnaVrednostOdZenski, String referentnaVrednostDoZenski, String popust) {
		
		try {
			FileWriter fw = new FileWriter(putanja, true);
			
			String upis = String.join(",", String.valueOf(grupaAnalize), imeAnalize, jedinicaMere, cena, referentnaVrednostOdMuski, referentnaVrednostDoMuski, referentnaVrednostOdZenski,
					referentnaVrednostDoZenski, "", popust, Entitet.ANALIZA.name()); 
			fw.write(upis + "\n");
			fw.close();
			
			AnalizaController.ucitavanje(putanja);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static ArrayList<String> vracanjeImenaAnalizaPoLaborantu(String korisnickoImeLaboranta){
		
		Laborant laborant = KorisniciController.vracanjeLaborantaNaOsnovuKorisnickogImena(korisnickoImeLaboranta);
		
		ArrayList<String> imenaAnalizaPoLaborantu = new ArrayList<String>();
		
		for (Analiza analiza : analize) {
			
			if (laborant.getSpecijalizacije().contains(analiza.getGrupa())) {
				
				imenaAnalizaPoLaborantu.add(analiza.getImeAnalize());
			}
		}
		
		return imenaAnalizaPoLaborantu;
	}
	
	public static Analiza vracanjeAnalizeNaOsnovuImena(String imeAnalize) {
		
		for (Analiza analiza : analize) {
			
			if (analiza.getImeAnalize().equals(imeAnalize)) {
				
				return analiza;
			}
		}
		
		return null;
	}
	
	public static String dobavljanjeRezultataAnaliza(Zahtev selektovanZahtev, String imeAnalize) {
		
		NalazController.ucitavanje(putanja);
		
		String [] rezultatiAnaliza = null;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(putanja));
			
			String linija;
			
			try {
				while((linija = reader.readLine()) != null) {
								
					linija = linija.trim();
					String [] reci = linija.split(",");
					
					if (reci[reci.length - 1].trim().equals(Entitet.NALAZ.name())) {
						
						if (reci[2].trim().equals(String.valueOf(selektovanZahtev.getIdZahteva()))){
							
							rezultatiAnaliza = (reci[5].trim()).split("-");
						}
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
		
		for (int i = 0; i < selektovanZahtev.getImenaAnaliza().length; i++) {
			
			if (selektovanZahtev.getImenaAnaliza()[i].equals(imeAnalize)) {
				
				return rezultatiAnaliza[i];
			}
		}
		
		return null;
	}
	
	public static String vracanjeGrupaAnaliza(Zahtev zahtev) {

		String grupeAnaliza = "";
		
		for (String imeAnalize : zahtev.getImenaAnaliza()) {
			
			if (!grupeAnaliza.contains(vracanjeAnalizeNaOsnovuImena(imeAnalize).getGrupa().name())) {
			
			grupeAnaliza = grupeAnaliza + vracanjeAnalizeNaOsnovuImena(imeAnalize).getGrupa().name() + ", ";
		}
	}
		
		return grupeAnaliza.substring(0, grupeAnaliza.length() - 2);
	}
}

