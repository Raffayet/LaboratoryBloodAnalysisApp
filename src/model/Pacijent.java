package model;

import java.util.Date;

import enumeracije.Pol;

public class Pacijent extends Korisnik {

	private String LBO;

	public Pacijent() {

	}

	public Pacijent(String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String adresa,
			Pol pol, Date datumRodjenja, String LBO) {
		super(korisnickoIme, lozinka, ime, prezime, telefon, adresa, pol, datumRodjenja);
		this.LBO = LBO;
		super.setKorisnickoIme(korisnickoIme);
		super.setLozinka(lozinka);
		super.setIme(ime);
		super.setPrezime(prezime);
		super.setTelefon(telefon);
		super.setAdresa(adresa);
		super.setPol(pol);
		super.setDatumRodjenja(datumRodjenja);
	}

	public String getLBO() {
		return LBO;
	}

	public void setLBO(String LBO) {
		this.LBO = LBO;
	}

	@Override
	public String toString() {
		return "Pacijent [LBO=" + LBO + "]";
	}

	public void pregledNalaza() {
		
	}

	public void kreiranjeZahteva() {
		//uradjeno
	}

}
