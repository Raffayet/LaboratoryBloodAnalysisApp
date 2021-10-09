package model;

import java.util.Date;

import enumeracije.Pol;

public abstract class Korisnik {
	
	private String korisnickoIme, lozinka, ime, prezime, telefon, adresa;
	private Pol pol;
	private Date datumRodjenja;
	
	public Korisnik() {
		
	}
	
	public Korisnik(String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String adresa,
			Pol pol, Date datumRodjenja) {
		this();
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.telefon = telefon;
		this.adresa = adresa;
		this.pol = pol;
		this.datumRodjenja = datumRodjenja;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Pol getPol() {
		return pol;
	}

	public void setPol(Pol pol) {
		this.pol = pol;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	@Override
	public String toString() {
		return "Korisnik [korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + ", ime=" + ime + ", prezime="
				+ prezime + ", telefon=" + telefon + ", adresa=" + adresa + ", pol=" + pol + ", datumRodjenja="
				+ datumRodjenja + "]";
	}

}
