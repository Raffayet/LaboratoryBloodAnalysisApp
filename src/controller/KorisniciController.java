package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

import enumeracije.Entitet;
import enumeracije.GrupaAnalize;
import enumeracije.Pol;
import enumeracije.StrucnaSprema;
import model.Administrator;
import model.Korisnik;
import model.Laborant;
import model.MedicinskiTehnicar;
import model.Musterija;
import model.Nalaz;
import model.Pacijent;
import model.Zaposleni;
import view.administrator.DodavanjeSpecijalizacija;
import view.administrator.IzborVremenskogOpsegaIzvestaji;
import view.administrator.RegistracijaLaboranta;

public class KorisniciController {
	
	public static String putanja = "bazaPodataka/testniPrimeri.csv";
	public static ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
	public static ArrayList<String> licniBrojeviOsiguranika = new ArrayList<String>();
	public static ArrayList<String> korisnickaImenaMedicinskihTehnicara = new ArrayList<String>();
	public static ArrayList<String> korisnickaImenaPacijenata = new ArrayList<String>();
	public static ArrayList<String> korisnickaImenaLaboranata = new ArrayList<String>();
	
	public static void ucitavanje(String putanja) {
		
		korisnici.clear();
		licniBrojeviOsiguranika.clear();
		punjenjeListeKorisnickihImena();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(putanja));
			
			String linija;
			
