package model;

import java.util.Date;

import enumeracije.Pol;

public class Musterija {
	
	private String ime, prezime, adresa, LBO, telefon;
	private Date datumRodjenja;
	private Pol pol;
	
	public Musterija(String ime, String prezime, String adresa, String LBO, String telefon, Date datumRodjenja, Pol pol) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.adresa = adresa;
		this.LBO = LBO;
		this.telefon = telefon;
		this.datumRodjenja = datumRodjenja;
		this.pol = pol;
	}

	public Musterija() {
		
	}

	public Musterija(String ime, String prezime, String adresa, String LBO, Date datumRodjenja, String telefon, Pol pol) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.adresa = adresa;
		this.LBO = LBO;
		this.datumRodjenja = datumRodjenja;
		this.telefon = telefon;
		this.pol = pol;
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

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getLBO() {
		return LBO;
	}

	public void setLBO(String LBO) {
		this.LBO = LBO;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public Pol getPol() {
		return pol;
	}

	public void setPol(Pol pol) {
		this.pol = pol;
	}

	@Override
	public String toString() {
		return "Musterija [ime=" + ime + ", prezime=" + prezime + ", adresa=" + adresa + ", LBO=" + LBO + ", telefon="
				+ telefon + ", datumRodjenja=" + datumRodjenja + ", pol=" + pol + "]";
	}

}
