package model;

import java.util.Date;

import enumeracije.Pol;
import enumeracije.StrucnaSprema;

public class MedicinskiTehnicar extends Zaposleni{
	
	public MedicinskiTehnicar() {
		
	}
	
	public MedicinskiTehnicar(String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String adresa,
			Pol pol, Date datumRodjenja, double osnova, double koeficijent, double bonus, int staz, StrucnaSprema strucnaSprema) {
		
		super(korisnickoIme, lozinka, ime, prezime, telefon, adresa, pol, datumRodjenja, osnova, koeficijent, bonus, staz, strucnaSprema);
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
	
	public void registracijaPacijenta() {
		//uradjeno
	}
	
	public void registracijaMusterija() {
		//uradjeno
	}
	
	public void preuzetiZahtevi() {
		//uradjeno
	}
	
	public void kreiranjeZahteva() {
		//uradjeno
	}
	
	public void preuzimanjeUzorka() {
		//uradjeno
	}
}
