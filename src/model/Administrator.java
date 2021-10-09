package model;

import java.util.Date;

import enumeracije.Pol;

public class Administrator extends Korisnik{
	
	
	
	public Administrator() {
		
	}
	
	public Administrator(String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String adresa,
			Pol pol, Date datumRodjenja) {
		
		super(korisnickoIme, lozinka, ime, prezime, telefon, adresa, pol, datumRodjenja);
		super.setKorisnickoIme(korisnickoIme);
		super.setLozinka(lozinka);
		super.setIme(ime);
		super.setPrezime(prezime);
		super.setTelefon(telefon);
		super.setAdresa(adresa);
		super.setPol(pol);
		super.setDatumRodjenja(datumRodjenja);
	}
	
	public void racunanjeMesecnePlate() {
		
	}
	
	public void izvestajiPrihodi() {
		
	}
	
	public void izvestajRashodi() {
		
	}

}