			try {
				while((linija = reader.readLine()) != null) {
								
					linija = linija.trim();
					String [] reci = linija.split(",");
					
					if (reci[reci.length - 1].trim().equals(Entitet.ADMINISTRATOR.name())) {
						
						kreiranjeAdministratora(linija);
						
					}
					
					if(reci[reci.length - 1].trim().equals(Entitet.MEDICINSKI_TEHNICAR.name())){
						
						kreiranjeMedicinskogTehnicara(linija);
						
					}
					
					if (reci[reci.length - 1].trim().equals(Entitet.LABORANT.name())) {
					
						kreiranjeLaboranta(linija);
							
					}
					
					if (reci[reci.length - 1].trim().equals(Entitet.PACIJENT.name())) {
						
						kreiranjePacijenta(linija);
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
	
	private static void kreiranjePacijenta(String linija) {
		
		String [] reci = linija.split(",");
		Date krajnjiDatum = vracanjeParsiranogDatuma(reci[7].trim());
		Pacijent pacijent = new Pacijent(reci[0].trim(), reci[1].trim(), reci[2].trim(), reci[3].trim(), reci[4].trim(), reci[5].trim(), 
						     Pol.valueOf(reci[6].trim()), krajnjiDatum, reci[8].trim());
		korisnici.add(pacijent);
		licniBrojeviOsiguranika.add(pacijent.getLBO());
	}

	private static void kreiranjeLaboranta(String linija) {
		
		String [] reci = linija.split(",");
		Date krajnjiDatum = vracanjeParsiranogDatuma(reci[7].trim());
		ArrayList<GrupaAnalize> specijalizacije = new ArrayList<GrupaAnalize>();
		String [] grupeAnaliza = (reci[13].trim()).split("-");
		
		for (int i = 0; i < grupeAnaliza.length; i++) {
			
			GrupaAnalize specijalizacija = GrupaAnalize.valueOf(grupeAnaliza[i]);
			specijalizacije.add(specijalizacija);
		}
		
		Laborant laborant = new Laborant(reci[0].trim(), reci[1].trim(), reci[2].trim(), reci[3].trim(), reci[4].trim(), reci[5].trim(), Pol.valueOf(reci[6].trim()), krajnjiDatum, 
				Double.parseDouble(reci[8].trim().substring(0, reci[8].trim().length() - 1)), Double.parseDouble(reci[9].trim().substring(0, reci[9].trim().length() - 1)), 
				Double.parseDouble(reci[10].trim().substring(0, reci[10].trim().length() - 1)), Integer.parseInt(reci[11].trim().substring(0, reci[11].trim().length() - 1)),
				StrucnaSprema.valueOf(reci[12].trim()), specijalizacije);
		korisnici.add(laborant);
	}

	private static void kreiranjeMedicinskogTehnicara(String linija) {
		
		String [] reci = linija.split(",");
		Date krajnjiDatum = vracanjeParsiranogDatuma(reci[7].trim());
		MedicinskiTehnicar medicinskiTehnicar = new MedicinskiTehnicar(reci[0].trim(), reci[1].trim(), reci[2].trim(), reci[3].trim(), reci[4].trim(), reci[5].trim(),
				Pol.valueOf(reci[6].trim()), krajnjiDatum, Double.parseDouble(reci[8].trim().substring(0, reci[8].trim().length() - 1)), 
				Double.parseDouble(reci[9].trim().substring(0, reci[9].trim().length() - 1)), Double.parseDouble(reci[10].trim().substring(0, reci[10].trim().length() - 1)), 
				Integer.parseInt(reci[11].trim().substring(0, reci[11].trim().length() - 1)), StrucnaSprema.valueOf(reci[12].trim()));
		korisnici.add(medicinskiTehnicar);
		
	}

	private static void kreiranjeAdministratora(String linija) {
		
		String [] reci = linija.split(",");
		Date krajnjiDatum = vracanjeParsiranogDatuma(reci[7].trim());
		Administrator administrator = new Administrator(reci[0].trim(), reci[1].trim(), reci[2].trim(), reci[3].trim(), reci[4].trim(), reci[5].trim(), 
			     										Pol.valueOf(reci[6].trim()), krajnjiDatum);
		korisnici.add(administrator);
	}
	
	static Date vracanjeParsiranogDatuma(String izvorniDatum) {
	DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	Date krajnjiDatum = null;
	try {
		krajnjiDatum = format.parse(izvorniDatum);
	} catch (ParseException e) {
		e.printStackTrace();
	}
	return krajnjiDatum;
	}
	
	public static void registracijaPacijenata(String korisnickoIme, String lozinka, String LBO, String ime, String prezime, String adresa, String telefon,
			String pol, String datumRodjenja) {
		
		try {
			FileWriter fw = new FileWriter(putanja, true);
			
			String upis = String.join(",", korisnickoIme, lozinka, ime, prezime, telefon, adresa, pol, datumRodjenja.toString(), LBO, Entitet.PACIJENT.name());
			fw.write(upis + "\n");
			fw.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		ucitavanje(putanja);
	}
	
	public static String vracanjeLBOPacijenta(String korisnickoIme) {
		
		for (Korisnik korisnik : korisnici) {
			
			if (korisnik instanceof Pacijent) {
				
				if (korisnik.getKorisnickoIme().equals(korisnickoIme)) {
					
					return ((Pacijent) korisnik).getLBO();
				}
			}
		}
		
		return null;
	}
	
	public static String vracanjeAdrese(String LBO) {
		
		for (Korisnik korisnik : korisnici) {
			
			if (korisnik instanceof Pacijent) {
				
				if (((Pacijent) korisnik).getLBO().equals(LBO)) {
					
					return korisnik.getAdresa();
				}
			}
		}
		
		for (Musterija musterija : MusterijaController.musterije) {
			
			if (musterija.getLBO().equals(LBO)){
				
				return musterija.getAdresa();
			}
		}
		return LBO;
	}
	
	public static void preuzimanjeZahteva(String preuzetZahtev, String korisnickoImeMedicinskogTehnicara) {
		
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
					
				
				if (reci[6].trim().equals(preuzetZahtev)) {
					
					recZaPromenu = reci[5].trim();
					novaLinija = linija.replace(recZaPromenu, korisnickoImeMedicinskogTehnicara);
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
	
	public static void punjenjeListeKorisnickihImena() {
		
		korisnickaImenaMedicinskihTehnicara.clear();
		korisnickaImenaPacijenata.clear();
		korisnickaImenaLaboranata.clear();
		
		for (Korisnik korisnik : korisnici) {
			
			if (korisnik instanceof MedicinskiTehnicar) {
				
				korisnickaImenaMedicinskihTehnicara.add(korisnik.getKorisnickoIme());
			}
			
			else if (korisnik instanceof Pacijent){
				
				korisnickaImenaPacijenata.add(korisnik.getKorisnickoIme());
			}
			
			else if (korisnik instanceof Laborant) {
				
				korisnickaImenaLaboranata.add(korisnik.getKorisnickoIme());
			}
		}
	}
	
	public static String vracanjePolaNaOsnovuKorisnickogImena(String korisnickoIme) {
		
		for (Korisnik korisnik : korisnici) {
			
			if (korisnik.getKorisnickoIme().equals(korisnickoIme)) {
				
				return korisnik.getPol().name();
			}
		}
		
		return "";
	}
	
	
	public static void registracijaMedicinskogTehnicara(String korisnickoIme, String lozinka, String ime, String prezime, String adresa, String telefon,
			String pol, String datumRodjenja, String osnova, String koeficijent, String staz, String selektovanaStrucnaSprema) {
		
		try {
			FileWriter fw = new FileWriter(putanja, true);
			
			String upis = String.join(",", korisnickoIme, lozinka, ime, prezime, telefon, adresa, pol, datumRodjenja.toString(), osnova + "!", koeficijent + "!", "0.00!", 
					staz + "!", selektovanaStrucnaSprema, Entitet.MEDICINSKI_TEHNICAR.name());
			fw.write(upis + "\n");
			fw.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		ucitavanje(putanja);
	}
	
	public static void registracijaLaboranta(String korisnickoIme, String lozinka, String ime, String prezime, String adresa, String telefon,
			String pol, String datumRodjenja, String osnova, String koeficijent, String staz, String selektovanaStrucnaSprema) {
		
		try {
			FileWriter fw = new FileWriter(putanja, true);
			
			String upis = String.join(",", korisnickoIme, lozinka, ime, prezime, telefon, adresa, pol, datumRodjenja.toString(), osnova + "!", koeficijent + "!", "0.00!", staz + "!", selektovanaStrucnaSprema, 
				parsiraneSpecijalizacije(), Entitet.LABORANT.name());
			fw.write(upis + "\n");
			fw.close();
			
			KorisniciController.ucitavanje(putanja);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		azuriranjeBonusaZaLaboranta(korisnickoIme);
		ucitavanje(putanja);
	}
	
	private static String parsiraneSpecijalizacije() {
		
		String specijalizacije = "";
		
		for (String specijalizacija : RegistracijaLaboranta.izabraneSpecijalizacije) {
			
			specijalizacije = specijalizacije + specijalizacija + "-";
		}
		
		return specijalizacije.substring(0, specijalizacije.length() - 1);
	}
	
	public static String vracanjeKorisnickogImenaNaOsnovuLBO(String LBO) {
		

		for (Korisnik korisnik : korisnici) {
			
			if (korisnik instanceof Pacijent) {
				
				if (((Pacijent) korisnik).getLBO().equals(LBO)) {
					
					return ((Pacijent) korisnik).getKorisnickoIme();
				}
			}
		}
		
		return "";
	}
	
	public static ArrayList<GrupaAnalize> vracanjeSpecijalizacijaNaOsnovuKorisnickogImena(String korisnickoIme){
		
		KorisniciController.ucitavanje(putanja);
		
		for (Korisnik korisnik : korisnici) {
			
			if (korisnik instanceof Laborant) {
				
				if (korisnik.getKorisnickoIme().equals(korisnickoIme)) {
					
					return ((Laborant) korisnik).getSpecijalizacije();
				}
			}
		}
		
		return null;
	}
	
	public static void dodavanjeSpecijalizacija(String korisnickoImeLaboranta, ArrayList<GrupaAnalize> specijalizacije) {
		
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
				
				String parsiraneSpecijalizacije = "";
				
				for (GrupaAnalize specijalizacija : DodavanjeSpecijalizacija.izabraneSpecijalizacije) {
					
					parsiraneSpecijalizacije = parsiraneSpecijalizacije + specijalizacija.name() + "-";
				}
				
				parsiraneSpecijalizacije = parsiraneSpecijalizacije.substring(0, parsiraneSpecijalizacije.length() - 1);
				
				if (reci[reci.length - 1].equals(Entitet.LABORANT.name())) {
					
				
				if (reci[0].trim().equals(korisnickoImeLaboranta)) {
					
					recZaPromenu = reci[13].trim();
					novaLinija = linija.replace(recZaPromenu, recZaPromenu + "-" + parsiraneSpecijalizacije);
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
		
		azuriranjeBonusaZaLaboranta(korisnickoImeLaboranta);
	}
	
	private static void azuriranjeBonusaZaLaboranta(String korisnickoImeLaboranta) {
		
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
				
				if (reci[reci.length - 1].equals(Entitet.LABORANT.name())) {
					
				
				if (reci[0].trim().equals(korisnickoImeLaboranta)) {
					
					recZaPromenu = reci[10].trim();
					novaLinija = linija.replace(recZaPromenu, racunanjeBonusaZaLaboranta(korisnickoImeLaboranta));
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
	
	private static String racunanjeBonusaZaLaboranta(String korisnickoImeLaboranta) {
		
		for (Korisnik korisnik : korisnici) {
			
			if (korisnik instanceof Laborant) {
				
				if (korisnik.getKorisnickoIme().equals(korisnickoImeLaboranta)) {
					
					return String.valueOf(((Laborant) korisnik).getSpecijalizacije().size() * 2000.00);
				}
			}
		}
		
		return null;
	}
	
	private static String racunanjeBonusaZaMedicinskogTehnicara(String korisnickoIme) {
		
		int brojKucnihPoseta = ZahtevController.brojKucnihPosetaPoPacijentu(korisnickoIme);
		return String.valueOf(brojKucnihPoseta * 500.00);
	}
	
	public static void azuriranjeBonusaZaMedicinskogTehnicara(String korisnickoImeMedicinskogTehnicara) {
		
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
				
				if (reci[reci.length - 1].equals(Entitet.MEDICINSKI_TEHNICAR.name())) {
					
				
				if (reci[0].trim().equals(korisnickoImeMedicinskogTehnicara)) {
					
					recZaPromenu = reci[10].trim();
					novaLinija = linija.replace(recZaPromenu, racunanjeBonusaZaMedicinskogTehnicara(korisnickoImeMedicinskogTehnicara));
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
	
	public static Zaposleni vracanjeZaposlenogNaOsnovuKorisnickogImena(String korisnickoImeZaposlenog) {
		
		for (Korisnik korisnik : korisnici) {
			
			if (korisnik instanceof Zaposleni) {
				
				if (korisnik.getKorisnickoIme().equals(korisnickoImeZaposlenog)) {
					
					return (Zaposleni) korisnik;
				}
			}
		}
		
		return null;
	}
	
	public static String vracanjePlate(String osnova, String koeficijent, String bonus, String staz) {
		
		return String.valueOf(Math.round(Double.parseDouble(osnova) * Double.parseDouble(koeficijent) * Double.parseDouble(staz) + Double.parseDouble(bonus))) + "  RSD";
	}
	
	public static void menjanjeAtributaZaposlenog(String korisnickoImeZaposlenog, String novaOsnova, String noviKoeficijent,
			String noviBonus, String noviStaz) {
		
		KorisniciController.ucitavanje(putanja);
		
		String osnovaZaPromenu = "";
		String koeficijentZaPromenu = "";
		String bonusZaPromenu = "";
		String stazZaPromenu = "";
		
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
		String linija1;
		String linija2;
		String linija3;

		try {
			while ((linija = br.readLine()) != null)
			{
				linija = linija.trim();
				
				stariSadrzaj = stariSadrzaj + linija + System.lineSeparator();
				
				String [] reci = linija.split(",");
				
				if (reci[reci.length - 1].equals(Entitet.MEDICINSKI_TEHNICAR.name()) || reci[reci.length - 1].equals(Entitet.LABORANT.name())) {
					
				
				if (reci[0].trim().equals(korisnickoImeZaposlenog)) {
					
					osnovaZaPromenu = reci[8].trim();
					koeficijentZaPromenu = reci[9].trim();
					bonusZaPromenu = reci[10].trim();
					stazZaPromenu = reci[11].trim();
					linija1 = linija.replaceFirst(osnovaZaPromenu, novaOsnova);
					linija2 = linija1.replaceFirst(koeficijentZaPromenu, noviKoeficijent);
					linija3 = linija2.replaceFirst(bonusZaPromenu, noviBonus);
					novaLinija = linija3.replaceFirst(stazZaPromenu, noviStaz);
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
	
	public static void preuzimanjeNalazaZaObradu(String preuzetNalaz, String korisnickoImeLaboranta) {
		
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
				
				if (reci[reci.length - 1].equals(Entitet.NALAZ.name())) {
					
				
				if (reci[2].trim().equals(preuzetNalaz)) {
					
					recZaPromenu = reci[4].trim();
					
					if (recZaPromenu.length() == 1 && !KorisniciController.korisnickaImenaLaboranata.contains(recZaPromenu)) {
					
					novaLinija = linija.replace(recZaPromenu, korisnickoImeLaboranta);
					noviSadrzaj = noviSadrzaj + novaLinija + System.lineSeparator();
				}
					
					else {
						
						novaLinija = linija.replace(recZaPromenu, recZaPromenu + "-" + korisnickoImeLaboranta);
						noviSadrzaj = noviSadrzaj + novaLinija + System.lineSeparator();
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
		
		NalazController.menjanjeStatusaObradaNalaza(NalazController.vracanjeNalazaPrekoIdNalaza(preuzetNalaz));
	}
	
	public static Laborant vracanjeLaborantaNaOsnovuKorisnickogImena(String korisnickoImeLaboranta) {
		
		for (Korisnik korisnik : korisnici) {
			
			if (korisnik instanceof Laborant) {
				
				if (korisnik.getKorisnickoIme().equals(korisnickoImeLaboranta)) {
					
					return (Laborant) korisnik;
				}
			}
		}
		
		return null;
	}
	
	public static boolean zauzeteSpecijalizacije(String korisnickoImeLaboranta, Nalaz nalaz){
		
		Laborant laborant = vracanjeLaborantaNaOsnovuKorisnickogImena(korisnickoImeLaboranta);
		
		ArrayList<String> listaZauzetihSpecijalizacija = new ArrayList<String>();
		
		ArrayList<String> listaPotrebnihSpecijalizacija = ZahtevController.konvertovanjeIzNizaUListu(ZahtevController.vracanjeZahtevaprekoIdZahteva(String.valueOf(nalaz.getIdZahteva()))
				.getImenaAnaliza());
		
		boolean zauzeteSpecijalizacije = true;
		
		for (String kImeLaboranta : nalaz.getKorisnickaImenaLaboranata()) {
			
			if (korisnickaImenaLaboranata.contains(kImeLaboranta)) {
			
			Laborant trenutniLaborant = vracanjeLaborantaNaOsnovuKorisnickogImena(kImeLaboranta);
			
			for (GrupaAnalize specijalizacija : trenutniLaborant.getSpecijalizacije()) {
				
				listaZauzetihSpecijalizacija.add(specijalizacija.name());
			}
		}
		}
		
		for (GrupaAnalize specijalizacijaUvezenogLaboranta : laborant.getSpecijalizacije()) {
			
			if (!listaZauzetihSpecijalizacija.contains(specijalizacijaUvezenogLaboranta.name()) && listaPotrebnihSpecijalizacija.contains(specijalizacijaUvezenogLaboranta.name())) {
				
				zauzeteSpecijalizacije = false;
			}
		}
		
		return zauzeteSpecijalizacije;
	}
	
	public static Pol vracanjePolaNaOsnovuLBO(String LBO) {
		

		try {
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(new FileReader(putanja));
			
			String linija;
			
			try {
				while((linija = reader.readLine()) != null) {
								
					linija = linija.trim();
					String [] reci = linija.split(",");
					
					if (reci[reci.length - 1].trim().equals(Entitet.PACIJENT.name())) {
						
						String trazenLBO = reci[8].trim();
						
						if (trazenLBO.equals(LBO)) {
							
							return Pol.valueOf(reci[6].trim());
						}
						
					}
					
					else if (reci[reci.length - 1].trim().equals(Entitet.MUSTERIJA.name())){
						
						String trazenLBO = reci[3].trim();
						
						if (trazenLBO.equals(LBO)) {
							
							return Pol.valueOf(reci[6].trim());
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
		return null;
	}
	
	public static LocalDateTime konvertovanjeULocalDateTime(Date dateToConvert) {
	    return Instant.ofEpochMilli(dateToConvert.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
	}
	
	public static String vracanjeImenaNaOsnovuLBO(String LBO) {
		
		for (Korisnik korisnik : korisnici) {
			
			if (korisnik instanceof Pacijent) {
				
				if (((Pacijent) korisnik).getLBO().equals(LBO)) {
					
					return korisnik.getIme();
				}
			}
		}
		
		for (Musterija musterija : MusterijaController.musterije) {
			
			if (musterija.getLBO().equals(LBO)) {
				
				return musterija.getIme();
			}
		}
		
		return null;
	}
	
	public static String vracanjePrezimenaNaOsnovuLBO(String LBO) {
		
		for (Korisnik korisnik : korisnici) {
			
			if (korisnik instanceof Pacijent) {
				
				if (((Pacijent) korisnik).getLBO().equals(LBO)) {
					
					return korisnik.getPrezime();
				}
			}
		}
		
		for (Musterija musterija : MusterijaController.musterije) {
			
			if (musterija.getLBO().equals(LBO)) {
				
				return musterija.getPrezime();
			}
		}
		
		return null;
	}
	
	public static double vracanjePlateLaboranataZaIzvestaje(LocalDateTime pocetniDatum, LocalDateTime krajnjiDatum, Laborant laborant) {
		
		long brojDanaIzmedjuDvaDatuma = (ChronoUnit.DAYS.between(pocetniDatum, krajnjiDatum) * IzborVremenskogOpsegaIzvestaji.izabraniDaniUNedelji.size()) / 7;
		
		double dnevnica = (laborant.getOsnova() * laborant.getKoeficijent() * laborant.getStaz() + laborant.getBonus()) / 30;
		double plata = dnevnica * brojDanaIzmedjuDvaDatuma;
		
		return Math.round(plata);
	}
}
