package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import enumeracije.Entitet;
import enumeracije.GrupaAnalize;
import enumeracije.StatusObrade;
import model.Analiza;
import model.Laborant;
import model.Nalaz;
import model.Zahtev;
import view.administrator.IzborVremenskogOpsegaIzvestaji;
import view.laborant.PreuzetiNalazi;

public class NalazController {
	
	public static String putanja = "bazaPodataka/testniPrimeri.csv";
	public static ArrayList<Nalaz> nalazi = new ArrayList<Nalaz>();
	public static ArrayList<Nalaz> nalaziPoLaborantu = new ArrayList<Nalaz>();
	
	public static void ucitavanje(String putanja) {
		
		nalazi.clear();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(putanja));
			
			String linija;
			
			try {
				while((linija = reader.readLine()) != null) {
								
					linija = linija.trim();
					String [] reci = linija.split(",");
					
					if (reci[reci.length - 1].trim().equals(Entitet.NALAZ.name())) {
						
						kreiranjeNalaza(linija);
						
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

	private static void kreiranjeNalaza(String linija) {
		
		String [] reci = linija.split(",");
		ArrayList<String> laboranti = new ArrayList<String>();
		ArrayList<String> rezultatiAnaliza = new ArrayList<String>();
		String [] korisnickaImenaLaboranata = (reci[4].trim()).split("-");
		String [] analize = (reci[5].trim()).split("-");
		
		for (int i = 0; i < korisnickaImenaLaboranata.length; i++) {
			
			String laborant = korisnickaImenaLaboranata[i];
			laboranti.add(laborant);
		}
		
		for (int j = 0; j < analize.length; j++) {
			
			String rezultatAnalize = analize[j];
			rezultatiAnaliza.add(rezultatAnalize);
		}
		
		Nalaz nalaz = new Nalaz(StatusObrade.valueOf(reci[0].trim()), Double.parseDouble(reci[1].trim()), Integer.parseInt(reci[2].trim()),
				LocalDateTime.parse(reci[3].trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), laboranti, rezultatiAnaliza);
		
		nalazi.add(nalaz);
	}

	public static void kreiranjeNovogNalaza(String cena) {
		
		NalazController.ucitavanje(putanja);
		
		try {
			FileWriter fw = new FileWriter(putanja, true);
			
			String upis = null;
			try {
				upis = String.join(",", StatusObrade.POCETNO_STANJE.name(), cena, String.valueOf(nalazi.size() + 1),
						konvertovanjeStringaUDatumIVreme("01/01/0001 00:00"), "#", "!", Entitet.NALAZ.name());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fw.write(upis + "\n");
			fw.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static ArrayList<String> dobavljanjeDatumaObradeNalaza(String LBO) {
		
		NalazController.ucitavanje(putanja);
		
		ArrayList<String> datumiNalaza = new ArrayList<String>();
		
		for (Zahtev zahtev : ZahtevController.zahtevi) {
				
				for (Nalaz nalaz : nalazi) {
				
				if (zahtev.getLBO().equals(LBO) && String.valueOf(nalaz.getIdZahteva()).equals(String.valueOf(zahtev.getIdZahteva()))) {
					
					datumiNalaza.add(String.valueOf(nalaz.getDatumObradeNalaza()));
				}
			}
		}
		
		return datumiNalaza;
	}
	
	public static String konvertovanjeStringaUDatumIVreme(String izvorniDatum)
	        throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy HH:mm");
	    SimpleDateFormat ispis = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    Date podaci = sdf.parse(izvorniDatum);
	    String formatiranDatum = ispis.format(podaci);
	    return formatiranDatum;
	}
	
	public static String vracanjeDatumaObradeNalaza(String izvorniDatum) {
		
		if (izvorniDatum.equals("0001-01-01T00:00")) {
			
			return "Obrada u toku";
		}
		
		else {
			
			DateTimeFormatter parsiranDatumNalaza = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
			
			return LocalDateTime.parse(izvorniDatum).format(parsiranDatumNalaza);
		}
	}

	public static String ulepsavanjeStatusaObradeNalaza(String izvorniStatusObrade) {
		
		if (izvorniStatusObrade.equals(StatusObrade.POCETNO_STANJE.name())) {
			
			return "Pocetno stanje";
		}
		
		else if (izvorniStatusObrade.equals(StatusObrade.UZIMANJE_UZORKA.name())) {
			
			return "Uzimanje uzorka";
		}
		
		else if (izvorniStatusObrade.equals(StatusObrade.OBRADA_NALAZA.name())) {
			
			return "Obrada nalaza";
		}
		
		else if (izvorniStatusObrade.equals(StatusObrade.OBRADJENO.name())) {
			
			return "Obradjeno";
		}
		
		else {
			
			return null;
		}
	}
	
	public static Nalaz vracanjeNalazaPrekoIdNalaza(String idNalaza) {
		
		for (Nalaz nalaz : nalazi) {
			
			if (String.valueOf(nalaz.getIdZahteva()).equals(idNalaza)) {
				
				return nalaz;
			}
		}
		
		return null;
	}
	
	public static Nalaz vracanjeNalazaNaOsnovuZahteva(String idZahteva) {
		
		NalazController.ucitavanje(putanja);
		
		for (Nalaz nalaz : nalazi) {
				
			if (String.valueOf(nalaz.getIdZahteva()).equals(idZahteva)){
					
				return nalaz;
			}
			
		}
		
		return null;
	}
	
	public static void menjanjeStatusaUzimanjeUzorka(Nalaz nalaz) {
		
		NalazController.ucitavanje(putanja);
		
		String recZaPromenu = "";
		String drugaRecZaPromenu = "";
		
		DateTimeFormatter parsiranTrenutniDatum = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
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
				
				if (reci[reci.length - 1].equals(Entitet.NALAZ.name())) {
				
				
				if (reci[2].trim().equals(String.valueOf(nalaz.getIdZahteva()))) {
					
					recZaPromenu = reci[0].trim();
					
					drugaRecZaPromenu = reci[3].trim();
					novaLinija = linija.replaceFirst(recZaPromenu, StatusObrade.UZIMANJE_UZORKA.name());
					novaLinija = novaLinija.replaceFirst(drugaRecZaPromenu, String.valueOf(LocalDateTime.now().format(parsiranTrenutniDatum)));
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
	
	public static void menjanjeStatusaPocetnoStanje(Nalaz nalaz) {
		
		NalazController.ucitavanje(putanja);
		
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
				
				if (reci[reci.length - 1].equals(Entitet.NALAZ.name())) {
					
				
				if (reci[2].trim().equals(String.valueOf(nalaz.getIdZahteva()))) {
					
					recZaPromenu = reci[0].trim();
					
					novaLinija = linija.replaceFirst(recZaPromenu, StatusObrade.POCETNO_STANJE.name());
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
	
	public static ArrayList<Integer> vracanjeIdNalazaUzimanjeUzorkaIliObradaNalaza() {
		
		ArrayList<Integer> idNalaziUzimanjeUzorka = new ArrayList<Integer>();
		
		for (Nalaz nalaz : NalazController.nalazi) {
				
			if (nalaz.getStatus().equals(StatusObrade.UZIMANJE_UZORKA) || nalaz.getStatus().equals(StatusObrade.OBRADA_NALAZA)) {
				
				idNalaziUzimanjeUzorka.add(nalaz.getIdZahteva());
			}
		}
		
		return idNalaziUzimanjeUzorka;
		
	}
	
	public static void menjanjeStatusaObradaNalaza(Nalaz nalaz) {
		
		NalazController.ucitavanje(putanja);
		
		String recZaPromenu = "";
		String drugaRecZaPromenu = "";
		
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
				
				if (reci[reci.length - 1].equals(Entitet.NALAZ.name())) {
					
				
				if (reci[2].trim().equals(String.valueOf(nalaz.getIdZahteva()))) {
					
					recZaPromenu = reci[0].trim();
					drugaRecZaPromenu = reci[5].trim();
					novaLinija = linija.replaceFirst(recZaPromenu, StatusObrade.OBRADA_NALAZA.name());
					novaLinija = novaLinija.replaceFirst(drugaRecZaPromenu, "!");
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
	
	public static void menjanjeStatusaObradjen(Nalaz nalaz) {
		
		NalazController.ucitavanje(putanja);
		
		ZahtevController.generisanjeRezultataAnaliza(String.valueOf(nalaz.getIdZahteva()));
		
		String recZaPromenu = "";
		String drugaRecZaPromenu = "";
		String trecaRecZaPromenu = "";
		DateTimeFormatter parsiranTrenutniDatum = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
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
				
				if (reci[reci.length - 1].equals(Entitet.NALAZ.name())) {
					
				
				if (reci[2].trim().equals(String.valueOf(nalaz.getIdZahteva()))) {
					
					recZaPromenu = reci[0].trim();
					
					if (recZaPromenu.equals(StatusObrade.OBRADA_NALAZA.name())) {
					
					drugaRecZaPromenu = reci[3].trim();
					trecaRecZaPromenu = reci[5].trim();
					novaLinija = linija.replaceFirst(recZaPromenu, StatusObrade.OBRADJENO.name());
					novaLinija = novaLinija.replaceFirst(drugaRecZaPromenu, String.valueOf(LocalDateTime.now().format(parsiranTrenutniDatum)));
					novaLinija = novaLinija.replaceFirst(trecaRecZaPromenu, ZahtevController.parsiraniRezultatiAnaliza());
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
	
	public static void preuzetiNalazi(String korisnickoImeLaboranta) {
		
		nalaziPoLaborantu.clear();
		
		NalazController.ucitavanje(putanja);
		
		for (Nalaz nalaz : nalazi) {
			
			if (nalaz.getKorisnickaImenaLaboranata().contains(korisnickoImeLaboranta)){
				
				nalaziPoLaborantu.add(nalaz);
			}
		}
		
	}
	
	public static void ucitavanjeIzabranihNalaza() {
		
		ucitavanje(putanja);
		
		for (Nalaz nalaz : nalazi) {
			
			if (nalaz.getStatus().equals(StatusObrade.OBRADJENO)) {
				
				PreuzetiNalazi.idIzabranihNalaza.add(String.valueOf(nalaz.getIdZahteva()));
			}
		}
	}
	
	public static ArrayList<LocalDateTime> vracanjeOpsegaDatumaNalaza(LocalDateTime pocetniDatum, LocalDateTime krajnjiDatum){
		
		ArrayList<LocalDateTime> datumiUOpsegu = new ArrayList<LocalDateTime>();
		
		for (Nalaz nalaz : nalazi) {
			
			if (nalaz.getDatumObradeNalaza().isAfter(pocetniDatum) && nalaz.getDatumObradeNalaza().isBefore(krajnjiDatum)) {
				
				datumiUOpsegu.add(nalaz.getDatumObradeNalaza());
			}
		}
		
		return datumiUOpsegu;
	}
	
	public static ArrayList<Integer> vracanjeIdNalazaOdredjenihDana(){
		
		ArrayList<Integer> idNalazaSaOdredjenimDanima = new ArrayList<Integer>();
		
		for (Nalaz nalaz : nalazi) {
			
			if (IzborVremenskogOpsegaIzvestaji.izabraniDaniUNedeljiEngleski.contains(nalaz.getDatumObradeNalaza().getDayOfWeek())) {
				
				idNalazaSaOdredjenimDanima.add(nalaz.getIdZahteva());
			}
		}
		
		return idNalazaSaOdredjenimDanima;
	}
	
	public static void konvertovanjeDanaNaEngleski() {
		
		IzborVremenskogOpsegaIzvestaji.izabraniDaniUNedeljiEngleski.clear();
		
		for (String dan : IzborVremenskogOpsegaIzvestaji.izabraniDaniUNedelji){
			
			if (dan.equals("Ponedeljak")) {
				
				IzborVremenskogOpsegaIzvestaji.izabraniDaniUNedeljiEngleski.add(DayOfWeek.MONDAY);
			}
			
			else if(dan.equals("Utorak")) {
				
				IzborVremenskogOpsegaIzvestaji.izabraniDaniUNedeljiEngleski.add(DayOfWeek.TUESDAY);
			}
			
			else if (dan.equals("Sreda")) {
				
				IzborVremenskogOpsegaIzvestaji.izabraniDaniUNedeljiEngleski.add(DayOfWeek.WEDNESDAY);
			}
			
			else if (dan.equals("Cetvrtak")) {
				
				IzborVremenskogOpsegaIzvestaji.izabraniDaniUNedeljiEngleski.add(DayOfWeek.THURSDAY);
			}
			
			else if (dan.equals("Petak")) {
				
				IzborVremenskogOpsegaIzvestaji.izabraniDaniUNedeljiEngleski.add(DayOfWeek.FRIDAY);
			}
			
			else if (dan.equals("Subota")) {
				
				IzborVremenskogOpsegaIzvestaji.izabraniDaniUNedeljiEngleski.add(DayOfWeek.SATURDAY);
			}
			
			else if (dan.equals("Nedelja")) {
				
				IzborVremenskogOpsegaIzvestaji.izabraniDaniUNedeljiEngleski.add(DayOfWeek.SUNDAY);
			}
		}
	}
	
	public static ArrayList<GrupaAnalize> odredjivanjePotrebnihSpecijalizacija(Nalaz nalaz) {
		
		ArrayList<GrupaAnalize> potrebneSpecijalizacije = new ArrayList<GrupaAnalize>();
		
		Zahtev zahtev = ZahtevController.vracanjeZahtevaprekoIdZahteva(String.valueOf(nalaz.getIdZahteva()));
		
		for (String imeAnalize : zahtev.getImenaAnaliza()) {
			
			Analiza analiza = AnalizaController.vracanjeAnalizeNaOsnovuImena(imeAnalize);
			
			if (!potrebneSpecijalizacije.contains(analiza.getGrupa())) {
			
			potrebneSpecijalizacije.add(analiza.getGrupa());
		}
		}
		
		for (String korisnickoImeLaboranta : nalaz.getKorisnickaImenaLaboranata()) {
			
			if (KorisniciController.korisnickaImenaLaboranata.contains(korisnickoImeLaboranta)) {
			
			for (GrupaAnalize specijalizacija : KorisniciController.vracanjeLaborantaNaOsnovuKorisnickogImena(korisnickoImeLaboranta).getSpecijalizacije()) {
				
				if (potrebneSpecijalizacije.contains(specijalizacija)){
					
					potrebneSpecijalizacije.remove(specijalizacija);
				}
			}
		}
		}
		
		return potrebneSpecijalizacije;
	}
	
	public static Integer vracanjeBrojaObradjenihNalaza(Laborant laborant, LocalDateTime pocetniDatum, LocalDateTime krajnjiDatum) {
		
		int brojObradjenihNalaza = 0;
		
		for (Nalaz nalaz : nalazi) {
			
			if (nalaz.getStatus().equals(StatusObrade.OBRADJENO)) {
				
				if (nalaz.getKorisnickaImenaLaboranata().contains(laborant.getKorisnickoIme()) && nalaz.getDatumObradeNalaza().isAfter(pocetniDatum) 
						&& nalaz.getDatumObradeNalaza().isBefore(krajnjiDatum)) {
					
					brojObradjenihNalaza += 1;
				}
			}
		}
		
		return brojObradjenihNalaza;
	}
	
	public static String vracanjeUkupneCeneNalaza(String LBO, LocalDateTime pocetniDatum, LocalDateTime krajnjiDatum) {
		
		double ukupanIznos = 0;
		
		for (Nalaz nalaz : nalazi) {
			
			if (ZahtevController.vracanjeZahtevaprekoIdZahteva(String.valueOf(nalaz.getIdZahteva())).getLBO().equals(LBO)) {
				
				if (ZahtevController.vracanjeZahtevaprekoIdZahteva(String.valueOf(nalaz.getIdZahteva())).getVremeUzorka().isAfter(pocetniDatum) && 
						ZahtevController.vracanjeZahtevaprekoIdZahteva(String.valueOf(nalaz.getIdZahteva())).getVremeUzorka().isBefore(krajnjiDatum) && 
						ZahtevController.vracanjeIdZahtevaOdredjenihDana().contains(nalaz.getIdZahteva())) {
				
				ukupanIznos = ukupanIznos + nalaz.getUkupnaCena();
			}
		}
		}
		
		return String.valueOf(Math.round(ukupanIznos)) + "  RSD";
	}
}
