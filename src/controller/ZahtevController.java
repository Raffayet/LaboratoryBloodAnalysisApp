package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import enumeracije.Entitet;
import enumeracije.Pol;
import enumeracije.StatusObrade;
import model.Analiza;
import model.MedicinskiTehnicar;
import model.Nalaz;
import model.Zahtev;
import view.administrator.IzborVremenskogOpsegaIzvestaji;
import view.medicinski_tehnicar.PreuzetiZahtevi;
import view.univerzalno.KreiranjeZahteva;

public class ZahtevController {

	public static String putanja = "bazaPodataka/testniPrimeri.csv";
	public static ArrayList<Zahtev> zahtevi = new ArrayList<Zahtev>();
	public static ArrayList<Zahtev> zahteviPoMedicinskomTehnicaru = new ArrayList<Zahtev>();
	public static ArrayList<String> nasumicneVrednostiRezultata = new ArrayList<String>();

	public static void ucitavanje(String putanja) {

		zahtevi.clear();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(putanja));

			String linija;

			try {
				while((linija = reader.readLine()) != null) {

					linija = linija.trim();
					String [] reci = linija.split(",");

					if (reci[reci.length - 1].trim().equals(Entitet.ZAHTEV.name())) {

						kreiranjeZahteva(linija);

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

	private static void kreiranjeZahteva(String linija) {

		String [] reci = linija.split(",");
		Zahtev zahtev = new Zahtev(Boolean.parseBoolean(reci[0].trim()), Boolean.parseBoolean(reci[1].trim()), reci[2].trim(),
				(reci[3].trim()).split("-"), LocalDateTime.parse(reci[4].trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), reci[5].trim(),
				Integer.parseInt(reci[6]));

		zahtevi.add(zahtev);
	}

	public static void preuzetiZahtevi(String medicinskiTehnicar) {

		zahteviPoMedicinskomTehnicaru.clear();

		ZahtevController.ucitavanje(putanja);

		for (Zahtev zahtev : zahtevi) {

			if (zahtev.getKorisnickoImeMedicinskogTehnicara().equals(medicinskiTehnicar)){

				zahteviPoMedicinskomTehnicaru.add(zahtev);
			}
		}

	}

	public static String prikazPojedinacnihAnaliza(Zahtev zahtev) {

		String analize = "";

		for (String analiza : zahtev.getImenaAnaliza()) {

			analize = analize + analiza + ", ";
		}

		return analize.substring(0, analize.length() - 2);
	}

	private static String parsiraneAnalize() {

		String analize = "";

		for (String analiza : KreiranjeZahteva.izabraneAnalize) {

			analize = analize + analiza + "-";
		}

		return analize.substring(0, analize.length() - 1);
	}

	public static void kreiranjeNovogZahteva(String LBO, String datumUzorka, String vremeUzorka, String kucnaPoseta, String entitet, String korisnickoIme) {

		ZahtevController.ucitavanje(putanja);

		if (vremeUzorka.equals("")){

			vremeUzorka = "--:--";
		}

		try {
			FileWriter fw = new FileWriter(putanja, true);

			String upis = "";

			if (entitet == Entitet.MEDICINSKI_TEHNICAR.name()) {

				try {
					upis = String.join(",", kucnaPoseta, "false", LBO, parsiraneAnalize(), konvertovanjeStringaUDatum(datumUzorka) + " " + vremeUzorka, 
							korisnickoIme, String.valueOf(zahtevi.size() + 1), 
							Entitet.ZAHTEV.name());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			else {

				try {
					upis = String.join(",", kucnaPoseta, "false", LBO, parsiraneAnalize(), konvertovanjeStringaUDatum(datumUzorka) + " " + vremeUzorka,
							"#", String.valueOf(zahtevi.size() + 1), 
							Entitet.ZAHTEV.name());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			fw.write(upis + "\n");
			fw.close();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static String konvertovanjeStringaUDatum(String izvorniDatum)
			throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat ispis = new SimpleDateFormat("yyyy-MM-dd");
		Date podaci = sdf.parse(izvorniDatum);
		String formatiranDatum = ispis.format(podaci);
		return formatiranDatum;
	}

	public static ArrayList<String> vracanjeImenaAnaliza(String LBO) {

		ArrayList<String> imenaAnaliza = new ArrayList<String>();

		for (Zahtev zahtev : ZahtevController.zahtevi) {

			if (zahtev.getLBO().equals(LBO)) {

				for (String imeAnalize : zahtev.getImenaAnaliza()) {

					imenaAnaliza.add(imeAnalize);
				}
			}
		}

		return imenaAnaliza;
	}

	public static Zahtev vracanjeZahtevaprekoIdZahteva(String idNalaza) {

		for (Zahtev zahtev : zahtevi) {

			if (String.valueOf(zahtev.getIdZahteva()).equals(idNalaza)) {

				return zahtev;
			}
		}

		return null;
	}

	public static Date proveraUnosaProslogDatuma(String izvorniDatum)
			throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date krajnjiDatum = sdf.parse(izvorniDatum);
		return krajnjiDatum;
	}

	public static int brojKucnihPosetaPoPacijentu(String korisnickoIme) {

		int brojKucnihPoseta = 0;

		ucitavanje(putanja);

		for (Zahtev zahtev : zahtevi) {

			if (zahtev.getKorisnickoImeMedicinskogTehnicara().equals(korisnickoIme) && zahtev.isKucnaPoseta() == true) {

				brojKucnihPoseta += 1;
			}
		}

		return brojKucnihPoseta;

	}

	public static ArrayList<String> konvertovanjeIzNizaUListu(String [] niz){

		ArrayList<String> lista = new ArrayList<String>(Arrays.asList(niz));

		return lista;
	}

	public static void generisanjeRezultataAnaliza(String idIzabranogNalaza) {
		
		nasumicneVrednostiRezultata.clear();
		
		Random r = new Random();

		Zahtev zahtev = ZahtevController.vracanjeZahtevaprekoIdZahteva(idIzabranogNalaza);

		for (String imeAnalize : zahtev.getImenaAnaliza()) {
		
			Analiza analiza = AnalizaController.vracanjeAnalizeNaOsnovuImena(imeAnalize);
			
			if (KorisniciController.vracanjePolaNaOsnovuLBO(zahtev.getLBO()).equals(Pol.MUSKI)) {

				double minimalnaVrednostMuski = analiza.getReferentnaVrednostOdMuski() - 2;
				double maksimalnaVrednostMuski = analiza.getReferentnaVrednostDoMuski() + 2;

				nasumicneVrednostiRezultata.add(String.valueOf(Math.round((minimalnaVrednostMuski + (maksimalnaVrednostMuski - minimalnaVrednostMuski) * 
						r.nextDouble()) * 100.0) / 100.0));
			}
		
		else {

			double minimalnaVrednostZenski = analiza.getReferentnaVrednostOdZenski() - 2;
			double maksimalnaVrednostZenski = analiza.getReferentnaVrednostDoZenski() + 2;

			nasumicneVrednostiRezultata.add(String.valueOf(Math.round((minimalnaVrednostZenski + (maksimalnaVrednostZenski - minimalnaVrednostZenski) * 
					r.nextDouble()) * 100.0) / 100.0));
		}
		}
	}
	
	public static String parsiraniRezultatiAnaliza() {

		String rezultatiAnaliza = "";

		for (String rezultatAnalize : nasumicneVrednostiRezultata) {

			rezultatiAnaliza = rezultatiAnaliza + rezultatAnalize + "-";
		}

		return rezultatiAnaliza.substring(0, rezultatiAnaliza.length() - 1);
	}
	
	public static void upisZavrsenogZahteva(Nalaz nalaz) {
		
		KorisniciController.ucitavanje(putanja);
		
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
				
				if (reci[reci.length - 1].equals(Entitet.ZAHTEV.name())) {
					
				
				if (reci[6].trim().equals(String.valueOf(nalaz.getIdZahteva()))) {
					
					recZaPromenu = reci[1].trim();
					novaLinija = linija.replace(recZaPromenu, "true");
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
		
		postavljanjeKucnePoseteNaFalse(nalaz);
	}
	
	public static void ucitavanjeIzabranihZahteva() {
		
		ucitavanje(putanja);
		
		for (Nalaz nalaz : NalazController.nalazi) {
			
			if (nalaz.getStatus().equals(StatusObrade.UZIMANJE_UZORKA) || nalaz.getStatus().equals(StatusObrade.OBRADA_NALAZA) || nalaz.getStatus().equals(StatusObrade.OBRADJENO)) {
				
				PreuzetiZahtevi.idIzabranihZahteva.add(String.valueOf(nalaz.getIdZahteva()));
			}
		}
	}
	
	public static ArrayList<LocalDateTime> vracanjeOpsegaDatumaZahteva(LocalDateTime pocetniDatum, LocalDateTime krajnjiDatum){
		
		ArrayList<LocalDateTime> datumiUOpsegu = new ArrayList<LocalDateTime>();
		
		for (Zahtev zahtev : zahtevi) {
			
			if (zahtev.getVremeUzorka().isAfter(pocetniDatum) && zahtev.getVremeUzorka().isBefore(krajnjiDatum)) {
				
				datumiUOpsegu.add(zahtev.getVremeUzorka());
			}
		}
		
		return datumiUOpsegu;
	}
	
	public static ArrayList<Integer> vracanjeIdZahtevaOdredjenihDana(){
		
		ArrayList<Integer> idZahtevaSaOdredjenimDanima = new ArrayList<Integer>();
		
		for (Zahtev zahtev : zahtevi) {
			
			if (IzborVremenskogOpsegaIzvestaji.izabraniDaniUNedeljiEngleski.contains(zahtev.getVremeUzorka().getDayOfWeek())) {
				
				idZahtevaSaOdredjenimDanima.add(zahtev.getIdZahteva());
			}
		}
		
		return idZahtevaSaOdredjenimDanima;
	}
	
	public static Integer vracanjeBrojaObradjenihZahteva(MedicinskiTehnicar medicinskiTehnicar, LocalDateTime pocetniDatum, LocalDateTime krajnjiDatum) {
		
		int brojObradjenihZahteva = 0;
		
		for (Zahtev zahtev : zahtevi) {
			
			if (!NalazController.vracanjeNalazaPrekoIdNalaza(String.valueOf(zahtev.getIdZahteva())).getStatus().equals(StatusObrade.POCETNO_STANJE) && 
				NalazController.vracanjeNalazaPrekoIdNalaza(String.valueOf(zahtev.getIdZahteva())).getDatumObradeNalaza().isAfter(pocetniDatum) && 
				NalazController.vracanjeNalazaPrekoIdNalaza(String.valueOf(zahtev.getIdZahteva())).getDatumObradeNalaza().isBefore(krajnjiDatum)) {
				
				if (zahtev.getKorisnickoImeMedicinskogTehnicara().equals(medicinskiTehnicar.getKorisnickoIme())) {
					
					brojObradjenihZahteva += 1;
				}
			}
		}
		
		return brojObradjenihZahteva;
	}
	
	public static double vracanjePlateMedicinskihTehnicaraZaIzvestaje(LocalDateTime pocetniDatum, LocalDateTime krajnjiDatum, MedicinskiTehnicar medicinskiTehnicar) {
		
		long brojDanaIzmedjuDvaDatuma = (ChronoUnit.DAYS.between(pocetniDatum, krajnjiDatum) * IzborVremenskogOpsegaIzvestaji.izabraniDaniUNedelji.size()) / 7;
		
		int bonus = 0;
		
		for (Zahtev zahtev : ZahtevController.zahtevi) {
			
			if (ZahtevController.vracanjeOpsegaDatumaZahteva(pocetniDatum, krajnjiDatum).contains(zahtev.getVremeUzorka()) && 
					ZahtevController.vracanjeIdZahtevaOdredjenihDana().contains(zahtev.getIdZahteva()) &&
					zahtev.getKorisnickoImeMedicinskogTehnicara().equals(medicinskiTehnicar.getKorisnickoIme()) && 
					!NalazController.vracanjeNalazaNaOsnovuZahteva(String.valueOf(zahtev.getIdZahteva())).getStatus().equals(StatusObrade.POCETNO_STANJE)) {
				
				bonus = bonus + 500;
			}
		}
		
		double dnevnica = (medicinskiTehnicar.getOsnova() * medicinskiTehnicar.getKoeficijent() * medicinskiTehnicar.getStaz() + bonus) / 30;
		double plata = dnevnica * brojDanaIzmedjuDvaDatuma;
		
		return Math.round(plata);
	}
	
	public static void postavljanjeKucnePoseteNaFalse(Nalaz nalaz) {
		
		KorisniciController.ucitavanje(putanja);
		
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
				
				if (reci[reci.length - 1].equals(Entitet.ZAHTEV.name())) {
					
				
				if (reci[6].trim().equals(String.valueOf(nalaz.getIdZahteva()))) {
					
					recZaPromenu = reci[0].trim();
					novaLinija = linija.replaceFirst(recZaPromenu, "false");
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
	
	public static String vracanjeBrojaZahteva(String LBO, LocalDateTime pocetniDatum, LocalDateTime krajnjiDatum) {
		
		int brojZahteva = 0;
		
		for (Zahtev zahtev : zahtevi) {
			
			if (zahtev.getLBO().equals(LBO)) {
				
				if (vracanjeOpsegaDatumaZahteva(pocetniDatum, krajnjiDatum).contains(zahtev.getVremeUzorka()) && vracanjeIdZahtevaOdredjenihDana().contains(zahtev.getIdZahteva())) {
				
				brojZahteva += 1;
			}
			}
		}
		
		return String.valueOf(brojZahteva);
	}
}

