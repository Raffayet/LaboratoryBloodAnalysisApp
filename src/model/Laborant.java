package model;

import java.util.Date;
import java.util.ArrayList;

import enumeracije.GrupaAnalize;
import enumeracije.Pol;
import enumeracije.StrucnaSprema;

public class Laborant extends Zaposleni{
	
	private ArrayList<GrupaAnalize> specijalizacije;
	
	public Laborant() {
		
	}

	public Laborant(String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String adresa, 
			Pol pol, Date datumRodjenja, double osnova, double koeficijent, double bonus, int staz, StrucnaSprema strucnaSprema, 
			ArrayList<GrupaAnalize> specijalizacije) {
		super(korisnickoIme, lozinka, ime, prezime, telefon, adresa, pol, datumRodjenja, osnova, koeficijent, bonus, staz, strucnaSprema);
		this.specijalizacije = specijalizacije;
		super.setKorisnickoIme(korisnickoIme);
		super.setLozinka(lozinka);
		super.setIme(ime);
		super.setPrezime(prezime);
		super.setTelefon(telefon);
		super.setAdresa(adresa);
		super.setPol(pol);
		super.setDatumRodjenja(datumRodjenja);
		super.setOsnova(osnova);
		super.setKoeficijent(koeficijent);
		super.setBonus(bonus);
		super.setStaz(staz);
		super.setStrucnaSprema(strucnaSprema);
	}

	public ArrayList<GrupaAnalize> getSpecijalizacije() {
		return specijalizacije;
	}

	public void setSpecijalizacije(ArrayList<GrupaAnalize> specijalizacije) {
		this.specijalizacije = specijalizacije;
	}

	@Override
	public String toString() {
		return "Laborant [specijalizacije=" + specijalizacije + "]";
	}
}
